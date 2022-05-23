package gui_pack;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import business.MenuItem;

public class MenuTable {

    public JTable productsTable;
    public TableRowSorter<TableModel> sorter;

    public MenuTable(List<MenuItem> menu){
        productsTable = createMenuTable(menu);
        sorter = new TableRowSorter<>(productsTable.getModel());
        productsTable.setRowSorter(sorter);
    }

    public void refreshTable(List<MenuItem> menu) {
        this.productsTable = createMenuTable(menu);
    }

    public static JTable createMenuTable(List<MenuItem> menu){
        String[] columnNames = {"TITLE",
                "RATING",
                "CALORIES",
                "PROTEIN",
                "FAT",
                "SODIUM",
                "PRICE"};
        String[][] data = new String[menu.size()][7];
        int i = 0;
        try{
            for (MenuItem m : menu) {
                data[i][0] = m.getName();
                data[i][1] = Float.toString(m.getRating());
                data[i][2] = Integer.toString(m.getCalories());
                data[i][3] = Integer.toString(m.getProtein());
                data[i][4] = Integer.toString(m.getFat());
                data[i][5] = Integer.toString(m.getSodium());
                data[i][6] = Integer.toString(m.getPrice());
                i++;
            }
            DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
            JTable table = new JTable(tableModel);
            table.setPreferredScrollableViewportSize(new Dimension(700, 200));
            table.setRowSelectionAllowed(true);
            return table;
        }
        catch (Exception ex){
            data[i][2] = data[i][3] = data[i][4] = data[i][5] = " ";
            return null;
        }
    }
    public static void Filter(TableRowSorter<TableModel> sorter, String filter,int indice){
        RowFilter<TableModel, Object> aux;
        try{         
            aux = RowFilter.regexFilter("(?i)" + filter,indice);
        }catch(PatternSyntaxException e){
            return;
        }
        sorter.setRowFilter(aux);
    }
  
    

	public void addMouseListener(MouseListener mouseListener) {
		// TODO Auto-generated method stub
		
	}
}