package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.Config;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage extends PageHelper<AuthPage> {

    private final SelenideElement eltEmailInput = $("#email");
    private final SelenideElement eltPasswordInput = $("#password");
    private final SelenideElement eltSubmitBtn = $("#submitLoginBtn");
    private final SelenideElement eltAlertMsg = $("#message");

    // inputField.shouldHave(Condition.value("admin"));

    @Override
    protected AuthPage self() {
        return Objects.requireNonNull(this);
    }
    public AuthPage openPage() {
        open(Config.getPageUrl("authEndpoint"));
        return this;
    }

    public AuthPage writeEmail(String text) {
        eltEmailInput.sendKeys(text);
        return this;
    }

    public AuthPage writePassword(String text) {
        eltPasswordInput.sendKeys(text);
        return this;
    }

    public AuthPage clickSubmitBtn() {
        eltSubmitBtn.click();
        return this;
    }

    public AuthPage alertIsVisible() {
        eltAlertMsg.shouldBe(Condition.visible);
        return this;
    }

    public AuthPage checkPasswordIsHidden(String text) {
        eltPasswordInput.shouldHave(Condition.value(text));
        return this;
    }

    public AuthPage clickLogout() {
        return this;
    }
}
