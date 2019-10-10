package com.faziz.assignment.sim;

/**
 * An abstraction to represent a given position of the robot on the table top.
 */
public class Point extends java.awt.Point {

    public Point(Point newPoint) {
        super(newPoint);
    }
    
    public Point(int x, int y) {
        super(x, y);
    }

    /**
     * @param point1
     * @param point2
     * @return True if this Point is isBetween the given two points, else return false.
     */
    public Boolean isBetween(Point point1, Point point2) {
        return this.x >= point1.x && this.y >= point1.y 
            && this.x < point2.x && this.y < point2.y;
    }
}
