package model;

import java.util.List;

public class Cart {
    List<Item> items;
    double salesTax;
    double total = 0.0;

    public Cart(List<Item> items, double salesTax) {
        this.salesTax = salesTax;
        this.items = items;
        this.items.forEach(item -> {
            item.setName(item.getName().replaceAll("\\bat\\b", ":"));
        });

        for (Item item : items) {
            this.total += item.getPrice();
        }
//        this.total+=salesTax;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
