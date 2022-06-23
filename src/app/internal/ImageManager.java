package app.internal;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageManager {
    public static BufferedImage zoom(BufferedImage img, int nwidth,int nheight){
        Image img2  = img.getScaledInstance(nwidth, nheight,  Image.SCALE_SMOOTH);
        BufferedImage bimg2 = new BufferedImage(nwidth,nheight,BufferedImage.TYPE_INT_ARGB);
        bimg2.getGraphics().drawImage(img2,0,0,null);
        img = bimg2;
        return bimg2;
    }
    public static BufferedImage invert(BufferedImage img){
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgba = img.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(Math.abs(255 - col.getRed()),
                        Math.abs(255 - col.getGreen()),
                        Math.abs(255 - col.getBlue()),col.getAlpha());
                img.setRGB(x, y, col.getRGB());
            }
        }
        return img;
    }
}
