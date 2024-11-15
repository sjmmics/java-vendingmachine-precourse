package vendingmachine.controller;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.InventoryFactory;
import vendingmachine.model.dto.VMInitialMoney;
import vendingmachine.service.VMService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VMController {

    private final InputView inputView;

    private final OutputView outputView;

    private final VMService service;

    public VMController(InputView inputView, OutputView outputView, VMService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        VMInitialMoney initialMoney = getInitialMoney();
        VMInitialMoney initialMoney = getInitialMoneyFromInput();
        Coins coins = service.createCoins(initialMoney);
        outputView.printCoins(coins);
    }

    private VMInitialMoney getInitialMoneyFromInput() {
        while (true) {
            try {
                String line = inputView.getInitialMoney();
                return new VMInitialMoney(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
