package app.ui;

import app.internal.Core;
import app.internal.ImageManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainView extends JPanel {
    public static int MIN_ZOOM = 30;
    public static int MID_ZOOM = 30;
    public static int MAX_ZOOM = 100;
    private static String penSizes[] = {"1","2","3","4","5"};
    public static JSlider zoomSlider = new JSlider();
    private JPanel sideView = new JPanel();
    private JLabel zoomLabel = new JLabel("Zoom");
    private JToggleButton pen;
    public static JButton palette;
    private ColorChooser colorChooser = new ColorChooser();
    private JSpinner sizeSpinner = new JSpinner(new SpinnerListModel(penSizes));

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
            //ZOOM CODE
            double zoom = zoomSlider.getValue();
            zoom = (zoom / 30);
            if (w.imageView.getIcon().getIconHeight() != zoom * Core.originalHeight)
                Core.zoom(zoom);
            Core.win.imageView.repaint();
            Core.win.pv.setBounds(260,100,Math.min(Core.win.getWidth()-340,Core.img.getWidth()),Math.min(Core.win.getHeight()-180, Core.img.getHeight()));

            Core.win.imageView.repaint();
            repaint();
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
        palette.setBackground(Core.selectedColor);
        palette.addActionListener(e -> colorChooser.cColor());
        sizeSpinner.setBounds(86,80,80,30);
        ((
                JSpinner.DefaultEditor) sizeSpinner.getEditor()).getTextField().setEditable(false);
        sizeSpinner.addChangeListener(e -> {
          Core.penSize = Integer.parseInt((String) sizeSpinner.getValue());
        });
        sideView.add(sizeSpinner);

    }
}
