package Client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Admin.view.DailyMenuView;
import Admin.view.ReportsView;
import business.DeliveryService;
import business.MenuItem;
import business.Order;
import data.Serializator;
import gui_pack.FailWindow;
import gui_pack.MenuTable;
import gui_pack.StartGui;
import model.Client;
import gui_pack.SuccesWindow;

public class ClientView {

	private JTextField name = new JTextField();
	private JTextField rating = new JTextField();
	private JTextField calories = new JTextField();
	private JTextField protein = new JTextField();
	private JTextField fat = new JTextField();
	private JTextField sodium = new JTextField();
	private JTextField price = new JTextField();
	private int ratingNr,caloriesNr,proteinNr,fatNr,sodiumNr,priceNr;
	private List<MenuItem> basketList = new ArrayList<>();
	JToggleButton lessRating =  new JToggleButton("<");
	JToggleButton equalRating =  new JToggleButton("=");
	JToggleButton greaterRating =  new JToggleButton(">");
	public List<MenuItem> menu = new ArrayList<MenuItem>();
	public ClientView(JFrame f,Client cl) {
		//name colt dreapta sus +buton reintoarcere stanga sus
 
		f.setSize(1050, 650);
	    JLabel l = new JLabel("Client ");
	    l.setFont(new Font("Serif", Font.BOLD, 15));
	    l.setBounds(980,10, 60,30);  
	    JButton ret = new JButton("BACK");
	    ret.setBounds(10, 10, 70, 35);   
	    f.add(l); f.add(ret);
	    
        JLabel label = new JLabel("See our daily menus!");
        label.setBounds(30, 55, 500, 30);
        f.add(label);
	    
        List<MenuItem> dailyMenu = Serializator.MenuDeserializator("DailyMenu.csv");

        MenuTable table1 = new MenuTable(dailyMenu);

        table1.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane2 = new JScrollPane(table1.productsTable);
        scrollPane2.setBounds(30,85,700,165);
        f.add(scrollPane2);
   
	    
        JLabel label1 = new JLabel("Check our menu!");
        label1.setBounds(30, 265, 500, 30);
        f.add(label1);
	    
        menu = Serializator.MenuDeserializator("RegularMenu.csv");
        MenuTable table = new MenuTable(menu);
        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(30,295,700,295);
        f.add(scrollPane);
        f.setLayout(null);  
	    f.setVisible(true);
        final int[] rowBaseProducts = new int[1];

        table.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowBaseProducts[0] = table.productsTable.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        final int[] rowDailyMenu = new int[1];

        table1.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowDailyMenu[0] = table1.productsTable.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
	    
	    
	    
	    //comnezi labele 
        JLabel labelfl = new JLabel("Filter by");
        labelfl.setBounds(740, 265, 500, 30);
        f.add(labelfl);
        JLabel l1 = new JLabel("Name");
        l1.setBounds(740, 295, 100, 20);
        f.add(l1);
        JLabel l2 = new JLabel("Rating");
        l2.setBounds(740, 325, 100, 20);
        f.add(l2);
        JLabel l3 = new JLabel("Calories");
        l3.setBounds(740, 355, 100, 20);
        f.add(l3);
        JLabel l4 = new JLabel("Protein");
        l4.setBounds(740, 385, 100, 20);
        f.add(l4);
        JLabel l5 = new JLabel("Fat");
        l5.setBounds(740, 415, 100, 20);
        f.add(l5);
        JLabel l6 = new JLabel("Sodium");
        l6.setBounds(740, 445, 100, 20);
        f.add(l6);
        JLabel l7 = new JLabel("Price");
        l7.setBounds(740, 475, 100, 20);
        f.add(l7);
        
        //atribute produse
        name.setBounds(795, 295, 105, 20);
         f.add(name);
        rating.setBounds(795, 325, 105, 20);
        f.add(rating);
        calories.setBounds(795, 355, 105, 20);
        f.add(calories);
        protein.setBounds(795, 385, 105, 20);
        f.add(protein);
        fat.setBounds(795, 415, 105, 20);
        f.add(fat);
        sodium.setBounds(795, 445, 105, 20);
        f.add(sodium);
        price.setBounds(795, 475, 105, 20);
        f.add(price);
        //toogles
        
        lessRating.setBounds(910,325,20,20);
        lessRating.setMargin(new Insets(0, 0, 0, 0));//sa incapa textul
        f.add(lessRating);
       
        equalRating.setBounds(930,325,20,20);
        equalRating.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalRating);
        
