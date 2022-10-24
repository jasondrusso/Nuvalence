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
public class RectangleUtilTest {
    
    @Test
    public void testIntersecting() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(5.0, 11.0);
        Point bottomRight2 = new Point(11.0, 5.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertTrue(RectangleUtil.isIntersecting(rect1, rect2));
    }
    
    @Test
    public void testNotIntersecting() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(10.0, 12.0);
        Point bottomRight2 = new Point(15.0, 6.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertFalse(RectangleUtil.isIntersecting(rect1, rect2));
    }
    
    @Test
    public void testIsContained1() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(3.0, 8.0);
        Point bottomRight2 = new Point(8.0, 3.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertTrue(RectangleUtil.isContained(rect1, rect2));
    }
    
    @Test
    public void testIsContained2() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(3.0, 8.0);
        Point bottomRight2 = new Point(9.0, 2.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertTrue(RectangleUtil.isContained(rect1, rect2));
    }
    
    @Test
    public void testIsNotContained() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(3.0, 8.0);
        Point bottomRight2 = new Point(10.0, 1.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertFalse(RectangleUtil.isContained(rect1, rect2));
    }
    
    @Test
    public void testIsAdjacent() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(9.0, 6.0);
        Point bottomRight2 = new Point(12.0, 3.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertTrue(RectangleUtil.isAdjacent(rect1, rect2));
    }
    
    @Test
    public void testIsNotAdjacent() throws InvalidObjectException {
        Point topLeft1 = new Point(2.0, 9.0);
        Point bottomRight1 = new Point(9.0, 2.0);
        
        Point topLeft2 = new Point(10.0, 6.0);
        Point bottomRight2 = new Point(12.0, 3.0);
        
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2);
        
        assertFalse(RectangleUtil.isAdjacent(rect1, rect2));
    }
}
