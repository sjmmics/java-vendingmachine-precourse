package vendingmachine.model.dto;

import vendingmachine.model.entity.Inventory;
import vendingmachine.model.entity.Product;
import vendingmachine.util.message.ExceptionMessage;

import static vendingmachine.util.StringValidator.VALIDATE_BASIC_FORMAT;

public class PurchaseProduct {

    private final Product product;

    public PurchaseProduct(Product product) {
        this.product = product;
    }

    public static PurchaseProduct getOfLineAndInventory(String productName, Inventory inventory) {
        VALIDATE_BASIC_FORMAT(productName);
        if (!contains(productName, inventory)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_CONTAINS_PRODUCT.toString());
        }
        if (outOfStock(productName, inventory)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_STOCK.toString());
        }
        Product product = inventory.getProductByName(productName);
        return new PurchaseProduct(product);
    }

    private static boolean contains(String productName, Inventory inventory) {
        return inventory.containsFromProductName(productName);
    }

    private static boolean outOfStock(String productName, Inventory inventory) {
        return inventory.outOfStockByProductName(productName);
    }

    public Product get() {
        return product;
    }

    public int getPrice() {
        return product.getPrice();
    }

}
