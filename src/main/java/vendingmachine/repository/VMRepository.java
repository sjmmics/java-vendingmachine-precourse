package vendingmachine.repository;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;

public class VMRepository {

    private Coins coins;

    private Inventory inventory;

    public void saveCoins(Coins coins) {
        this.coins = coins;
    }

    public void saveInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
