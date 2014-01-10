/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Task;

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
    public int customerid;


    public TaskHandlingPanel() throws ClassNotFoundException, SQLException, IOException {
        initComponents();

        modelOnTask = new DefaultListModel();
        listUsersOnTask.setModel(modelOnTask);

        Controller.fillCombobox(comboBoxProjectLeader, Controller.userList);
        Controller.fillCombobox(comboBoxType, Controller.typeList);
        Controller.fillCombobox(comboBoxStatus, Controller.statusList);
        Controller.fillList(listUsers, Controller.userList);
//        Controller.fillCombobox(comboBoxCustomer, Controller.customerList);
        Controller.fillTableWithTask(tableAllTasks);
        Controller.removeTableHeadersTask(tableAllTasks);
       // Controller.tHandler.removeFinshedTaskFilter(tableAllTasks);
        
        
         addActionListerner();
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
        jLabel31 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAllTasks = new javax.swing.JTable();
        buttonFilter = new javax.swing.JButton();
        textFieldSorting = new javax.swing.JTextField();
        comboboxSorting = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        buttonFindCustomer = new javax.swing.JButton();
        textFieldCustomer = new javax.swing.JTextField();

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

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Alle opgaver");

        tableAllTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ParentID", "TaskName", "Type", "Status", "Kunde", "User", "Start dato", "Slut dato", "Forventet tidsforbrug", "Prioritet", "Beskrivelse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAllTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAllTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllTasksMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableAllTasksMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableAllTasks);

        buttonFilter.setText("Test Filter");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        textFieldSorting.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSortingKeyReleased(evt);
            }
        });

        comboboxSorting.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "ParentID", "TaskName", "Type", "Status", "Kunde", "Bruger" }));

        textAreaDescription.setColumns(20);
        textAreaDescription.setRows(5);
        jScrollPane4.setViewportView(textAreaDescription);

        jButton2.setText("Test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonFindCustomer.setText("Find kunde");
        buttonFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(698, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(buttonEditTask)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(comboBoxProjectLeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboBoxPriority, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))
                                            .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buttonSaveChanges, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboBoxStatus, 0, 104, Short.MAX_VALUE)
                                            .addComponent(comboBoxType, 0, 104, Short.MAX_VALUE)
                                            .addComponent(textFieldTaskName, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                            .addComponent(textFieldCustomer))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
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
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(91, 91, 91))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(buttonFindCustomer))))
                            .addComponent(jScrollPane3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxSorting, 0, 125, Short.MAX_VALUE)
                                    .addComponent(textFieldSorting)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(buttonFilter))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(385, 385, 385))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboboxSorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonFilter)
                        .addGap(71, 71, 71)
                        .addComponent(jButton2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonFindCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                    .addComponent(textFieldCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
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
                                    .addComponent(textFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(comboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonEditTask)
                                    .addComponent(buttonSaveChanges)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddUserActionPerformed

        Controller.addUserToOnTaskList(listUsers, listUsersOnTask, buttonAddUser);

    }//GEN-LAST:event_buttonAddUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Controller.updateTableWithNewTasks(tableAllTasks);
            //Controller.fillTableWithTask(tableAllTasks);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveUserActionPerformed
        Controller.removeUserFromTaskList(listUsers, listUsersOnTask, buttonRemoveUser);
    }//GEN-LAST:event_buttonRemoveUserActionPerformed

    private void tableAllTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTasksMouseClicked


    }//GEN-LAST:event_tableAllTasksMouseClicked

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed

        Controller.tHandler.applyRowFilter(tableAllTasks, textFieldSorting, comboboxSorting.getSelectedIndex());

    }//GEN-LAST:event_buttonFilterActionPerformed

    private void buttonSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveChangesActionPerformed

        Controller.SaveChangesToTask(tableAllTasks,
                listUsers,
                listUsersOnTask,
                buttonSaveChanges,
                textFieldTaskName,
                comboBoxType,
                comboBoxStatus,
                comboBoxCustomer,
                comboBoxProjectLeader,
                dateChooserExpectedStart,
                dateChooserExpectedEnd,
                textFieldTime,
                comboBoxPriority,
                textAreaDescription);
        
        Controller.clearAll(textFieldTaskName,
                comboBoxType,
                comboBoxStatus,
                comboBoxCustomer,
                comboBoxProjectLeader,
                dateChooserExpectedStart,
                dateChooserExpectedEnd,
                textFieldTime,
                comboBoxPriority,
                listUsers,
                listUsersOnTask);


    }//GEN-LAST:event_buttonSaveChangesActionPerformed

    private void comboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCustomerActionPerformed

    private void tableAllTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTasksMouseReleased
        modelTable = (DefaultTableModel) tableAllTasks.getModel();
        try {

            
                     Controller.fillComponents(Integer.parseInt(modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0).toString()),
                        listUsers,
                        listUsersOnTask,
                        tableAllTasks,
                        textFieldTaskName,
                        comboBoxType,
                        comboBoxStatus,
                        comboBoxCustomer,
                        comboBoxProjectLeader,
                        dateChooserExpectedStart,
                        dateChooserExpectedEnd,
                        textFieldTime,
                        comboBoxPriority,
                        textAreaDescription);
                             
        } catch (SQLException | IOException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            try {
//                //  fillAllWithSelectedTask((Integer) modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0));
//                
//                
//                Controller.fillWithSelectedTask(listUsers,
//                        listUsersOnTask,
//                        tableAllTasks,
//                        textFieldTaskName,
//                        comboBoxType,
//                        comboBoxStatus,
//                        comboBoxCustomer,
//                        comboBoxProjectLeader,
//                        dateChooserExpectedStart,
//                        dateChooserExpectedEnd,
//                        textFieldTime,
//                        comboBoxPriority,
//                        textAreaDescription);
//            } catch (ParseException ex) {
//                Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IOException | SQLException ex) {
//            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableAllTasksMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                textFieldCustomer.setText(Controller.getCustomerIDToString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textFieldSortingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSortingKeyReleased
       
    }//GEN-LAST:event_textFieldSortingKeyReleased

    private void buttonFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindCustomerActionPerformed
              Controller.openCustomerLookUpFrame();
    }//GEN-LAST:event_buttonFindCustomerActionPerformed

    private void addActionListerner(){
        textFieldSorting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.tHandler.applyRowFilter(tableAllTasks, textFieldSorting, comboboxSorting.getSelectedIndex());
            }
        });
    }
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonEditTask;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JButton buttonFindCustomer;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listUsers;
    private javax.swing.JList listUsersOnTask;
    private javax.swing.JTable tableAllTasks;
    private javax.swing.JTextArea textAreaDescription;
    private javax.swing.JTextField textFieldCustomer;
    private javax.swing.JTextField textFieldSorting;
    private javax.swing.JTextField textFieldTaskName;
    private javax.swing.JTextField textFieldTime;
    // End of variables declaration//GEN-END:variables

   

}
