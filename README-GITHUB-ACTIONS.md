# UNICA Manager Android 0.1.1 — build AAB con GitHub Actions

Questa versione è predisposta per generare il file Android App Bundle `.aab` senza Android Studio.

## Identificativo definitivo dell'app

- Application ID: `it.unicasrl.manager`
- Versione: `0.1.1`
- Version code: `2`

È consigliato usare questo Application ID già dal primo caricamento su Google Play.

## 1. Crea un repository GitHub privato

Su GitHub crea un nuovo repository **Private**, per esempio `unica-manager-android`.
Non aggiungere README o altri file durante la creazione.

Carica **il contenuto di questa cartella**, non la cartella esterna stessa. Alla radice del repository devono vedersi `app`, `.github`, `build.gradle` e `settings.gradle`.

## 2. Crea una sola volta la chiave di firma

Su Mac fai doppio clic su:

`scripts/create-upload-key-mac.command`

Se macOS lo blocca: tasto destro → Apri.

Lo script crea:

- `unica-manager-upload.jks` — chiave privata di firma;
- `unica-manager-upload.jks.base64.txt` — testo da copiare in GitHub.

**Non caricare questi file nel repository.** Sono già esclusi da `.gitignore`.

Conserva il `.jks` e la password in almeno due luoghi sicuri.

## 3. Inserisci i 4 GitHub Secrets

Nel repository vai in:

`Settings → Secrets and variables → Actions → New repository secret`

Crea:

1. `ANDROID_KEYSTORE_BASE64`
   - valore: tutto il contenuto di `unica-manager-upload.jks.base64.txt`
2. `ANDROID_KEYSTORE_PASSWORD`
   - valore: password del keystore
3. `ANDROID_KEY_ALIAS`
   - valore: `unica-manager`
4. `ANDROID_KEY_PASSWORD`
   - valore: la stessa password usata per il keystore

## 4. Genera l'AAB

Nel repository:

`Actions → Build UNICA Android AAB → Run workflow → Run workflow`

Attendi il completamento del job **Generate signed AAB**.

In fondo alla pagina del workflow, nella sezione **Artifacts**, scarica:

`unica-manager-0.1.1-aab`

All'interno trovi:

`unica-manager-0.1.1-release.aab`

Questo è il file da caricare in Google Play Console.

## 5. Google Play

Per il primo test usa:

`Google Play Console → Test → Test interno`

Carica il file `.aab`, crea la release, aggiungi gli account Google dei tester e pubblica nel canale di test interno.

## Versioni future

Per ogni nuova release sarà sufficiente aggiornare `versionCode` e `versionName`, caricare i nuovi sorgenti nel repository e premere di nuovo **Run workflow**. La chiave di firma e i GitHub Secrets restano gli stessi.

## Nota sulla chiave di firma

Non perdere `unica-manager-upload.jks`. Anche utilizzando Google Play App Signing, questa chiave viene usata come **upload key** per firmare le nuove release da inviare a Google Play.
