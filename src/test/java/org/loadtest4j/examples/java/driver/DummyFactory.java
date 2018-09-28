package org.loadtest4j.examples.java.driver;

import org.loadtest4j.driver.Driver;
import org.loadtest4j.driver.DriverFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class DummyFactory implements DriverFactory {
    @Override
    public Set<String> getMandatoryProperties() {
        return Collections.singleton("url");
    }

    @Override
    public Driver create(Map<String, String> properties) {
        final String url = properties.get("url");
        return new Dummy(url);
    }
}