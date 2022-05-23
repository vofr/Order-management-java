package Admin.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import data.Serializator;
import gui_pack.FailWindow;
import gui_pack.StartGui;
import model.Admin;

public class AdminLogin {

	public AdminLogin(JFrame f){
		//admin account

        Admin admin = Serializator.AdminDeserializator("AdminData.csv");
		//nume colt dreapta sus +buton reintoarcere stanga sus
	    JLabel l1 = new JLabel("Admin ");
	    l1.setFont(new Font("Serif", Font.BOLD, 15));
	    l1.setBounds(700,10, 60,30);  
	    JButton ret = new JButton("BACK");
	    ret.setBounds(10, 10, 70, 35);   
	    f.add(l1); f.add(ret);
	     
	       JLabel usernameLabel = new JLabel("Username: ");
	        usernameLabel.setBounds(200, 150, 120, 30);
	        JTextField username = new JTextField(30);
	        username.setBounds(280, 150, 300, 30);
	        username.setText("vofr");
	        JLabel passwordLabel = new JLabel("Password: ");
	        passwordLabel.setBounds(200, 250, 120, 30);
	        JTextField password = new JTextField(30);
	        password.setBounds(280, 250, 300, 30);
	        password.setText("aaa");
	        JButton buttLogin = new JButton("Login");
	        buttLogin.setBounds(350, 350, 100, 50);

	        f.add(usernameLabel);
	        f.add(username);
	        f.add(passwordLabel);
	        f.add(password);
	        f.add(buttLogin);
	      
	    //buton retur pagina start (back, apare in fiecare pagina si se intoarce la pagina anterioara daca nu e vorba de login)
	    ret.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	StartGui start = new StartGui(f);
	        }
	    });	
    
    buttLogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String userText=username.getText();
        	String passText=password.getText();
        	if(admin.getUsername().equals(userText)&&(admin.getPassword().equals(passText)))
        	{
        	f.getContentPane().removeAll();
        	f.getContentPane().repaint();
        	AdminView ad = new AdminView(f);
        	}
        	else
        	{
        		FailWindow fail = new FailWindow();
        	}
        }
    });	
}
}

