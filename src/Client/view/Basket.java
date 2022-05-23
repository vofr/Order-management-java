package Client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Admin.view.DailyMenuView;
import Admin.view.ReportsView;
import business.MenuItem;
import data.Serializator;
import gui_pack.MenuTable;
import gui_pack.StartGui;
import gui_pack.SuccesWindow;

public class Basket {
private int totalPrice;
private int priceToDelete=0;
private String aux;
	public Basket(List<MenuItem> basket){
	    
		JFrame f= new JFrame("Your Basket");
	    //display + scrollf
        MenuTable  table= new MenuTable(basket);

        table.productsTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table.productsTable);
        scrollPane.setBounds(30,2,700,200);
        f.add(scrollPane);
	    
        int totalPrice = 0;
        for(MenuItem m : basket) totalPrice += m.getPrice();
	    
        JLabel totalPriceLabel = new JLabel("Total price: " + totalPrice);
        totalPriceLabel.setBounds(650, 250, 600, 30);
        f.add(totalPriceLabel);
	    f.setLayout(null);  
	    f.setVisible(true); 
	    f.setSize(780,350);
	    f.setLocationRelativeTo(null);
	    
        final int[] row = new int[1];

        table.productsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                row[0] = table.productsTable.getSelectedRow();
                aux=((String) table.productsTable.getValueAt(row[0], 6));
                System.out.println("stergem suma de aux"+aux);
                priceToDelete=parseInt(aux);
                System.out.println("stergem suma de price delk"+priceToDelete);
            }

			private int parseInt(String str) {
					int i;
					int x=0,y=0;
					for(i=0;i<str.length();i++) {
						x=x+str.charAt(i)-48;
					    x=x*10;
					}
					x/=10;
					return x;
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
	    JButton del = new JButton("Delete one");
	    del.setBounds(30, 240, 150, 50);
	    f.add(del);
	    
	    del.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int temp=0;
	           basket.remove(row[0]);;
	            ((DefaultTableModel)table.productsTable.getModel()).removeRow(row[0]);
	            //table = new MenuTable(basket);
	            for(MenuItem m : basket) temp += m.getPrice();
	            setTotalPrice(temp);
	            totalPriceLabel.setText((String)("Total price: " + getTotalPrice()));
	            SuccesWindow view = new SuccesWindow();
	    	}
	    });
    
	}

	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
}
