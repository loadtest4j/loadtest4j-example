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

import static com.github.loadtest4j.example.ResultAssert.assertThat;

@Category(LoadTest.class)
public class ExampleLoadTest {

    private final LoadTester loadTester = LoadTesterFactory.getLoadTester();

    @Test
    public void testLoad() {
        final List<Request> requests = Collections.singletonList(Request.get("/example"));

        final Result result = loadTester.run(requests);

        assertThat(result)
                .satisfiesMaxResponseTime(Duration.ofSeconds(7))
                .satisfiesPercentKo(0)
                .satisfiesRequestsPerSecond(0);
    }
}
