#인증서 생성
#openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout tls.key -out tls.crt -subj "/CN=10.10.27.17.nip.io/O=10.10.27.17.nip.io"
openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout key.pem -out cert.pem -subj "/C=US/ST=State/L=City/O=Organization/CN=10.10.27.17.nip.io" -addext "subjectAltName = DNS:10.10.27.17.nip.io, IP:10.10.27.17"



sleep 1

#Secret 생성
#kubectl create secret tls spring.secret.key -n covi --key tls.key --cert tls.crt
kubectl create secret tls spring.secret.key -n covi --key key.pem --cert cert.pem
