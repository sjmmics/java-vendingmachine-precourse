package vendingmachine;

import vendingmachine.appconfig.AppConfig;
import vendingmachine.controller.VMController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        VMController controller = appConfig.getVMController();
        controller.run();
    }
}
