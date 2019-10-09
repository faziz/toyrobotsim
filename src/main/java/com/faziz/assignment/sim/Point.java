package com.faziz.assignment.sim;

public class Point extends java.awt.Point {

    public Point(Point newPoint) {
        super(newPoint);
    }
    
    public Point(int x, int y) {
        super(x, y);
    }

    public Boolean between(Point point1, Point point2) {
        return this.x >= point1.x && this.y >= point1.y 
            && this.x < point2.x && this.y < point2.y;
    }
}
