package org.loadtest4j.example.driver;

import com.github.loadtest4j.loadtest4j.driver.Driver;
import com.github.loadtest4j.loadtest4j.driver.DriverFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class DummyFactory implements DriverFactory {
    public Set<String> getMandatoryProperties() {
        return Collections.singleton("url");
    }
    
    public Driver create(Map<String, String> properties) {
        final String url = properties.get("url");
        return new Dummy(url);
    }
}