package app;


import app.internal.ConfigParser;
import app.internal.Core;
import app.ui.Window;

import javax.swing.*;
import java.io.File;

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
        ConfigParser configParser = new ConfigParser();
        configParser.parseConfig(new File("data.cfg"));
        new Core(new Window(),configParser);
    }
}
