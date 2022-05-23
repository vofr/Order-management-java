package business;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;

import data.Serializator;

public class DeliveryService implements  Serializable,DeliveryProcessing{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3296459099771925144L;

    public List<MenuItem> regularMenu;
    public List<MenuItem> dailyMenu;
    public Map<Order, List<MenuItem>> ordersInfo;

    public DeliveryService() {
        this.regularMenu = null;
        this.dailyMenu = null;
        this.ordersInfo = new Hashtable<>();;
    }

    public boolean corectness(){
        if(regularMenu==null || dailyMenu==null || ordersInfo==null)
        	return false;
        else
           return true;
    }
	@Override
	public void PlaceOrder(Order order) {
		int a;
		
	}

	@Override
	public void ModifyProduct(MenuItem product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreateDailyMenu(String product1, String product2, String product3, String product4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GenerateRaports() {
		// TODO Auto-generated method stub
		
	}

    public static Function<String, MenuItem>  mapare = (line) -> {
        String[] aux = line.split(",");
        String name=aux[0];
        float rating=Float.parseFloat(aux[1]);
        int calories=Integer.parseInt(aux[2]);
        int protein=Integer.parseInt(aux[3]);
        int fat=Integer.parseInt(aux[4]);
        int sodium=Integer.parseInt(aux[5]);
        int price=Integer.parseInt(aux[6]);
        return new BaseProduct(name, rating, calories, protein, fat, sodium, price);
    };
	@Override
	public List<MenuItem> ImportProducts() {
		//dupa verificare cu assert citim printr-un buffer products.csv si mapam in menu produsele colectate si sortate in functie de nume stocate intr-o lista
		assert corectness();
		InputStream fis;
		BufferedReader buff;
		List<MenuItem> menu;
		try {
			fis = new FileInputStream("Products.csv");
	        buff = new BufferedReader(new InputStreamReader(fis));
	        //inlocuire lambda
	        menu = buff.lines().skip(1).map(mapare).collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getName))), ArrayList::new));	    
	        try {
				buff.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("filele nu au fost inchise corect(buffers si input stream)");
				e.printStackTrace();
			}
	        
	        return menu;
		} catch (FileNotFoundException e) {
			System.out.println("Importing products went wrong!");
			e.printStackTrace();
		}
		return null;
		}

	@Override
	public void AddProduct(MenuItem product) {
		regularMenu.add(product);
        Serializator.MenuSerializator(regularMenu,"RegularMenu.cvs");
		
	}

	@Override
	public void DeleteProduct(MenuItem product) {
		// TODO Auto-generated method stub
		
	}

}