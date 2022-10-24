/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.russo.Nuvalence;

/**
 *
 * @author jason
 */
public class RectangleUtil {
    public boolean isIntersecting(Rectangle r1, Rectangle r2) {
        return r1.getTop().isCrossed(r2.getLeft())
                || r1.getTop().isCrossed(r2.getRight())
                || r1.getBottom().isCrossed(r2.getLeft())
                || r1.getBottom().isCrossed(r2.getRight())
                || r1.getLeft().isCrossed(r2.getTop())
                || r1.getLeft().isCrossed(r2.getBottom())
                || r1.getRight().isCrossed(r2.getTop())
                || r1.getRight().isCrossed(r2.getBottom());
    }
    
    public boolean isContained(Rectangle r1, Rectangle r2) {
        return false;
    }
    
    public boolean isAdjacent(Rectangle r1, Rectangle r2) {
        return false;
    }    
}
