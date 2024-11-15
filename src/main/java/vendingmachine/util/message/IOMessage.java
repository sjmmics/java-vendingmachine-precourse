package vendingmachine.util.message;

public enum IOMessage {

    ENTER_INITIAL_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
