package tests;

import DTO.CartItemDTO;
import DTO.ProductItemDTO;
import org.junit.jupiter.api.Assertions;
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
        page.openPage();
        ProductItemDTO expecterItem = page.getProductItemByIndex(0);
        page.addToCartByIndex(0);

        CartItemDTO actualItem = page.getCartItemByIndex(0);

        Assertions.assertEquals(expecterItem.getTitle(), actualItem.getTitle());

        Assertions.assertEquals(expecterItem.getPrice(), actualItem.getBasePrice());

        Assertions.assertEquals(1, actualItem.getQuantity());
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

    @DisplayName("Number of items in cart cant be 0")
    @Test
    public void numOfItemCantBeZeroTest() {

    }

}
