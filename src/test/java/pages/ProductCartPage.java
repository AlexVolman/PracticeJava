package pages;

import DTO.ProductItemDTO;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.Config;

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

    public ProductCartPage checkCart(int index, ProductItemDTO expectedItem) {

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

    public ProductCartPage increaseProductNum() {
        return this;
    }

    public ProductCartPage reduceProductNum() {
        return this;
    }

    public ProductCartPage checkTotalPrice() {
        return this;
    }

    public int getQuantityOfProducts() {
        return eltShopItems.size();
    }

    public ProductCartPage scrollToLast() {
        return this;
    }

    public ProductCartPage clickPurchaseBtn() {
        eltPurchaseBtn.shouldBe(visible, enabled).click();
        return this;
    }

}
