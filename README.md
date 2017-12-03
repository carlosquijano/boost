# boost!
Boost!, rapid web authoring platform for the masses.

## Build and Test

### Minimum Requirements

- Git
- JDK 8
- Gradle 3+
- Docker Engine 1.13+

We use the `all` task to perform a `build` and `test` in a single step:

	$ ./gradlew all

## Running Boost!

Run using the gradle wrapper

	$ ./gradlew bootRun

Run Local (in-memory)

	$ java -jar build/libs/boost-0.1.0.jar

Run Local in development mode

	$ export SPRING_PROFILES_ACTIVE=dev
	$ java -jar build/boost-0.1.0.jar

### Docker Compose

See the following examples on how to build and run the application using docker and compose:

Run a Development docker environment

	$  docker-compose -f env/dev/docker-compose.yml up

	
