package vendingmachine.model.dto;

import vendingmachine.model.PutMoney;

public class RemainPutMoney {

    private static final String PREFIX = "투입 금액: ";

    private static final String SUFFIX = "원";

    private final int money;

    public RemainPutMoney(int money) {
        this.money = money;
    }

    public static RemainPutMoney getFromPutMoney(PutMoney putMoney) {
        int money = putMoney.get();
        return new RemainPutMoney(money);
    }

    public int get() {
        return money;
    }

    @Override
    public String toString() {
        return PREFIX + money + SUFFIX;
    }

}
