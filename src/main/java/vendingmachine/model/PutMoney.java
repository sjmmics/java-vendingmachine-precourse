package vendingmachine.model;

import static vendingmachine.util.StringValidator.VALIDATE_BASIC_FORMAT;
import static vendingmachine.util.StringValidator.VALIDATE_NUMBER_FORMAT;

public class PutMoney {

    private int money;

    public PutMoney(int money) {
        this.money = money;
    }

    public static PutMoney getFromLine(String line) {
        VALIDATE_BASIC_FORMAT(line);
        VALIDATE_NUMBER_FORMAT(line);
        int money = Integer.parseInt(line);
        return new PutMoney(money);
    }

    public void deduct(int price) {
        this.money -= price;
    }

    public int get() {
        return money;
    }
}
