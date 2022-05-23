package gui_pack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class FailWindow {
  private JFrame f;
  public FailWindow(){
     f = new JFrame("BAD");
	  f.setLocationRelativeTo(null);
		        f.setSize(300,200);
		        f.setResizable(false);
		        JLabel lab = new JLabel("                                Operation failed!");
		        lab.setBounds(135, 90, 300, 50);
		        f.add(lab);
		        f.setVisible(true);
		        new Timer(3_000, (e) -> { f.setVisible(false); f.dispose(); }).start();
		    }
		}

