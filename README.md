# loadtest4j-example-java

[![Build Status](https://travis-ci.com/loadtest4j/loadtest4j-example.svg?branch=master)](https://travis-ci.com/loadtest4j/loadtest4j-example)

A working example of [loadtest4j](https://www.loadtest4j.org) in Java.

## Usage

### In Maven

```bash
# Runs all tests in development mode
mvn verify

# Runs load tests against staging
mvn test-compile surefire:test@load -P staging

# Runs load tests against production
mvn test-compile surefire:test@load -P production
```

### In IDE

1. Tick the box in your IDE to enable **one** of your loadtest4j Maven profiles.
2. (Local mode) Start the Service Under Test.
3. Hit Play to run the tests using that profile.