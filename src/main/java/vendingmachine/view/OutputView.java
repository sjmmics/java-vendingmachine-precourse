package vendingmachine.view;

import vendingmachine.model.Coins;
import vendingmachine.model.dto.RemainPutMoney;
import vendingmachine.util.message.IOMessage;

public class OutputView {

    public void printCoins(Coins coins) {
        System.out.println();
        System.out.println(IOMessage.COINS_VM_HAVE);
        System.out.println(coins);
    }
}
