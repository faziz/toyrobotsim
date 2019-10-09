package com.faziz.assignment.sim;

import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {
    
    private final Point point1 = new Point(0, 0);
    private final Point point2 = new Point(4, 4);

    @Test
    public void testBetween_base00() {
        Point point = new Point(1, 2);
        Boolean expResult = true;
        Boolean result = point.between(point1, point2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBetween_base00_Y_Outlier() {
        Point point = new Point(1, 6);
        Boolean expResult = false;
        Boolean result = point.between(point1, point2);
        assertEquals(expResult, result);
        
        point = new Point(1, -5);
        result = point.between(point1, point2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBetween_base00_X_Outlier() {
        Point point = new Point(11, 4);
        Boolean expResult = false;
        Boolean result = point.between(point1, point2);
        assertEquals(expResult, result);
        
        point = new Point(-1, 4);
        result = point.between(point1, point2);
        assertEquals(expResult, result);
    }
}
