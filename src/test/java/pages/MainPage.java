package pages;

import config.Config;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class MainPage extends PageHelper<MainPage> {

    protected By eltHideSidebarBtn = By.xpath("//*[@id='sidebarCollapse']");
    protected By eltSidebar = By.xpath("//*[@class=\"active\" and @id=\"sidebar\"]");
    protected By eltContactBtn = By.xpath("//*[@id=\"contact\"]");
    protected By eltHomeBtn = By.xpath("//*[@id=\"home\"]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    protected MainPage self() {
        return Objects.requireNonNull(this);  // Возвращаем текущий экземпляр MainPage
    }

    public MainPage openPage(){
        driver.get(Config.getBaseUrl());
        return this;
    }

    // относится ко всем страницам
    public MainPage clickContactBtn() {
        driver.findElement(eltContactBtn).click();
        return this;
    }

    // относится ко всем страницам
    public MainPage clickHomeBtn() {
        driver.findElement(eltHomeBtn).click();
        return this;
    }

    // относится ко всем страницам
    public MainPage clickSidebarBtn() {
        driver.findElement(eltHideSidebarBtn).click();
        return this;
    }

    // относится ко всем страницам
    public MainPage checkSidebarIsVisible() {
        Assertions.assertTrue(driver.findElements(eltSidebar).isEmpty());
        return this;
    }

    // относится ко всем страницам
    public MainPage checkSidebarIsHide() {
        Assertions.assertTrue(driver.findElement(eltSidebar).isDisplayed());
        return this;
    }

// пример перехода на другую страницу
//    public CartPage addToCart() {
//        driver.findElement(addBtn).click();
//        return new CartPage(driver);  // Переход на новую страницу
//    }
}
