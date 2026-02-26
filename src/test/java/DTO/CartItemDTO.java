package DTO;


class CartItem {
    private final String title;
    private final String basePrice; // цена за единицу (из списка товаров)
    private int quantity;

    CartItem(String title, String basePrice, int quantity) {
        this.title = title;
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    // Геттеры
    String getTitle() { return title; }
    String getBasePrice() { return basePrice; }
    int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "CartItem{title='" + title +
                "', basePrice='" + basePrice +
                "', quantity=" + quantity + "}";
    }
}
