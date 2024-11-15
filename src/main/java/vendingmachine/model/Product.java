package vendingmachine.model;

import java.util.Objects;

public class Product {

    public static final int PRICE_MIN = 100;

    public static final int PRICE_UNIT = 10;

    private final String name;

    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
