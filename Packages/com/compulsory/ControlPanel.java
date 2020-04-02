package com.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ControlPanel class:  is managing the image being created.
 * This panel will contain the buttons: Load, Save, Reset, Exit.
 * It wil be placed at the bottom of the frame
 */
public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JButton saveBtn = new JButton("Save");
    private JButton loadBtn = new JButton("Load");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");

    /**
     * optional
     */
    private JButton removeLastShapeBtn = new JButton("Remove last shape");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * addButtons method: adds the elements to panel
     */
    private void addButtons() {
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(removeLastShapeBtn);
    }

    /**
     * addListeners method: configures listeners for all buttons
     */
    private void addListeners() {
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        removeLastShapeBtn.addActionListener(this::removeLastShape);
    }

    /**
     * init method: initializes the buttons
     * setLayout - changes the default layout manager
     */
    private void init() {
        setLayout(new GridLayout(1, 5));
        addButtons();
        addListeners();
    }


    /**
     * save method: saves the canvas in the current folder
     */
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.getCanvas().image, "PNG", new File("./paint.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * reset method: resets the canvas
     */
    private void reset(ActionEvent e) {
        frame.getCanvas().resetPanel();
    }

    /**
     * exit method: close the canvas
     */
    private void exit(ActionEvent e) {
        System.exit(0);
    }


    /**
     * optional
     * load method - file chooser in order to specify the file where the image will be saved (or load).
     */
    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                BufferedImage image = ImageIO.read(new File(fileChooser.getSelectedFile().getPath()));
                frame.getCanvas().loadImage(image);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * optional
     */
    private void removeLastShape(ActionEvent event) {
        frame.getCanvas().removeLastShape();
    }
}