
Get the Github project in your workspace
> git clone https://github.com/debdayal/user-service-docker.git

If you want to build your own docker image and upload to your docker hub account, then do the following

> cd user-service-docker

Build and Run the project using STS.
Need a MongoDB running locally **spring.data.mongodb.uri=mongodb://localhost/local**
I am not using the docker maven plugin but manual build and push to docker hub.
Package the application and **copy the jar file to docker folder**
From Vagrant Ubuntu VM run the below commands
> cd docker

> docker build --force-rm -t debdayal/user-service .

Replace _debdayal_ with **your name**
> docker login 

Login to to your docker hub account
> docker push debdayal/user-service

Check your docker hub account if the image has been uploaded.
Then from this machine or another machine you can pull the docker image and run. You can also directly run as the run command automatically pulls the image.
> docker pull debdayal/user-service

You need to start config-server first as it stores and provides all the configuration which is maintained thru github. Once the config-server is running then 
you can start the user-service contianers

Now dynamically pass the config-server URL using Spring Boots **spring.cloud.config.uri** or using --link container-name option of docker. You can run multiple instances of user-service.

> docker run -p 8001:8080 --name user-service-1 --link config-server -d -t debdayal/user-service --debug

> docker run -p 8002:8080 --name user-service-2 -d -t debdayal/user-service --spring.cloud.config.uri=http://192.168.33.11:8004 --debug

While running multiple instances of user-service the consumer needs a single end point to connect to it. One of the way it can be achieved is using a HAProxy.
A tutorial on HA Proxy configuraiton can be found @ _https://www.howtoforge.com/tutorial/ubuntu-load-balancer-haproxy_

Please refer to haproxy-api-docker project for more details.

