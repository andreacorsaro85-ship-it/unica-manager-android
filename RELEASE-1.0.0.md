# UNICA Manager Android 1.0.0 — Release ufficiale

Questa è la prima release destinata alla pubblicazione ufficiale su Google Play.

## Identità applicazione
- Application ID: `it.unicasrl.manager`
- Version name: `1.0.0`
- Version code: `5`
- Target SDK: Android 16 / API 36
- Min SDK: API 26

## Build tramite GitHub Actions
1. Caricare/sostituire i file di questo progetto nel repository GitHub privato.
2. Conservare gli stessi 4 GitHub Secrets già configurati:
   - `ANDROID_KEYSTORE_BASE64`
   - `ANDROID_KEYSTORE_PASSWORD`
   - `ANDROID_KEY_ALIAS`
   - `ANDROID_KEY_PASSWORD`
3. Aprire **Actions**.
4. Selezionare **Build UNICA Android Production AAB**.
5. Premere **Run workflow**.
6. A build completata, scaricare l'artifact `unica-manager-1.0.0-aab`.
7. All'interno si trova `unica-manager-1.0.0-release.aab`.

## Firma
NON creare una nuova chiave. Usare lo stesso keystore delle release di test già caricate su Google Play.

## Pubblicazione Google Play
Caricare `unica-manager-1.0.0-release.aab` nella release desiderata (Produzione o testing previsto dalla Play Console).

Prima del rollout pubblico verificare almeno:
- login e logout;
- Google Authenticator / TOTP;
- elenco e dettaglio incarichi;
- geolocalizzazione;
- geofence;
- avvio e termine lavoro;
- comportamento senza rete;
- autorizzazioni localizzazione;
- URL produzione corretto;
- assenza di account/test data precompilati.
