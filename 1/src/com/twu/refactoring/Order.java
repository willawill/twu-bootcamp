package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> itemList;


    public Order(String customerName, String customerAddress, List<LineItem> itemList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(customerName);
        output.append(customerAddress);

        output.append(displayLineItems());
        output.append("Sales Tax");
        output.append('\t');

        output.append(this.calculateTotalSalesTax());
        output.append("Total Amount");
        output.append('\t');

        output.append(this.calculateTotalAmount());
        return output.toString();

    }

    private String displayLineItems() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : itemList) {
            output.append(lineItem.toString());

        }
        return output.toString();
    }

    private double calculateTotalAmount() {
        double totalAmount = 0;

        for (LineItem oneItem : itemList) {
            totalAmount += oneItem.calculateAmountWithSalesTax();
        }
        return totalAmount;
    }

    private double calculateTotalSalesTax() {
        double totalSalesTax = 0;

        for (LineItem oneItem : itemList) {
            totalSalesTax += oneItem.calculateSalesTax();
        }
        return totalSalesTax;
    }

}
