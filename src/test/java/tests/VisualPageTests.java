package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VisualPage;

public class VisualPageTests extends BaseTest {
    private VisualPage page;

    @BeforeEach
    void setUp() {
        page = new VisualPage();
    }

    @DisplayName("Open visual page")
    @Test
    public void openPageTest () {
        page.openPage().checkTextIsVisible("GIF page");
    }

    @DisplayName("Gif remains visible after sidebar toggle ")
    @Test
    public void gifIndependentOfSidebar() {
        page.openPage()
                .checkGifIsVisible()
                .clickSidebarBtn()
                .checkSidebarIsHide()
                .checkGifIsVisible()
                .clickSidebarBtn()
                .checkSidebarIsVisible()
                .checkGifIsVisible();
    }


    @DisplayName("Gif source is correct")
    @Test
    public void geiSrcCorrect(){
        page.openPage()
                .checkGifIsVisible()
                .checkGifSrcMatches();
    }

    @DisplayName("Gif size is correct")
    @Test
    public void gifSizeCorrect() {
        page.openPage()
                .checkGifIsVisible()
                .checkGifSize();
    }

    @DisplayName("Gif appears not broken")
    @Test
    public void gifAppears() {
        page.openPage()
                .checkGifIsVisible()
                .checkGifIsNotBroken();
    }
}
