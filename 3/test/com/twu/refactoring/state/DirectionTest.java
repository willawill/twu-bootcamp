package com.twu.refactoring.state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;

    @Before
    public void setUp() throws Exception {
        north = new Direction(DirectionUnit.NORTH);
        east = new Direction(DirectionUnit.EAST);
    }

    @Test
    public void shouldTurnEastWhenTurnRightFromNorth() {
        Direction east = north.turnRight();
        assertThat(east, is(new Direction(DirectionUnit.EAST)));
    }
    @Test
    public void shouldTurnSouthWhenTurnRightFromEast() {
        Direction south = east.turnRight();
        assertThat(south, is(new Direction(DirectionUnit.SOUTH)));
    }

    @Test
    public void shouldTurnNorthWhenTurnRightFromWest() {
        Direction west = new Direction(DirectionUnit.WEST);
        Direction north = west.turnRight();
        assertThat(north, is(new Direction(DirectionUnit.NORTH)));
    }


    @Test
    public void shouldTurnWestWhenTurnLeftFromNorth() {
        Direction west = north.turnLeft();
        assertThat(west, is(new Direction(DirectionUnit.WEST)));
    }
    @Test
    public void shouldTurnEastWhenTurnLeftFromSouth() {
        Direction south=new Direction(DirectionUnit.SOUTH);
        Direction west = south.turnLeft();
        assertThat(west, is(new Direction(DirectionUnit.EAST)));
    }
    @Test
    public void shouldTurnNorthWhenTurnLeftFromEast() {
        Direction north = east.turnLeft();
        assertThat(north, is(new Direction(DirectionUnit.NORTH)));
    }@Test
    public void shouldTurnSouthWhenTurnLeftFromWest() {
        Direction west=new Direction(DirectionUnit.WEST);
        Direction north = west.turnLeft();
        assertThat(north, is(new Direction(DirectionUnit.SOUTH)));
    }
}
