package selenideexample;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideExampleTest {

    @Test
    public void selenideTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        open("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide")
                .pressEnter();
        $$x("//h3[contains(text(), 'Selenide')]")
                .filter(visible)
                .shouldHave(sizeGreaterThanOrEqual(7))
                .get(1)
                .click();
        $(".donate_header")
                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));
    }

}