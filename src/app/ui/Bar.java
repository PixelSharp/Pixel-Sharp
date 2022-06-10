package app.ui;

import javax.swing.*;

public class Bar {
    public JMenu fmenu = new JMenu("File");
    public JMenu emenu = new JMenu("Edit");
    public JMenu pmenu = new JMenu("Preferences");
    public JMenu hmenu = new JMenu("Help");
    public JMenuItem oitem = new JMenuItem("Open");
    public JMenuItem nitem = new JMenuItem("New");
    public JMenuItem sitem = new JMenuItem("Save");
    public JMenuItem saitem = new JMenuItem("Save As");
    public JMenuItem eitem = new JMenuItem("Exit");
    public JMenuItem uitem = new JMenuItem("Undo");
    public JMenuItem ritem = new JMenuItem("Redo");
    public JMenuItem citem = new JMenuItem("Clear All");
    public JMenuItem seitem = new JMenuItem("Setting");
    public JMenuItem hitem = new JMenuItem("Help");
    public JMenuItem ditem = new JMenuItem("Donate");

    public void setup(Window win){
        win.menuBar.add(fmenu);
        win.menuBar.add(emenu);
        win.menuBar.add(pmenu);
        win.menuBar.add(hmenu);
        fmenu.add(nitem);
        fmenu.add(nitem);
        fmenu.add(sitem);
        fmenu.add(saitem);
        fmenu.add(eitem);
        emenu.add(citem);
        emenu.add(uitem);
        emenu.add(ritem);
        pmenu.add(seitem);
        hmenu.add(hitem);
        hmenu.add(ditem);
    }
}
