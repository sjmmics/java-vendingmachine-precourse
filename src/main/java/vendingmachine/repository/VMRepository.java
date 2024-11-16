package vendingmachine.repository;

import vendingmachine.model.entity.Coins;
import vendingmachine.model.entity.Inventory;
import vendingmachine.model.entity.PutMoney;
import vendingmachine.model.dto.RemainPutMoney;

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

    public Inventory getInventory() {
        return inventory;
    }

    public void deductPutMoney(int price) {
        this.putMoney.deduct(price);
    }

    public RemainPutMoney getRemainPutMoney() {
        return RemainPutMoney.getFromPutMoney(putMoney);
    }

    public Coins getCoins() {
        return coins;
    }
}
