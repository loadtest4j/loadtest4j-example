package org.loadtest4j.examples.java.driver;

import org.loadtest4j.driver.DriverResponseTime;
import org.loadtest4j.driver.DriverResult;

import java.time.Duration;
import java.util.Optional;

class DummyResult implements DriverResult {

    private final long ok;
    private final long ko;

    DummyResult(long ok, long ko) {
        this.ok = ok;
        this.ko = ko;
    }

    public long getOk() {
        return ok;
    }
    
    public long getKo() {
        return ko;
    }
    
    public Duration getActualDuration() {
        return Duration.ZERO;
    }
    
    public DriverResponseTime getResponseTime() {
        return new DummyResponseTime();
    }
    
    public Optional<String> getReportUrl() {
        return Optional.empty();
    }
}