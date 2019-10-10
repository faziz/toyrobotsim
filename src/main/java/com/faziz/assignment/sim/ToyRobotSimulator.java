package com.faziz.assignment.sim;

import static java.lang.String.format;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import static java.util.stream.Stream.of;

/**
 * Entry point for the application.
 */
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
        while (sc.hasNextLine()) {
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
        return this.robot.move(x, y);
    }
    
    private Boolean moveHandler(String cmd) {
        return robot != null ? robot.move() : false;
    }
    
    private Boolean rotationHandler(String cmd) {
        boolean isValidRotation = validRotationCommand(cmd);
        if (null != this.robot && isValidRotation) {
            robot.rotate(Rotation.valueOf(cmd));
        }
        return isValidRotation;
    }

    private boolean validRotationCommand(String cmd) {
        boolean isValidRotation = of(Rotation.values()).
            filter(r -> r.toString().equals(cmd)).findFirst().isPresent();
        return isValidRotation;
    }
    
    private Boolean reportHandler(String cmd) {
        String report = robot != null ? robotReport() : "Please place robot using the PLACE command";
        System.out.println(report);
        return true;
    }

    private String robotReport() {
        Point currentPosition = tableTop.getCurrentPosition();
        return format("%s,%s,%s", currentPosition.x, currentPosition.y, robot.getDirection());
    }
    
    private Boolean unsupportedCommand(String cmd) {
        System.out.println("Command not supported.");
        return false;
    }
}
