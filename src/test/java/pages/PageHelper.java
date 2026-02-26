package pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public abstract class PageHelper<T extends PageHelper<T>> {

    protected abstract T self();

    public T checkTextIsVisible(String text) {
        $(byXpath("//*[contains(text(), \"" + text + "\")]")).shouldBe(visible);
        return self();
    }

        public T checkTextIsNotVisible(String text) {
        $(byXpath("//*[contains(text()=\"" + text + "\")]")).shouldNotBe(visible);
        return self();
    }
}
