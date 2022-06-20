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
}
