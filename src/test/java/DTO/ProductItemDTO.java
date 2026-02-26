package DTO;

public class ProductItemDTO {
    public final String title;
    final String price;

    ProductItemDTO(String title, String price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductItem{title='" + title + "', price='" + price + "'}";
    }
}
