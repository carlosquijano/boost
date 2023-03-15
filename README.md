# boost!
**boost!**, just a backend.

## Build and Test

### Minimum Requirements

- Java 11+
- Docker 1.13+

### Build

Perform a clean build using the `all` gradle task:
```
./gradlew all
```
### Running a Developer Environment

Bring up the dependencies
```
docker-compose up
```
Once all the dependencies are up you can run an application instance using gradle:
```
gradlew bootRun
```
