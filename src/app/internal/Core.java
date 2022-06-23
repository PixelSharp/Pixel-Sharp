package app.internal;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import app.ui.Window;

public class Core {
    public static BufferedImage img = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
    public static Window win;
    public static int originalWidth,originalHeight;
    public static BufferedImage oimg;
    public static Color selectedColor = Color.BLACK;
    public static int penSize = 1;
    public Core(Window w,ConfigParser configParser){
        win = w;
        win.imageView.setIcon(new ImageIcon(img));
        originalWidth = img.getWidth();
        originalHeight = img.getHeight();
        win.imageView.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        for(int i = 0;i<400;i++){
          Color c = new Color(255,255,255);
          for(int j = 0;j<400;j++){
              img.setRGB(i,j,i*j);
          }
      }
        oimg = img;
    }
    public static void zoom(double z){
        img = ImageManager.zoom(oimg,(int)(z*originalWidth),(int)(z*originalHeight));
        Core.win.imageView.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        Core.win.imageView.getGraphics().dispose();
        Core.win.imageView.setIcon(new ImageIcon(img));
        Core.win.imageView.repaint();
        Core.win.pv.repaint();
    }
}
