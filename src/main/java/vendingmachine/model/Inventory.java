package vendingmachine.model;

import java.util.Map;

public class Inventory {

    private final Map<Product, Integer> inventory;

    public Inventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

}
