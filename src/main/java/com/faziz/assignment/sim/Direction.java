package com.faziz.assignment.sim;

/**
 * An enumeration to be used as a command to the robot for the direction.
 */
public enum Direction {

    NORTH {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y + 1);
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }
    }, 
    SOUTH {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y - 1);
        }

        @Override
        public Direction left() {
           return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }
    }, 
    EAST {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x + 1, currentPosition.y);
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }
    }, 
    WEST {
        @Override
        public Point newPosition(Point currentPosition) {
            return new Point(currentPosition.x - 1, currentPosition.y);
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }
    };

    /**
     * Calculates new position relative to the current position.
     * @param currentPosition
     * @return 
     */
    public abstract Point newPosition(Point currentPosition);
    
    /**
     * Determines the new direction when the robot is rotated left off current direction.
     * @return 
     */
    public abstract Direction left();
    
    /**
     * Determines the new direction when the robot is rotated right off current direction.
     * @return 
     */
    public abstract Direction right();
}
