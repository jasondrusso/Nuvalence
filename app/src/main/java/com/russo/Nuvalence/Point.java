/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.russo.Nuvalence;

/**
 * Class to represent a point
 * 
 * For helper functions reference
 * https://algorithmtutor.com/Computational-Geometry/Determining-if-two-consecutive-segments-turn-left-or-right/
 *
 * @author jason
 */
public class Point {
    public final double x, y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Computes a new point after subtracting point p from *this*
     * 
     * @param p
     * 
     * @return 
     */
    Point subtract(Point p) {
        return new Point(this.x - p.x, this.y - p.y);
    }
    
    /**
     * Computes cross product of two vectors computed from points p1 and p2 from
     * zero origin.
     * 
     * @param p1
     * @param p2
     * 
     * @return 
     */
    static double crossProduct(Point p1, Point p2) {
        return (p1.x * p2.y) - (p2.x * p1.y);
    }
    
    /**
     * Determines clockwise/counterclockwise direction between vectors p1 & p2
     * with respect to this point.
     * 
     * @param p1        Point #1 to compare
     * @param p2        Point #2 to compare
     * 
     * @return          If vector this->p2 is clockwise vector this->p1, then
     * result is positive. If vector this->p2 is counter-clockwise vector this->p1,
     * then result is negative. If zero, then both vectors are collinear.
     */
    public double direction(Point p1, Point p2) {
        return crossProduct(p2.subtract(this), p1.subtract(this));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Point other = (Point) obj;
        
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }
}
