package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final String PREFIX = "COIN_";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static List<Integer> getAmounts() {
        List<Integer> amounts = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            amounts.add(coin.amount);
        }
        return amounts;
    }

    public static Coin getFromAmount(int amount) {
        String name = PREFIX + amount;
        return Coin.valueOf(name);
    }

}