        greaterRating.setMargin(new Insets(0, 0, 0, 0));
        greaterRating.setBounds(950,325,20,20);
        f.add(greaterRating);
        
        JButton refreshSort = new JButton("refresh");
        refreshSort.setBounds(910,295,60,20);
        refreshSort.setMargin(new Insets(0, 0, 0, 0));
        f.add(refreshSort);
        
        JToggleButton lessCalories =  new JToggleButton("<");
        lessCalories.setBounds(910,355,20,20);
        lessCalories.setMargin(new Insets(0, 0, 0, 0));
        f.add(lessCalories);
        JToggleButton equalCalories=  new JToggleButton("=");
        equalCalories.setBounds(930,355,20,20);
        equalCalories.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalCalories);
        JToggleButton greaterCalories= new JToggleButton(">");
        greaterCalories.setMargin(new Insets(0, 0, 0, 0));
        greaterCalories.setBounds(950,355,20,20);
        f.add(greaterCalories);
        
        JToggleButton lessProtein =  new JToggleButton("<");
        lessProtein.setBounds(910,385,20,20);
        lessProtein.setMargin(new Insets(0, 0, 0, 0));
        f.add(lessProtein);
        JToggleButton equalProtein=  new JToggleButton("=");
        equalProtein.setBounds(930,385,20,20);
        equalProtein.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalProtein);
        JToggleButton greaterProtein= new JToggleButton(">");
        greaterProtein.setMargin(new Insets(0, 0, 0, 0));
        greaterProtein.setBounds(950,385,20,20);
        f.add(greaterProtein);
        
        JToggleButton lessFat =  new JToggleButton("<");
        lessFat.setBounds(910,415,20,20);
        lessFat.setMargin(new Insets(0, 0, 0, 0));
        f.add(lessFat);
        JToggleButton equalFat=  new JToggleButton("=");
        equalFat.setBounds(930,415,20,20);
        equalFat.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalFat);
        JToggleButton greaterFat= new JToggleButton(">");
        greaterFat.setMargin(new Insets(0, 0, 0, 0));
        greaterFat.setBounds(950,415,20,20);
        f.add(greaterFat);
        
        JToggleButton lessSodium =  new JToggleButton("<");
        lessSodium.setBounds(910,445,20,20);
        lessSodium.setMargin(new Insets(0, 0, 0, 0));
        f.add(lessSodium);
        JToggleButton equalSodium=  new JToggleButton("=");
        equalSodium.setBounds(930,445,20,20);
        equalSodium.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalSodium);
        JToggleButton greaterSodium= new JToggleButton(">");
        greaterSodium.setMargin(new Insets(0, 0, 0, 0));
        greaterSodium.setBounds(950,445,20,20);
        f.add(greaterSodium);
        
        JToggleButton lessPrice =  new JToggleButton("<");
        lessPrice.setBounds(910,475,20,20);
        lessPrice.setMargin(new Insets(0, 0, 0, 0));
        f.add(lessPrice);
        JToggleButton equalPrice=  new JToggleButton("=");
        equalPrice.setBounds(930,475,20,20);
        equalPrice.setMargin(new Insets(0, 0, 0, 0));
        f.add(equalPrice);
        JToggleButton greaterPrice= new JToggleButton(">");
        greaterPrice.setMargin(new Insets(0, 0, 0, 0));
        greaterPrice.setBounds(950,475,20,20);
        f.add(greaterPrice);
        
        //filter
        greaterRating.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterRating.isSelected()) {
            		equalRating.setSelected(false);
            		lessRating.setSelected(false);
            	    ratingNr=1;
            	    List<MenuItem> filtredM=MenuSorter();
            	    table.refreshTable(filtredM);
                    table.productsTable.revalidate();
                    table.productsTable.updateUI();
                    scrollPane.setViewportView(table.productsTable);
                    scrollPane.revalidate();
                    scrollPane.updateUI();
            	} 
            	else{
            		ratingNr=0;
            	}
            }});
        equalRating.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalRating.isSelected()) {
            		greaterRating.setSelected(false);
            		lessRating.setSelected(false);
               		ratingNr=2;
               	    List<MenuItem> filtredM=MenuSorter();
            	    table.refreshTable(filtredM);
                    table.productsTable.revalidate();
                    table.productsTable.updateUI();
                    scrollPane.setViewportView(table.productsTable);
                    scrollPane.revalidate();
                    scrollPane.updateUI();
            	} 
            	else
            		ratingNr=0;
            }});
        lessRating.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessRating.isSelected()) {
            		equalRating.setSelected(false);
            		greaterRating.setSelected(false);
            		ratingNr=3;
               	    List<MenuItem> filtredM=MenuSorter();
            	    table.refreshTable(filtredM);
                    table.productsTable.revalidate();
                    table.productsTable.updateUI();
                    scrollPane.setViewportView(table.productsTable);
                    scrollPane.revalidate();
                    scrollPane.updateUI();
            	 } 
            	else ratingNr=0;
            	}});
	  
        greaterCalories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterCalories.isSelected()) {
            		equalCalories.setSelected(false);
            		lessCalories.setSelected(false);
            		caloriesNr=1;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		caloriesNr=0;
            }});
        equalCalories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalCalories.isSelected()) {
            		greaterCalories.setSelected(false);
            		lessCalories.setSelected(false);
            		caloriesNr=2;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		caloriesNr=0; }});
        lessCalories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessCalories.isSelected()) {
            		equalCalories.setSelected(false);
            		greaterCalories.setSelected(false);
            		caloriesNr=3;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		caloriesNr=0; }});
        
        greaterProtein.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterProtein.isSelected()) {
            		equalProtein.setSelected(false);
            		lessProtein.setSelected(false);
            		proteinNr=1;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		proteinNr=0; }});
        equalProtein.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalProtein.isSelected()) {
            		greaterProtein.setSelected(false);
            		lessProtein.setSelected(false);
            		proteinNr=2;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		proteinNr=0; }});
        lessProtein.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessProtein.isSelected()) {
            		equalProtein.setSelected(false);
            		greaterProtein.setSelected(false);
            		proteinNr=3;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		proteinNr=0; }});
        
        //fat soium price
        greaterFat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterFat.isSelected()) {
            		equalFat.setSelected(false);
            		lessFat.setSelected(false);
            		fatNr=1;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		fatNr=0; }});
        equalFat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalFat.isSelected()) {
            		greaterFat.setSelected(false);
            		lessFat.setSelected(false);
            		fatNr=2;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		fatNr=0; }});
        lessFat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessFat.isSelected()) {
            		equalFat.setSelected(false);
            		greaterFat.setSelected(false);
            		fatNr=3;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		fatNr=0;}});
        
        greaterSodium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterSodium.isSelected()) {
            		equalSodium.setSelected(false);
            		lessSodium.setSelected(false);
            		sodiumNr=1;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		sodiumNr=0; }});
        equalSodium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalSodium.isSelected()) {
            		greaterSodium.setSelected(false);
            		lessSodium.setSelected(false);
            		sodiumNr=2;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		sodiumNr=0;  }});
        lessSodium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessSodium.isSelected()) {
            		equalSodium.setSelected(false);
            		greaterSodium.setSelected(false);
            		sodiumNr=3;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		sodiumNr=0;  }});
        
        greaterPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(greaterPrice.isSelected()) {
            		equalPrice.setSelected(false);
            		lessPrice.setSelected(false);
            		priceNr=1;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		priceNr=0;  }});
        equalPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(equalPrice.isSelected()) {
            		greaterPrice.setSelected(false);
            		lessPrice.setSelected(false);
            		priceNr=2;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		priceNr=0;  }});
        lessPrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(lessPrice.isSelected()) {
            		equalPrice.setSelected(false);
            		greaterPrice.setSelected(false);
            		priceNr=3;
            		 List<MenuItem> filtredM=MenuSorter();
             	    table.refreshTable(filtredM);
                     table.productsTable.revalidate();
                     table.productsTable.updateUI();
                     scrollPane.setViewportView(table.productsTable);
                     scrollPane.revalidate();
                     scrollPane.updateUI();
            	} 
            	else
            		priceNr=0;  }});
        
        //butoane
	    JButton add = new JButton("add");
	    add.setBounds(740, 505, 70, 40);   
	    f.add(add);
	    JButton order = new JButton("Order");
	    order.setBounds(820, 505, 70, 40);   
	    f.add(order);
	    JButton seeBasket = new JButton("Basket");
	    seeBasket.setBounds(900, 505, 70, 40);   
	    f.add(seeBasket);
	    JButton addDaily = new JButton("add daily menu!");
	    addDaily.setBounds(740, 80, 230, 40);   
	    f.add(addDaily);
        
	    ret.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	f.setSize(800, 600);
	        	StartGui start = new StartGui(f);
	        }
	    });	
	    seeBasket.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Basket basket = new Basket(basketList);
	        }
	    });	
	    order.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	DeliveryService delivery = new DeliveryService();
	            int totalPrice = 0;
	            for(MenuItem m : basketList) totalPrice += m.getPrice();
	            Order order = new Order(cl.getId(), totalPrice);
	            System.out.println(order.getDate()+" ");
	            delivery.ordersInfo.put(order,basketList);
	            Serializator.OrderSerializator(delivery.ordersInfo, "Orders.csv");
	            Serializator.DeliveryServiceSerializator(delivery, "DeliveryService.csv");

	            try {
	                FileWriter fileWriter = new FileWriter("bill.txt");
	                fileWriter.write("This is your bill\n");
	                fileWriter.write("> Order by: " + cl.getUsername() + "\n");
	                fileWriter.write("> PRODUCTS: \n");
	                for(MenuItem m : basketList) fileWriter.write(m.getName() + "\n");
	                fileWriter.write("\n> Total price : " + totalPrice + "\n");
	                fileWriter.write("\n> Date: " + order.getDate().toString() + "\n");
	                fileWriter.close();
	                

	            } catch (IOException ioException) {
	                ioException.printStackTrace();
	            }
	            SuccesWindow view = new SuccesWindow();
	        }
	    });	
	    
	    add.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String baseProductTitle = (String) table.productsTable.getValueAt(rowBaseProducts[0], 0);
	            for(MenuItem m : menu){
	                if(m.getName().equals(baseProductTitle)){
	                    basketList.add(m);
	                    break;
	                }
	            }
	            SuccesWindow view = new SuccesWindow();
	        }
	    });	
	    refreshSort.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            greaterRating.setSelected(false);
	            equalRating.setSelected(false);
	            lessRating.setSelected(false);
	            rating.setText("");
	            
	            greaterCalories.setSelected(false);
	            equalCalories.setSelected(false);
	            lessCalories.setSelected(false);
	            calories.setText("");
	            
	            greaterProtein.setSelected(false);
	            equalProtein.setSelected(false);
	            lessProtein.setSelected(false);
	           protein.setText("");
	            
	            greaterFat.setSelected(false);
	            equalFat.setSelected(false);
	            lessFat.setSelected(false);
	            fat.setText("");
	            
	            greaterSodium.setSelected(false);
	            equalSodium.setSelected(false);
	            lessSodium.setSelected(false);
	            sodium.setText("");
	            
	            greaterPrice.setSelected(false);
	            equalPrice.setSelected(false);
	            lessPrice.setSelected(false);
	            price.setText("");
	            
	            
	            table.refreshTable(menu);
                table.productsTable.revalidate();
                table.productsTable.updateUI();
                scrollPane.setViewportView(table.productsTable);
                scrollPane.revalidate();
                scrollPane.updateUI();
	            
	        }
	    });	
	    
	    addDaily.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String dailyMenuTitle = (String) table1.productsTable.getValueAt(rowDailyMenu[0], 0);
	            for(MenuItem m : dailyMenu){
	                if(m.getName().equals(dailyMenuTitle)){
	                    basketList.add(m);
	                    break;
	                }
	            }
	            SuccesWindow view = new SuccesWindow();
	        }
	    });	
	    
	    //filter listners
	    name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               table.Filter(table.sorter, name.getText(),0);
            }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub				
			}

	    
    });
	    
	
}
	public List<MenuItem> MenuSorter() {
    	List<MenuItem> filtredMenu=new ArrayList<MenuItem>(menu);

    	if(!rating.getText().equals("") && ratingNr!=0)
    		if(ratingNr==1)
    			filtredMenu.removeIf(element -> element.getRating()<Float.parseFloat(rating.getText()));
    		else if(ratingNr==2)
    	    	filtredMenu.removeIf(element -> element.getRating()!=Float.parseFloat(rating.getText()));
    		else if(ratingNr==3)
    	    	filtredMenu.removeIf(element -> element.getRating()>Float.parseFloat(rating.getText()));

        	if(!calories.getText().equals("") && caloriesNr!=0)
        		if(caloriesNr==1)
        			filtredMenu.removeIf(element -> element.getCalories()<Float.parseFloat(calories.getText()));
        		else if(caloriesNr==2)
        	    	filtredMenu.removeIf(element -> element.getCalories()!=Float.parseFloat(calories.getText()));
        		else if(caloriesNr==3)
        	    	filtredMenu.removeIf(element -> element.getCalories()>Float.parseFloat(calories.getText()));   
        	    
        if(!protein.getText().equals("") && proteinNr!=0)
                if(proteinNr==1)
            			filtredMenu.removeIf(element -> element.getProtein()<Float.parseFloat(protein.getText()));
                else  if(proteinNr==2)
            	    	filtredMenu.removeIf(element -> element.getProtein()!=Float.parseFloat(protein.getText()));
                else if(proteinNr==3)
            	    	filtredMenu.removeIf(element -> element.getProtein()>Float.parseFloat(protein.getText()));
          
         
        if(!fat.getText().equals("") && fatNr!=0)
                if(fatNr==1)
                			filtredMenu.removeIf(element -> element.getFat()<Float.parseFloat(fat.getText()));
                else if(fatNr==2)
                	    	filtredMenu.removeIf(element -> element.getFat()!=Float.parseFloat(fat.getText()));
                else if(fatNr==3)
                	    	filtredMenu.removeIf(element -> element.getFat()>Float.parseFloat(fat.getText()));
                
        if(!sodium.getText().equals("") && sodiumNr!=0)
          if(sodiumNr==1)
            			filtredMenu.removeIf(element -> element.getSodium()<Float.parseFloat(sodium.getText()));
          else if(sodiumNr==2)
            	    	filtredMenu.removeIf(element -> element.getSodium()!=Float.parseFloat(sodium.getText()));
          else if(sodiumNr==3)
            	    	filtredMenu.removeIf(element -> element.getSodium()>Float.parseFloat(sodium.getText()));
        
        if(!price.getText().equals("") && priceNr!=0)
            if(priceNr==1)
              			filtredMenu.removeIf(element -> element.getPrice()<Float.parseFloat(price.getText()));
            else if(priceNr==2)
              	    	filtredMenu.removeIf(element -> element.getPrice()!=Float.parseFloat(price.getText()));
            else if(priceNr==3)
              	    	filtredMenu.removeIf(element -> element.getPrice()>Float.parseFloat(price.getText()));                   
    	    
    	   return filtredMenu;
    }
}
