#!/bin/sh

# http
#/usr/local/bin/kubectl port-forward --address 0.0.0.0 deployment/ingress-nginx-controller 80:80 -n ingress-nginx
/usr/local/bin/kubectl port-forward --address 0.0.0.0 deployment/springmvc 8081:8081 -n duhyun
