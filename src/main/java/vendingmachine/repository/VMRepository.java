package vendingmachine.repository;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.PutMoney;
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

    public PutMoney getPutMoney() {
        return null;
    }

    public void deductPutMoney(int price) {
        this.putMoney.deduct(price);
    }

    public PutMoneyDto getPutMoneyToDto() {
        return PutMoneyDto.getFromPutMoney(putMoney);
    public RemainPutMoney getRemainPutMoney() {
        return RemainPutMoney.getFromPutMoney(putMoney);
    }

    }
}
