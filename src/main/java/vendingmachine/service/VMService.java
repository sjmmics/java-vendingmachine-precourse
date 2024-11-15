package vendingmachine.service;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.PutMoney;
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
}
