/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Statuss;
import model.Task;
import model.Type;
import model.User;

/**
 *
 * @author Nikolaj Nielsen
 */
public class CreateTaskPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateTaskPanel
     */
    private DefaultListModel model;
    private DefaultListModel modelOnTask;
    private DefaultTableModel modelTable;

    public CreateTaskPanel() throws ClassNotFoundException, SQLException, IOException {
        initComponents();

        modelOnTask = new DefaultListModel();
        listUsersOnTask.setModel(modelOnTask);
        
        fillCustomerCombo();
        fillTypeCombo();

        Controller.fillCombobox(comboBoxUser, Controller.userList);
        Controller.fillCombobox(comboBoxType, Controller.typeList);
        Controller.fillCombobox(comboBoxStatus, Controller.statusList);
        Controller.fillList(listUsers, Controller.userList);

        fillTableWithTasks();


    }

    private void fillCustomerCombo() throws SQLException, IOException {

        comboBoxCustomer.setSelectedIndex(-1);
        comboBoxCustomer.removeAllItems();
        comboBoxCustomer.addItem("Vælg kunde");

        ArrayList<Customer> customers = Controller.dbHandler.SPgetCustomers();
        for (int i = 0; i < customers.size(); i++) {
            comboBoxCustomer.addItem(customers.get(i));
        }
        comboBoxCustomer.setSelectedIndex(0);
    }

    private void fillTypeCombo() throws SQLException, IOException {

        comboBoxType.setSelectedIndex(-1);
        comboBoxType.removeAllItems();
        comboBoxType.addItem("Vælg type");

        ArrayList<Type> typesList = Controller.dbHandler.SPgetTypes();
        for (int i = 0; i < typesList.size(); i++) {
            comboBoxType.addItem(typesList.get(i));
        }
        comboBoxType.setSelectedIndex(0);
    }

    private void fillUserCombo() throws SQLException, IOException {

        comboBoxUser.setSelectedIndex(-1);
        comboBoxUser.removeAllItems();
        comboBoxUser.addItem("Vælg projektleder");

        //  ArrayList<User> userList = Controller.dbHandler.SPgetUsers();
        for (int i = 0; i < Controller.userList.size(); i++) {
            comboBoxUser.addItem(Controller.userList.get(i));
        }
        comboBoxUser.setSelectedIndex(0);
    }

    private void fillStatusCombo() throws SQLException, IOException {

        comboBoxStatus.setSelectedIndex(-1);
        comboBoxStatus.removeAllItems();
        comboBoxStatus.addItem("Vælg status");

        ArrayList<Statuss> statusList = Controller.dbHandler.SPgetStatus();
        for (int i = 0; i < statusList.size(); i++) {
            comboBoxStatus.addItem(statusList.get(i));
        }
        comboBoxStatus.setSelectedIndex(0);
    }

    private void fillUserList() throws SQLException, IOException {
        //Flyt dette

        model = new DefaultListModel();

        listUsers.setModel(model);
        ArrayList<User> userList = Controller.dbHandler.SPgetUsers();

        for (int i = 0; i < userList.size(); i++) {
            model.addElement(userList.get(i));
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
        comboBoxCustomer = new javax.swing.JComboBox();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listUsersOnTask = new javax.swing.JList();
        jButton9 = new javax.swing.JButton();
        dateChooserExpectedStart = new com.toedter.calendar.JDateChooser();
        dateChooserExpectedEnd = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAllTask = new javax.swing.JTable();
        CheckBoxSub = new javax.swing.JCheckBox();

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

        listUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listUsers.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(listUsers);

        buttonAddUser.setText("Tilføj medarbejder");
        buttonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddUserActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listUsersOnTask);

        jButton9.setText("Opret opgave");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        tableAllTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TaskName", "Kunde", "Type", "Status", "User", "Forventet tidsforbrug", "Prioritet", "Start dato", "Slut dato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAllTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAllTaskMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableAllTask);

        CheckBoxSub.setText("Opret opgaven som delopgave");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxCustomer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxUser, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textFieldEstimatedTime)
                                            .addComponent(comboBoxPriority, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textFieldTaskName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dateChooserExpectedEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(dateChooserExpectedStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(CheckBoxSub, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
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
                            .addComponent(comboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(47, 47, 47)
                        .addComponent(jButton9)))
                .addContainerGap(175, Short.MAX_VALUE))
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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
modelTable = (DefaultTableModel) tableAllTask.getModel();
        Type type = new Type(comboBoxType.getSelectedItem().toString());
        Statuss status = new Statuss(comboBoxStatus.getSelectedItem().toString());
        Customer customer = new Customer(comboBoxCustomer.getSelectedItem().toString());
        User user = new User(comboBoxUser.getSelectedItem().toString());
        
        if (CheckBoxSub.isSelected()) {
            try {
                System.out.println(modelTable.getValueAt(tableAllTask.getSelectedRow(), 0).toString());
                Task task = new Task(textFieldTaskName.getText(),
                        Integer.parseInt(modelTable.getValueAt(tableAllTask.getSelectedRow(), 0).toString()),
                        type,
                        status,
                        customer,
                        user,
                        dateChooserExpectedStart.getDate(),
                        dateChooserExpectedEnd.getDate(),
                        Integer.parseInt(textFieldEstimatedTime.getText()),
                        Integer.parseInt(comboBoxPriority.getSelectedItem().toString()),
                        textAreaBeskrivelse.getText());

                Controller.dbHandler.createSubTask(task);
                Controller.dbHandler.addUserToTask(listUsersOnTask);
                
            } catch (SQLException ex) {
                Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Task task = new Task(textFieldTaskName.getText(),
                        type,
                        status,
                        customer,
                        user,
                        dateChooserExpectedStart.getDate(),
                        dateChooserExpectedEnd.getDate(),
                        Integer.parseInt(textFieldEstimatedTime.getText()),
                        Integer.parseInt(comboBoxPriority.getSelectedItem().toString()),
                        textAreaBeskrivelse.getText());

                Controller.dbHandler.createTask(task);
                Controller.dbHandler.addUserToTask(listUsersOnTask);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(CreateTaskPanel.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void buttonRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveUserActionPerformed

        int index = listUsersOnTask.getSelectedIndex();

        model = (DefaultListModel) listUsers.getModel();
        modelOnTask = (DefaultListModel) listUsersOnTask.getModel();

        if (index != -1) {
            model.addElement(listUsersOnTask.getSelectedValue());
            modelOnTask.removeElement(listUsersOnTask.getSelectedValue());
        } else {
            JOptionPane.showMessageDialog(this, "Der ikke valgt nogen medarbejder", "Fejlrapport", JOptionPane.WARNING_MESSAGE);

        }


    }//GEN-LAST:event_buttonRemoveUserActionPerformed

    private void textFieldTaskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTaskNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTaskNameActionPerformed

    private void tableAllTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAllTaskMouseClicked
    }//GEN-LAST:event_tableAllTaskMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxSub;
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonRemoveUser;
    private javax.swing.JComboBox comboBoxCustomer;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JComboBox comboBoxType;
    private javax.swing.JComboBox comboBoxUser;
    private com.toedter.calendar.JDateChooser dateChooserExpectedEnd;
    private com.toedter.calendar.JDateChooser dateChooserExpectedStart;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JTextField textFieldEstimatedTime;
    private javax.swing.JTextField textFieldTaskName;
    // End of variables declaration//GEN-END:variables

    private void fillTableWithTasks() throws IOException, SQLException {

        modelTable = (DefaultTableModel) tableAllTask.getModel();
        ArrayList<Task> tasks = Controller.dbHandler.SPgetTasks();

        for (int i = 0; i < tasks.size(); i++) {
            Object[] data = {tasks.get(i).getTaskID(),
                tasks.get(i).getTaskName(),
                tasks.get(i).getCustomer(),
                tasks.get(i).getType(),
                tasks.get(i).getStatus(),
                tasks.get(i).getUser(),
                tasks.get(i).getEstimatedtime(),
                tasks.get(i).getPriority(),
                tasks.get(i).getStartDate(),
                tasks.get(i).getEndDate()};
            modelTable.addRow(data);
        }
    }
}
