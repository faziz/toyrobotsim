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
        return tableTop.move(direction);
    }

    public Direction getDirection() {
        return direction;
    }
    
}
