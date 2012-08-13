package com.twu.refactoring.state;

public class Direction {
    private final DirectionUnit direction;
/*

Introduce polymorphism by implementing different behaviors.

    private DirectionState directionStates;
    public Direction(char direction){
        this.direction = direction;
    }
    private void setDirectionState(char direction){
        switch(direction){

        case 'W':
            this.directionState = new North();
            break;
         case 'S':
            this.directionState = new South();
            break;
            //TODO complete other directions.
         default :
            throw new IllegalArgument();
        }
    }
    public Direction turnLeft(){
        return directionState.turnLeft();
    }

    public Direction turnRight(){
        return directionState.turnRight();
    }
     @Override equals and harshcode
    }
*/
    public Direction(DirectionUnit direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        int currentOne = direction.getValue();
        return new Direction(getNextDirection((currentOne + 1) % 4));
    }

    public Direction turnLeft() {
        int currentOne = direction.getValue();
        return new Direction(getNextDirection((currentOne + 3) % 4));
    }

    private DirectionUnit getNextDirection(int num) {
        return DirectionUnit.values()[num];

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return direction != null ? direction.hashCode() : 0;
    }
}
