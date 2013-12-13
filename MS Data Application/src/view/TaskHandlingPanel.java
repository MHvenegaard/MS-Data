/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Customer;
import model.Statuss;
import model.Task;
import model.Type;
import model.User;

/**
 *
 * @author Mikkel
 */
public class TaskHandlingPanel extends javax.swing.JPanel {

    /**
     * Creates new form TaskHandlingPanel
     */
    private DefaultListModel model;
    private DefaultListModel modelOnTask;
    private DefaultTableModel modelTable;
//    private final ArrayList<User> userList;
//    private final ArrayList<Type> typeList;
    private final ArrayList<Customer> customerList;
//    private final ArrayList<Statuss> statusList;
    private ArrayList<User> userOnTaskList;

    public TaskHandlingPanel() throws ClassNotFoundException, SQLException, IOException {
        initComponents();

        modelOnTask = new DefaultListModel();
        listUsersOnTask.setModel(modelOnTask);

        customerList = Controller.dbHandler.SPgetCustomers();

        Controller.fillCombobox(comboBoxProjectLeader, Controller.userList);
        Controller.fillCombobox(comboBoxType, Controller.typeList);
        Controller.fillCombobox(comboBoxStatus, Controller.statusList);
        Controller.fillList(listUsers, Controller.userList);

        fillCustomerCombo();
        fillTableWithTask();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxStatus = new javax.swing.JComboBox();
        textFieldTaskName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRemoveUser = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCustomer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUsers = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsersOnTask = new javax.swing.JList();
        buttonAddUser = new javax.swing.JButton();
        comboBoxProjectLeader = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboBoxPriority = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboBoxType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonEditTask = new javax.swing.JButton();
        buttonSaveChanges = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dateChooserExpectedStart = new com.toedter.calendar.JDateChooser();
        dateChooserExpectedEnd = new com.toedter.calendar.JDateChooser();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAllTasks = new javax.swing.JTable();
        buttonFilter = new javax.swing.JButton();
        textFieldSorting = new javax.swing.JTextField();
        comboboxSorting = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(1280, 775));
        setPreferredSize(new java.awt.Dimension(1280, 775));

        jLabel9.setText("timer");

        jLabel5.setText("Projektleder");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ansatte");

        jLabel3.setText("Status");

        jLabel4.setText("Kunde");

