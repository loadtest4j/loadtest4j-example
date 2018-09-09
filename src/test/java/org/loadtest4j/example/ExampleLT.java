package org.loadtest4j.example;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.loadtest4j.LoadTester;
import org.loadtest4j.Request;
import org.loadtest4j.Result;
import org.loadtest4j.factory.LoadTesterFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class ExampleLT {

    @ClassRule
    public static final DropwizardAppRule<ExampleConfiguration> APP =
            new DropwizardAppRule<>(ExampleApplication.class, ResourceHelpers.resourceFilePath("development.yaml"));

    private final LoadTester loadTester = LoadTesterFactory.getLoadTester();

    @Test
    public void testLoad() {
        final List<Request> requests = Collections.singletonList(Request.get("/example"));

        final Result result = loadTester.run(requests);

        assertSoftly(s -> {
            s.assertThat(result.getPercentOk()).as("Percent OK").isEqualTo(100);
            s.assertThat(result.getRequestsPerSecond()).as("Requests Per Second").isEqualTo(0);
            s.assertThat(result.getResponseTime().getMax()).as("Max Response Time").isEqualTo(Duration.ZERO);
        });
    }
}
