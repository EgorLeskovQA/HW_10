import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest extends TestBase {

    @Test
    public void issueSearchSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/EgorLeskovQA");
        $("[data-tab-item='repositories']").click();
        $(linkText("EgorLeskovQA/HW_10")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
