package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PageHelper;


public class MainPageTests extends PageHelper<MainPageTests> {
    private MainPage page;

    @BeforeEach
    void setUp() {
        page = new MainPage(driver);
    }

    @DisplayName("Main page is opened")
    @Test
    public void welcomePageTest() {
        page.openPage()
                .checkTextIsVisible("Welcome!");
    }

    @DisplayName("Hide/Open sidebar")
    @Test
    public void hideSidebarTest() {
        page.openPage()
                .clickSidebarBtn()
                .checkSidebarIsHide()
                .clickSidebarBtn()
                .checkSidebarIsVisible();
    }

    @DisplayName("Move to Contact and return Home")
    @Test
    public void contactHomePagesTest(){
        page.openPage()
                .clickContactBtn()
                .checkTextIsVisible("\n" +
                        "            Contact us\n" +
                        "          ")
                .clickHomeBtn()
                .checkTextIsVisible("Welcome!");
    }

    @Override
    protected MainPageTests self() {
        return this ;
    }
}
