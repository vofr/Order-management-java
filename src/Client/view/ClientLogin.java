package Client.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Admin.view.AdminView;
import data.Serializator;
import gui_pack.FailWindow;
import gui_pack.StartGui;
import model.Admin;
import model.Client;

public class ClientLogin {

	private List <Client> cl= new ArrayList<Client>();
	public ClientLogin(JFrame f){
		
		//nume colt dreapta sus +buton reintoarcere stanga sus
	    JLabel l1 = new JLabel("Client ");
	    l1.setFont(new Font("Serif", Font.BOLD, 15));
	    l1.setBounds(700,10, 60,30);  
	    JButton ret = new JButton("BACK");
	    ret.setBounds(10, 10, 70, 35);   
	    f.add(l1); f.add(ret);
	     
	       JLabel usernameLabel = new JLabel("Username: ");
	        usernameLabel.setBounds(200, 150, 120, 30);
	        JTextField username = new JTextField(30);
	        username.setBounds(280, 150, 300, 30);
	        JLabel passwordLabel = new JLabel("Password: ");
	        passwordLabel.setBounds(200, 250, 120, 30);
	        JTextField password = new JTextField(30);
	        password.setBounds(280, 250, 300, 30);
	        JButton buttLogin = new JButton("Login");
	        buttLogin.setBounds(250, 350, 100, 50);
	        JButton buttSingUp = new JButton("Sing-up");
	        buttSingUp.setBounds(400, 350, 100, 50);

	        username.setText("Tony");
	        password.setText("pass");
	        f.add(usernameLabel);
	        f.add(username);
	        f.add(passwordLabel);
	        f.add(password);
	        f.add(buttLogin);
	        f.add(buttSingUp);
	    
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
        	boolean aux=false;
        	cl=Serializator.ClientDeserializator("ClientsData.csv");
        	for(Client j : cl) {
        		if(j.getUsername().equals(userText) && j.getPassword().equals(passText))
        		{f.getContentPane().removeAll();
            	f.getContentPane().repaint();
            	ClientView clientV = new ClientView(f,j);
            	aux=true;
        		}
        	}   
        	if(aux==false)
        	{
        	FailWindow fail = new FailWindow();
        	}
        }
    });	
    buttSingUp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String userText=username.getText();
        	String passText=password.getText();
        	Client client = new Client(userText,passText);
        	cl.add(client);
        	Serializator.ClientSerializator(cl, "ClientsData.csv");
        }
    });	
}
	public void addClient(Client aux) {
		cl.add(aux);
	}

}
