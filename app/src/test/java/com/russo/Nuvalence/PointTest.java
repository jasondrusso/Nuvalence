/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.russo.Nuvalence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jason
 */
public class PointTest {

    @Test
    public void testSubtractPoints() {
        Point p1 = new Point(5.0, 6.0);
        Point p2 = new Point(3.0, 9.0);
        
        Point expected = new Point(2.0, -3.0);
        Point result = p1.subtract(p2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testCrossProduct() {
        Point p1 = new Point(3.0, 6.0);
        Point p2 = new Point(2.0, 4.0);
        
        double expected = 0.0;
        double result = Point.crossProduct(p1, p2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testDirectionClockwise() {
        Point o = new Point(5.0, 6.0);
        Point p1 = new Point(10.0, 3.0);
        Point p2 = new Point(4.0, 1.0);
        
        assertTrue(o.direction(p1, p2) > 0);
    }
    
    @Test
    public void testDirectionCounterClockwise() {
        Point o = new Point(3.0, 4.0);
        Point p1 = new Point(1.0, 6.0);
        Point p2 = new Point(-1.0, 5.0);
        
        assertTrue(o.direction(p1, p2) < 0);
    }
    
    @Test
    public void testCollinear() {
        Point o = new Point(2.0, 2.0);
        Point p1 = new Point(1.0, 5.0);
        Point p2 = new Point(0.0, 8.0);
        
        assertTrue(o.direction(p1, p2) == 0);
    }
}
