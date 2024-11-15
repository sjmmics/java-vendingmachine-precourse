package vendingmachine.util;

import vendingmachine.util.message.ExceptionMessage;

public class StringValidator {

    public static void VALIDATE_BASIC_FORMAT(String line) {
        if (IS_EMPTY(line)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.get());
        }
        if (CONTAINS_BLANK(line)) {
            throw new IllegalArgumentException(ExceptionMessage.CONTAINS_BLANK.get());
        }
    }

    public static boolean IS_EMPTY(String line) {
        return line.isEmpty();
    }

    public static boolean CONTAINS_BLANK(String line) {
        return line.contains(" ");
    }

    public static void VALIDATE_NUMBER_FORMAT(String line) {
        if (IS_NOT_DIGIT(line)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.get());
        }
        if (START_ZERO(line)) {
            throw new IllegalArgumentException(ExceptionMessage.START_WITH_ZERO.get());
        }
    }

    public static boolean IS_NOT_DIGIT(String line) {
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (!Character.isDigit(letter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean START_ZERO(String line) {
        return line.startsWith("0");
    }

    public static boolean DOES_OUT_OF_INT(String line) {
        try {
            Integer.parseInt(line);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
