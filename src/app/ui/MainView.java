package app.ui;

import app.internal.Core;
import app.internal.ImageManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MainView extends JPanel {
     public static int MIN_ZOOM = 1;
     public static int MID_ZOOM = 25;
     public static int MAX_ZOOM = 50;

     public JPanel sideView = new JPanel();
     public static JSlider zoomSlider = new JSlider();
     public JLabel zoomLabel = new JLabel("Zoom");

     public MainView(Window w){
          this.setLayout(null);
          sideView.setSize(190,1400);
          sideView.setBackground(w.menuBar.getBackground());
          sideView.setLayout(null);
          this.add(sideView);
          zoomLabel.setBounds(14,10,160,20);
          zoomSlider.setBounds(5,40,160,20);
          zoomSlider.setValue(MID_ZOOM);
          zoomSlider.setMinimum(MIN_ZOOM);
          zoomSlider.setMaximum(MAX_ZOOM);
          sideView.add(zoomSlider);
          sideView.add(zoomLabel);
          zoomSlider.addChangeListener(e -> {
                double zoom = zoomSlider.getValue();
                zoom = (zoom/25) * 1;
                if(w.imageView.getIcon().getIconHeight()!=zoom*Core.originalHeight)
                Core.zoom(zoom);
               Core.win.imageView.repaint();

          });
     }
}
