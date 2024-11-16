package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import vendingmachine.model.entity.Coin;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {

    @ParameterizedTest
    @MethodSource("coinAmountAndCoinType")
    @DisplayName("코인 금액으로 코인 객체 가져오기 테스트")
    void getCoinTypeByAmountTest(int amount, Coin expectedCoin) {
        Coin coin = Coin.getFromAmount(amount);
        assertEquals(coin, expectedCoin);

    }

    static Stream<Arguments> coinAmountAndCoinType() {
        return Stream.of(
                Arguments.arguments(10, Coin.COIN_10),
                Arguments.arguments(50, Coin.COIN_50),
                Arguments.arguments(100, Coin.COIN_100),
                Arguments.arguments(500, Coin.COIN_500)
        );
    }

}