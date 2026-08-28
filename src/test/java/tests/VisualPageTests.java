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
}
