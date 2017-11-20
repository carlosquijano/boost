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

	$ java -jar build/target/server.jar

Run Local in production mode

	$ export SPRING_PROFILES_ACTIVE=prod
	$ java -jar build/target/server.jar
