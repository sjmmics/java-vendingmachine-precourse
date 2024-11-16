package vendingmachine.controller;

import vendingmachine.model.Coins;
import vendingmachine.model.Inventory;
import vendingmachine.model.InventoryFactory;
import vendingmachine.model.PutMoney;
import vendingmachine.model.dto.PurchaseProduct;
import vendingmachine.model.dto.RemainPutMoney;
import vendingmachine.model.dto.SmallChange;
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
        createCoinsAndSave(initialMoney);
        createInventoryAndSave();
        createPutMoneyAndSave();
        makeSale();
        printSmallChange();
    }

    private void makeSale() {
        do {
            PurchaseProduct purchaseProduct = getPurchaseProductFromInput();
            service.deductPutMoneyByPurchase(purchaseProduct);
            service.updateInventoryFromPurchase(purchaseProduct);
        } while (doesRemainToSale());
    }

    private PurchaseProduct getPurchaseProductFromInput() {
        Inventory inventory = service.getInventory();
        while (true) {
            try {
                RemainPutMoney remainPutMoney = service.getRemainPutMoney();
                String line = inputView.getPurchaseProductName(remainPutMoney);
                return PurchaseProduct.getOfLineAndInventory(line, inventory);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean doesRemainToSale() {
        return service.doesRemainToSale();
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

    private void createCoinsAndSave(VMInitialMoney initialMoney) {
        Coins coins = service.createCoins(initialMoney);
        outputView.printCoins(coins);
    }

    private void createInventoryAndSave() {
        Inventory inventory = getInventoryFromInput();
        service.saveInventory(inventory);
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

    private void createPutMoneyAndSave() {
        PutMoney putMoney = getPutMoneyFromInput();
        service.savePutMoney(putMoney);
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

    private void printSmallChange() {
        SmallChange smallChange = service.getSmallChange();
        RemainPutMoney putMoney = service.getRemainPutMoney();
        outputView.printSmallChange(smallChange, putMoney);
    }

}
