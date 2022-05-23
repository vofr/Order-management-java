package gui_pack;

import javax.swing.*;
import java.awt.*;

public class SuccesWindow {

    private JFrame f;

    public SuccesWindow(){
    	f = new JFrame("GOOD");
    	f.setLocationRelativeTo(null);
    f.setSize(300,200);
    f.setResizable(false);
    JLabel lab = new JLabel("                                Operation succeeded!");
    lab.setBounds(135, 90, 300, 50);
    f.add(lab);
    f.setVisible(true);
    new Timer(3_000, (e) -> { f.setVisible(false); f.dispose(); }).start();
}
}