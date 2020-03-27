package compulsory;

import javax.swing.*;

/**
 * ConfigPanel - introduces parameters regarding the shapes that
 * will be drawn: the size, the number of sides, the color.
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // regular polygons
    JSpinner sidesField; //number of sides
    JComboBox<String> colorCombo; //the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JComboBox<String> getColorCombo() {
        return colorCombo;
    }

    /**
     * init method: -creates the label and the spinner
     *              -creates the colorCombo, containing the values: Random and Black
     *              -adds the elements
     */
    private void init() {
        sidesLabel = new JLabel("Number of sides");
        sidesField = new JSpinner(new SpinnerNumberModel(5, 3, 30, 1));
        sidesField.setValue(6); //default number of sides

        String[] colors = {"Black", "Random"};
        colorCombo = new JComboBox<>(colors);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

}
