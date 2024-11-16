package vendingmachine.model;

import vendingmachine.model.dto.PurchaseProduct;

import java.util.Map;

public class Inventory {

    private final Map<Product, Integer> inventory;

    public Inventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public boolean containsFromProductName(String productName) {
        return getProductByName(productName) != null;
    }

    public Product getProductByName(String productName) {
        Product returnProduct = null;
        for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
            Product product = entry.getKey();
            String name = product.getName();
            if (name.equals(productName)) {
                returnProduct = product;
            }
        }
        return returnProduct;
    }

    public boolean outOfStockByProductName(String productName) {
        Product product = getProductByName(productName);
        int remainStockOfProduct = inventory.get(product);
        return remainStockOfProduct <= 0;
    }

    public void deductionStockFromPurchaseProduct(PurchaseProduct purchaseProduct) {
        Product product = purchaseProduct.get();
        inventory.put(product, inventory.get(product) - 1);
    }

    public boolean doesRemainSaleFromPutMoney(int putMoney) {
        for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
            int stock = entry.getValue();
            Product product = entry.getKey();
            int price = product.getPrice();
            if (stock > 0 && price <= putMoney) {
                return true;
            }
        }
        return false;
    }
}
