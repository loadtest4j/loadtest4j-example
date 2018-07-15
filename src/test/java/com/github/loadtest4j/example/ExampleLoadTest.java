package com.github.loadtest4j.example;

import com.github.loadtest4j.example.junit.LoadTest;
import com.github.loadtest4j.loadtest4j.LoadTester;
import com.github.loadtest4j.loadtest4j.factory.LoadTesterFactory;
import com.github.loadtest4j.loadtest4j.Request;
import com.github.loadtest4j.loadtest4j.Result;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@Category(LoadTest.class)
public class ExampleLoadTest {

    private final LoadTester loadTester = LoadTesterFactory.getLoadTester();

    @Test
    public void testLoad() {
        final List<Request> requests = Collections.singletonList(Request.get("/example"));

        final Result result = loadTester.run(requests);

        assertSoftly(softly -> {
            softly.assertThat(result.getPercentOk()).as("Percent OK").isEqualTo(100);
            softly.assertThat(result.getRequestsPerSecond()).as("Requests Per Second").isEqualTo(0);
            softly.assertThat(result.getResponseTime().getMax()).as("Max Response Time").isEqualTo(Duration.ZERO);
        });
    }
}
