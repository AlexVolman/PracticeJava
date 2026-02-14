package pages;

import config.Config;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class AuthPage extends PageHelper<AuthPage> {

    public AuthPage(WebDriver driver){
        this.driver = driver;
    }

    public AuthPage open() {
        driver.get(Config.getPageUrl("authEndpoint"));
        return this;
    }

    @Override
    protected AuthPage self() {
        return Objects.requireNonNull(this);
    }
}
