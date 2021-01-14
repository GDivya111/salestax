package utilities;


import model.Cart;
import model.Item;

import java.util.Arrays;
import java.util.List;

public class SalesTaxCalc {

    public static Cart calculateSalesTax(List<Item> items) {
        double salesTax = 0.0;

        for (Item item : items) {
            double itemSalesTax = 0.0;

            if (!isExcluded(item.getName())) {
                itemSalesTax += 0.1 * item.getPrice() * item.getQty();
            }

            if (item.getName().contains("imported")) {
                itemSalesTax += 0.05 * item.getPrice() * item.getQty();
            }
            item.setPrice(item.getPrice() + itemSalesTax);
            salesTax += itemSalesTax;
        }

        salesTax = Math.round(salesTax * 20.0) / 20.0;
        return new Cart(items, salesTax);
    }

    private static boolean isExcluded(String input) {
        boolean flag = false;
        List<String> excludedItems = Arrays.asList("book", "chocolate", "medical", "headache pills");
        for (String curr : excludedItems) {
            if (input.contains(curr)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
