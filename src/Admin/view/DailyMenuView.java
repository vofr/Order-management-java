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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.BaseProduct;
import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;
import data.Serializator;
import gui_pack.MenuTable;
import gui_pack.StartGui;
import gui_pack.SuccesWindow;

public class DailyMenuView {
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	public DailyMenuView(JFrame f,DeliveryService delivery){
		//String[] menu = { "Placinte","Pizza","Spaghete","Ciolan","Supa" };
		//name colt dreapta sus +buton reintoarcere stanga sus
	    JLabel l = new JLabel("Admin ");
	    l.setFont(new Font("Serif", Font.BOLD, 15));
	    l.setBounds(700,10, 60,30);  
	    JButton ret = new JButton("BACK");
	    ret.setBounds(10, 10, 70, 35);   
	    f.add(l); f.add(ret);
	    
	    //display + scrollf
        List<MenuItem> dailyMenu = Serializator.MenuDeserializator("DailyMenu.csv");

        MenuTable dailyMenuTable = new MenuTable(dailyMenu);

        dailyMenuTable.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(dailyMenuTable.productsTable);
        scrollPane.setBounds(30,60,700,200);
        f.add(scrollPane);

        List<MenuItem> menu = Serializator.MenuDeserializator("RegularMenu.csv");  
	    
	    
	    //labels
	    l1 = new JLabel("Select the first product");
	    l1.setBounds(30, 280, 300, 30);
	    f.add(l1);
        l2 = new JLabel("Select the second product");
        l2.setBounds(30, 320, 300, 30);
        f.add(l2);
        l3 = new JLabel("Select the third product");
        l3.setBounds(30, 360, 300, 30);
        f.add(l3);
        l4 = new JLabel("Select the fourth product");
        l4.setBounds(30, 400, 300, 30);
        f.add(l4);
          
        //combo
        JComboBox cb1 =JCombo(menu);
        cb1.setBounds(250, 280, 300, 30);
        f.add(cb1);
        JComboBox cb2 = JCombo(menu);
        cb2.setBounds(250, 320, 300, 30);
        f.add(cb2);
        JComboBox cb3 =JCombo(menu);
        cb3.setBounds(250, 360, 300, 30);
        f.add(cb3);
        JComboBox cb4 = JCombo(menu);
        cb4.setBounds(250, 400, 300, 30);     
        f.add(cb4);
	    
	    //butoane meniu
	    JButton add= new JButton("Create Menu");
	    add.setBounds(30, 450, 125, 50);
	    f.add(add);
	    JButton delete = new JButton("Delete Menu");
	    delete.setBounds(180, 450, 125, 50);
	    f.add(delete);
	    ret.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	f.getContentPane().removeAll();
	        	f.getContentPane().repaint();
	        	AdminView admin = new AdminView(f);
	        }
	    });	
    
        final int[] row = new int[1];

        dailyMenuTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                row[0] = dailyMenuTable.productsTable.getSelectedRow();
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

	    
	add.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	CompositeProduct cp = new CompositeProduct();

            String productName1 = (String) cb1.getSelectedItem();
            String productName2 = (String) cb2.getSelectedItem();
            String productName3 = (String) cb3.getSelectedItem();
            String productName4 = (String) cb4.getSelectedItem();

            delivery.CreateDailyMenu(productName1, productName2, productName3, productName4);

            for (MenuItem m : menu){
                if(m.getName().equals(productName1)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getName().equals(productName2)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getName().equals(productName3)){
                    cp.addProduct((BaseProduct) m);
                }
                if(m.getName().equals(productName4)){
                    cp.addProduct((BaseProduct) m);
                }
            }

            dailyMenu.add(cp);
            dailyMenu.sort(Comparator.comparing(MenuItem::getName));
            Serializator.MenuSerializator(dailyMenu, "DailyMenu.csv");
            ((DefaultTableModel)dailyMenuTable.productsTable.getModel()).addRow(new Object[]{cp.getName(), cp.getRating(),cp.getCalories(), cp.getProtein(), cp.getFat(), cp.getSodium(),cp.getPrice()});
            ((DefaultTableModel)dailyMenuTable.productsTable.getModel()).fireTableDataChanged();
            SuccesWindow view = new SuccesWindow();
        }
    });	
	
    delete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dailyMenu.remove(row[0]);
            Serializator.MenuSerializator(dailyMenu, "DailyMenu.csv");
            ((DefaultTableModel)dailyMenuTable.productsTable.getModel()).removeRow(row[0]);

            SuccesWindow view = new SuccesWindow();
        }
    });	


}
	 public JComboBox JCombo(List<MenuItem> menu){
	        JComboBox<String> combo = new JComboBox<>();
	        if(menu == null || menu.size() == 0){
	            combo.addItem("None");
	        }
	        else{
	            combo.addItem("None");
	            for (MenuItem m : menu) {
	                combo.addItem(m.getName());
	            }
	        }
	        return combo;
	    }

}
