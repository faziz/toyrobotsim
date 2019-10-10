package com.faziz.assignment.sim;

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
        System.out.println("rotate");
        Rotation rotation = null;
        Direction expResult = null;
        Direction result = robot.rotate(rotation);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Robot.
     */
    @Test
    public void testMove() {
        Boolean expResult = null;
        Boolean result = robot.move();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirection method, of class Robot.
     */
    @Test
    public void testGetDirection() {
        Direction expResult = null;
        Direction result = robot.getDirection();
        assertEquals(expResult, result);
    }
    
}
