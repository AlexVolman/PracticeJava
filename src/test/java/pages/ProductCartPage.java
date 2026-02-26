package pages;

import DTO.CartItemDTO;
import DTO.ProductItemDTO;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.Config;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductCartPage extends PageHelper<ProductCartPage> {
    private final SelenideElement eltCartSection = $("#prooood");
    private final SelenideElement eltPurchaseBtn = $(".btn-purchase");
    private final SelenideElement eltTotalPrice = $(".cart-total-price");
    private final ElementsCollection eltShopItems = $$(".shop-items");
    private final ElementsCollection eltCartItems = $$(".cart-items");


    private static final String SHOP_ITEM_BTN = ".shop-item-button";
    private static final String REMOVE_BTN = ".btn btn-danger";
    private static final String CART_QUANTITY_INPUT = ".cart-quantity-input";
    private static final String CART_ITEM_TITLE = ".cart-item-title";
    private static final String CART_PRICE = ".cart-price";
    private static final String SHOP_ITEM_TITLE = ".shop-item-title";
    private static final String SHOT_PRICE = ".shop-item-price";

    @Override
    protected ProductCartPage self() {
        return Objects.requireNonNull(this);
    }

    public ProductCartPage openPage() {
        open(Config.getPageUrl("productsEndpoint"));
        return this;
    }

    public ProductCartPage checkCartIsOpen() {
        eltCartSection.shouldBe(visible);
        return this;
    }

    public ProductCartPage addToCartByIndex(int index) {
        eltShopItems.get(index)
                .find(SHOP_ITEM_BTN)
                .shouldBe(visible, enabled)
                .click();
        return this;
    }

    public ProductCartPage addToCartLast() {
        eltShopItems.last()
                .find(SHOP_ITEM_BTN)
                .shouldBe(visible, enabled)
                .click();
        return this;
    }

    public double getTotalPrice() {
        String price = eltTotalPrice.getText().replace("$", "");
        try {
            return Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse price: " + price, e);
        }
    }

    public ProductCartPage deleteProduct(int index) {
        eltCartItems.get(index)
                .find(REMOVE_BTN)
                .shouldBe(visible, enabled)
                .click();
        return this;
    }

    void increaseProductNum(int index) {
        SelenideElement input = eltCartItems.get(index)
                .find(CART_QUANTITY_INPUT);
        input.click();
        input.sendKeys(Keys.UP);
    }

    void reduceProductNum(int index) {
        SelenideElement input = eltCartItems.get(index)
                .find(CART_QUANTITY_INPUT);
        input.click();
        input.sendKeys(Keys.DOWN);
    }

    void setProductNum(int index, String itemNum) {
        eltCartItems.get(index)
                .find(CART_QUANTITY_INPUT)
                .setValue(itemNum)
                .sendKeys(Keys.ENTER);
    }

    int checkItemNum (int index) {
        String num = eltCartItems.get(index)
                .find(CART_QUANTITY_INPUT)
                .getValue();
        return Integer.parseInt(num);
    }

    public int getQuantityOfProducts() {
        return eltShopItems.size();
    }

    public ProductCartPage clickPurchaseBtn() {
        eltPurchaseBtn.shouldBe(visible, enabled).click();
        return this;
    }

    public CartItemDTO getCartItemByIndex(int index) {
        SelenideElement cartItemElt = eltCartItems.get(index);
        String title = cartItemElt.find(CART_ITEM_TITLE).getText();
        String price = cartItemElt.find(CART_PRICE).getText();
        int quantity = Integer.parseInt(cartItemElt.find(CART_QUANTITY_INPUT).getText());

        return new CartItemDTO(title, price, quantity);
    }

    public ProductItemDTO getProductItemByIndex(int index) {
        SelenideElement productItemElt = eltShopItems.get(index);
        String title = productItemElt.find(SHOP_ITEM_TITLE).getText();
        String price = productItemElt.find(SHOT_PRICE).getText();

        return new ProductItemDTO(title, price);
    }

}