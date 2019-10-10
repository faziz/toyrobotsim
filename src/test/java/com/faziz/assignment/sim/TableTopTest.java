package com.faziz.assignment.sim;

import static com.faziz.assignment.sim.Direction.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TableTopTest {

    private TableTop tableTop;

    @Before
    public void setup() {
        tableTop = new TableTop(5, 5);
    }

    @Test
    public void testGetCurrentPosition() {
        Point expectedCurrentPosition = new Point(0, 0);
        Point result = tableTop.getCurrentPosition();
        assertEquals(expectedCurrentPosition, result);
    }

    @Test
    public void testMoveEast_isValid() {
        Point expectedCurrentPosition = new Point(1, 0);
        Boolean successfull = tableTop.move(EAST);
        assertTrue(successfull);
        Point result = tableTop.getCurrentPosition();
        assertEquals(expectedCurrentPosition, result);
        
        expectedCurrentPosition = new Point(2, 0);
        successfull = tableTop.move(EAST);
        assertTrue(successfull);
        result = tableTop.getCurrentPosition();
        assertEquals(expectedCurrentPosition, result);
    }
    
    @Test
    public void testMoveNorth_isValid() {
        Point expectedCurrentPosition = new Point(0, 1);
        Boolean successfull = tableTop.move(NORTH);
        assertTrue(successfull);
        Point result = tableTop.getCurrentPosition();
        assertEquals(expectedCurrentPosition, result);
        
        expectedCurrentPosition = new Point(0, 0);
        successfull = tableTop.move(SOUTH);
        assertTrue(successfull);
        result = tableTop.getCurrentPosition();
        assertEquals(expectedCurrentPosition, result);
    }
}
