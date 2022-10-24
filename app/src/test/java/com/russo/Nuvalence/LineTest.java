/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.russo.Nuvalence;

import java.io.InvalidObjectException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jason
 */
public class LineTest {

    @Test
    public void linesCrossTest() throws InvalidObjectException {
        Point p1 = new Point(7.0, 2.0);
        Point p2 = new Point(1.0, 4.0);
        Point p3 = new Point(5.0, 9.0);
        Point p4 = new Point(1.0, 1.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertTrue(l1.isCrossed(l2));
    }
    
    @Test
    public void linesNotCrossTest() throws InvalidObjectException {
        Point p1 = new Point(7.0, 2.0);
        Point p2 = new Point(5.0, 3.0);
        Point p3 = new Point(5.0, 9.0);
        Point p4 = new Point(1.0, 1.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertFalse(l1.isCrossed(l2));
    }
    
    @Test
    public void isLinesCollinear() throws InvalidObjectException {
        Point p1 = new Point(7.0, 2.0);
        Point p2 = new Point(5.0, 3.0);
        Point p3 = new Point(9.0, 1.0);
        Point p4 = new Point(11.0, 0.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertTrue(l1.isCollinear(l2));
    }
    
    @Test
    public void isNotCollinear() throws InvalidObjectException {
        Point p1 = new Point(7.0, 2.0);
        Point p2 = new Point(5.0, 3.0);
        Point p3 = new Point(9.0, 1.0);
        Point p4 = new Point(12.0, 0.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertFalse(l1.isCollinear(l2));
    }
    
    @Test
    public void testIsPointOnSegment() throws InvalidObjectException {
        Point o = new Point(6.0, 6.0);
        Point p1 = new Point(4.0, 8.0);
        Point p2 = new Point(8.0, 4.0);
        
        Line l1 = new Line(p1, p2);
        
        assertTrue(l1.isPointOnSegment(o));
    }
    
    @Test
    public void isAdjacent() throws InvalidObjectException {
        Point p1 = new Point(4.0, 0.0);
        Point p2 = new Point(4.0, 9.0);
        Point p3 = new Point(4.0, 2.0);
        Point p4 = new Point(4.0, 7.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertTrue(l1.isAdjacent(l2));
    }
    
    @Test
    public void isNotAdjacent() throws InvalidObjectException {
        Point p1 = new Point(4.0, 4.0);
        Point p2 = new Point(9.0, 4.0);
        Point p3 = new Point(11.0, 4.0);
        Point p4 = new Point(15.0, 4.0);
        
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        
        assertFalse(l1.isAdjacent(l2));
    }
}
