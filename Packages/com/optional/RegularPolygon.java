package com.optional;


import java.awt.*;

/**
 * Regular Polygon class = the description of the shape to be created and added
 */
public class RegularPolygon extends Polygon implements ShapeType {
    private Color color;
    public RegularPolygon(int x0, int y0, int radius, int sides, Color color) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; ++i) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}