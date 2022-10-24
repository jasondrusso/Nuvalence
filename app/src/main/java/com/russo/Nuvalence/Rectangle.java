/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.russo.Nuvalence;

import java.io.InvalidObjectException;

/**
 *
 * @author jason
 * 
 * Representation of a rectangle oriented horizontal/vertical
 * 
 */
public class Rectangle {
    private final Point topLeft, topRight, bottomLeft, bottomRight;
    private final Line top, bottom, left, right;
    
    public Rectangle(Point topLeft, Point bottomRight) throws InvalidObjectException {
        if (topLeft == null || bottomRight == null)
            throw new InvalidObjectException("Rectangle must have two points defined");
        
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        
        this.topRight = new Point(bottomRight.x, topLeft.y);
        this.bottomLeft = new Point(topLeft.x, bottomRight.y);
        
        this.top = new Line(topLeft, topRight);
        this.bottom = new Line(bottomLeft, bottomRight);
        this.left = new Line(topLeft, bottomLeft);
        this.right = new Line(topRight, bottomRight);
    }
    
    public Rectangle(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight)
            throws InvalidObjectException {
        if (topLeft == null || topRight == null || bottomLeft == null || bottomRight == null)
            throw new InvalidObjectException("Rectangle must have four points defined");
        
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        
        this.top = new Line(topLeft, topRight);
        this.bottom = new Line(bottomLeft, bottomRight);
        this.left = new Line(topLeft, bottomLeft);
        this.right = new Line(topRight, bottomRight);
    }

    public Point getTopLeft() {
        return topLeft;
    }
    
    public Point getTopRight() {
        return topRight;
    }

    public Point getBottomRight() {
        return bottomRight;
    }
    
    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Line getTop() {
        return top;
    }

    public Line getBottom() {
        return bottom;
    }

    public Line getLeft() {
        return left;
    }

    public Line getRight() {
        return right;
    }
}
