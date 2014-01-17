/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.ArrayList;
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

    public TableHandler() {
    }

    /**
     * NÅR DER SKAL GØRES BRUG AF APPLYROWFILTER: table sættes til den ønsket
     * tablet der skal filteres. field sættes til textFieldet hvor teksten der
     * skal filteres efter skrives. VIGTIGT - Det er vigtigt at itemsne i
     * comboboxen står i samme rækkefølge som i tabellen dvs. Hvis tabellen
     * indeholder ID, Navn, Efternavn skal comboxens items have samme
     * rækkefølge!
     * **************************************************************************
     * applyRowFilter henter tabel data ud Opretter derefter en sorter med
     * tabelmodellen Sættes på den kaldte table og laver et RowFilter som bruges
     * til at sorter udfra hvad der står i textField og hvilket index der er
     * valgt i combox
     */
    /**
     * Filters the table to show only task with inserted field and filters tasks with
     * status "Afsluttet" away
     * @param table The targeted jTable
     * @param field The jTextField where the text that is going to filtered by
     * @param combobox It is important that the items in the combobox is in the
     * same order as      in the table. If the table contains ID, Name, Surname,
     * then the comboboxs items must      be in the same order!
     */
    public void applyRowFilter(JTable table, JTextField field, int selectedIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.regexFilter(field.getText(), selectedIndex));
        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));

        sorter.setRowFilter(RowFilter.andFilter(andFilters));
    }

    /**
     * Filters the table to show only task with inserted String str and filters tasks with
     * status "Afsluttet" away
     * @param table The targeted jTable
     * @param str The String str is the text that is going to filtered by
     * @param int It is important that the items in the combobox is in the
     * same order as in the table. If the table contains ID, Name, Surname,
     * then the comboboxs items must be in the same order!
     */
    public void applyRowFilter(JTable table, String str, int selectedIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.regexFilter(str, selectedIndex));
        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));


        sorter.setRowFilter(RowFilter.andFilter(andFilters));
    }

    /**
     * Filters all tasks that have the status "Afsluttet" away
     * @param table The targeted jTable
     */
    public void removeFinshedTaskFilter(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();

        andFilters.add(RowFilter.notFilter(RowFilter.regexFilter("Afsluttet", 4)));

        sorter.setRowFilter(RowFilter.andFilter(andFilters));
     }

}
