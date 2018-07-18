package org.loadtest4j.example.driver;

import com.github.loadtest4j.loadtest4j.driver.DriverResponseTime;

import java.time.Duration;

class DummyResponseTime implements DriverResponseTime {
    @Override
    public Duration getPercentile(int i) {
        return Duration.ZERO;
    }
}
