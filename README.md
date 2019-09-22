# boost!
Boost!, rapid web authoring platform for the masses.

## Build and Test

### Minimum Requirements

- Git
- JDK 8+
- Gradle 3+
- Docker Engine 1.13+

We use the `all` task to perform a `build` and `test` in a single step:

	$ ./gradlew all

## Running Boost!

### Run Using Gradle

Run using the gradle wrapper

	$ ./gradlew bootRun

### Run Using Docker

Run a Development docker environment

	$  docker-compose up

### Run Using Java

Run Local

	$ java -jar build/libs/boost-0.1.0.jar