        buttonRemoveUser.setText("Fjern medarbejder");
        buttonRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveUserActionPerformed(evt);
            }
        });

        jLabel6.setText("Forventet start");

        comboBoxCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCustomerActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listUsers);

        jLabel7.setText("Forventet færdigt");

        jScrollPane2.setViewportView(listUsersOnTask);

        buttonAddUser.setText("Tilføj medarbejder");
        buttonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Type");

        comboBoxPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        jLabel10.setText("Prioritet");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ansatte på projektet");

        jLabel1.setText("Projekt navn");

        jLabel8.setText("Forventet tidsforbrug");

        buttonEditTask.setText("Rediger opgave ");

        buttonSaveChanges.setText("Gem ændringer");
        buttonSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveChangesActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Delopgave 1", "Delopgave 2", "Delopgave 3", "Delopgave 4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList2);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Delopgaver");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Alle opgaver");

        tableAllTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TaskName", "Type", "Status", "Kunde", "User", "Start dato", "Slut dato", "Forventet tidsforbrug", "Prioritet", "Beskrivelse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAllTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllTasksMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAllTasks);

        buttonFilter.setText("Test Filter");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        comboboxSorting.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "TaskName", "Type", "Status", "Kunde", "Bruger" }));

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        jScrollPane4.setViewportView(textAreaDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(buttonEditTask)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxProjectLeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxPriority, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldTaskName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonSaveChanges, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buttonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buttonRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(146, 146, 146)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxSorting, 0, 125, Short.MAX_VALUE)
                                    .addComponent(buttonFilter)
                                    .addComponent(textFieldSorting))
                                .addGap(141, 141, 141)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jButton1)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboboxSorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFilter))
                    .addComponent(jScrollPane8))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textFieldTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxProjectLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(textFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(buttonAddUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonRemoveUser))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditTask)
                    .addComponent(buttonSaveChanges))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddUserActionPerformed
        int index = listUsers.getSelectedIndex();

        model = (DefaultListModel) listUsers.getModel();
        modelOnTask = (DefaultListModel) listUsersOnTask.getModel();
        if (index != -1) {
            modelOnTask.addElement(listUsers.getSelectedValue());
            model.removeElement(listUsers.getSelectedValue());

        } else {
            JOptionPane.showMessageDialog(this, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonAddUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        model = (DefaultListModel) listUsers.getModel();

        for (int i = 0; i < userOnTaskList.size(); i++) {
            //  modelOnTask.addElement(Controller.userList.get(i));
            System.out.println(modelOnTask.get(i).toString() + " er lige med : " + Controller.userList.get(i).getUserName().toString());
            if (modelOnTask.get(i).toString().equals(Controller.userList.get(i).getUserName().toString())) {
                System.out.println("Fjerner : " + Controller.userList.get(i));
                model.removeElement(model.get(i));

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveUserActionPerformed
        int index = listUsersOnTask.getSelectedIndex();

        model = (DefaultListModel) listUsers.getModel();
        modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        if (index != -1) {
            for (int i = 0; i < model.size(); i++) {
                if (model.get(i).toString().equals(listUsersOnTask.getSelectedValue().toString())) {
                    System.out.println("Fjerner " + listUsersOnTask.getSelectedValue());
                    model.removeElement(listUsersOnTask.getSelectedValue());
                }
            }
            model.addElement(listUsersOnTask.getSelectedValue());
            modelOnTask.removeElement(listUsersOnTask.getSelectedValue());

        } else {
            JOptionPane.showMessageDialog(this, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_buttonRemoveUserActionPerformed

    private void tableAllTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTasksMouseClicked
        modelTable = (DefaultTableModel) tableAllTasks.getModel();
        try {
            try {
                fillAllWithSelectedTask((Integer) modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0));
            } catch (ParseException ex) {
                Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tableAllTasksMouseClicked

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed

        Controller.tHandler.applyRowFilter(tableAllTasks, textFieldSorting, comboboxSorting.getSelectedIndex());

    }//GEN-LAST:event_buttonFilterActionPerformed

    private void buttonSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveChangesActionPerformed
        modelTable = (DefaultTableModel) tableAllTasks.getModel();
        Type type = new Type(comboBoxType.getSelectedItem().toString());
        Statuss status = new Statuss(comboBoxStatus.getSelectedItem().toString());
        Customer customer = new Customer(comboBoxCustomer.getSelectedItem().toString());
        User user = new User(comboBoxProjectLeader.getSelectedItem().toString());

        Task task = new Task(Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0).toString()),
                textFieldTaskName.getText(),
                type,
                status,
                customer,
                user,
                dateChooserExpectedStart.getDate(),
                dateChooserExpectedEnd.getDate(),
                Integer.parseInt(textFieldTime.getText()),
                Integer.parseInt(comboBoxPriority.getSelectedItem().toString()),
                textAreaDescription.getText());
        try {
            Controller.dbHandler.SPremoveAllUsersOnTask(task.getTaskID());
            Controller.dbHandler.updateTask(task);

            Controller.dbHandler.addUserToAlreadyMadeTask(listUsersOnTask, task.getTaskID());

            Controller.fillList(listUsers, Controller.userList);
            fillTableWithTask();
        } catch (SQLException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSaveChangesActionPerformed

    private void comboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCustomerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonEditTask;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JButton buttonRemoveUser;
    private javax.swing.JButton buttonSaveChanges;
    private javax.swing.JComboBox comboBoxCustomer;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboBoxProjectLeader;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboBoxType;
    private javax.swing.JComboBox comboboxSorting;
    private com.toedter.calendar.JDateChooser dateChooserExpectedEnd;
    private com.toedter.calendar.JDateChooser dateChooserExpectedStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList listUsers;
    private javax.swing.JList listUsersOnTask;
    private javax.swing.JTable tableAllTasks;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextField textFieldSorting;
    private javax.swing.JTextField textFieldTaskName;
    private javax.swing.JTextField textFieldTime;
    // End of variables declaration//GEN-END:variables

    private void fillTableWithTask() throws IOException, SQLException {
        modelTable = (DefaultTableModel) tableAllTasks.getModel();
        ArrayList<Task> tasks = Controller.dbHandler.SPgetTasks();
        modelTable.setRowCount(0);
        for (int i = 0; i < tasks.size(); i++) {
            Object[] data = {tasks.get(i).getTaskID(),
                tasks.get(i).getTaskName(),
                tasks.get(i).getType(),
                tasks.get(i).getStatus(),
                tasks.get(i).getCustomer(),
                tasks.get(i).getUser(),
                tasks.get(i).getStartDate(),
                tasks.get(i).getEndDate(),
                tasks.get(i).getEstimatedtime(),
                tasks.get(i).getPriority(),
                tasks.get(i).getDescription()};
            modelTable.addRow(data);
        }
    }

    private void fillAllWithSelectedTask(int taskID) throws IOException, SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model = (DefaultListModel) listUsers.getModel();
        textFieldTaskName.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 1).toString());
        comboBoxCustomer.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 4).toString());
        comboBoxPriority.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 9).toString());
        comboBoxProjectLeader.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 5).toString());
        comboBoxStatus.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 3).toString());
        comboBoxType.setSelectedItem(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 2).toString());
        textFieldTime.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 8).toString());

        Date startDate = sdf.parse(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 6).toString());
        dateChooserExpectedStart.setDate(startDate);
        Date endDate = sdf.parse(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 7).toString());
        dateChooserExpectedEnd.setDate(endDate);

        textAreaDescription.setText(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 10).toString());

        modelOnTask.clear();
        model.clear();
        Controller.fillList(listUsers, Controller.userList);

        userOnTaskList = Controller.dbHandler.SPgetUserOnTask(taskID);

        model = (DefaultListModel) listUsers.getModel();
        modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        for (int i = 0; i < userOnTaskList.size(); i++) {
            modelOnTask.addElement(Controller.userList.get(i));
            System.out.println(modelOnTask.get(i).toString() + " er lige med : " + Controller.userList.get(i).getUserName().toString());
            if (modelOnTask.get(i).toString().equals(Controller.userList.get(i).getUserName().toString())) {
                System.out.println("Fjerner : " + Controller.userList.get(i));
                model.removeElement(Controller.userList.get(i));
            }
        }
    }

    private void fillCustomerCombo() throws SQLException, IOException {
        comboBoxCustomer.setSelectedIndex(-1);
        comboBoxCustomer.removeAllItems();
        comboBoxCustomer.addItem("Vælg kunde");

        for (int i = 0; i < customerList.size(); i++) {
            comboBoxCustomer.addItem(customerList.get(i).toString());
        }
        comboBoxCustomer.setSelectedIndex(0);
    }
}
