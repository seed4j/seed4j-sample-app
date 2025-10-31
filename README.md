# Seed4J Sample Application

## Prerequisites

### Java

You need to have Java 25:

- [JDK 25](https://openjdk.java.net/projects/jdk/25/)

### Node.js and NPM

Before you can build this project, you must install and configure the following dependencies on your machine:

[Node.js](https://nodejs.org/): We use Node to run a development web server and build the project.
Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

## Local environment

- [Local server](http://localhost:8080)
- [Local API doc](http://localhost:8080/swagger-ui.html)

<!-- seed4j-needle-localEnvironment -->

## Start up

```bash
./mvnw
```

```bash
docker compose -f src/main/docker/postgresql.yml up -d
```

```bash
docker compose -f src/main/docker/keycloak.yml up -d
```

<!-- seed4j-needle-startupCommand -->

## Documentation

- [Package types](documentation/package-types.md)
- [Assertions](documentation/assertions.md)
- [Hexagonal architecture](documentation/hexagonal-architecture.md)
- [Logs Spy](documentation/logs-spy.md)
- [CORS configuration](documentation/cors-configuration.md)
- [Dev tools](documentation/dev-tools.md)
- [Vue](documentation/vue.md)
- [sonar](documentation/sonar.md)
- [PostgreSQL](documentation/postgresql.md)
- [Cucumber](documentation/cucumber.md)
- [Cucumber authentication](documentation/cucumber-authentication.md)
- [Kipe expression](documentation/kipe-expression.md)
- [Kipe authorization](documentation/kipe-authorization.md)
- [Sample](documentation/sample.md)

<!-- seed4j-needle-documentation -->
