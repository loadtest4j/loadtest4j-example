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

1. Tick the box in your IDE to enable **one** of your loadtest4j Maven profiles.
2. (Local mode) Start the Service Under Test.
3. Hit Play to run the tests using that profile.