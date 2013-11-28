/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.Controller;
import handlers.DBHandler;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
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
    DBHandler dbh = new DBHandler();
    Controller controller = new Controller();

    public TaskHandlingPanel(DBHandler dbh) throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        this.dbh = dbh;
        fillCustomerCombo();
        fillStatusCombo();
        fillTypeCombo();
        fillUserCombo();
        fillUserList();

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

        ComboBoxStatus = new javax.swing.JComboBox();
        TextFieldTaskName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TextFieldTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ButtonRemoveUser = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxCustomer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListUsers = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListUsersOnTask = new javax.swing.JList();
        ButtonAddUser = new javax.swing.JButton();
        ComboBoxProjectLeader = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxPriority = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboBoxType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        TextFieldEstimatedStart = new javax.swing.JTextField();
        TextFieldEstimatedFinish = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ButtonEditTask = new javax.swing.JButton();
        ButtonSaveChanges = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1280, 775));
        setPreferredSize(new java.awt.Dimension(1280, 775));

        jLabel9.setText("timer");

        jLabel5.setText("Projektleder");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ansatte");

        jLabel3.setText("Status");

        jLabel4.setText("Kunde");

        ButtonRemoveUser.setText("Fjern medarbejder");

        jLabel6.setText("Forventet start");

        jScrollPane1.setViewportView(ListUsers);

        jLabel7.setText("Forventet færdigt");

        jScrollPane2.setViewportView(ListUsersOnTask);

        ButtonAddUser.setText("Tilføj medarbejder");
        ButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Type");

        jLabel10.setText("Prioritet");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ansatte på projektet");

        jLabel1.setText("Projekt navn");

        jLabel8.setText("Forventet tidsforbrug");

        ButtonEditTask.setText("Rediger opgave ");

        ButtonSaveChanges.setText("Gem ændringer");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Opgave navn", "Kunde", "Type", "Status", "Leder"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addComponent(ButtonEditTask)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxCustomer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxProjectLeader, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldEstimatedStart, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldEstimatedFinish, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldTime)
                                    .addComponent(ComboBoxPriority, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldTaskName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(ButtonSaveChanges))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(146, 146, 146)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ButtonAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ButtonRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jButton1))))
                    .addComponent(jScrollPane4))
                .addContainerGap(561, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextFieldTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ComboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBoxProjectLeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TextFieldEstimatedStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TextFieldEstimatedFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(TextFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(ButtonAddUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonRemoveUser))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboBoxPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonEditTask)
                            .addComponent(ButtonSaveChanges)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton1)))
                .addGap(247, 247, 247))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAddUserActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            fillAllWithSelectedTask((Integer)model.getValueAt(jTable1.getSelectedRow(), 0));
        } catch (IOException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TaskHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        // System.out.println("column: " + jTable1.getSelectedColumn());
        System.out.println("Hent værdi: " + model.getValueAt(jTable1.getSelectedRow(), 0));
       
        // model.getValueAt(jTable1.getSelectedColumn(), 1);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddUser;
    private javax.swing.JButton ButtonEditTask;
    private javax.swing.JButton ButtonRemoveUser;
    private javax.swing.JButton ButtonSaveChanges;
    private javax.swing.JComboBox ComboBoxCustomer;
    private javax.swing.JComboBox ComboBoxPriority;
    private javax.swing.JComboBox ComboBoxProjectLeader;
    private javax.swing.JComboBox ComboBoxStatus;
    private javax.swing.JComboBox ComboBoxType;
    private javax.swing.JList ListUsers;
    private javax.swing.JList ListUsersOnTask;
    private javax.swing.JTextField TextFieldEstimatedFinish;
    private javax.swing.JTextField TextFieldEstimatedStart;
    private javax.swing.JTextField TextFieldTaskName;
    private javax.swing.JTextField TextFieldTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void fillTableWithTask() throws IOException, SQLException {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Task> tasks = dbh.SPgetTasks();

        for (int i = 0; i < tasks.size(); i++) {
            Object[] data = {tasks.get(i).getTaskID(),
                tasks.get(i).getTaskName(),
                tasks.get(i).getCustomer(),
                tasks.get(i).getType(),
                tasks.get(i).getStatus(),
                tasks.get(i).getUser()};
            model.addRow(data);
        }
    }

    private void fillAllWithSelectedTask(int taskID) throws IOException, SQLException {
        Task task;
        task = dbh.SPgetTask(taskID);

        TextFieldTaskName.setText(task.getTaskName());
        System.out.println(""+task.getCustomer().getCompanyName());
       
        ComboBoxCustomer.setSelectedItem(task.getCustomer().toString());
        ComboBoxPriority.setSelectedItem(task.getPriority());
        ComboBoxProjectLeader.setSelectedItem(task.getUser());
        ComboBoxStatus.setSelectedItem(task.getStatus());
        ComboBoxType.setSelectedItem(task.getType());
        TextFieldTime.setText(""+task.getEstimatedtime());
        TextFieldEstimatedStart.setText(task.getStartDate().toString());
        TextFieldEstimatedFinish.setText(task.getEndDate().toString());
        
        
    }

    private void fillCustomerCombo() throws SQLException, IOException {

        ComboBoxCustomer.setSelectedIndex(-1);
        ComboBoxCustomer.removeAllItems();
        ComboBoxCustomer.addItem("Vælg kunde");

        ArrayList<Customer> customers = dbh.SPgetCustomers();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).toString());
            ComboBoxCustomer.addItem(customers.get(i));
        }
        ComboBoxCustomer.setSelectedIndex(0);
    }

    private void fillTypeCombo() throws SQLException, IOException {

        ComboBoxType.setSelectedIndex(-1);
        ComboBoxType.removeAllItems();
        ComboBoxType.addItem("Vælg type");

        ArrayList<Type> typesList = dbh.SPgetTypes();
        for (int i = 0; i < typesList.size(); i++) {
            ComboBoxType.addItem(typesList.get(i));
        }
        ComboBoxType.setSelectedIndex(0);
    }

    private void fillUserCombo() throws SQLException, IOException {

        ComboBoxProjectLeader.setSelectedIndex(-1);
        ComboBoxProjectLeader.removeAllItems();
        ComboBoxProjectLeader.addItem("Vælg projektleder");

        ArrayList<User> userList = dbh.SPgetUsers();
        for (int i = 0; i < userList.size(); i++) {
            ComboBoxProjectLeader.addItem(userList.get(i));
        }
        ComboBoxProjectLeader.setSelectedIndex(0);
    }

    private void fillStatusCombo() throws SQLException, IOException {

        ComboBoxStatus.setSelectedIndex(-1);
        ComboBoxStatus.removeAllItems();
        ComboBoxStatus.addItem("Vælg status");

        ArrayList<Statuss> statusList = dbh.SPgetStatus();
        for (int i = 0; i < statusList.size(); i++) {
            ComboBoxStatus.addItem(statusList.get(i));
        }
        ComboBoxStatus.setSelectedIndex(0);
    }

    private void fillUserList() throws SQLException, IOException {
        //Flyt dette
        DefaultListModel modelOnTask = new DefaultListModel();
        ListUsersOnTask.setModel(modelOnTask);

        DefaultListModel model = new DefaultListModel();

        ListUsers.setModel(model);
        ArrayList<User> userList = dbh.SPgetUsers();

        for (int i = 0; i < userList.size(); i++) {
            model.addElement(userList.get(i));
        }

    }
}
