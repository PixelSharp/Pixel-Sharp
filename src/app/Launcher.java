package app;


import app.internal.ConfigParser;
import app.internal.Session;

import javax.swing.*;

public class Launcher {
    public static void launchSession(ConfigParser config){
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Session(config);
    }
}
