package vendingmachine.model;

import vendingmachine.util.message.ExceptionMessage;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.util.StringValidator.VALIDATE_BASIC_FORMAT;
import static vendingmachine.util.StringValidator.VALIDATE_NUMBER_FORMAT;

public class InventoryFactory {

    private static final int NAME_INDEX = 0;

    private static final int PRICE_INDEX = 1;

    private static final int QUANTITY_INDEX = 2;

    public Inventory create(String line) {
        VALIDATE_BASIC_FORMAT(line);
        String[] inventoryLines = line.split(";");
        validateDoesSeparateThreePart(inventoryLines);
        validatePriceAndQuantityFormat(inventoryLines);
        Map<Product, Integer> inventory = getMapFromLine(line);
        return new Inventory(inventory);
    }

    private void validateDoesSeparateThreePart(String[] inventoryLines)
                                               throws IllegalArgumentException {

        for (String inventoryLine : inventoryLines) {
            String[] inventorySplit = inventoryLine.split(",");
            if (inventorySplit.length != 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validatePriceAndQuantityFormat(String[] inventoryLines)
                                                throws IllegalArgumentException {
        for (String inventoryLine : inventoryLines) {
            String[] inventorySplit = inventoryLine.split(",");
            String price = inventorySplit[PRICE_INDEX];
            String quantity = inventorySplit[QUANTITY_INDEX];
            validatePriceAndQuantityDigit(price, quantity);
            validatePriceAndQuantityContent(price, quantity);
        }
    }

    private void validatePriceAndQuantityDigit(String price, String quantity)
                                               throws IllegalArgumentException {
        VALIDATE_NUMBER_FORMAT(price);
        VALIDATE_NUMBER_FORMAT(quantity);
        validatePriceAndQuantityContent(price, quantity);
    }

    private void validatePriceAndQuantityContent(String price, String quantity)
                                                 throws IllegalArgumentException {
        if (doesUnderPriceMin(price)) {
            throw new IllegalArgumentException(ExceptionMessage.PRICE_MOD_TEN_NOT_ZERO.get());
        }
        if (isNotModZero(price)) {
            throw new IllegalArgumentException(ExceptionMessage.MOD_TEN_NOT_ZERO.get());
        }
        if (isQuantityZero(quantity)) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_QUANTITY.get());
        }
    }

    private boolean isNotModZero(String priceLine) {
        int price = Integer.parseInt(priceLine);
        return price % Product.PRICE_UNIT != 0;
    }

    private boolean isQuantityZero(String quantityLine) {
        int quantity = Integer.parseInt(quantityLine);
        return quantity == 0;
    }

    private boolean doesUnderPriceMin(String priceLine) {
        int price = Integer.parseInt(priceLine);
        return price < Product.PRICE_MIN;
    }

    private Map<Product, Integer> getMapFromLine(String line) {
        Map<Product, Integer> inventory = new HashMap<>();
        String[] lineSplit = line.split(";");
        for (String inventoryLine : lineSplit) {
            putProductAndQuantityToInventory(inventoryLine, inventory);
        }
        return inventory;
    }

    private static void putProductAndQuantityToInventory(String inventoryLine,
                                                         Map<Product, Integer> inventory) {
        String[] inventoryInfos = inventoryLine.split(",");

        String name = inventoryInfos[NAME_INDEX];
        int price = Integer.parseInt(inventoryInfos[PRICE_INDEX]);
        int quantity = Integer.parseInt(inventoryInfos[QUANTITY_INDEX]);

        Product product = new Product(name, price);
        inventory.put(product, quantity);
    }

}
