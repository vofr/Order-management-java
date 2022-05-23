package gui_pack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Admin.view.AdminLogin;
import Client.view.ClientLogin;



public class StartGui {

	public StartGui(JFrame f) {
	JLabel l1 = new JLabel("Login as: ");
    l1.setFont(new Font("Serif", Font.BOLD, 30));
    l1.setBounds(275,200, 130,40);
    
    JButton admin = new JButton("Admin");
    admin.setBounds(150, 270, 140, 50);
    
    JButton client = new JButton("Client");
    client.setBounds(350, 270, 140, 50);
    
    
    f.add(l1); f.add(admin); f.add(client);
    f.setSize(800,600);  
    f.setLayout(null);  
    f.setVisible(true); 
    admin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	f.getContentPane().removeAll();
        	f.getContentPane().repaint();
        	AdminLogin admin = new AdminLogin(f);
        }
    });
    client.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	f.getContentPane().removeAll();
        	f.getContentPane().repaint();
        	ClientLogin cl = new ClientLogin(f);
        }
    });
	
	}
}

