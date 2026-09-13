# UNICA Manager Android 1.0.0

Prima release predisposta per compilazione automatica tramite GitHub Actions.

- Application ID: `it.unicasrl.manager`
- Version: `1.0.0`
- Version code: `2`
- Min Android: API 26
- Target/Compile SDK: API 36

Per creare il file `.aab` senza Android Studio, seguire `README-GITHUB-ACTIONS.md`.

Funzioni applicative già presenti:
- configurazione URL gestionale HTTPS;
- login UNICA Manager;
- supporto 2FA TOTP/Google Authenticator lato server;
- autenticazione Bearer token;
- elenco incarichi Pulizie autorizzati;
- dettaglio incarico;
- accettazione incarico;
- avvio/fine lavoro con GPS e geofence;
- supporto forzatura fuori geofence;
- logout/revoca token.
