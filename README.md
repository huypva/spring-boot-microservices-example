The example project for StringBoot service

<div align="center">
    <img src="./assets/images/architecture.png"/>
</div>

## Getting Started

## Technology List

- Spring Cloud Consul
- Spring Cloud Sleuth
- Docker
- gRPC

## Project structure
```
.
├── service-A
│   ├── Dockerfile
│   ...
├── bank-service
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start infrastructure

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-infrastructure up -d
```

## Start services
### Start services in local

- Build project
```shell script
$ ./mvnw clean package
$ cd hello-word
$ ../mvnw spring-boot:run
...
```

### Start services in docker 

```shell script
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service up -d
```

## Run testing

```shell script
curl http://localhost:8081/greet?name=World
```

## Stop project

- Kill project if start in local mode
- Stop infrastructure & services in docker

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-infrastructure down
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service down
```


- Open jeager tool on browser at http://localhost:16686/

## Contribute

## Reference

- https://github.com/yidongnan/spring-cloud-consul-example
- https://github.com/piomin/sample-spring-microservices-new
- https://github.com/rkudryashov/microservices-example