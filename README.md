
docker run -e SCRING_DATA_MONGODB_URI=mongodb://<server>/<database> -p 8001:8080 --name user-service-1 -t debdayal/user-service -d
docker run -e SCRING_DATA_MONGODB_URI=mongodb://<server>/<database> -p 8002:8080 --name user-service-2 -t debdayal/user-service -d
HA Proxy Configuration:
https://www.howtoforge.com/tutorial/ubuntu-load-balancer-haproxy/
