package com.rinat.practice.junit.gismeteo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GismeteoParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"/","weather-moscow-4368/","weather-moscow-4368/tomorrow/"})
    @DisplayName("Проверка доступности поля поиска на разных страницах Gismeteo")
    public void searchFieldIsAvailableOnDifferentPage(String endpoint) {
        open("https://www.gismeteo.ru/" + endpoint);
        $(".search-form").shouldBe(Condition.exist).shouldBe(Condition.enabled);
    }

}
