# loadtest4j-example

[![Build Status](https://travis-ci.com/loadtest4j/loadtest4j-example.svg?branch=master)](https://travis-ci.com/loadtest4j/loadtest4j-example)

A working example of loadtest4j.

## Setup

- Maven
- Java 8+

## Run

### In Maven

```bash
# Run all tests in development mode
mvn verify

# Run load tests against a local Service Under Test
mvn surefire:test@load

# Run load tests against a remote Service Under Test
mvn surefire:test@load -P production
```

### In IDE

1. Tick the box in the relevant part of your IDE to enable the Maven profile you want. **Only enable one loadtest4j profile at a time.**
2. Hit Play to run the tests using that profile.