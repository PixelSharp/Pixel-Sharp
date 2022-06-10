package app.ui;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame {
    public JMenuBar menuBar = new JMenuBar();
    public Bar bar = new Bar();
    public MainView mainView;
    public PaintView pv = new PaintView();

    public Window() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        bar.setup(this);
        mainView = new MainView(this);
        this.add(mainView);
        mainView.add(pv);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                pv.setBounds(260,100,getWidth()-340,getHeight()-250);

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });


    }
}
