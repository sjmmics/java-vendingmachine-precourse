package vendingmachine.repository;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.PutMoney;

public class VMRepository {

    private Coins coins;

    private Inventory inventory;

    private PutMoney putMoney;

    public void saveCoins(Coins coins) {
        this.coins = coins;
    }

    public void saveInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void savePutMoney(PutMoney putMoney) {
        this.putMoney = putMoney;
    }
}
