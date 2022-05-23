package Admin.view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.BaseProduct;
import business.DeliveryService;
import business.MenuItem;
import data.Serializator;
import gui_pack.StartGui;
import gui_pack.SuccesWindow;
import gui_pack.MenuTable;

public class AdminView {

    DeliveryService delivery = Serializator.DeliveryServiceDeserializator("DeliveryService.csv");
    private MenuTable table;
	private JTextField name = new JTextField();
	private JTextField rating = new JTextField();
	private JTextField calories = new JTextField();
	private JTextField protein = new JTextField();
	private JTextField fat = new JTextField();
	private JTextField sodium = new JTextField();
	private JTextField price = new JTextField();
	private int[] selectedField;
	private int selectedRow;
	public AdminView (JFrame f){
		//name colt dreapta sus +buton reintoarcere stanga sus
	    JLabel l = new JLabel("Admin ");
	    l.setFont(new Font("Serif", Font.BOLD, 15));
	    l.setBounds(700,10, 60,30);  
	    JButton ret = new JButton("BACK");
	    ret.setBounds(10, 10, 70, 35);   
	    f.add(l); f.add(ret);
	    
	    //display + scrollf
        List<MenuItem> menu = Serializator.MenuDeserializator("RegularMenu.csv");

        table = new MenuTable(menu);

        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(50,60,700,200);
        f.add(scrollPane);
        
        //aici
        int[] row = new int[1];

        table.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                row[0] = table.productsTable.getSelectedRow();
                name.setText((String) table.productsTable.getValueAt(row[0], 0));
                rating.setText((String) table.productsTable.getValueAt(row[0], 1));
                calories.setText((String) table.productsTable.getValueAt(row[0], 2));
                protein.setText((String) table.productsTable.getValueAt(row[0], 3));
                fat.setText((String) table.productsTable.getValueAt(row[0], 4));
                sodium.setText((String) table.productsTable.getValueAt(row[0], 5));
                price.setText((String) table.productsTable.getValueAt(row[0], 6));
            }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	    
	    //butoane produse
	    JButton dailyMenu = new JButton("Daily Menu");
	    dailyMenu.setBounds(30, 280, 100, 50);
	    f.add(dailyMenu);
	    JButton addProduct = new JButton("Add");
	    addProduct.setBounds(155, 280, 100, 50);
	    f.add(addProduct);
	    JButton removeProduct = new JButton("Remove");
	    removeProduct.setBounds(275, 280, 100, 50);
	    f.add(removeProduct);
	    JButton modifyProduct = new JButton("Modify");
	    modifyProduct.setBounds(395, 280, 100, 50);
	    f.add(modifyProduct);
	    JButton importProduct = new JButton("Import");
	    importProduct.setBounds(515, 280, 100, 50);
	    f.add(importProduct);
	    JButton raportProduct = new JButton("Raports");
	    raportProduct.setBounds(635, 280, 100, 50);
	    f.add(raportProduct);
	    
