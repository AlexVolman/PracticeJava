package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductCartPage;

public class ProductCartTests extends BaseTest{
    private ProductCartPage page;

    @BeforeEach
    void setUp() {
        page = new ProductCartPage();
    }

    @DisplayName("Open product cart")
    @Test
    public void openProductCartPageTest() {
        page.openPage()
                .checkCartIsOpen();
    }

    @DisplayName("Add item to cart")
    @Test
    public void addItemToCartTest() {
        page.addToCartByIndex(0);
    }

    @DisplayName("Remove item from cart")
    @Test
    public void removeItemTest() {

    }

    @DisplayName("Add multiple items")
    @Test
    public void addMultipleItemsTest() {

    }

    @DisplayName("add several of the same items")
    @Test
    public void addSeveralSameItemsTest() {

    }

    @DisplayName("Purchase items")
    @Test
    public void purchaseItemsTest() {

    }
}
