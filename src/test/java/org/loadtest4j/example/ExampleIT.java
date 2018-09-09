package org.loadtest4j.example;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleIT {

    @ClassRule
    public static final DropwizardAppRule<ExampleConfiguration> APP =
            new DropwizardAppRule<>(ExampleApplication.class, ResourceHelpers.resourceFilePath("development.yaml"));

    @Test
    public void testIntegration() {
        final Client client = JerseyClientBuilder.createClient();

        final Response response = client.target(
                String.format("http://localhost:%d/example", APP.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}
