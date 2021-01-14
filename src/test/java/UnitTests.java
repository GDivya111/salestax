import model.Cart;
import model.Item;
import org.junit.Test;
import utilities.FileReaderUtil;
import utilities.ItemsParser;
import utilities.SalesTaxCalc;

import java.util.List;

public class UnitTests {

    private String fileInput = null;
    private List<Item> itemList;

    private void printItems(Cart cart) {
        for (Item item : cart.getItems()) {
            System.out.println(item.toString());
        }
        System.out.println("Sales Taxes:" + cart.getSalesTax());
        System.out.println(String.format("Total:%.2f\n", cart.getTotal()));
    }

    @Test
    public void calculateSalesTaxForInput1() {
        fileInput = FileReaderUtil.readFile("src/test/resources/test_data/input1.txt");
        itemList = ItemsParser.getListOfItems(fileInput);
        printItems(SalesTaxCalc.calculateSalesTax(itemList));
    }

    @Test
    public void calculateSalesTaxForInput2() {
        fileInput = FileReaderUtil.readFile("src/test/resources/test_data/input2.txt");
        itemList = ItemsParser.getListOfItems(fileInput);
        printItems(SalesTaxCalc.calculateSalesTax(itemList));
        ;
    }

    @Test
    public void calculateSalesTaxForInput3() {
        fileInput = FileReaderUtil.readFile("src/test/resources/test_data/input3.txt");
        itemList = ItemsParser.getListOfItems(fileInput);
        printItems(SalesTaxCalc.calculateSalesTax(itemList));
    }
}
