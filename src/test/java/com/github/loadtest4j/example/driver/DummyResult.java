package com.github.loadtest4j.example.driver;

import com.github.loadtest4j.loadtest4j.ResponseTime;
import com.github.loadtest4j.loadtest4j.driver.DriverResult;

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
    
    public ResponseTime getResponseTime() {
        return new DummyResponseTime();
    }
    
    public Optional<String> getReportUrl() {
        return Optional.empty();
    }
}