package vendingmachine.controller;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.InventoryFactory;
import vendingmachine.model.PutMoney;
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
        VMInitialMoney initialMoney = getInitialMoneyFromInput();
        Coins coins = service.createCoins(initialMoney);
        outputView.printCoins(coins);
        Inventory inventory = getInventoryFromInput();
        service.saveInventory(inventory);
        PutMoney putMoney = getPutMoneyFromInput();
        service.savePutMoney(putMoney);
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

    private Inventory getInventoryFromInput() {
        InventoryFactory factory = new InventoryFactory();
        while (true) {
            try {
                String line = inputView.getInventory();
                return factory.create(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PutMoney getPutMoneyFromInput() {
        while (true) {
            try {
                String line = inputView.getPutMoney();
                return PutMoney.getFromLine(line);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
