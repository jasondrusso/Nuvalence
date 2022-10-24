/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.russo.Nuvalence;

import java.io.InvalidObjectException;

/**
 * Class to represent a line.
 * 
 * For helper functions reference
 * https://algorithmtutor.com/Computational-Geometry/Check-if-two-line-segment-intersect/
 *
 * @author jason
 */
public class Line {
    private final Point p1, p2;
    
    public Line(Point p1, Point p2) throws InvalidObjectException {
        if (p1 == null || p2 == null)
            throw new InvalidObjectException("Line must have two points defined");
        
        this.p1 = p1;
        this.p2 = p2;
    }
    
    /**
     * Lines cross if the vectors between the endpoints point in opposite directions
     * for both lines.
     * 
     * @param other     Other line to compare.
     * 
     * @return          True if lines cross, false if not.
     */
    public boolean isCrossed(Line other) {
        return (this.p1.direction(this.p2, other.p1) * this.p1.direction(this.p2, other.p2) < 0) &&
                (other.p1.direction(other.p2, this.p1) * other.p1.direction(other.p2, this.p2) < 0);
    }
    
    /**
     * 
     * @param other
     * @return 
     */
    public boolean isConnected(Line other) {
        return (!this.isCollinear(other) && 
                this.p1.direction(this.p2, other.p1) * this.p1.direction(this.p2, other.p2) == 0) ||
                (!other.isCollinear(this) &&
                other.p1.direction(other.p2, this.p1) * other.p1.direction(other.p2, this.p2) == 0);
    }
    
    /**
     * Tests if other line is adjacent to this.  Adjacent means both lines are collinear
     * and at least one endpoint of one line is within bounds of the other segment.
     * 
     * @param other
     * @return 
     */
    public boolean isAdjacent(Line other) {
        return this.isPointOnSegment(other.p1) || this.isPointOnSegment(other.p2) ||
                other.isPointOnSegment(this.p1) || other.isPointOnSegment(this.p2);
    }
    
    /**
     * If point is collinear to line and within bounds of segment then it is on
     * segment
     * 
     * @param p         Point to test
     * 
     * @return          True is point is on segment, false if not
     */
    boolean isPointOnSegment(Point p) {
        return ((p.direction(this.p1, this.p2) == 0) &&
                (p.x >= Math.min(this.p1.x, this.p2.x) && (p.x <= Math.max(this.p1.x, this.p2.x))) &&
                (p.y >= Math.min(this.p1.y, this.p2.y) && (p.y <= Math.max(this.p1.y, this.p2.y))));
    }
    
    /**
     * Collinear lines go in the same direction.
     * 
     * @param other     Other line to compare.
     * 
     * @return          True is lines are collinear, false if not.
     */
    boolean isCollinear(Line other) {
        return this.p1.direction(this.p2, other.p1) == 0 &&
                this.p1.direction(this.p2, other.p2) == 0;
    }
}
