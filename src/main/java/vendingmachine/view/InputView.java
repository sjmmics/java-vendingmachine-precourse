package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.message.IOMessage;

public class InputView {


    public String getInitialMoney() {
        System.out.println(IOMessage.ENTER_INITIAL_MONEY);
        return Console.readLine();
    }
}
