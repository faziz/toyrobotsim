package com.faziz.assignment.sim;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ToyRobotSimulator {
    
    private final Map<String, Function<String, Boolean>> commandHandlers;

    public ToyRobotSimulator() {
        this.commandHandlers = new HashMap<>();
        this.commandHandlers.put("PLACE",  this::placeHandler);
        this.commandHandlers.put("MOVE",   this::moveHandler);
        this.commandHandlers.put("LEFT",   this::rotationHandler);
        this.commandHandlers.put("RIGHT",  this::rotationHandler);
        this.commandHandlers.put("REPORT", this::reportHandler);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public Boolean canHandle(String command) {
        return this.commandHandlers.containsKey(command);
    }
    
    private Boolean placeHandler(String cmd) {
        return false;
    }
    
    private Boolean moveHandler(String cmd) {
        return false;
    }
    
    private Boolean rotationHandler(String cmd) {
        return false;
    }
    
    private Boolean reportHandler(String cmd) {
        return false;
    }
}
