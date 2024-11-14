package com.rinat.practice.junit.gismeteo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GismeteoSearchTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @ParameterizedTest
    @CsvSource({
            "Москва, Москва",
            "Санкт-Петербург, Санкт-Петербург",
            "Новосибирск, Новосибирск"
    })
    @DisplayName("Проверка поиска по городам на Gismeteo")
    public void searchForCities(String city, String expectedText) {
        open("https://www.gismeteo.ru/");

        $(".input.js-input").shouldBe(visible).setValue(city).pressEnter();
        $(".page-title").shouldBe(visible).shouldHave(text(expectedText));
    }
}

