package com.faziz.assignment.sim;

import static java.lang.Boolean.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class PlaceCommandValidatorTest {
    
    @Test 
    public void testPlaceCommand() {
        PlaceCommandValidator v = new PlaceCommandValidator("PLACE 0,0,NORTH");
        Boolean result = v.validate();
        Boolean expectedResult = TRUE;
        assertEquals(expectedResult, result);
        
        v = new PlaceCommandValidator("PLACE 0,0,SOUTH");
        result = v.validate();
        expectedResult = TRUE;
        assertEquals(expectedResult, result);
        
        v = new PlaceCommandValidator("PLACE");
        result = v.validate();
        expectedResult = FALSE;
        assertEquals(expectedResult, result);
        
        v = new PlaceCommandValidator("PLACE 0");
        result = v.validate();
        expectedResult = FALSE;
        assertEquals(expectedResult, result);
        
        v = new PlaceCommandValidator("PLACE 0,0");
        result = v.validate();
        expectedResult = FALSE;
        assertEquals(expectedResult, result);
        
        v = new PlaceCommandValidator("PLACE X,0,NORTH");
        result = v.validate();
        expectedResult = FALSE;
        assertEquals(expectedResult, result);
        
        
    }
}
