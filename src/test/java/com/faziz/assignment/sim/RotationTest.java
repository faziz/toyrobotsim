package com.faziz.assignment.sim;

import static com.faziz.assignment.sim.Direction.*;
import static com.faziz.assignment.sim.Rotation.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotationTest {

    @Test
    public void testRotate_NORTH() {
        Direction direction = NORTH;
        Direction expResult = WEST;
        Rotation rotation = LEFT;
        Direction result = rotation.rotate(direction);
        assertEquals(expResult, result);
        
        direction = NORTH;
        expResult = EAST;
        rotation = RIGHT;
        result = rotation.rotate(direction);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRotate_WEST() {
        Direction direction = WEST;
        Direction expResult = SOUTH;
        Rotation rotation = LEFT;
        Direction result = rotation.rotate(direction);
        assertEquals(expResult, result);
        
        direction = WEST;
        expResult = NORTH;
        rotation = RIGHT;
        result = rotation.rotate(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testRotate_SOUTH() {
        Direction direction = SOUTH;
        Direction expResult = EAST;
        Rotation rotation = LEFT;
        Direction result = rotation.rotate(direction);
        assertEquals(expResult, result);
        
        direction = SOUTH;
        expResult = WEST;
        rotation = RIGHT;
        result = rotation.rotate(direction);
        assertEquals(expResult, result);
    }

    @Test
    public void testRotate_EAST() {
        Direction direction = EAST;
        Direction expResult = NORTH;
        Rotation rotation = LEFT;
        Direction result = rotation.rotate(direction);
        assertEquals(expResult, result);
        
        direction = EAST;
        expResult = SOUTH;
        rotation = RIGHT;
        result = rotation.rotate(direction);
        assertEquals(expResult, result);
    }
    
}
