package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.Config;
import org.openqa.selenium.Dimension;

import java.util.Objects;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VisualPage extends PageHelper<VisualPage>{

    private final SelenideElement eltGif = $("img[src*='giphy.com']");

    private static final String EXPECTED_GIF_SRC = "https://media.giphy.com/media/d3mlE7uhX8KFgEmY/giphy.gif";
    private static final int MIN_WIDTH = 200;
    private static final int MIN_HEIGHT = 120;
    private static final int MAX_WIDTH = 800;
    private static final int MAX_HEIGHT = 450;

    @Override
    protected VisualPage self() {
        return Objects.requireNonNull(this);
    }

    public VisualPage openPage() {
        open(Config.getPageUrl("visualEndpoint"));
        return this;
    }

    public VisualPage checkGifIsVisible() {
        eltGif.shouldBe(visible);
        return this;
    }

    public VisualPage checkGifSrcMatches() {
        eltGif.shouldHave(attribute("src", EXPECTED_GIF_SRC));
        return this;
    }

    public VisualPage checkGifIsNotBroken() {
        Integer naturalWidth = (Integer) Selenide.executeJavaScript("return arguments[0].naturalWidth;", eltGif);
        Integer naturalHeight = (Integer) Selenide.executeJavaScript("return arguments[0].naturalHeight;", eltGif);

        if (naturalWidth == null || naturalHeight == null) {
            throw new AssertionError(
                    "Could not retrieve natural size of the GIF. Element might be stale or missing."
            );
        }

        if (naturalHeight == 0 || naturalWidth == 0) {
            throw new AssertionError("GIF appears broken or not loaded. Natural size 0");
        };
        return this;
    }

    public VisualPage checkGifSize() {
        Dimension size = eltGif.getSize();

        int width = size.getWidth();
        int height = size.getHeight();

        assertHeightInRange(height);
        assertWidthInRange(width);

        return this;
    }


    private void assertWidthInRange(int actualWidth) {
         if (actualWidth < MIN_WIDTH || actualWidth > MAX_WIDTH) {
            throw new AssertionError(
                    String.format("GIF width is out of range: %dpx (expected [%d, %d])",
                            actualWidth, MIN_WIDTH, MAX_WIDTH)
            );
        }
    }

    private void assertHeightInRange(int actualHeight) {
        if (actualHeight < MIN_HEIGHT || actualHeight > MAX_HEIGHT) {
            throw new AssertionError(
                    String.format("GIF height is out of range: %dpx (expected [%d, %d])",
                            actualHeight, MIN_HEIGHT, MAX_HEIGHT)
            );
        }
    }
}
