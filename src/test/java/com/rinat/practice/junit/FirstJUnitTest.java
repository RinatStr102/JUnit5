package com.rinat.practice.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {

    @Test
    @DisplayName("Проверка, что 5 больше 2")
    public void basicTest() {
        Assertions.assertTrue(5>2, "Проверям, что 5 больше двух");
    }
}
