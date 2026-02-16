package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.Config;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.Objects;

public class MainPage extends PageHelper<MainPage> {

    //
    private final SelenideElement eltContactBtn = $("#contact");
    private final SelenideElement eltHomeBtn = $("#home");
    private final SelenideElement eltHideSidebarBtn = $("#sidebarCollapse");
    private final SelenideElement eltSidebar = $("#sidebar");

    protected MainPage self() {
        return Objects.requireNonNull(this);  // Возвращаем текущий экземпляр MainPage
    }

    public MainPage openPage(){
        open(Config.getBaseUrl());
        return this;
    }

    // относится ко всем страницам
    public MainPage clickContactBtn() {
        eltContactBtn.shouldBe(Condition.visible).click();
        return this;
    }

    // относится ко всем страницам
    public MainPage clickHomeBtn() {
        eltHomeBtn.click();
        return this;
    }

    // относится ко всем страницам
    public MainPage clickSidebarBtn() {
        eltHideSidebarBtn.click();
        return this;
    }

    // относится ко всем страницам
    public MainPage checkSidebarIsVisible() {
        eltSidebar.shouldNotHave(Condition.cssClass("active"));
        return this;
    }

    // относится ко всем страницам
    public MainPage checkSidebarIsHide() {
        eltSidebar.shouldHave(Condition.cssClass("active"));
        return this;
    }
}
