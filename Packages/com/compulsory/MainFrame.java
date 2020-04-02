package com.compulsory;


import javax.swing.*;
import java.awt.*;

/**
 * MainFrame class: The Frame of the application
 */
public class MainFrame extends JFrame {
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    /**
     * optional
     */
    private ShapesPanel shapesPanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public ShapesPanel getShapesPanel() {
        return shapesPanel;
    }

    /**
     * createPanels method: creates the panels(components) to be added
     */
    private void createPanels() {
        canvas = new DrawingPanel(this);
        shapesPanel = new ShapesPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
    }

    /**
     * addElements method = arrange the components in the container (frame)
     * JFrame uses a BorderLayout by default
     */
    private void addElements() {
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(shapesPanel, BorderLayout.WEST);
    }

    /**
     * init method: initialize the Mainframe
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createPanels();
        addElements();
        //invoke the layout manager
        pack();
    }


}