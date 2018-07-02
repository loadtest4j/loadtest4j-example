package com.github.loadtest4j.example;

import com.github.loadtest4j.example.junit.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Assertions.assertThat;

@Category(UnitTest.class)
public class ExampleUnitTest {
    @Test
    public void testUnit() {
        assertThat(true).isTrue();
    }
}
