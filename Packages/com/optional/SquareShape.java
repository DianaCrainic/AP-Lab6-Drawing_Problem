package com.optional;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * SquareShape class = the description of the shape to be created and added
 */
public class SquareShape extends Rectangle2D.Double implements ShapeType {
    private Color color;
    public SquareShape(double x0, double y0, double l, Color color) {
        super(x0 - l / 2, y0 - l / 2, l, l);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

