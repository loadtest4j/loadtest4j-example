package org.loadtest4j.examples.java;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public void run(ExampleConfiguration exampleConfiguration, Environment environment) {
        environment.healthChecks().register("example", new ExampleHealthCheck());

        environment.jersey().register(new ExampleResource());
    }
}
