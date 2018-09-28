package org.loadtest4j.examples.java.driver;

import org.loadtest4j.driver.DriverResponseTime;
import org.loadtest4j.driver.DriverResult;

import java.time.Duration;

class DummyResult implements DriverResult {

    private final long ok;
    private final long ko;

    DummyResult(long ok, long ko) {
        this.ok = ok;
        this.ko = ko;
    }

    @Override
    public long getOk() {
        return ok;
    }

    @Override
    public long getKo() {
        return ko;
    }

    @Override
    public Duration getActualDuration() {
        return Duration.ZERO;
    }

    @Override
    public DriverResponseTime getResponseTime() {
        return new DummyResponseTime();
    }
}