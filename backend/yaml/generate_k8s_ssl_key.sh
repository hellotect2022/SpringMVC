openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout tls.key -out tls.crt -subj "/CN=10.10.27.17.nip.io"

sleep 1

kubectl create secret tls sping.secret.key --key tls.key --cert tls.crt
