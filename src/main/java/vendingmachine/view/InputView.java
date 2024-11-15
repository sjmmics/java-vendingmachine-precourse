package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.message.IOMessage;

public class InputView {


    public String getInitialMoney() {
        System.out.println(IOMessage.ENTER_INITIAL_MONEY);
        return Console.readLine();
    }

    public String getInventory() {
        System.out.println(IOMessage.ENTER_INVENTORY);
        return Console.readLine();
    }
}
