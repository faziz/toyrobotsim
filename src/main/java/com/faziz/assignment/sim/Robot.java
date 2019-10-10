package com.faziz.assignment.sim;

/**
 * Robot abstraction that provides services to rotate and move the robot on the given table top.
 */
public class Robot {
    
    private Direction direction;
    private final TableTop tableTop;
    
    public Robot(Direction direction, TableTop tableTop) {
        this.direction = direction;
        this.tableTop = tableTop;
    }

    /**
     * Rotates the robot off it's current direction.
     * @param rotation
     * @return 
     */
    public Direction rotate(Rotation rotation) {
        this.direction = rotation.rotate(direction);
        return this.direction;
    }

    /**
     * Move the robot in it's current direction.
     * @return 
     */
    public Boolean move() {
        return tableTop.newPosition(direction);
    }
    
    /**
     * Positions the robot on the given point on the table top.
     * @param x
     * @param y
     * @return 
     */
    public Boolean move(Integer x, Integer y) {
        return this.tableTop.setCurrentPosition(x, y);
    }

    /**
     * @return current position of the robot.
     */
    public Direction getDirection() {
        return direction;
    }
    
}
