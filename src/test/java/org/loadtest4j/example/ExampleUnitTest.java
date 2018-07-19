package org.loadtest4j.example;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadtest4j.example.junit.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;

@Category(UnitTest.class)
public class ExampleUnitTest {
    @Test
    public void testUnit() {
        assertThat(true).isTrue();
    }
}
