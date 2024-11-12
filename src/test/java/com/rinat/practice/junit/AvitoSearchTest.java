package com.rinat.practice.junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AvitoSearchTest {

    static {
        Configuration.browser = "firefox";  // Используйте "chrome", если хотите тестировать в Chrome
        Configuration.timeout = 80000; // Увеличиваем таймаут до 80 секунд
        Configuration.pageLoadStrategy = "eager"; // Настройка загрузки страницы (попробуем частичную загрузку)
    }

    @Test
    @DisplayName("Проверка наличия и доступности поля поиска на Avito")
    @Tag("UI")
    public void searchFieldIsAvailable() {
        // Открываем страницу Avito
        open("https://www.avito.ru/");

        // Ищем элемент с явным ожиданием и дополнительной проверкой на существование перед видимостью и доступностью
        $("input[data-marker='search-form/suggest/input']")
                .should(exist)          // Проверка, что элемент существует
                .shouldBe(visible)       // Проверка, что элемент видим
                .shouldBe(enabled);      // Проверка, что элемент доступен для ввода
    }
}
