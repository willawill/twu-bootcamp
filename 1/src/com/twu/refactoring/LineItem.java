package com.twu.refactoring;

public class LineItem {
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