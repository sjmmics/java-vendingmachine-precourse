package vendingmachine.util.message;

public enum ExceptionMessage {

    CONTAINS_BLANK("빈칸(띄어쓰기)가 있으면 안됩니다."),

    EMPTY_INPUT("아무 것도 입력하지 않으셨습니다."),

    IS_NOT_DIGIT("숫자가 아닌 문자를 입력하면 안 됩니다."),

    START_WITH_ZERO("0으로 시작하는 숫자를 입력하면 안됩니다."),

    MONEY_UNDER_MIN("10원 이상이어야 합니다."),

    OUT_OF_INT_BOUND("2의 31제곱보다 작아야 합니다."),

    MOD_TEN_NOT_ZERO("10원으로 나누어 떨어져야 합니다."),

    PRICE_MOD_TEN_NOT_ZERO("가격은 10원으로 나누어 떨어져야 합니다."),

    ZERO_QUANTITY("수량은 1 이상이어야 합니다.");

    public static final String PREFIX = "[ERROR] ";

    public static final String RE_ENTER = " 다시 입력하시세요.";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + this.message + RE_ENTER;
    }
}
