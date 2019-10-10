package com.faziz.assignment.sim;

import static java.lang.Boolean.TRUE;
import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class ToyRobotSimulator {

    /** Simulator command handler mapping. */
    private final Map<String, Function<String, Boolean>> cmdHandlers;

    private final TableTop tableTop;
    private Robot robot;
    
    public ToyRobotSimulator() {
        this.cmdHandlers = new HashMap<>();
        this.cmdHandlers.put("PLACE",  this::placeHandler);
        this.cmdHandlers.put("MOVE",   this::moveHandler);
        this.cmdHandlers.put("LEFT",   this::rotationHandler);
        this.cmdHandlers.put("RIGHT",  this::rotationHandler);
        this.cmdHandlers.put("REPORT", this::reportHandler);

        this.tableTop = new TableTop(5, 5);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ToyRobotSimulator sim = new ToyRobotSimulator();
        Scanner sc = new Scanner(System.in);
        while (TRUE) {
            String cmdLine = sc.nextLine();
            String cmdName = cmdLine.startsWith("PLACE ") ? "PLACE" : cmdLine;
            sim.cmdHandlers.getOrDefault(cmdName, sim::unsupportedCommand).apply(cmdLine);
        }
    }
    
    public Boolean canHandle(String command) {
        return this.cmdHandlers.containsKey(command);
    }
    
    private Boolean placeHandler(String cmd) {
        PlaceCommandValidator v = new PlaceCommandValidator(cmd);
        Boolean isValidCommand = v.validate();
        
        if (!isValidCommand) {
            return isValidCommand;
        }
        
        String[] cmdParams = cmd.split(" ")[1].split(",");
        Integer x = Integer.valueOf(cmdParams[0].trim());
        Integer y = Integer.valueOf(cmdParams[1].trim());
        Direction direction = Direction.valueOf(cmdParams[2]);
        
        this.robot = new Robot(direction, tableTop);
        return this.tableTop.setCurrentPosition(x, y);
    }
    
    private Boolean moveHandler(String cmd) {
        return robot.move();
    }
    
    private Boolean rotationHandler(String cmd) {
        robot.rotate(Rotation.valueOf(cmd));
        return true;
    }
    
    private Boolean reportHandler(String cmd) {
        Point currentPosition = tableTop.getCurrentPosition();
        System.out.println(format("%s,%s,%s", currentPosition.x, currentPosition.y, robot.getDirection()));
        return true;
    }
    
    private Boolean unsupportedCommand(String cmd) {
        System.out.println("Command not supported.");
        return false;
    }
}
