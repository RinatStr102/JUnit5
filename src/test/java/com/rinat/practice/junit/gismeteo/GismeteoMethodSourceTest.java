package com.rinat.practice.junit.gismeteo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GismeteoMethodSourceTest {

    // Вспомогательный класс для хранения информации о городе и ожидаемом заголовке
    static class CityData {
        String city;
        String expectedHeader;

        CityData(String city, String expectedHeader) {
            this.city = city;
            this.expectedHeader = expectedHeader;
        }
    }

    // Метод настройки тестов
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    // Метод, предоставляющий данные для параметризированного теста
    static Stream<CityData> provideCities() {
        return Stream.of(
                new CityData("Москва", "Погода в Москве"),
                new CityData("Санкт-Петербург", "Погода в Санкт-Петербурге"),
                new CityData("Новосибирск", "Погода в Новосибирске")
        );
    }

    // Параметризированный тест с использованием аннотации @MethodSource
    @ParameterizedTest
    @MethodSource("provideCities")
    @DisplayName("Проверка поиска по городам на Gismeteo с использованием MethodSource")
    public void searchForCitiesWithMethodSource(CityData data) {
        open("https://www.gismeteo.ru/");

        // Вводим город в поле поиска
        $(".input.js-input").shouldBe(visible).setValue(data.city).pressEnter();

        // Проверяем, что заголовок страницы соответствует ожидаемому
        $(".page-title").shouldBe(visible).shouldHave(text(data.expectedHeader));
    }
}
