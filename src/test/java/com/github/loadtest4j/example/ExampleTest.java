package com.github.loadtest4j.example;

import com.github.loadtest4j.loadtest4j.LoadTester;
import com.github.loadtest4j.loadtest4j.factory.LoadTesterFactory;
import com.github.loadtest4j.loadtest4j.Request;
import com.github.loadtest4j.loadtest4j.Result;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static com.github.loadtest4j.example.ResultAssert.assertThat;

public class ExampleTest {

    private final LoadTester loadTester = LoadTesterFactory.getLoadTester();

    @Test
    public void testLoad() {
        final List<Request> requests = Collections.singletonList(Request.get("/example"));

        final Result result = loadTester.run(requests);

        assertThat(result)
                .satisfiesMaxResponseTime(Duration.ofSeconds(7))
                .satisfiesPercentKo(0.1)
                .satisfiesRequestsPerSecond(0);
    }
}
