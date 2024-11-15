package vendingmachine.appconfig;

import vendingmachine.controller.VMController;
import vendingmachine.repository.VMRepository;
import vendingmachine.service.VMService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class AppConfig {

    private VMRepository repository() {
        return new VMRepository();
    }

    private VMService service() {
        return new VMService(repository());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    public VMController getVMController() {
        return new VMController(inputView(), outputView(), service());
    }

}
