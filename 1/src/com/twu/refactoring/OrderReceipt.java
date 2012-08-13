package com.twu.refactoring;

public class OrderReceipt {
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
}