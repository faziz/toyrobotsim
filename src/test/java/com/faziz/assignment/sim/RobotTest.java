package com.faziz.assignment.sim;

import static com.faziz.assignment.sim.Direction.*;
import static com.faziz.assignment.sim.Rotation.*;
import static java.lang.Boolean.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RobotTest {
    
    private TableTop tableTop;
    private Robot robot;
    
    @Before
    public void setUp() {
        tableTop = new TableTop(5, 5);
    }
    
    /**
     * Test of rotate method, of class Robot.
     */
    @Test
    public void testRotate() {
        robot = new Robot(NORTH, tableTop);
        Rotation rotation = LEFT;
        Direction expResult = WEST;
        Direction result = robot.rotate(rotation);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Robot.
     */
    @Test
    public void testMove() {
        robot = new Robot(NORTH, tableTop);
        Boolean expResult = TRUE;
        Boolean result = robot.move();
        assertEquals(expResult, result);
        assertEquals(0, tableTop.getCurrentPosition().x);
        assertEquals(1, tableTop.getCurrentPosition().y);
    }

    /**
     * Test of getDirection method, of class Robot.
     */
    @Test
    public void testGetDirection() {
        robot = new Robot(NORTH, tableTop);
        Direction direction = robot.rotate(RIGHT);
        assertEquals(EAST, direction);
    }
}
