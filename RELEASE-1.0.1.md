# UNICA Manager Android 1.0.1 — Privacy / Google Play

- Application ID: `it.unicasrl.manager`
- Version name: `1.0.1`
- Version code: `8`
- Target SDK: API 36

## Novità
- Voce Privacy accessibile dalla schermata di login e dall'app autenticata.
- Link alla pagina pubblica `/privacy-unica-manager/` del server configurato.
- Informativa ben visibile prima della prima richiesta Android di posizione.
- L'informativa spiega posizione precisa, trasmissione al gestionale, geofence e assenza di tracking continuo.
- La richiesta di posizione resta solo foreground e user-initiated su Inizia/Termina lavoro.

## Build
Usare lo stesso keystore e gli stessi GitHub Secrets delle release precedenti.
GitHub Actions genera `unica-manager-1.0.1-release.aab`.
