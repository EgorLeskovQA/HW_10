import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsAnnotation {

    @Step("Открыть главную страницу профиля в гите")
    public StepsAnnotation openMainPage(){
        open("/EgorLeskovQA");

        return this;
    }

    @Step("Открываем все репозитории")
    public StepsAnnotation openRepositories(){
        $("[data-tab-item='repositories']").click();

        return this;
    }

    @Step("Выбор нужного репозитория")
    public StepsAnnotation selectingTheDesiredRepository(){
        $(linkText("EgorLeskovQA/HW_10")).click();

        return this;
    }

    @Step("Проверяем наличие Issue")
    public StepsAnnotation shouldSeeIssue(){
        $("#issues-tab").shouldHave(text("Issues"));

        return this;
    }

}
