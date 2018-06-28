package com.github.loadtest4j.example;

import com.github.loadtest4j.loadtest4j.driver.Driver;
import com.github.loadtest4j.loadtest4j.driver.DriverRequest;
import com.github.loadtest4j.loadtest4j.driver.DriverResult;
import java.util.List;

class Dummy implements Driver {

    private final String url;
    
    Dummy(String url) {
        this.url = url;
    }
    
    public DriverResult run(List<DriverRequest> requests) {
        validatePresenceOf(url);

        return new DummyResult();
    }

    private static void validatePresenceOf(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}