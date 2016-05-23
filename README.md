
Build and Run the project using STS.
Need a MongoDB running locally **spring.data.mongodb.uri=mongodb://localhost/local**
I am not using the docker maven plugin but manual build and push to docker hub.
Package the application and copy the jar file to docker folder
From Vagrant Ubuntu VM run the below commands
> docker build --force-rm -t debdayal/user-service .

Replace _debdayal_ with **your name**
> docker login 

Login to to your docker hub account
> docker push debdayal/user-service

Check your docker hub account if the image has been uploaded.
Then from this machine or another machine you can pull the docker image and run. You can also directly run as the run command automatically pulls the image.
> docker pull debdayal/user-service

Now dynamically pass the MongoDB database URL using Spring Boots **spring.data.mongodb.uri property**. You can run multiple instances of user-service.
> docker run -e SCRING_DATA_MONGODB_URI=mongodb://server/database -p 8001:8080 --name user-service-1 -t debdayal/user-service -d

> docker run -e SCRING_DATA_MONGODB_URI=mongodb://server/database -p 8002:8080 --name user-service-2 -t debdayal/user-service -d

While running multiple instances of user-service the consumer needs a single endpoint to connect to it. One of the way it can be achieved is using a HAProxy.
A tutorial on HA Proxy configuraiton can be found @ _ https://www.howtoforge.com/tutorial/ubuntu-load-balancer-haproxy/ _
I have also provided the /etc/haproxy/haproxy.cfg file assuming you have ** port forwarding on 8000 ** and your Vagrant VM's private ip: **192.168.33.11** in the host network.
Once you do all this from Windows machine you can run **http://localhost:8000/users** or you can use Vagrant Share.
