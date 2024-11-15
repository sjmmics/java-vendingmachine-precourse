package vendingmachine.controller;

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
    }

    private VMInitialMoney getInitialMoney() {
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
