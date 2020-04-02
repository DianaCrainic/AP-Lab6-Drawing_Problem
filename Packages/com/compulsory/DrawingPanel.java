package com.compulsory;

import com.optional.NodeShape;
import com.optional.RegularPolygon;
import com.optional.ShapeType;
import com.optional.SquareShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * DrawingPanel(canvas):  draws shapeTypes
 * This panel must be placed in the center part of the frame
 */
public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private final int W = 800, H = 580;

    BufferedImage image; //the offscreen image
    Graphics2D graphics; // the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    /**
     * createOffScreenImage method - creates the clear image
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * init method: initializes the canvas
     */
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                drawShape(event.getX(), event.getY());
                repaint();
            }
        });
    }

    /**
     * getShapeColor method: get the color selected for drawing the shape
     */
    private Color getShapeColor() {
        if (Objects.equals(frame.getConfigPanel().getColorCombo().getSelectedItem(), "Random")) {
            return generateColor();
        } else {
            return Color.BLACK;
        }
    }

    /**
     * generate a random color
     */
    private Color generateColor() {
        Random rand = new Random();
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        return color;
    }

    /**
     * optional: list of shapeTypes
     */
    private List<ShapeType> shapesList = new ArrayList<>();

    /**
     * drawShape method - draws a figure
     * randomize the radius
     * gets the selected sides
     * set the color selected
     */
    private void drawShape(int x, int y) {
        Random random = new Random();
        int radius = random.nextInt(90) + 20;
        Color color = getShapeColor();
        graphics.setColor(color);
        ShapeType shapeType;
        if (frame.getShapesPanel().getPolygonBtn().isSelected()) {
            int sides = (int) frame.getConfigPanel().getSidesField().getValue();
            shapeType = new RegularPolygon(x, y, radius, sides, color);
        } else if (frame.getShapesPanel().getNodeBtn().isSelected()) {
            shapeType = new NodeShape(x, y, radius, color);
        } else {
            shapeType = new SquareShape(x, y, radius, color);
        }
        graphics.fill((java.awt.Shape) shapeType);
        shapesList.add(shapeType);
    }

    /**
     * for optimization
     */
    public void update(Graphics g) {
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


    public void loadImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        repaint();
    }

    /**
     * optional
     * resetPanel method: reset the panel, clear, fill with white color
     */
    void resetPanel() {
        shapesList.clear();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
    }

    /**
     * optional
     * removeLastShape method: remove the last drawn shape
     */
    void removeLastShape() {
        int lengthOfShapesList = this.shapesList.size();
        if (lengthOfShapesList > 0) {
            this.shapesList.remove(lengthOfShapesList - 1);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, W, H);
            repaint();
            for (ShapeType shapeType : this.shapesList) {
                graphics.setColor(shapeType.getColor());
                graphics.fill((java.awt.Shape) shapeType);
            }
        }
    }
}