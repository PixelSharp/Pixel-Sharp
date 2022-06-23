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
            Core.selectedColor = chooser.getColor();
        }).start();

    }

    public void cColor() {
        this.setVisible(true);
    }
}
