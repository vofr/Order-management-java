package Admin.view;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import data.Serializator;
import gui_pack.StartGui;
import model.Client;

public class ReportsView {
public ReportsView(JFrame f,DeliveryService ds){
	
	//name colt dreapta sus +buton reintoarcere stanga sus
    JLabel l = new JLabel("Admin ");
    l.setFont(new Font("Serif", Font.BOLD, 15));
    l.setBounds(700,10, 60,30);  
    JButton ret = new JButton("BACK");
    ret.setBounds(10, 10, 70, 35);   
    f.add(l); f.add(ret);
    

    JButton generateButt = new JButton("Click here to GENERATE");
    generateButt.setBounds(300, 450, 200, 50);
    f.add(generateButt);

    JLabel l1 = new JLabel("Start hour: ");
    l1.setBounds(250, 60, 300, 30);
    JTextField tf1 = new JTextField(300);
    tf1.setBounds(250, 90, 300, 30);
    JLabel l2 = new JLabel("End hour: ");
    l2.setBounds(250, 120, 300, 30);
    JTextField tf2 = new JTextField(300);
    tf2.setBounds(250, 150, 300, 30);
    JLabel l3 = new JLabel("Number for products report: ");
    l3.setBounds(250, 180, 300, 30);
    JTextField tf3 = new JTextField(300);
    tf3.setBounds(250, 210, 300, 30);
    JLabel l4 = new JLabel("Number for clients report: ");
    l4.setBounds(250, 240, 300, 30);
    JTextField tf4 = new JTextField(300);
    tf4.setBounds(250, 270, 300, 30);
    JLabel l5 = new JLabel("Minim value of the order: ");
    l5.setBounds(250, 300, 300, 30);
    JTextField tf5 = new JTextField(300);
    tf5.setBounds(250, 330, 300, 30);
    JLabel l6 = new JLabel("The day for the products report: ");
    l6.setBounds(250, 360, 300, 30);
    JTextField tf6 = new JTextField(300);
    tf6.setBounds(250, 390, 300, 30);

    f.add(l1);
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(l5);
    f.add(l6);
    f.add(tf1);
    f.add(tf2);
    f.add(tf3);
    f.add(tf4);
    f.add(tf5);
    f.add(tf6);
    
    
    ret.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	f.getContentPane().removeAll();
        	f.getContentPane().repaint();
        	AdminView start = new AdminView(f);
        }
    });	
    generateButt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            FileWriter fileWriter;

            try {
                fileWriter = new FileWriter("Raport.txt");

                fileWriter.write("GENERATED REPORTS\n");

                fileWriter.write("-> The orders performed between given start hour " + tf1.getText() + " and given end hour " + tf2.getText() + " : ");
                StringBuilder stringBuilder = new StringBuilder();

                List<Order> orderList = new ArrayList<>();
                ds.ordersInfo = Serializator.OrderDeserializator("Orders.csv");
                ds.ordersInfo.forEach((key, value) -> orderList.add(key));
                orderList.stream().filter(order -> order.getDate().getHour() >= Integer.parseInt(tf1.getText()) && order.getDate().getHour() <= Integer.parseInt(tf2.getText())).forEach(order -> stringBuilder.append(order.getOrderId()).append(", "));
                fileWriter.write(stringBuilder.toString());


                fileWriter.write("\n-> The products ordered more than " + tf3.getText() + " times so far : ");
                StringBuilder stringBuilder2 = new StringBuilder();

                List<MenuItem> menuItemsFromOrders = new ArrayList<>();
                ds.ordersInfo.forEach((key, value) -> menuItemsFromOrders.addAll(value));
                menuItemsFromOrders.forEach(MenuItem::setOrderedTimes);
                menuItemsFromOrders.stream().filter(menuItem -> menuItem.getOrderedTimes() >= Integer.parseInt(tf3.getText())).forEach(menuItem -> stringBuilder2.append(menuItem.getName()).append(", "));
                fileWriter.write(stringBuilder2.toString());


                fileWriter.write("\n-> The clients that have ordered more than " + tf4.getText() + " times and the value of the order was higher than " + tf5.getText() + " : ");
                StringBuilder stringBuilder3 = new StringBuilder();

                List<Client> accountsList = Serializator.ClientDeserializator("ClientsData.csv");
                accountsList.stream().filter(account -> account.getNrOrders() > Integer.parseInt(tf4.getText())).forEach(account -> stringBuilder3.append(account.getUsername()).append(", "));
                fileWriter.write(stringBuilder3.toString());

                fileWriter.write("\n-> The products ordered within " + tf6.getText() + " : ");
                StringBuilder stringBuilder4 = new StringBuilder();

                menuItemsFromOrders.clear();

                for (Map.Entry<Order, List<MenuItem>> entry : ds.ordersInfo.entrySet()) {
                   if(entry.getKey().getDate().getDayOfWeek().toString().equals(tf1.getText().toUpperCase(Locale.ROOT))){
                       menuItemsFromOrders.add((MenuItem) entry.getValue());
                   }
                }

                menuItemsFromOrders.stream().distinct().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparing(MenuItem::getName))), ArrayList::new)).forEach(menuItem -> stringBuilder4.append(menuItem.getName()).append(", "));
                fileWriter.write(stringBuilder4.toString());

                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });	
}
}
