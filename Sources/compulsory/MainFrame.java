package compulsory;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame class
 * The Frame of the Application
 */
public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    /**
     * createPanels method: creates the panels(components) to be added
     */
    private void createPanels() {
        canvas = new DrawingPanel(this);
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
    }


    /**
     * init method = initialize the Mainframe
     */
    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createPanels();
        addElements();
        //invoke the layout manager
        pack();
    }
}
