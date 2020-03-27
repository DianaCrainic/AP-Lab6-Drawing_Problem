package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ControlPanel class - is managing the image being created.
 * This panel will contain the buttons: Load, Save, Reset, Exit.
 * It wil be placed at the bottom of the frame
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

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
    }

    /**
     * addListeners method: configures listeners for all buttons
     */
    private void addListeners() {
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    /**
     * init method: initializes the buttons
     * setLayout - changes the default layout manager
     */
    public void init() {

        setLayout(new GridLayout(1, 4));
        addButtons();
        addListeners();
    }

    /**
     * save method: saves the canvas in the current folder
     */
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.getCanvas().image, "PNG", new File("./test.png"));
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

    private void load(ActionEvent e) {
        /*
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            BufferedImage image = null;
            //image = ImageIO.read(new File(fileChooser.getSelectedFile().getPath()));
            frame.getCanvas().loadImage(image);
        }
        */
    }

}