	    //comnezi labele       
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 350, 100, 20);
        f.add(l1);
        JLabel l2 = new JLabel("Rating");
        l2.setBounds(50, 380, 100, 20);
        f.add(l2);
        JLabel l3 = new JLabel("Calories");
        l3.setBounds(450, 380, 100, 20);
        f.add(l3);
        JLabel l4 = new JLabel("Protein");
        l4.setBounds(50, 410, 100, 20);
        f.add(l4);
        JLabel l5 = new JLabel("Fat");
        l5.setBounds(450, 410, 100, 20);
        f.add(l5);
        JLabel l6 = new JLabel("Sodium");
        l6.setBounds(50, 440, 100, 20);
        f.add(l6);
        JLabel l7 = new JLabel("Price");
        l7.setBounds(450, 440, 100, 20);
        f.add(l7);
        
        //atribute produse
        name.setBounds(150, 350, 600, 20);
         f.add(name);
        rating.setBounds(150, 380, 200, 20);
        f.add(rating);
        calories.setBounds(550, 380, 200, 20);
        f.add(calories);
        protein.setBounds(150, 410, 200, 20);
        f.add(protein);
        fat.setBounds(550, 410, 200, 20);
        f.add(fat);
        sodium.setBounds(150, 440, 200, 20);
        f.add(sodium);
        price.setBounds(550, 440, 200, 20);
        f.add(price);
        
	    ret.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	StartGui start = new StartGui(f);
	        }
	    });	
	    dailyMenu.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	DailyMenuView d = new DailyMenuView(f,delivery);
	        }
	    });	
	    raportProduct.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	ReportsView d = new ReportsView(f,delivery);
	        }
	    });	
	    
	    importProduct.addActionListener(new ActionListener() {//regularMenu list stocheaza produsele importate. le incarcam in fila RegularMenu.csv
	    public void actionPerformed(ActionEvent e) {
	    	
        delivery.regularMenu = delivery.ImportProducts();
        Serializator.MenuSerializator(delivery.regularMenu, "RegularMenu.csv");
        SuccesWindow succ = new SuccesWindow();
        
	    }});
	    
	    addProduct.addActionListener(new ActionListener() {//creeez un nou produs pe ceare il adaug in menu, sortez meniul, serializez, adaug noul rand in tabela
	    	public void actionPerformed(ActionEvent e) {
	    		BaseProduct newProduct = new BaseProduct(name.getText(), Float.parseFloat(rating.getText()), Integer.parseInt(calories.getText()), Integer.parseInt(protein.getText()), Integer.parseInt(fat.getText()), Integer.parseInt(sodium.getText()), Integer.parseInt(price.getText()));
	            menu.add(newProduct);
	            menu.sort(Comparator.comparing(MenuItem::getName));
	            Serializator.MenuSerializator(menu, "RegularMenu.csv");
	            ((DefaultTableModel)table.productsTable.getModel()).addRow(new Object[]{newProduct.getName(), newProduct.getRating(),newProduct.getCalories(), newProduct.getProtein(), newProduct.getFat(), newProduct.getSodium(),newProduct.getPrice()});
	            ((DefaultTableModel)table.productsTable.getModel()).fireTableDataChanged();
	            SuccesWindow view = new SuccesWindow();	
	    	}
	    });
	    
	    removeProduct.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//remove mutam toate randurile pe locurile potrivite pentru a se potrivi cu indexi deja fixati
	    		selectedField = table.productsTable.getSelectedRows();
                for(int i = 0; i < selectedField.length; i++){
                    menu.remove(selectedField[i] - i);
                    Serializator.MenuSerializator(menu, "RegularMenu.csv");
                    ((DefaultTableModel)table.productsTable.getModel()).removeRow(selectedField[i] - i);
                }                        
	            SuccesWindow view = new SuccesWindow();

	    	}
	    });
	    
	    modifyProduct.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {//creem un nou produs pe care il inlocuim cu cel vechi
	    		selectedField = table.productsTable.getSelectedRows();
	    		selectedRow = table.productsTable.getSelectedRow();
	    		BaseProduct modificatedProduct = new BaseProduct(name.getText(), Float.parseFloat(rating.getText()), Integer.parseInt(calories.getText()), Integer.parseInt(protein.getText()), Integer.parseInt(fat.getText()), Integer.parseInt(sodium.getText()), Integer.parseInt(price.getText()));
	    		menu.set(selectedRow, modificatedProduct);
	    		menu.sort(Comparator.comparing(MenuItem::getName));
	            Serializator.MenuSerializator(menu, "RegularMenu.csv");


	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(name.getText(), selectedRow, 0);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(rating.getText(), selectedRow, 1);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(calories.getText(), selectedRow, 2);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(protein.getText(), selectedRow, 3);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(fat.getText(), selectedRow, 4);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(sodium.getText(), selectedRow, 5);
	            ((DefaultTableModel)table.productsTable.getModel()).setValueAt(price.getText(), selectedRow, 6);
	            SuccesWindow view = new SuccesWindow();	
	    	}
	    });
	   
	}
}
