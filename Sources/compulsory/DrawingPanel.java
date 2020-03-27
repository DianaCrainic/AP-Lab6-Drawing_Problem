package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Random;

/**
 * DrawingPanel(canvas) - draws shapes
 * This panel must be placed in the center part of the frame
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage image; //the offscreen image
    Graphics2D graphics; // the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffScreenImage();
        init();
    }

    /**
     * createOffScreenImage method - creates the clear image
     */
    private void createOffScreenImage() {
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
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
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
     * drawShape method - draws a figure
     * randomize the radius
     * gets the selected sides
     * set the color selected
     */
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(90) + 20;
        int sides = (int) frame.getConfigPanel().getSidesField().getValue();//TODO get the value from UI (in ConfigPanel)
        graphics.setColor(getShapeColor());
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    /**
     * for optimization
     */
    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void resetPanel() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        repaint();
    }

    public void loadImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        repaint();
    }
}
