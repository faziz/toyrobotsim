package com.faziz.assignment.sim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.String.format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
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
        //Initialize command handler mappings.
        this.cmdHandlers = new HashMap<>();
        this.cmdHandlers.put("PLACE",  this::placeHandler);
        this.cmdHandlers.put("MOVE",   this::moveHandler);
        this.cmdHandlers.put("LEFT",   this::rotationHandler);
        this.cmdHandlers.put("RIGHT",  this::rotationHandler);
        this.cmdHandlers.put("REPORT", this::reportHandler);
        //Initialize table top with given dimension.
        this.tableTop = new TableTop(5, 5);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ToyRobotSimulator sim = new ToyRobotSimulator();
        //Load robot commands and run each of them one-by-one.
        sim.robotCommands().forEach(sim::handleCommand);
    }
    
    /**
     * @return Returns list of commands for the robot.
     * @throws IOException 
     */
    private List<String> robotCommands() throws IOException {
        try (BufferedReader reader = loadReader()) {
            return reader.lines().
                map(cmd -> cmd.trim()).
                    filter(cmd -> !cmd.isEmpty()).
                        collect(toList());
        }
    }

    /**
     * @return Reader based on the command file on the classpath.
     */
    private BufferedReader loadReader() {
        return new BufferedReader(
            new InputStreamReader(
                this.getClass().getResourceAsStream("/robot-commands.txt")));
    }
    
    /**
     * Handles commands one-by-one
     * @param cmd 
     */
    private void handleCommand(final String cmd) {
        String cmdName = cmd.startsWith("PLACE ") ? "PLACE" : cmd;
        //If a command handler is found process the command, else execute unsupportedCommandHandler.
        this.cmdHandlers.getOrDefault(cmdName, this::unsupportedCommandHandler).apply(cmd);
    }
    
    /**
     * @param cmdName
     * @return true if command handler is setup for the given command name, else return false.
     */
    public Boolean canHandle(String cmdName) {
        return this.cmdHandlers.containsKey(cmdName);
    }
    
    /**
     * Initializes a new instance of robot with the given command PLACE argument, if the position 
     * of the robot lies within the allowed dimension of the table top.
     * @param cmd
     * @return 
     */
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
    
    /**
     * Issues move instruction to the robot in the direction the robot is in. Thr robot would stay
     * on it's current position, if the move could mean the new position is beyond the table top.
     * @param cmd
     * @return 
     */
    private Boolean moveHandler(String cmd) {
        return robot != null ? robot.move() : false;
    }
    
    /**
     * Issue rotate command to the robot off it's current direction.
     * @param cmd
     * @return 
     */
    private Boolean rotationHandler(String cmd) {
        boolean isValidRotation = validRotationCommand(cmd);
        if (null != this.robot && isValidRotation) {
            robot.rotate(Rotation.valueOf(cmd));
        }
        return isValidRotation;
    }

    /**
     * @param cmd
     * @return Return true if the command is either LEFT or RIGHT, else return false.
     */
    private boolean validRotationCommand(String cmd) {
        boolean isValidRotation = of(Rotation.values()).
            filter(r -> r.toString().equals(cmd)).findFirst().isPresent();
        return isValidRotation;
    }
    
    /**
     * Prints the current status of the robot if the robot has been initialized.
     * @param cmd
     * @return 
     */
    private Boolean reportHandler(String cmd) {
        String report = robot != null ? robotReport() : "Please place robot using the PLACE command";
        System.out.println(report);
        return true;
    }

    /**
     * @return builds the robot report based on current position.
     */
    private String robotReport() {
        Point currentPosition = tableTop.getCurrentPosition();
        return format("%s,%s,%s", currentPosition.x, currentPosition.y, robot.getDirection());
    }
    
    /**
     * Handler to process commands not supported by the simulator.
     * @param cmd
     * @return 
     */
    private Boolean unsupportedCommandHandler(String cmd) {
        System.err.println("Command not supported.");
        return false;
    }
}
