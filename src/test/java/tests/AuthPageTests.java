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
                .checkAuthPageIsOpen();
    }

    @DisplayName("Enter valid credits")
    @Test
    public void enterValidCreditsTest() {
        page.openPage()
                .writeEmail(Config.getProperty("email"))
                .writePassword(Config.getProperty("password"))
                .clickSubmitBtn()
                .logoutVisible();
    }

    @DisplayName("Logout")
    @Test
    public void logoutTest() {
        page.openPage()
                .writePassword(Config.getProperty("password"))
                .writeEmail(Config.getProperty("email"))
                .clickSubmitBtn()
                .clickLogout()
                .checkAuthPageIsOpen();
    }

    @DisplayName("Enter invalid credits")
    @Test
    public void enterInvalidCreditsTest() {
        page.openPage()
                .writeEmail("test@test.ru")
                .writePassword("password")
                .clickSubmitBtn()
                .alertIsVisible();
    }

    @DisplayName("Password should be hidden")
    @Test
    public void passwordIsHiddenTest() {
        page.openPage()
                .writePassword("password")
                .checkPasswordIsHidden("password");
    }

    @DisplayName("Enter no credits")
    @Test
    public void enterNoCresitsTest() {
        page.openPage()
                .clickSubmitBtn()
                .alertIsVisible();
    }
}
