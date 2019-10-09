package com.faziz.assignment.sim;

import org.junit.Test;
import static org.junit.Assert.*;

public class DirectionTest {
    
    private final Point currentPosition = new Point(0, 0);
    
    @Test
    public void testMoveEast() {
        Direction direction = Direction.EAST;
        Point expectedNewPosition = new Point(1, 0);
        Point result = direction.newPosition(currentPosition);
        assertEquals(expectedNewPosition, result);
    }
    
    @Test
    public void testMoveWest() {
        Direction direction = Direction.WEST;
        Point expectedNewPosition = new Point(-1, 0);
        Point result = direction.newPosition(currentPosition);
        assertEquals(expectedNewPosition, result);
    }

    @Test
    public void testMoveNorth() {
        Direction direction = Direction.NORTH;
        Point expectedNewPosition = new Point(0, 1);
        Point result = direction.newPosition(currentPosition);
        assertEquals(expectedNewPosition, result);
    }
    
    @Test
    public void testMoveSouth() {
        Direction direction = Direction.SOUTH;
        Point expectedNewPosition = new Point(0, -1);
        Point result = direction.newPosition(currentPosition);
        assertEquals(expectedNewPosition, result);
    }
}
