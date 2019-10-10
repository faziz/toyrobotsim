package com.faziz.assignment.sim;

public class TableTop {

    private final Point allowedLocation;
    private final Point basePosition;
    private Point currentPosition;

    public TableTop(Integer x, Integer y) {
        this.allowedLocation = new Point(x, y);
        this.basePosition = new Point(0, 0);
        this.currentPosition = this.basePosition;
    }

    public Boolean setCurrentPosition(Integer x, Integer y) {
        Point p = new Point(x, y);
        Boolean moveAllowed = moveAllowed(p);
        if (moveAllowed) {
            this.currentPosition = p;
        }
        return moveAllowed;
    }

    public Boolean move(Direction newDirection) {
        Point newPosition = newDirection.newPosition(currentPosition);
        Boolean moveAllowed = moveAllowed(newPosition);
        if (moveAllowed) {
            this.currentPosition = newPosition;
        }
        return moveAllowed;
    }

    private Boolean moveAllowed(Point newPosition) {
        return newPosition.between(basePosition, allowedLocation);
    }

    public Point getCurrentPosition() {
        //Return clone so that the client wouldn't be able to change the current position.
        return new Point(currentPosition);
    }
}
