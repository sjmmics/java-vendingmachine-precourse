package vendingmachine.controller;

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

}
