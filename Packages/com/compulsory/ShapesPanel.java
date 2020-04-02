package com.compulsory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * ShapesPanel class: contains a list of shapes you can
 * -regular polygon shape
 * -node shape
 * -square shape
 */
public class ShapesPanel extends JPanel {
    private final MainFrame frame;
    private JRadioButton polygonBtn = new JRadioButton("Regular Polygon");
    private JRadioButton nodeBtn = new JRadioButton("Node");
    private JRadioButton squareBtn = new JRadioButton("Square");

    public ShapesPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public MainFrame getFrame() {
        return frame;
    }

    public JRadioButton getPolygonBtn() {
        return polygonBtn;
    }

    public JRadioButton getNodeBtn() {
        return nodeBtn;
    }

    public JRadioButton getSquareBtn() {
        return squareBtn;
    }

    private void addButtons() {
        add(polygonBtn);
        add(nodeBtn);
        add(squareBtn);
    }

    private void addListeners() {
        polygonBtn.addActionListener(this::getShapeBtn);
        nodeBtn.addActionListener(this::getShapeBtn);
        squareBtn.addActionListener(this::getShapeBtn);
    }


    private void getShapeBtn(ActionEvent event) {
        frame.getConfigPanel().changeConfigurations();
    }

    /**
     * optional
     * isSelectedIndividually method - one single JRadioButton is selected at a time
     */
    private void isSelectedIndividually() {
        ButtonGroup group = new ButtonGroup();
        group.add(polygonBtn);
        group.add(nodeBtn);
        group.add(squareBtn);
    }

    private void init() {
        polygonBtn.setSelected(true);
        setLayout(new GridLayout(3,1));
        isSelectedIndividually();
        addButtons();
        addListeners();
    }
}