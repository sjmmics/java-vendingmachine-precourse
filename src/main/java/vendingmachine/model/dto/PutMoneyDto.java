package vendingmachine.model.dto;

import vendingmachine.model.PutMoney;

public class PutMoneyDto {

    private static final String PREFIX = "투입 금액: ";

    private static final String SUFFIX = "원";

    private final int money;

    public PutMoneyDto(int money) {
        this.money = money;
    }

    public static PutMoneyDto getFromPutMoney(PutMoney putMoney) {
        int money = putMoney.get();
        return new PutMoneyDto(money);
    }

    public int get() {
        return money;
    }

    @Override
    public String toString() {
        return PREFIX + money + SUFFIX;
    }

}
