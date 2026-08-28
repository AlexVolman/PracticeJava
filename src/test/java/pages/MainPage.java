package pages;

import com.codeborne.selenide.SelenideElement;
import config.Config;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.Objects;

public class MainPage extends PageHelper<MainPage> {

    private final SelenideElement eltWelcomeSection = $(".jumbotron jumbotron-fluid");
    private final SelenideElement eltContactSection = $(".mb-4");

    protected MainPage self() {
        return Objects.requireNonNull(this);  // Возвращаем текущий экземпляр MainPage
    }

    public MainPage openPage(){
        open(Config.getBaseUrl());
        return this;
    }

    public MainPage checkWelcomeSectionIsOpen() {
        eltWelcomeSection.shouldBe(visible);
        return this;
    }

    public MainPage checkContactSectionIsOpen() {
        eltContactSection.shouldBe(visible);
        return this;
    }
}
