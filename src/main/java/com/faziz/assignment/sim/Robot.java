package com.faziz.assignment.sim;


public class Robot {
    
    private Direction direction;
    private final TableTop tableTop;
    
    public Robot(Direction direction, TableTop tableTop) {
        this.direction = direction;
        this.tableTop = tableTop;
    }

    public Direction rotate(Rotation rotation) {
        this.direction = rotation.rotate(direction);
        return this.direction;
    }

    public Boolean move() {
        return tableTop.newPosition(direction);
    }
    
    public Boolean move(Integer x, Integer y) {
        return this.tableTop.setCurrentPosition(x, y);
    }

    public Direction getDirection() {
        return direction;
    }
    
}
