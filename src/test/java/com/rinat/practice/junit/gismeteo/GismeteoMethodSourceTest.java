package com.rinat.practice.junit.gismeteo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GismeteoMethodSourceTest {

    // Предварительная настройка теста
    @BeforeAll
    public static void setUp() {
        System.out.println("Настройка перед запуском тестов.");
    }

    // Метод для предоставления данных
    static Stream<String> provideTestData() {
        return Stream.of(
                "Gismeteo",
                "Погода",
                "Прогноз"
        );
    }

    // Параметризированный тест с использованием @MethodSource
    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("Простой тест на проверку строк")
    public void testStringContainsExpectedWord(String input) {
        System.out.println("Проверяем строку: " + input);

        // Пример проверки, которая всегда пройдет
        assertTrue(input.length() > 0, "Строка должна быть не пустой");
    }
}