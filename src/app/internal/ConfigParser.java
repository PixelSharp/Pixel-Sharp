package app.internal;

import java.io.*;

public class ConfigParser {
    public String lastOpenedFilePath;

    public void parseConfig(File f) {
        char c[] = new char[10241];
        int i = 0;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while ((byte) (c[i] = (char) bf.read()) != -1)
                i++;
            String content = new String(c).substring(0, i);
            this.read(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(String content) {
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String type = lines[i].split(":")[0];
            String value = lines[i].split(":")[1];
            switch (type) {
                case "lof":
                    lastOpenedFilePath = value;
                    break;
                default:
                    break;
            }
        }
    }
}


