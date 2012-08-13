package com.twu.refactoring;

import sun.tools.tree.ThisExpression;

public class FieldDefinition {

    private  int startIndex;
    private  int endIndex;
    private  int startValue;
    private  int endValue;
    private  String unitName;


    public FieldDefinition(int startIndex, int endIndex, int startValue, int endValue, String unitName) {
        this.startIndex = startIndex;
        this.startValue = startValue;
        this.endIndex = endIndex;
        this.endValue = endValue;
        this.unitName = unitName;

    }




}
