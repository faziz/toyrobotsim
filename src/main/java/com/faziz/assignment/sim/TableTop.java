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
        Boolean moveAllowed = positionAllowed(p);
        if (moveAllowed) {
            this.currentPosition = p;
        }
        return moveAllowed;
    }

    public Boolean newPosition(Direction direction) {
        Point newPosition = direction.newPosition(currentPosition);
        Boolean moveAllowed = positionAllowed(newPosition);
        if (moveAllowed) {
            this.currentPosition = newPosition;
        }
        return moveAllowed;
    }

    private Boolean positionAllowed(Point newPosition) {
        return newPosition.between(basePosition, allowedLocation);
    }

    public Point getCurrentPosition() {
        //Return clone so that the client wouldn't be able to change the current position.
        return new Point(currentPosition);
    }
}
