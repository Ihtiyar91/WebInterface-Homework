package ru.netology.test;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CartTest {

    @Test
    void shouldСompletedBlank()  {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79378586100");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно " +
                "отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}