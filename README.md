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
├── service-B
│   ├── Dockerfile
│   ...
├── service-C
│   ├── Dockerfile
│   ...
├── service-D
│   ├── Dockerfile
│   ...
├── infrastructure
│   ├── docker-compose.yml
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
$ cd infrastructure
$ docker-compose up -d
```

## Start services
### Start services in local

- Start service-A
```shell script
$ ./mvnw clean package
$ cd service-A
$ ../mvnw spring-boot:run
...
```

- Start service-B
```shell script
$ ./mvnw clean package
$ cd service-B
$ ../mvnw spring-boot:run
...
```

- Start service-C
```shell script
$ ./mvnw clean package
$ cd service-C
$ ../mvnw spring-boot:run
...
```

### Start services in docker 

```shell script
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service up -d
```

## Run testing

```shell script
$ cd script
$ ./send_test_request.sh
```

- Open Jeager tool at http://localhost:16686/

## Stop project

- Kill project if start in local mode
- Stop infrastructure & services in docker

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-infrastructure down
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service down
```

## Contribute

## Reference

- https://github.com/yidongnan/spring-cloud-consul-example
- https://github.com/piomin/sample-spring-microservices-new
- https://github.com/rkudryashov/microservices-example