package app.ui;

import app.internal.Core;
import app.internal.ImageManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainView extends JPanel {
    public static int MIN_ZOOM = 30;
    public static int MID_ZOOM = 30;
    public static int MAX_ZOOM = 100;
    public static JSlider zoomSlider = new JSlider();
    public JPanel sideView = new JPanel();
    public JLabel zoomLabel = new JLabel("Zoom");
    public JToggleButton pen;
    public JButton palette;
    public ColorChooser colorChooser = new ColorChooser();

    public MainView(Window w) {
        this.setLayout(null);
        sideView.setSize(190, 1400);
        sideView.setBackground(w.menuBar.getBackground());
        sideView.setLayout(null);
        this.add(sideView);
        zoomLabel.setBounds(14, 10, 160, 20);
        zoomSlider.setBounds(5, 40, 160, 20);
        zoomSlider.setValue(MID_ZOOM);
        zoomSlider.setMinimum(MIN_ZOOM);
        zoomSlider.setMaximum(MAX_ZOOM);
        sideView.add(zoomSlider);
        sideView.add(zoomLabel);
        zoomSlider.addChangeListener(e -> {
            double zoom = zoomSlider.getValue();
            zoom = (zoom / 30);
            if (w.imageView.getIcon().getIconHeight() != zoom * Core.originalHeight)
                Core.zoom(zoom);
            Core.win.imageView.repaint();

        });
        try {
            pen = new JToggleButton(new ImageIcon(ImageManager.invert(ImageIO.read(new File("assets/pen.png")))));
            palette = new JButton(new ImageIcon(ImageManager.invert(ImageIO.read(new File("assets/palette.png")))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        pen.setBounds(14, 80, 30, 30);
        sideView.add(pen);
        palette.setBounds(50, 80, 30, 30);
        sideView.add(palette);
        palette.addActionListener(e -> colorChooser.cColor());


    }
}
