package app.ui;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
     public JPanel sideView = new JPanel();
     public MainView(Window w){
          this.setLayout(null);
          sideView.setSize(190,1400);
          sideView.setBackground(w.menuBar.getBackground());
          this.add(sideView);
     }
}
