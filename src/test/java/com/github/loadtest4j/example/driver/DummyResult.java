package com.github.loadtest4j.example.driver;

import com.github.loadtest4j.loadtest4j.ResponseTime;
import com.github.loadtest4j.loadtest4j.driver.DriverResult;

import java.time.Duration;
import java.util.Optional;

class DummyResult implements DriverResult {
    
    public long getOk() {
        return 0;
    }
    
    public long getKo() {
        return 0;
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