# boost!
**boost!**, rapid web authoring platform for the masses.

## Build and Test

### Minimum Requirements

- Git
- JDK 8+
- Gradle 3+
- Docker Engine 1.13+

Use the `all` task to perform a `build` and `test` everything:

	$ ./gradlew all

### Running `boost!`

Run dependencies using docker compose

	$  ./docker-compose up

Once all the dependencies are up and running you can run a boost! instance using either plain java or the spring boot gradle script:

	$ ./gradlew bootRun

	$ java -jar build/libs/boost-0.1.0.jar