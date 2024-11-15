package vendingmachine.repository;

import vendingmachine.model.Coins;

public class VMRepository {

    private Coins coins;

    public void saveCoins(Coins coins) {
        this.coins = coins;
    }
}
