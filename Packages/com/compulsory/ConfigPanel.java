package com.compulsory;

import javax.swing.*;

/**
 * ConfigPanel class: introduces parameters regarding the shapes that
 * will be drawn: the size, the number of sides, the color.
 */
public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private JSpinner sidesField; // number of sides
    private JComboBox<String> colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public MainFrame getFrame() {
        return frame;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JComboBox<String> getColorCombo() {
        return colorCombo;
    }

    /**
     * init method: -creates the label and the spinner
     * -creates the colorCombo, containing the values: Random and Black
     * -adds the elements
     */
    private void init() {
        if (frame.getShapesPanel().getPolygonBtn().isSelected()) {
            JLabel sidesLabel = new JLabel("Number of sides");
            sidesField = new JSpinner(new SpinnerNumberModel(5, 3, 30, 1));
            sidesField.setValue(6); //default number of sides
            add(sidesLabel);
            add(sidesField);
        }

        String[] colors = {"Random", "Black"};
        colorCombo = new JComboBox<>(colors);
        add(colorCombo);
    }

    /**
     * changeConfigurations method:
     * -in the case of RegularPolygon, there is a setting for changing the number of sides
     * -in the case of NodesShape or SquareShape, there is no setting except of changing the color
     * so it is verified the RadioButton selected
     */
    public void changeConfigurations() {
        this.removeAll();
        init();
        this.repaint();
        this.revalidate();
    }


}