package com.github.loadtest4j.example;

import com.github.loadtest4j.loadtest4j.LoadTester;
import com.github.loadtest4j.loadtest4j.factory.LoadTesterFactory;
import com.github.loadtest4j.loadtest4j.Request;
import com.github.loadtest4j.loadtest4j.Result;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private final LoadTester loadTester = LoadTesterFactory.getLoadTester();

    @Test
    public void testLoad() {
        final List<Request> requests = Collections.singletonList(Request.get("/"));

        final Result result = loadTester.run(requests);

        assertEquals(0, result.getPercentKo(), 0.001);
        assertEquals(0, result.getRequestsPerSecond(), 0.001);
        assertEquals(Duration.ZERO, result.getResponseTime().getPercentile(100));
    }
}
