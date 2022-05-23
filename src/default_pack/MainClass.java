package default_pack;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import data.Serializator;
import gui_pack.FailWindow;
import gui_pack.StartGui;
import gui_pack.SuccesWindow;
import model.Admin;
import model.Client;

public class MainClass {

	public static void main(String[] args) {
        //user admin cu nume si parola
		Serializator.AdminSerializator(new Admin("vofr","aaa"), "AdminData.csv");
		
		List<Client> aux = new ArrayList<Client>();//cont client inceput
		Client client = new Client("Tony","pass");
		aux.add(client);
		Serializator.ClientSerializator(aux, "ClientsData.csv");
		
		JFrame f= new JFrame("Order Management");
		StartGui start = new StartGui(f); 
		}

}
