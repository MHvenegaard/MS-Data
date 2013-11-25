/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.DBHandler;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import model.Customer;
import model.Statuss;
import model.Task;
import model.Type;
import model.User;
import quick.dbtable.DBTable;

/**
 *
 * @author Mikkel
 */
public class TaskHandlingPanel extends javax.swing.JPanel {

    /**
     * Creates new form TaskHandlingPanel
     */
    DBHandler dbh = new DBHandler();

    public TaskHandlingPanel(DBHandler dbh) throws ClassNotFoundException, SQLException, IOException {
        initComponents();
        this.dbh = dbh;
        fillCustomerCombo();
        fillStatusCombo();
        fillTypeCombo();
        fillUserCombo();
        fillUserList();

        fillListTasks();




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
        jScrollPane3 = new javax.swing.JScrollPane();
        ListTasks = new javax.swing.JList();
        ButtonEditTask = new javax.swing.JButton();
        ButtonSaveChanges = new javax.swing.JButton();

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

        ListTasks.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListTasksMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListTasks);

        ButtonEditTask.setText("Rediger opgave ");

        ButtonSaveChanges.setText("Gem ændringer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
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
                                .addComponent(jLabel9)
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
                            .addComponent(ButtonSaveChanges))
                        .addGap(0, 543, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonEditTask)
                    .addComponent(ButtonSaveChanges))
                .addGap(366, 366, 366))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAddUserActionPerformed

    private void ListTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListTasksMouseClicked


        TextFieldTaskName.setText("YOLOBITCHES");
    }//GEN-LAST:event_ListTasksMouseClicked
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
    private javax.swing.JList ListTasks;
    private javax.swing.JList ListUsers;
    private javax.swing.JList ListUsersOnTask;
    private javax.swing.JTextField TextFieldEstimatedFinish;
    private javax.swing.JTextField TextFieldEstimatedStart;
    private javax.swing.JTextField TextFieldTaskName;
    private javax.swing.JTextField TextFieldTime;
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
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void fillListTasks() throws IOException, SQLException {
        DefaultListModel model = new DefaultListModel();
        ListTasks.setModel(model);

        ArrayList<Task> Tasks = dbh.SPgetTasks();

        for (int i = 0; i < Tasks.size(); i++) {
            model.addElement(Tasks.get(i).toString());
        }
    }

    private void fillAllWithSelectedTask(int taskID) throws IOException, SQLException {

        Task task;
        task = dbh.SPgetTask(taskID);

        TextFieldTaskName.setText(task.getTaskName());
        ComboBoxCustomer.setSelectedItem(task.getCustomer());


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
            System.out.println(typesList.get(i).toString());
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
            System.out.println(userList.get(i).toString());
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
            System.out.println(statusList.get(i).toString());
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
