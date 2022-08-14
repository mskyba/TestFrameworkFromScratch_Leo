package selenideexample;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideExampleTest {

    @BeforeClass
    public void setUpSelenoid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "103.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://192.168.68.112:4444/wd/hub").toURL(),
                capabilities
        );
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test
    public void selenideTest1() {
                open("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide")
                .pressEnter();
        $$x("//h3[contains(text(), 'Selenide')]")
                .filter(visible)
                .shouldHave(sizeGreaterThanOrEqual(7))
                .get(0)
                .click();
        $(".donate_header")
                .shouldHave(text("Селенид поддерживает Украину \uD83C\uDDFA\uD83C\uDDE6"));
    }

    @Test
    public void selenideTest2() {
                open("https://google.com");
        $("[name='q']")
                .shouldBe(visible)
                .setValue("Selenide")
                .pressEnter();
        $$x("//h3[contains(text(), 'Selenide')]")
                .filter(visible)
                .shouldHave(sizeGreaterThanOrEqual(7))
                .get(0)
                .click();
        $(".main-menu-pages")
                .has(text("С чего начать?"));
    }

    @Test
    public void selenideTest3() {
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

    @Test
    public void selenideTest4() {
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
    @Test
    public void selenideTest5() {
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