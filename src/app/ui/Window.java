package app.ui;

import app.internal.Core;
import app.internal.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    public JMenuBar menuBar = new JMenuBar();
    public Bar bar = new Bar();
    public MainView mainView;
    public JLabel imageView;
    public JScrollPane pv;
    public Window() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        bar.setup(this);
        mainView = new MainView(this);
        this.add(mainView);
        imageView = new JLabel();
        imageView.setLocation(0,0);
        pv = new JScrollPane(imageView);
        mainView.add(pv);
        pv.setBorder(null);
        pv.setBackground(mainView.getBackground());
        imageView.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
               int ix = e.getX();
               int iy = e.getY();
               double xx = (double)ix/(double)Core.img.getWidth();
               double yx = (double) iy/(double) Core.img.getHeight();
               int xe = (int)(xx*Core.originalWidth);
                int ye = (int)(yx*Core.originalHeight);

                Core.oimg.setRGB(xe,ye,Core.selectedColor.getRGB());
                Core.oimg.getGraphics().dispose();
                Graphics2D g = Core.img.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                int ratio = Math.max(1,ix/xe);
                for(int i = 0;i<ratio;i++)
                    for(int j = 0;j<ratio;j++)
                        Core.img.setRGB(ix+i,iy+j,Core.selectedColor.getRGB());
                imageView.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                pv.setBounds(260,100,Math.min(getWidth()-340,Core.img.getWidth()),Math.min(getHeight()-250, Core.img.getHeight()));
                imageView.repaint();
                mainView.repaint();
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
        this.addWindowStateListener(e -> {
            pv.setBounds(260,100,Math.min(getWidth()-340,Core.img.getWidth()),Math.min(getHeight()-250, Core.img.getHeight()));
            imageView.repaint();
            mainView.repaint();
        });

    }
}
