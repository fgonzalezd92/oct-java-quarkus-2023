### Docker Desktop

* Installing Docker Desktop gives you the docker engine(server) and docker client tools
* **docker version**
* Every docker container is a Linux VM
* **MySQL container**: Linux VM with MySQL installed
* **Herbalife admin api container**: Linux VM with Admin Api installed and running inside it

### Java story

* You want to create a Car object
* You define a Car class with properties and behaviour
* You create an instance of Car class and specify the values for the properties


### Docker story

* You want to create a Car **container**
* You define a Car **image** with properties and behaviour
* You create an instance of Car **image** and specify the values for the properties
* **You have a Car container running in your machine!!!**

* You go to https://hub.docker.com to find all the images you need

### Setting up MySQL container

* Pull the mysql image from the docker hub

```
docker pull mysql:latest
```

* Create a container or run the image. When you run the image, a container is created for you

```
docker run -p 3306:3306  -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
```

* -d (*detached mode. You can close your terminal/cmd after running*)
* -p is port mapping (**host:container**)
* **-p 8080:3306** -> In the host machine if you acces **localhost:8080** the request is routed to port 3306 in the container 

* You can login to the container VM using **docker exec** command

```
docker exec --it dcd4ecfbdb80c745f21094db311a4dae61c4a42b941b6861067e650733faa423 /bin/sh
```

#### Containerizing quarkus

* Create a dockerfile

```
# Install JDK 17
FROM openjdk:17-alpine
# Copy the jar file
COPY build/day13-container-db-1.0.0-runner.jar app.jar
# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]

```

* Build an image
* If the name of the docker file is **Dockerfile**

```
docker build -t <imageName>:<version> .
```

* If you have a different name for the dockerfile

```
docker build -t <imageName>:<version> -f <dockerfileName>
```

* Run the image

```
docker run --name <nameOfTheContainer> --rm -p 8080:8080 -d <imageName>:<version>
```

* --rm removes the container when you stop it




