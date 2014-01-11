package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends javax.swing.JPanel {

    public Home() {
        initComponents();
        initiate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaAddComment = new javax.swing.JTextArea();
        comboBoxStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldMinutesSpent = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        labelTaskID = new javax.swing.JLabel();
        comboboxSortTaskAfterUser = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textFieldUser = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        labelSubtaskID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        comboBoxType = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableAllSubTasks = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAllTasks = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCustomer = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jLabel4.setText("Dagens opgaver:");

        jLabel5.setText("Delopgaver:");

        jLabel6.setText("Indrapportering for opgave med ID:");

        textAreaAddComment.setColumns(20);
        textAreaAddComment.setRows(5);
        jScrollPane4.setViewportView(textAreaAddComment);

        jLabel7.setText("Status:");

        jLabel8.setText("Tid brugt i minutter");

        jButton1.setText("Indrapporter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tilknyt kommentar:");

        labelTaskID.setText("             ");

        comboboxSortTaskAfterUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxSortTaskAfterUserItemStateChanged(evt);
            }
        });

        jLabel10.setText("Bruger:");

        textFieldUser.setEditable(false);

        jLabel11.setText("Delopgave ID:");

        labelSubtaskID.setText("              ");

        jLabel1.setText("Sorter efter bruger:");

        jButton2.setText("Sorter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Type:");

        tableAllSubTasks.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAllSubTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAllSubTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableAllSubTasksMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tableAllSubTasks);

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableAllTasksMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tableAllTasks);

        jLabel3.setText("Kunde:");

        jLabel14.setText("VÆLG OPGAVE EFTER ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(125, 125, 125))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10)
                                                .addGap(34, 34, 34))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelSubtaskID)
                                            .addComponent(labelTaskID)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel7)
                                                    .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldMinutesSpent, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(comboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(comboboxSortTaskAfterUser, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jButton2))))
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxSortTaskAfterUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelTaskID))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(labelSubtaskID))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldMinutesSpent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGap(5, 82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Controller.createNewTask(null, null, jButton1, null, textFieldUser, comboBoxType, comboBoxStatus, comboBoxStatus, comboBoxType, null, null, textFieldMinutesSpent, comboBoxStatus, textAreaAddComment);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableAllSubTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllSubTasksMouseReleased
        /*DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        try {
            try {
                //  fillAllWithSelectedTask((Integer) modelTable.getValueAt(tableAllTasks.getSelectedRow(), 0));
                Controller.fillWithSelectedTask(listUsers,
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
            } catch (ParseException ex) {
                Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_tableAllSubTasksMouseReleased

    private void tableAllTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTasksMouseReleased
        try {
            System.out.println("test " + Controller.getSelectedTaskId(tableAllTasks));
            Controller.fillTableWithList(tableAllSubTasks, Controller.getAllChildrenById(Controller.getSelectedTaskId(tableAllTasks)));
            
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableAllTasksMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Controller.tHandler.applyRowFilter(tableAllTasks, comboboxSortTaskAfterUser.getSelectedItem().toString(), 6);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboboxSortTaskAfterUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxSortTaskAfterUserItemStateChanged
        Controller.tHandler.applyRowFilter(tableAllTasks, comboboxSortTaskAfterUser.getSelectedItem().toString(), 6);
    }//GEN-LAST:event_comboboxSortTaskAfterUserItemStateChanged

    private void initiate(){
        try {
            Controller.setCurrentUserIDToTextField(textFieldUser);
            Controller.fillCombobox(comboBoxType, Controller.typeList);
            Controller.fillCombobox(comboBoxStatus, Controller.statusList); 
            System.out.println("TEST1");
            Controller.fillCombobox(comboBoxCustomer, Controller.customerList);
            System.out.println("TEST");
            System.out.println("userList size" + Controller.userList.size() + "TEST");
            Controller.fillCombobox(comboboxSortTaskAfterUser, Controller.userList);
            Controller.tHandler.removeFinshedTaskFilter(tableAllTasks);
            Controller.fillTableWithTask(tableAllTasks);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxCustomer;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboBoxType;
    private javax.swing.JComboBox comboboxSortTaskAfterUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelSubtaskID;
    private javax.swing.JLabel labelTaskID;
    private javax.swing.JTable tableAllSubTasks;
    private javax.swing.JTable tableAllTasks;
    private javax.swing.JTextArea textAreaAddComment;
    private javax.swing.JTextField textFieldMinutesSpent;
    private javax.swing.JTextField textFieldUser;
    // End of variables declaration//GEN-END:variables
}
