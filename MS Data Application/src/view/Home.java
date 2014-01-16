package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JPanel {

    private Controller control;
    
    public Home(Controller ctrl) {
        
        control = ctrl;
        
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
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaAddComment = new javax.swing.JTextArea();
        comboBoxStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldMinutesSpent = new javax.swing.JTextField();
        buttonInReport = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        labelTaskID = new javax.swing.JLabel();
        comboboxSortTaskAfterUser = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textFieldUser = new javax.swing.JTextField();
        labelSubtaskID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboBoxQuickTaskType = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableAllSubTasks = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAllTasks = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buttonInReportHeadtask = new javax.swing.JButton();
        buttonFindCustomer = new javax.swing.JButton();
        buttonGetCustomerID = new javax.swing.JButton();
        textFieldQuickTaskTimeSpent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textFieldQuickTaskCustomer = new javax.swing.JTextField();
        buttonCreateQuickTask = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaQuickTaskDescription = new javax.swing.JTextArea();

        jToggleButton1.setText("jToggleButton1");

        jLabel4.setText("Dagens opgaver:");

        jLabel5.setText("Delopgaver:");

        textAreaAddComment.setColumns(20);
        textAreaAddComment.setRows(5);
        jScrollPane4.setViewportView(textAreaAddComment);

        jLabel7.setText("Status:");

        jLabel8.setText("Tid brugt i minutter");

        buttonInReport.setText("Indrapporter");
        buttonInReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInReportActionPerformed(evt);
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

        labelSubtaskID.setText("              ");

        jLabel1.setText("Sorter efter bruger:");

        jLabel12.setText("Type:");

        tableAllSubTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ParentID", "Opgave navn", "Type", "Status", "Kunde", "Leder", "Start dato", "Slut dato", "Forventet tidsforbrug", "Prioritet", "Beskrivelse"
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
        tableAllSubTasks.getColumnModel().getColumn(0).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableAllSubTasks.getColumnModel().getColumn(1).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(1).setPreferredWidth(25);
        tableAllSubTasks.getColumnModel().getColumn(2).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(3).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(4).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(5).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(6).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(6).setPreferredWidth(25);
        tableAllSubTasks.getColumnModel().getColumn(7).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(8).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(9).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(10).setResizable(false);
        tableAllSubTasks.getColumnModel().getColumn(10).setPreferredWidth(20);
        tableAllSubTasks.getColumnModel().getColumn(11).setResizable(false);

        tableAllTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ParentID", "Opgave navn", "Type", "Status", "Kunde", "Leder", "Start dato", "Slut dato", "Forventet tidsforbrug", "Prioritet", "Beskrivelse"
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
        tableAllTasks.getColumnModel().getColumn(0).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableAllTasks.getColumnModel().getColumn(1).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(1).setPreferredWidth(25);
        tableAllTasks.getColumnModel().getColumn(2).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(3).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(4).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(5).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(6).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(6).setPreferredWidth(25);
        tableAllTasks.getColumnModel().getColumn(7).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(8).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(9).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(10).setResizable(false);
        tableAllTasks.getColumnModel().getColumn(10).setPreferredWidth(20);
        tableAllTasks.getColumnModel().getColumn(11).setResizable(false);

        jLabel3.setText("Kunde:");

        buttonInReportHeadtask.setText("Indrapporter hovedopgave");
        buttonInReportHeadtask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInReportHeadtaskActionPerformed(evt);
            }
        });

        buttonFindCustomer.setText("Find kunde");
        buttonFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindCustomerActionPerformed(evt);
            }
        });

        buttonGetCustomerID.setText("Hent kunde ID");
        buttonGetCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetCustomerIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Tid brugt");

        jLabel13.setText("Hurtig opgave");

        buttonCreateQuickTask.setText("Opret hurtig opgave");
        buttonCreateQuickTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateQuickTaskActionPerformed(evt);
            }
        });

        textAreaQuickTaskDescription.setColumns(20);
        textAreaQuickTaskDescription.setRows(5);
        jScrollPane1.setViewportView(textAreaQuickTaskDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(comboboxSortTaskAfterUser, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTaskID)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textFieldMinutesSpent, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelSubtaskID))))))
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonFindCustomer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonGetCustomerID))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(textFieldQuickTaskCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(comboBoxQuickTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(textFieldQuickTaskTimeSpent, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(235, 235, 235)
                                            .addComponent(jLabel7)
                                            .addGap(56, 56, 56))))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonCreateQuickTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buttonInReport, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buttonInReportHeadtask, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9))))
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
                        .addComponent(comboboxSortTaskAfterUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonInReport, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonInReportHeadtask, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(labelTaskID)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSubtaskID)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldMinutesSpent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonFindCustomer)
                                    .addComponent(buttonGetCustomerID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxQuickTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldQuickTaskTimeSpent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldQuickTaskCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(buttonCreateQuickTask, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInReportActionPerformed
        try {
            control.updateTimeSpentOnTask(tableAllSubTasks,
                    comboboxSortTaskAfterUser,
                    comboBoxStatus,
                    textFieldMinutesSpent,
                    textAreaAddComment);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonInReportActionPerformed

    private void tableAllSubTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllSubTasksMouseReleased
        DefaultTableModel modelTable = (DefaultTableModel) tableAllSubTasks.getModel();
        labelSubtaskID.setText(modelTable.getValueAt(tableAllSubTasks.convertRowIndexToModel(tableAllSubTasks.getSelectedRow()), 0).toString());
        control.fillHomeComponets(Integer.parseInt(labelSubtaskID.getText()), textFieldUser.getText(), textAreaAddComment, comboBoxStatus, textFieldMinutesSpent);
    }//GEN-LAST:event_tableAllSubTasksMouseReleased

    private void tableAllTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTasksMouseReleased
        try {
            control.fillTableWithList(tableAllSubTasks, control.getAllChildrenById(control.getSelectedTaskId(tableAllTasks)));

        } catch (IOException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelTable = (DefaultTableModel) tableAllTasks.getModel();
        labelTaskID.setText(modelTable.getValueAt(tableAllTasks.convertRowIndexToModel(tableAllTasks.getSelectedRow()), 0).toString());
        control.fillHomeComponets(Integer.parseInt(labelTaskID.getText()), modelTable.getValueAt(tableAllTasks.getSelectedRow(), 6).toString(), textAreaAddComment, comboBoxStatus, textFieldMinutesSpent);
    }//GEN-LAST:event_tableAllTasksMouseReleased

    private void comboboxSortTaskAfterUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxSortTaskAfterUserItemStateChanged
        Controller.tHandler.applyRowFilter(tableAllTasks, comboboxSortTaskAfterUser.getSelectedItem().toString(), 6);
        DefaultTableModel modelTable = (DefaultTableModel) tableAllSubTasks.getModel();
        modelTable.setRowCount(0);

        control.clearHomeComponents(textFieldMinutesSpent, textAreaAddComment, textFieldQuickTaskCustomer, textFieldQuickTaskTimeSpent, textAreaQuickTaskDescription);

        textFieldUser.setText(comboboxSortTaskAfterUser.getSelectedItem().toString());

    }//GEN-LAST:event_comboboxSortTaskAfterUserItemStateChanged

    private void buttonInReportHeadtaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInReportHeadtaskActionPerformed
        try {
            control.updateTimeSpentOnTask(tableAllTasks,
                    comboboxSortTaskAfterUser,
                    comboBoxStatus,
                    textFieldMinutesSpent,
                    textAreaAddComment);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonInReportHeadtaskActionPerformed

    private void buttonFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindCustomerActionPerformed
        control.openCustomerLookUpFrame();
    }//GEN-LAST:event_buttonFindCustomerActionPerformed

    private void buttonGetCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetCustomerIDActionPerformed
        textFieldQuickTaskCustomer.setText(control.getCustomerIDToString());
    }//GEN-LAST:event_buttonGetCustomerIDActionPerformed

    private void buttonCreateQuickTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateQuickTaskActionPerformed
        try {
            control.createQuickTask(textFieldQuickTaskCustomer,
                    comboBoxQuickTaskType,
                    comboboxSortTaskAfterUser,
                    textFieldQuickTaskTimeSpent,
                    textAreaQuickTaskDescription);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCreateQuickTaskActionPerformed

    private void initiate() {
        try {
            control.setCurrentUserIDToTextField(textFieldUser);
            control.fillCombobox(comboBoxQuickTaskType, Controller.typeList);
            control.fillCombobox(comboBoxStatus, Controller.statusList);
            control.fillCombobox(comboboxSortTaskAfterUser, Controller.userList);
            control.setComboboxCurrentUser(comboboxSortTaskAfterUser);
            control.fillTableWithTask(tableAllTasks);
            //Controller.tHandler.removeFinshedTaskFilter(tableAllTasks);
            Controller.tHandler.applyRowFilter(tableAllTasks, textFieldUser.getText(), 6);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreateQuickTask;
    private javax.swing.JButton buttonFindCustomer;
    private javax.swing.JButton buttonGetCustomerID;
    private javax.swing.JButton buttonInReport;
    private javax.swing.JButton buttonInReportHeadtask;
    private javax.swing.JComboBox comboBoxQuickTaskType;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboboxSortTaskAfterUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelSubtaskID;
    private javax.swing.JLabel labelTaskID;
    private javax.swing.JTable tableAllSubTasks;
    private javax.swing.JTable tableAllTasks;
    private javax.swing.JTextArea textAreaAddComment;
    private javax.swing.JTextArea textAreaQuickTaskDescription;
    private javax.swing.JTextField textFieldMinutesSpent;
    private javax.swing.JTextField textFieldQuickTaskCustomer;
    private javax.swing.JTextField textFieldQuickTaskTimeSpent;
    private javax.swing.JTextField textFieldUser;
    // End of variables declaration//GEN-END:variables
}
