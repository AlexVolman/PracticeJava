package DTO;

public class CartItemDTO {

    private final String title;

    private final String basePrice; // цена за единицу (из списка товаров)

    private int quantity;

    public CartItemDTO(String title, String basePrice, int quantity) {
        this.title = title;
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBasePrice() {
        return this.basePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartItem{title='" + title +
                "', basePrice='" + basePrice +
                "', quantity=" + quantity + "}";
    }
}
