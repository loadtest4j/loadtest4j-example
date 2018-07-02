package com.github.loadtest4j.example;

import com.github.loadtest4j.loadtest4j.Result;
import org.assertj.core.api.AbstractAssert;

import java.time.Duration;

/**
 * This custom assertion class describes the SLA for the Service Under Test.
 *
 * If you use AssertJ or a similar library that supports custom assertions, consider writing a custom assertion like
 * this. Add assertion methods to describe each aspect of the Service Under Test performance that you care about. For
 * example, the p50 (median), p90, p99, p100 (max) Response Times.
 */
public class ResultAssert extends AbstractAssert<ResultAssert, Result> {

    private ResultAssert(Result result) {
        super(result, ResultAssert.class);
    }

    static ResultAssert assertThat(Result actual) {
        return new ResultAssert(actual);
    }

    public ResultAssert satisfiesMaxResponseTime(Duration responseTime) {
        isNotNull();

        final Duration actualResponseTime = actual.getResponseTime().getPercentile(100);
        if (actualResponseTime.compareTo(responseTime) > 0) {
            failWithMessage("expected Max Response Time = %s, but actual = %s", responseTime, actualResponseTime);
        }

        return this;
    }

    public ResultAssert satisfiesRequestsPerSecond(double requestsPerSecond) {
        isNotNull();

        if (actual.getRequestsPerSecond() < requestsPerSecond) {
            failWithMessage("expected Requests Per Second = %f, but actual = %f", requestsPerSecond, actual.getRequestsPerSecond());
        }

        return this;
    }

    public ResultAssert satisfiesPercentKo(double percentKo) {
        isNotNull();

        if (actual.getPercentKo() > percentKo) {
            failWithMessage("expected Percent KO = %f, but actual = %f", percentKo, actual.getPercentKo());
        }

        return this;
    }
}