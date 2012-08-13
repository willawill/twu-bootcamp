package com.twu.refactoring;

public class OrderReceipt {
    public static final double DOUBLE = 1.4;

    private Order order;
    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(order.toString());
        return output.toString();

    }
    /*
    public void printHeaders() {
        StringBuilder output = new StringBuilder();
        String.format("{0}\t{1}\t{2}\t{3}\n", getDescription(), getPrice(), getQuantity(), totalAmount() + "\n");

        output.append("======Printing Orders======\n");

    //Be careful about calling method with performance concern.
    }
    */
}