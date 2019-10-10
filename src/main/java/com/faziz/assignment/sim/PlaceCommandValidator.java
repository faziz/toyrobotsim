package com.faziz.assignment.sim;

import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

/**
 * Validates the PLACE command and it's arguments.
 */
public class PlaceCommandValidator {
    
    private final String placeCommand;

    public PlaceCommandValidator(String cmd) {
        this.placeCommand = cmd;
    }

    public Boolean validate() {
        return isNotBlank() && placeCommand.startsWith("PLACE ") && checkArguments();
    }

    private boolean isNotBlank() {
        return null != placeCommand && !placeCommand.isEmpty();
    }

    private boolean checkArguments() {
        String[] parts = placeCommand.split(" ");
        String[] args = parts[1].split(",");
        List<String> argsList = of(args).map(a -> a.trim()).collect(toList());
        return argsList.size() == 3 && 
                isInteger(argsList.get(0)) && 
                isInteger(argsList.get(1)) && 
                isDirection(argsList.get(2));
    }

    private boolean isInteger(String arg) {
        try {
            Integer.valueOf(arg);
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDirection(String arg) {
        return of(Direction.values()).
                filter(d -> d.toString().equals(arg)).findAny().isPresent();
    }
    
}
