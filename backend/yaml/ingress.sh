#!/bin/sh

# http
/usr/local/bin/kubectl port-forward --address 0.0.0.0 deployment/ingress-nginx-controller 443:443 -n ingress-nginx
#/usr/local/bin/kubectl port-forward --address 0.0.0.0 service/springmvc 443:443 -n covi

