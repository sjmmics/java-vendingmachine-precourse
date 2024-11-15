package vendingmachine.model.dto;

import vendingmachine.util.message.ExceptionMessage;

import static vendingmachine.util.StringValidator.VALIDATE_BASIC_FORMAT;
import static vendingmachine.util.StringValidator.VALIDATE_NUMBER_FORMAT;

public class VMInitialMoney {

    private static final int MIN = 10;

    private final int money;

    public VMInitialMoney(String line) {
        VALIDATE_BASIC_FORMAT(line);
        VALIDATE_NUMBER_FORMAT(line);
        validateContent(line);
        this.money = Integer.parseInt(line);
    }

    private void validateContent(String line) {
        if (doesUnderMin(line)) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_UNDER_MIN.get());
        }
        if (doesModTenNotZero(line)) {
            throw new IllegalArgumentException(ExceptionMessage.MOD_TEN_NOT_ZERO.get());
        }
    }

    private boolean doesUnderMin(String line) {
        int number = Integer.parseInt(line);
        return number < MIN;
    }

    private boolean doesModTenNotZero(String line) {
        int number = Integer.parseInt(line);
        return number % MIN != 0;
    }

    public int get() {
        return money;
    }

}
