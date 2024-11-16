package vendingmachine.view;

import vendingmachine.model.entity.Coins;
import vendingmachine.model.dto.RemainPutMoney;
import vendingmachine.model.dto.SmallChange;
import vendingmachine.util.message.IOMessage;

public class OutputView {

    public void printCoins(Coins coins) {
        System.out.println();
        System.out.println(IOMessage.COINS_VM_HAVE);
        System.out.println(coins);
    }

    public void printSmallChange(SmallChange smallChange, RemainPutMoney putMoney) {
        System.out.println();
        System.out.println(putMoney);
        System.out.println(smallChange);
    }
}
