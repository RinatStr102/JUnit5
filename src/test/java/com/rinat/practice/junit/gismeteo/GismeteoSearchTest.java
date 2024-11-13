package com.rinat.practice.junit.gismeteo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GismeteoSearchTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @ParameterizedTest
    @CsvSource({
            "Москва, Погода в Москве сегодня",
            "Санкт-Петербург, Погода в Санкт-Петербурге сегодня",
            "Новосибирс, Погода в Новосибирске сегодня"
    })
    @DisplayName("Проверка поиска по популярным городам на Gismeteo")
    public void searchForCities(String city, String expectedHeader) {
        open("https://www.gismeteo.ru/");
        $(".search-form").setValue(city).pressEnter();
        $("h1.page-title").shouldHave(text(expectedHeader));
    }
}
