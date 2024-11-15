package vendingmachine.service;

import vendingmachine.model.Coins;
import vendingmachine.model.dto.VMInitialMoney;
import vendingmachine.repository.VMRepository;

public class VMService {

    private final VMRepository repository;

    public VMService(VMRepository repository) {
        this.repository = repository;
    }

    public void createCoins(VMInitialMoney initialMoney) {
        Coins coins = Coins.getFromInitialMoney(initialMoney.get());
        repository.saveCoins(coins);
    }
}
