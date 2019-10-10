package com.faziz.assignment.sim;

/**
 * Abstraction for the rotation of the robot.
 */
public enum Rotation {

    LEFT {
        @Override
        public Direction rotate(Direction direction) {
            return direction.rotateLeft();
        }
    },
    RIGHT {
        @Override
        public Direction rotate(Direction direction) {
            return direction.rotateRight();
        }
    };
    
    /**
     * Rotates off current direction.
     * @param direction
     * @return 
     */
    public abstract Direction rotate(Direction direction);
}
