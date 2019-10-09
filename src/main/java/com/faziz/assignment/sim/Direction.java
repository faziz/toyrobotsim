package com.faziz.assignment.sim;

/**
 * An enumeration to be used as a command to the robot for the direction.
 * @author faisal
 */
public enum Direction {

    NORTH {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y + 1);
        }

        @Override
        public Direction rotateLeft() {
            return WEST;
        }

        @Override
        public Direction rotateRight() {
            return EAST;
        }
    }, 
    SOUTH {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y - 1);
        }

        @Override
        public Direction rotateLeft() {
           return WEST;
        }

        @Override
        public Direction rotateRight() {
            return EAST;
        }
    }, 
    EAST {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x + 1, currentPosition.y);
        }

        @Override
        public Direction rotateLeft() {
            return NORTH;
        }

        @Override
        public Direction rotateRight() {
            return SOUTH;
        }
    }, 
    WEST {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x - 1, currentPosition.y);
        }

        @Override
        public Direction rotateLeft() {
            return SOUTH;
        }

        @Override
        public Direction rotateRight() {
            return NORTH;
        }
    };

    /**
     * Calculates new position relative to the current position and direction.
     * @param currentPosition
     * @return 
     */
    public abstract Point newPosition(Point currentPosition);
    
    public abstract Direction rotateLeft();
    
    public abstract Direction rotateRight();
}
