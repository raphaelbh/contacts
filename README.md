# POC Contacts

[![Project Status](https://img.shields.io/static/v1?label=project%20status&message=complete&color=success&style=flat-square)](#)
[![GitHub License](https://img.shields.io/github/license/raphaelbh/readme-template?style=flat-square)](#)

Repository created to practice concepts of Hexagonal Architecture and Git Flow with the development team.

- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow#:~:text=Gitflow%20is%20a%20legacy%20Git,software%20development%20and%20DevOps%20practices.)

## Requirements

[![docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)

## Installation

```bash
$ docker-compose up -d
```
    
## Usage

Swagger: http://localhost:8080

```bash
$ curl -X GET "http://localhost:8080/contacts" -H  "accept: application/json"
$ curl -X POST "http://localhost:8080/contacts" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"name\":\"John Conor\",\"phone\":\"5591980563029\",\"email\":\"jconor@gmail.com\"}"
```

## Running Tests

```bash
$ (cd application && ./mvnw clean test)
```

## Tech Stack

[![docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![aws](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)](https://aws.amazon.com/)

## Reference

- https://alistair.cockburn.us/hexagonal-architecture/
- https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c

## Feedback

If you have any feedback, please contact me at raphaeldias.ti@gmail.com

[![github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/raphaelbh)
[![linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/raphaelbh/)