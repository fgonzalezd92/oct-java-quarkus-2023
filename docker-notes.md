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

``` Dockerfile
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

* If you have environment variables defined like this

``` Dockerfile
# Install JDK 17
FROM openjdk:17-alpine
# Copy the jar file
COPY build/day13-container-db-1.0.0-runner.jar app.jar

ENV GREETINGS="Hello from Dockerfile"
ENV GOODBYE="Goodbye from Dockerfile"

# Run the jar file
ENTRYPOINT ["java", "-jar", "-Dwelcome.message=${GREETINGS}", "/app.jar"]

```


```
docker run --name my-api-2 --rm -d  -p 8081:8080 -e GREETINGS="Ola" -e GOODBYE="adios" day13-api:1.0.0

```

### Running docker compose file

```
docker compose -p my-kafka -f docker-compose-kafka.yml up -d
```

* Create a docker compose file and configure the services

``` dockerfile
version: '3.7'
services:
  weather-api:
    image: weather-api:1.0
    build:
      context: ./weather-api
      dockerfile: Dockerfile
    ports:
      - 8080:8080
    environment:
      - KAFKA_BOOTSTRAP_SERVERS=host.docker.internal:9094
  weather-finder:
    image: weather-finder:1.0
    build:
      context: ./weather-finder
      dockerfile: Dockerfile
    environment:
      - KAFKA_BOOTSTRAP_SERVERS=host.docker.internal:9094
    depends_on:
      - weather-api

```

* docker compose builds all the images and starts the containers

```
docker compose -p <projectName> -f <dockerComposeFile> up --build -d
```

* **--build** option makes sure the applications images are rebuilt

* Stop the containers

```
docker compose -p <projectName> -f <dockerComposeFile> down
```

### k8s

* Kubernetes is an orchestration tool. It manages the containers
* It makes sure the containers are always **UP** and **RUNNING**
* Fundamental building block of k8s is **"POD"**
* A Pod is a wrapper to a container.
* When somebody says "**Kubernetize your application**", this is what she means; 
* Create your application; Containerize it using Docker(or Podman); Convert it to a Pod and Deploy them

#### Working with k8s

* Enabling Kubernetes in Docker Desktop, gives you all the tools neccessary for working with k8s
* **kubectl** is the commandline tool that you'll use

```
kubectl version
```

* To get the cluster information 

```
kubectl config get-contexts
```

### Creating Pods

* You can create pods through CLI or through configuration file.
* Use **Deployments** to deploy n number of pods

#### Commands

```
kubectl run <pod-name> --image=<image-name>
kubectl get pods
kubectl delete <pod-name>
kubectl apply -f <config-file-name>
kubectl get deployments
kubectl delete -f <config-file-name>
```

* Set up a cluster in Azure; **AKS**
* Access the cluster from local machine. (**az login** and **az aks get-credentials** command)
* Switch(set the context) to the new cluster 
* Create Deployments, Services, ConfigMaps, Secrets ...etc
* You can access the pods using services
* **NodePort** not really used for production environments, because of the port limitation
* **LoadBalancer** can be used for pods; Generates an external ip address everytime; Every set of pods has a separate load balancer; Not preferred
* **Ingress**; Acts like a API Gateway; Set up routing information to various APIs. Most widely used in realtime




























