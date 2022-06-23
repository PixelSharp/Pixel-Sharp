package app.ui;

import app.internal.Core;

import javax.swing.*;

public class ColorChooser extends JFrame {
    public ColorChooser() {
        this.setVisible(false);
        this.setSize(700, 450);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JColorChooser chooser = new JColorChooser();
        this.setLayout(null);
        this.setContentPane(chooser);
        this.setLocationRelativeTo(null);
        new Timer(700, e -> {
            if(Core.selectedColor != chooser.getColor()) {
                Core.selectedColor = chooser.getColor();
                //if(Core.selectedColor.getRed()>200&&Core.selectedColor.getGreen()>200&&Core.selectedColor.getBlue()>200){
                //}
                MainView.palette.setBackground(Core.selectedColor);
            }

        }).start();

    }

    public void cColor() {
        this.setVisible(true);
    }
}
