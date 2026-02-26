package DTO;

public class ProductItemDTO {

    final String title;

    final String price;

    public ProductItemDTO(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ProductItem{title='" + title + "', price='" + price + "'}";
    }
}
