package com.github.loadtest4j.example.driver;

import com.github.loadtest4j.loadtest4j.ResponseTime;

import java.time.Duration;

class DummyResponseTime implements ResponseTime {
    @Override
    public Duration getPercentile(int i) {
        return Duration.ZERO;
    }
}
