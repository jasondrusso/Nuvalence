/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.russo.Nuvalence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jason
 */
public class RectangleUtil {
    
    public enum Axis {
        X, Y
    }
    
    /**
     * Test whether rectangles intersect.
     * 
     * @param r1
     * @param r2
     * 
     * @return 
     * 
     */
    public static boolean isIntersecting(Rectangle r1, Rectangle r2) {
        return r1.getTop().isCrossed(r2.getLeft())
                || r1.getTop().isCrossed(r2.getRight())
                || r1.getBottom().isCrossed(r2.getLeft())
                || r1.getBottom().isCrossed(r2.getRight())
                || r1.getLeft().isCrossed(r2.getTop())
                || r1.getLeft().isCrossed(r2.getBottom())
                || r1.getRight().isCrossed(r2.getTop())
                || r1.getRight().isCrossed(r2.getBottom());
    }
    
    /**
     * Test whether either rectangle is contained within the other
     * 
     * @param r1
     * @param r2
     * 
     * @return 
     */
    public static boolean isContained(Rectangle r1, Rectangle r2) {
        return !isIntersecting(r1, r2) && (isWithin(r1, r2) || isWithin(r2, r1));
    }
    
    public static boolean isAdjacent(Rectangle r1, Rectangle r2) {
        return !isContained(r1, r2) && isEdgeAdjacent(r1, r2);
    }
    
    private static boolean isEdgeAdjacent(Rectangle r1, Rectangle r2) {
        List<Line> rl1 = List.of(r1.getTop(), r1.getRight(), r1.getBottom(), r1.getLeft());
        List<Line> rl2 = List.of(r2.getTop(), r2.getRight(), r2.getBottom(), r2.getLeft());
        
        for (Line l1 : rl1) {
            for (Line l2 : rl2) {
                if (l1.isAdjacent(l2))
                    return true;
            }
        }
        
        return false;
    }
    
    private static boolean isWithin(Rectangle outer, Rectangle inner) {
        List<Double> outerX = getVerticies(outer, Axis.X);
        List<Double> outerY = getVerticies(outer, Axis.Y);
        List<Double> innerX = getVerticies(inner, Axis.X);
        List<Double> innerY = getVerticies(inner, Axis.Y);
        
        double minOuterX = Collections.min(outerX);
        double maxOuterX = Collections.max(outerX);
        
        double minOuterY = Collections.min(outerY);
        double maxOuterY = Collections.max(outerY);
        
        double minInnerX = Collections.min(innerX);
        double maxInnerX = Collections.max(innerX);
        
        double minInnerY = Collections.min(innerY);
        double maxInnerY = Collections.max(innerY);
        
        return minOuterX < minInnerX && maxOuterX > maxInnerX &&
                minOuterY < minInnerY && maxOuterY > maxInnerY;
    }
    
    private static List<Double> getVerticies(Rectangle rect, Axis axis) {
        switch (axis) {
            case X:
                return Arrays.asList(
                        rect.getTopLeft().x,
                        rect.getTopRight().x,
                        rect.getBottomLeft().x,
                        rect.getBottomRight().x);
            case Y:
                return Arrays.asList(
                        rect.getTopLeft().y,
                        rect.getTopRight().y,
                        rect.getBottomLeft().y,
                        rect.getBottomRight().y);
        }
        
        return null;
    }
}
