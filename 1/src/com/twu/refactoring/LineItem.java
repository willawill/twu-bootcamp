package com.twu.refactoring;

public class LineItem {
    private static final String PRINT_FORMAT_TEMPLATE="%s\t%.1f\t%d\t%s\n";

    private String itemName;

    private double price;
    private int quantity;
    private final double SALES_TAX_RATE = 0.10;



    public LineItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(itemName);
        output.append('\t');
        output.append(price);
        output.append('\t');
        output.append(quantity);
        output.append('\t');
        output.append(this.calculateTotalAmount());
        output.append('\n');
        return output.toString();
    }
//Though it's not Lineitem's responsibility to do the calculation but in order not to break the encapsulation

    private double calculateTotalAmount() {
        return quantity * price;
    }

    public double calculateAmountWithSalesTax() {
        return this.calculateTotalAmount() + this.calculateSalesTax();
    }

    public double calculateSalesTax(){
        return this.calculateTotalAmount()* SALES_TAX_RATE;
    }


}