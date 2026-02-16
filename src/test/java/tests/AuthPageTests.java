package tests;

import config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;

public class AuthPageTests extends BaseTest {
    private AuthPage page;

    @BeforeEach
    void setUp() {
        page = new AuthPage();
    }

    @DisplayName("Open auth page")
    @Test
    public void openAuthPageTest() {
        page.openPage()
                .checkTextIsVisible("Login - Shop");
    }

    @DisplayName("Enter valid credits")
    @Test
    public void enterValidCredits() {
        page.openPage()
                .writeEmail(Config.getProperty("email"))
                .writePassword(Config.getProperty("password"));
        // нужно придумать как дальше проверять. Происходит ридерект на магазин
    }
}
