package com.rinat.practice.junit.gismeteo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GismeteoTest {
    @Test
    @DisplayName("Проверка доступности поля поиска на Gismeteo")
    @Tag("UI")
    public void weatherSearchFieldIsAvailable () {
        open("https://www.gismeteo.ru/");
        $(".search-form ").should(Condition.exist).shouldBe(Condition.enabled);
    }

    @Disabled("Тест временно отключен для демонстрации аннотации @Disabled")
    @Test
    @DisplayName("Проверка временно отключенного теста")
    public void temporarilyDisabledTest() {
        // Логика для временного теста (не будет запускаться из-за аннотации @Disabled).
    }
}
