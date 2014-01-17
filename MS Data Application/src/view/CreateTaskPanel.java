package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @author Marc Hvenegaard, Mikkel Bloch & Nikolaj Nielsen
 * @version 1.4
 */
public class CreateTaskPanel extends javax.swing.JPanel {

    private Controller control;

    public CreateTaskPanel(Controller ctrl) throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        control = ctrl;

        DefaultListModel modelOnTask = new DefaultListModel();
        listUsersOnTask.setModel(modelOnTask);

        control.fillCombobox(comboBoxUser, Controller.userList);
        control.fillCombobox(comboBoxType, Controller.typeList);
        control.fillCombobox(comboBoxStatus, Controller.statusList);
        control.fillList(listUsers, Controller.userList);
        control.fillTableUsingTaskList(tableAllTask);
        control.removeTableHeadersTask(tableAllTask);
        control.tHandler.removeFinshedTaskFilter(tableAllTask);
        try {
            dateChooserExpectedStart.setDate(control.getCurrentDate());
            dateChooserExpectedEnd.setDate(control.getCurrentDate());
        } catch (ParseException ex) {
            Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboBoxType = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRemoveUser = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaBeskrivelse = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        comboBoxPriority = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textFieldEstimatedTime = new javax.swing.JTextField();
        textFieldTaskName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUsers = new javax.swing.JList();
        comboBoxUser = new javax.swing.JComboBox();
        buttonAddUser = new javax.swing.JButton();
        buttonCreateTask = new javax.swing.JButton();
        dateChooserExpectedStart = new com.toedter.calendar.JDateChooser();
        dateChooserExpectedEnd = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAllTask = new javax.swing.JTable();
        CheckBoxSub = new javax.swing.JCheckBox();
        buttonUpdateTable = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsersOnTask = new javax.swing.JList();
        textFieldCustomer = new javax.swing.JTextField();
        buttonFindCustomer = new javax.swing.JButton();
        buttonGetCustomerID = new javax.swing.JButton();

        jLabel1.setText("Projekt navn");

        jLabel8.setText("Forventet tidsforbrug");

        jLabel7.setText("Forventet færdigt");

        jLabel4.setText("Kunde");

        buttonRemoveUser.setText("Fjern medarbejder");
        buttonRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveUserActionPerformed(evt);
            }
        });

        jLabel13.setText("Beskrivelse af projekt");

        jLabel3.setText("Status");

        jLabel9.setText("timer");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ansatte");

        textAreaBeskrivelse.setColumns(20);
        textAreaBeskrivelse.setRows(5);
        textAreaBeskrivelse.setText("Memo122\n");
        jScrollPane3.setViewportView(textAreaBeskrivelse);

        jLabel2.setText("Type");

        comboBoxPriority.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        comboBoxPriority.setToolTipText("");

        jLabel10.setText("Prioritet");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ansatte på projektet");

        textFieldTaskName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTaskNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Projektleder");

        jLabel6.setText("Forventet start");

        listUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listUsers.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(listUsers);

        buttonAddUser.setText("Tilføj medarbejder");
        buttonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddUserActionPerformed(evt);
            }
        });

        buttonCreateTask.setText("Opret opgave");
        buttonCreateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateTaskActionPerformed(evt);
            }
        });

        tableAllTask.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAllTask.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAllTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllTaskMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableAllTask);
        tableAllTask.getColumnModel().getColumn(0).setResizable(false);
        tableAllTask.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableAllTask.getColumnModel().getColumn(1).setResizable(false);
        tableAllTask.getColumnModel().getColumn(1).setPreferredWidth(40);
        tableAllTask.getColumnModel().getColumn(2).setResizable(false);
        tableAllTask.getColumnModel().getColumn(3).setResizable(false);
        tableAllTask.getColumnModel().getColumn(4).setResizable(false);
        tableAllTask.getColumnModel().getColumn(5).setResizable(false);
        tableAllTask.getColumnModel().getColumn(6).setResizable(false);
        tableAllTask.getColumnModel().getColumn(6).setPreferredWidth(40);
        tableAllTask.getColumnModel().getColumn(7).setResizable(false);
        tableAllTask.getColumnModel().getColumn(8).setResizable(false);
        tableAllTask.getColumnModel().getColumn(9).setResizable(false);
        tableAllTask.getColumnModel().getColumn(10).setResizable(false);
        tableAllTask.getColumnModel().getColumn(10).setPreferredWidth(20);
        tableAllTask.getColumnModel().getColumn(11).setResizable(false);

        CheckBoxSub.setText("Opret opgaven som delopgave");
        CheckBoxSub.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CheckBoxSubStateChanged(evt);
            }
        });

        buttonUpdateTable.setText("Update");
        buttonUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateTableActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listUsersOnTask);

        buttonFindCustomer.setText("Hent kunde");
        buttonFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindCustomerActionPerformed(evt);
            }
        });

        buttonGetCustomerID.setText("Set kundeID");
        buttonGetCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetCustomerIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldCustomer)
                                            .addComponent(comboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxUser, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textFieldEstimatedTime)
                                            .addComponent(comboBoxPriority, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textFieldTaskName, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonFindCustomer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(buttonGetCustomerID)
                                                .addGap(18, 18, 18))))))
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CheckBoxSub, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonCreateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonUpdateTable)
                        .addGap(394, 394, 394))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckBoxSub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(textFieldCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonFindCustomer)
                            .addComponent(buttonGetCustomerID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(textFieldEstimatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(buttonUpdateTable)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(buttonAddUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonRemoveUser))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(buttonCreateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddUserActionPerformed

        control.addUserToOnTaskList(listUsers, listUsersOnTask);

    }//GEN-LAST:event_buttonAddUserActionPerformed

    private void buttonCreateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateTaskActionPerformed
        try {
            control.createNewTask(tableAllTask,
                    listUsersOnTask,
                    CheckBoxSub,
                    textFieldTaskName,
                    comboBoxType,
                    comboBoxStatus,
                    textFieldCustomer,
                    comboBoxUser,
                    dateChooserExpectedStart,
                    dateChooserExpectedEnd,
                    textFieldEstimatedTime,
                    comboBoxPriority,
                    textAreaBeskrivelse);

            control.createNewTimeSpentOnTask(comboBoxUser);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Det er ikke muligt at omforme "+ex, "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Der kunne ikke hentes data fra databasen?", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Kunne ikke skabe forbindelse til serveren", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonCreateTaskActionPerformed

    private void buttonRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveUserActionPerformed

        control.removeUserFromTaskList(listUsers, listUsersOnTask);

    }//GEN-LAST:event_buttonRemoveUserActionPerformed

    private void textFieldTaskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTaskNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTaskNameActionPerformed

    private void tableAllTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTaskMouseClicked
    }//GEN-LAST:event_tableAllTaskMouseClicked

    private void buttonUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateTableActionPerformed
        try {
            control.updateTableWithNewTasks(tableAllTask);
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Der kunne ikke hentes data fra databasen?", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Der er opstået en fejl ! Kunne ikke skabe forbindelse til serveren", "Fejlrapport", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonUpdateTableActionPerformed

    private void buttonFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindCustomerActionPerformed
        control.openCustomerLookUpFrame();
    }//GEN-LAST:event_buttonFindCustomerActionPerformed

    private void buttonGetCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetCustomerIDActionPerformed
        if (!textFieldCustomer.isEditable()) {
            System.out.println("Du kan ikke hente kunder ud når du laver en delopgave");
        } else {
            textFieldCustomer.setText(control.getCustomerIDToString());
        }
    }//GEN-LAST:event_buttonGetCustomerIDActionPerformed

    private void CheckBoxSubStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CheckBoxSubStateChanged
        if (CheckBoxSub.isSelected()) {
            textFieldCustomer.setEditable(false);
        } else {
            textFieldCustomer.setEditable(true);
        }


    }//GEN-LAST:event_CheckBoxSubStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxSub;
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonCreateTask;
    private javax.swing.JButton buttonFindCustomer;
    private javax.swing.JButton buttonGetCustomerID;
    private javax.swing.JButton buttonRemoveUser;
    private javax.swing.JButton buttonUpdateTable;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboBoxType;
    private javax.swing.JComboBox comboBoxUser;
    private com.toedter.calendar.JDateChooser dateChooserExpectedEnd;
    private com.toedter.calendar.JDateChooser dateChooserExpectedStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTable tableAllTask;
    private javax.swing.JTextArea textAreaBeskrivelse;
    private javax.swing.JTextField textFieldCustomer;
    private javax.swing.JTextField textFieldEstimatedTime;
    private javax.swing.JTextField textFieldTaskName;
    // End of variables declaration//GEN-END:variables
}
