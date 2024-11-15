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


}
