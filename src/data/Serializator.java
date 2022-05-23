package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import model.Admin;
import model.Client;

public class Serializator {

	public void createNecessaryFiles() {
        try {
            File myObj = new File("DeliveryService.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating Delivery Service file.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("AdminData.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating admin data file.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("ClientsData.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating clients data file.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("DailyMenu.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating daily menu data file.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("RegularMenu.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating regular menu data file.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("Orders.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating orders data file.");
            e.printStackTrace();
        }
        
	}
	
    public static void AdminSerializator(Admin a, String file){
    	try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(a);
            objectOutputStream.close();
            fos.close();

            System.out.println("Serialization admin succesfull!");
    	}
    	catch (IOException e) {
            e.printStackTrace();
            System.out.println("Serialization admin went wrong!");
    	}
    }
    public static Admin AdminDeserializator(String file){
        Admin aux = null ;
        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream objectInputStream  = new ObjectInputStream(fis);
            try {
				aux = (Admin)objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Something with admin deserialization went wrong!");
			}
            objectInputStream.close();
            fis.close();

            System.out.println("Admin deserialized succesfull! ");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Deserialization admin went wrong!");
        }
        return aux;
    }
    
    public static void ClientSerializator(List<Client> listOfClients, String file){

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fos);
            objectOutputStream.reset();
            objectOutputStream.writeObject(listOfClients);
            objectOutputStream.close();
            fos.close();

            System.out.println("Clients has been serialized!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Clients serialization went wrong!");
        }
    }

    @SuppressWarnings("unchecked")
	public static List<Client> ClientDeserializator(String file){

        List<Client> aux = new ArrayList<>();
        try
        {
         
            FileInputStream fis  = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            try {
				aux = (List<Client>) objectInputStream.readObject();
			     }
            catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            objectInputStream.close();
            fis.close();
            
            System.out.println("Clients has been deserialized! ");
            
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Clients deserialization went wrong!");
        }

        return aux;
    }
    
    
    public static void MenuSerializator(List<MenuItem> menu, String file){

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.reset();
            objectOutputStream.writeObject(menu);
            objectOutputStream.close();
            fos.close();

            System.out.println("Menu has been serialized!");

        } catch (Exception e) {
        	 System.out.println("Menu serialization went wrong!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public static List<MenuItem> MenuDeserializator(String file){

        List<MenuItem> menu = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            menu = (List<MenuItem>) objectInputStream.readObject();
            objectInputStream.close();
            fis.close();
            System.out.println("Menu has been deserialized!");
            
        }catch (Exception e) {
        	System.out.println("Menu deserialization went wrong!");
            e.printStackTrace();
        }

        return menu;
    }

    
    public static void DeliveryServiceSerializator(business.DeliveryService deliveryService, String file){

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fos);
            objectOutputStream.reset();
            objectOutputStream.writeObject(deliveryService);
            objectOutputStream.close();
            fos.close();

            System.out.println("Delivery Service has been serialized");

        } catch (Exception e) {
        	System.out.println("Delivery Service serialization went wrong!");
            e.printStackTrace();
        }
    }

    public static DeliveryService DeliveryServiceDeserializator(String file){

        DeliveryService aux = new DeliveryService();

        try
        {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
           aux = (DeliveryService) objectInputStream.readObject();
            objectInputStream.close();
            fis.close();

            System.out.println("Delivery Service has been deserialized!");
        }catch (Exception e) {
        	System.out.println("Delivery Service deserialization went wrong! ");
            e.printStackTrace();
        }

        return aux;
    }
    
    
    public static void OrderSerializator(Map<Order, List<MenuItem>> listOfOrders, String file){

        try {
            FileOutputStream fos= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.reset();
            objectOutputStream.writeObject(listOfOrders);
            objectOutputStream.close();
            fos.close();

            System.out.println("Orders list have been serialized!");

        } catch (Exception e) {
        	System.out.println("Orders list serialization went wrong!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public static Map<Order, List<MenuItem>> OrderDeserializator(String file){

        Map<Order, List<MenuItem>> aux = new Hashtable<>();

        try
        {
            FileInputStream fis  = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            aux = (Map<Order, List<MenuItem>>) objectInputStream.readObject();
            objectInputStream.close();
            fis.close();

            System.out.println("The orders have been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return aux;
    }

}
