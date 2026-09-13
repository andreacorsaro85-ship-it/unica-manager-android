#!/bin/bash
set -e
cd "$(dirname "$0")/.."
KEYSTORE="$PWD/unica-manager-upload.jks"
B64="$PWD/unica-manager-upload.jks.base64.txt"
ALIAS="unica-manager"

echo "UNICA Manager - creazione chiave di firma Android"
echo "La chiave verra salvata in: $KEYSTORE"
echo
if [ -f "$KEYSTORE" ]; then
  echo "ERRORE: $KEYSTORE esiste gia. Non verra sovrascritta."
  exit 1
fi

read -s -p "Scegli una password forte per il keystore: " PASS
echo
read -s -p "Ripeti la password: " PASS2
echo
if [ "$PASS" != "$PASS2" ]; then
  echo "Le password non coincidono."
  exit 1
fi
if [ ${#PASS} -lt 8 ]; then
  echo "Usa una password di almeno 8 caratteri."
  exit 1
fi

keytool -genkeypair \
  -v \
  -keystore "$KEYSTORE" \
  -storepass "$PASS" \
  -keypass "$PASS" \
  -alias "$ALIAS" \
  -keyalg RSA \
  -keysize 4096 \
  -validity 10000 \
  -dname "CN=UNICA SRL, O=UNICA SRL, C=IT"

base64 < "$KEYSTORE" | tr -d '\n' > "$B64"

echo
echo "Chiave creata correttamente."
echo "File keystore: $KEYSTORE"
echo "Valore base64 per GitHub: $B64"
echo
echo "GitHub Secrets da creare:"
echo "ANDROID_KEYSTORE_BASE64 = contenuto di unica-manager-upload.jks.base64.txt"
echo "ANDROID_KEYSTORE_PASSWORD = la password appena scelta"
echo "ANDROID_KEY_ALIAS = $ALIAS"
echo "ANDROID_KEY_PASSWORD = la stessa password"
echo
echo "CONSERVA IL FILE .jks E LA PASSWORD FUORI DA GITHUB IN UN POSTO SICURO."
