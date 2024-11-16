package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.dto.RemainPutMoney;
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

    public String getPutMoney() {
        System.out.println();
        System.out.println(IOMessage.ENTER_PUT_MONEY);
        return Console.readLine();
    }

    public String getPurchaseProductName(RemainPutMoney putMoney) {
        System.out.println();
        System.out.println(putMoney);
        System.out.println(IOMessage.ENTER_PURCHASE_PRODUCT_NAME);
        return Console.readLine();
    }

}
