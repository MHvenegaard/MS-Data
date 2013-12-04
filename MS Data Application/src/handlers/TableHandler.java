/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handlers;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mikkel
 */
public class TableHandler {
    
    private JTable table;

    public TableHandler() {
        this.table = table;
    }
    
    
    public void applyRowFilter(JTable table,JTextField field, JComboBox combobox){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        RowFilter<TableModel, Object> rf = null;
        
        rf = RowFilter.regexFilter(field.getText(), combobox.getSelectedIndex());
        sorter.setRowFilter(rf);
    }        

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
       
    
    
}
