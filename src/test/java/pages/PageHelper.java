package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public abstract class PageHelper<T extends PageHelper<T>> {

    private final SelenideElement eltContactBtn = $("#contact");
    private final SelenideElement eltHomeBtn = $("#home");
    private final SelenideElement eltHideSidebarBtn = $("#sidebarCollapse");
    private final SelenideElement eltSidebar = $("#sidebar");

    protected abstract T self();

    public T checkTextIsVisible(String text) {
        $(byXpath("//*[contains(text(), \"" + text + "\")]")).shouldBe(visible);
        return self();
    }

        public T checkTextIsNotVisible(String text) {
        $(byXpath("//*[contains(text()=\"" + text + "\")]")).shouldNotBe(visible);
        return self();
    }


    // относится ко всем страницам
    public T clickContactBtn() {
        eltContactBtn.shouldBe(visible).click();
        return self();
    }

    // относится ко всем страницам
    public T clickHomeBtn() {
        eltHomeBtn.click();
        return self();
    }

    // относится ко всем страницам
    public T clickSidebarBtn() {
        eltHideSidebarBtn.click();
        return self();
    }

    // относится ко всем страницам
    public T checkSidebarIsVisible() {
        eltSidebar.shouldNotHave(cssClass("active"));
        return self();
    }

    // относится ко всем страницам
    public T checkSidebarIsHide() {
        eltSidebar.shouldHave(cssClass("active"));
        return self();
    }
}
