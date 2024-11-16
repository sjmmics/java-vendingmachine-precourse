package vendingmachine.model.dto;

import vendingmachine.model.entity.Coin;
import vendingmachine.model.entity.Coins;

import java.util.Map;

public class SmallChange {

    public static final String HEAD = "잔돈";

    public static final String DELIMITER = " - ";

    private final Map<Coin, Integer> smallChange;

    public SmallChange(Map<Coin, Integer> smallChange) {
        this.smallChange = smallChange;
    }

    public static SmallChange getOf(RemainPutMoney remainPutMoney, Coins coins) {
        int remainMoney = remainPutMoney.get();
        Map<Coin, Integer> smallChange = coins.getSmallChange(remainMoney);
        return new SmallChange(smallChange);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD)
                .append("\n");
        for (Map.Entry<Coin, Integer> entry : smallChange.entrySet()) {
            Coin coin = entry.getKey();
            int coinCount = entry.getValue();
            stringBuilder.append(coin)
                    .append(DELIMITER)
                    .append(coinCount)
                    .append("개")
                    .append("\n");
        }
        return stringBuilder.toString();
    }

}
