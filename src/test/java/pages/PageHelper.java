package pages;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class PageHelper <T extends PageHelper<T>>{
    protected WebDriver driver;

    @BeforeAll
    public static void installWebDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void closeDriver() {
        if(driver != null) {
            driver.quit();
        }
    }

    protected abstract T self();

    public T checkTextIsVisible(String text) {
        By locator = By.xpath(String.format("//*[.=\"%s\"]", text));
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Текст '" + text + "' не найден или не виден");
        }
        return self();  // Возвращаем текущий объект
    }

    public T checkTextIsNotVisible(String text) {
        var result = driver.findElements(getTextLocator(text)).isEmpty();
        Assertions.assertFalse(result, String.format("Text '%s' is found",text));
        return self();
    }

    public By getTextLocator(String text) {
        return By.xpath(String.format("//*[.=\"%s\"]", text));
    }


    // вариант получения урла с эндпоинтом
    //protected String buildPageUrl(String endpoint) {
    //    return Config.getBaseUrl() + endpoint;
    //}
}
