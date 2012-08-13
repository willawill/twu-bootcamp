package com.twu.refactoring.state;

import org.omg.CORBA.PUBLIC_MEMBER;

public enum DirectionUnit {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int value;

    DirectionUnit(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
