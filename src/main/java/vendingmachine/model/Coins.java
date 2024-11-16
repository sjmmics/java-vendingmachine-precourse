package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Coins {

    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static Coins getFromInitialMoney(int initialMoney) {
        List<Integer> coinAmounts = Coin.getAmounts();
        Map<Coin, Integer> coins = new TreeMap<>();
        while (initialMoney > 0) {
            int money = Randoms.pickNumberInList(coinAmounts);
            if (money <= initialMoney) {
                Coin coin = Coin.getFromAmount(money);
                coins.put(coin, coins.getOrDefault(coin, 0) + 1);
                initialMoney -= money;
            }
        }
        return new Coins(coins);
    }

    public Map<Coin, Integer> getSmallChange(int remainMoney) {
        Map<Coin, Integer> smallChange = new TreeMap<>();
        while (remainMoney > 0) {
            for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
                Coin coin = entry.getKey();
                int deductionCoinCount = getDeductionCoinCount(coin, remainMoney);
                remainMoney -= (coin.getAmount() * deductionCoinCount);
                addSmallChange(coin, deductionCoinCount, smallChange);
            }
        }
        return smallChange;
    }

    private int getDeductionCoinCount(Coin coin, int remainMoney) {
        int coinAmount = coin.getAmount();
        int deductionCoinCount = remainMoney / coinAmount;
        int coinCount = coins.get(coin);
        return Math.min(deductionCoinCount, coinCount);
    }

    private void addSmallChange(Coin coin, int deductionCoinCount,
                                Map<Coin, Integer> smallChange) {
        if (deductionCoinCount == 0) {
            return;
        }
        smallChange.put(coin, deductionCoinCount);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Coin coin : Coin.values()) {
            int quantity = coins.getOrDefault(coin, 0);
            stringBuilder.append(coin.toString())
                    .append(" - ")
                    .append(quantity)
                    .append("개")
                    .append("\n");
        }
        return stringBuilder.toString();
    }

}
