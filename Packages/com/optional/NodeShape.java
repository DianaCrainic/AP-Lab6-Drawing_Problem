package com.optional;


import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * NodeShape class = the description of the shape to be created and added
 */
public class NodeShape extends Ellipse2D.Double implements ShapeType {
    private Color color;
    public NodeShape(double x0, double y0, double radius, Color color) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}