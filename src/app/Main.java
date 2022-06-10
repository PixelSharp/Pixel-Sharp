package app;

import app.internal.ConfigParser;


import java.io.File;

public class Main {
    public static void main(String args[]){
        ConfigParser config = new ConfigParser();
        config.parseConfig(new File("data.cfg"));;
        Launcher.launchSession(config);
    }
}
