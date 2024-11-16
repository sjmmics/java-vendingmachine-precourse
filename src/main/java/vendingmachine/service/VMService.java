package vendingmachine.service;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.PutMoney;
import vendingmachine.model.dto.PurchaseProduct;
import vendingmachine.model.dto.PutMoneyDto;
import vendingmachine.model.dto.RemainPutMoney;
import vendingmachine.model.dto.VMInitialMoney;
import vendingmachine.repository.VMRepository;

public class VMService {

    private final VMRepository repository;

    public VMService(VMRepository repository) {
        this.repository = repository;
    }

    public Coins createCoins(VMInitialMoney initialMoney) {
        Coins coins = Coins.getFromInitialMoney(initialMoney.get());
        repository.saveCoins(coins);
        return coins;
    }

    public void saveInventory(Inventory inventory) {
        repository.saveInventory(inventory);
    }

    public void savePutMoney(PutMoney putMoney) {
        repository.savePutMoney(putMoney);
    }

    public Inventory getInventory() {
        return repository.getInventory();
    }

    public void deductPutMoneyByPurchase(PurchaseProduct purchaseProduct) {
        int price = purchaseProduct.getPrice();
        repository.deductPutMoney(price);
    }

    public void updateInventoryFromPurchase(PurchaseProduct purchaseProduct) {
        Inventory inventory = repository.getInventory();
        inventory.deductionStockFromPurchaseProduct(purchaseProduct);
        repository.saveInventory(inventory);
    }

    public RemainPutMoney getRemainPutMoney() {
        return repository.getRemainPutMoney();
    }

    public boolean doesRemainToSale() {
        Inventory inventory = repository.getInventory();
        RemainPutMoney remainPutMoney = repository.getRemainPutMoney();
        int money = remainPutMoney.get();
        return inventory.doesRemainSaleFromPutMoney(money);
    }
}
