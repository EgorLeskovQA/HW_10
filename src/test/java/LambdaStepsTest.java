import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest extends TestBase {

    @Test
    @DisplayName("Lambda Steps Test")
    public void lambdaStepsTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу профиля в гите", () -> {
            open("/EgorLeskovQA");
        });

        step("Открываем все репозитории", () -> {
            $("[data-tab-item='repositories']").click();
        });

        step("Выбор нужного репозитория", () -> {
            $(linkText("EgorLeskovQA/HW_10")).click();
        });

        step("Проверяем наличие Issue", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }

    @Test
    @DisplayName("Наличие Issue при открытии репозитория с главной страницы пользователя")
    public void stepsAnnotationTest (){

        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsAnnotation steps = new StepsAnnotation();

        steps.openMainPage();
        steps.openRepositories();
        steps.selectingTheDesiredRepository();
        steps.shouldSeeIssue();
    }
}
