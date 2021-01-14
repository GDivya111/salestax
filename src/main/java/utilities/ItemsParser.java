package utilities;


import model.Item;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemsParser {

    public static List<Item> getListOfItems(String input) {
        List<Item> items = new ArrayList<>();

        for (String curr : input.split("\\n")) {

            int qty = 0;
            String description = "";
            double price = 0.0;

            for (String temp : curr.split("\\s")) {
                if (NumberUtils.isCreatable(temp) && qty == 0) {
                    qty = Integer.parseInt(temp);
                } else if (NumberUtils.isCreatable(temp) && qty > 0) {
                    price = Double.parseDouble(temp);
                } else {
                    description += temp + " ";
                }
            }

            items.add(new Item(description, qty, price));
        }
        return items;
    }

}
