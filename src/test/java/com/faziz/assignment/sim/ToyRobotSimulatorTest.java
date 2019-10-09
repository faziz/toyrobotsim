package com.faziz.assignment.sim;

import org.junit.Test;
import static org.junit.Assert.*;

public class ToyRobotSimulatorTest {

    @Test
    public void testCheckCommands() {
        ToyRobotSimulator sim = new ToyRobotSimulator();
        assertTrue(sim.canHandle("PLACE"));
        assertTrue(sim.canHandle("LEFT"));
        assertTrue(sim.canHandle("RIGHT"));
        assertTrue(sim.canHandle("MOVE"));
    }
    
}
