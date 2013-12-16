/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.User;

/**
 *
 * @author Mikkel
 */
public class UserHandlingPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserHandlingPanel
     */
    private ArrayList<User> userList;

    public UserHandlingPanel() throws SQLException, IOException {
        initComponents();
        userList = Controller.userList;
        Controller.fillTableWithUser(jTable1);
      
        Controller.fillCombobox(comboBoxDeleteUserList, userList);
    }

     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldFirstName = new javax.swing.JTextField();
        textFieldLastName = new javax.swing.JTextField();
        textFieldShortName = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        comboBoxAccessLevel = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxDeleteUserList = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldName2 = new javax.swing.JTextField();
        textFieldLastname2 = new javax.swing.JTextField();
        textFieldShortname2 = new javax.swing.JTextField();
        textFieldPassword2 = new javax.swing.JTextField();
        comboBoxAccessLevel2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonDeleteUser = new javax.swing.JButton();
        buttonUpdateUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        comboBoxAccessLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        jLabel1.setText("Navn");

        jLabel2.setText("Initialer");

        jLabel3.setText("Efternavn");

        jLabel4.setText("Password");

        jLabel5.setText("Adgangsniveau");

        jLabel6.setText("Opret medarbejder");

        jLabel7.setText("Fjern medarbejder");

        jLabel8.setText("Rediger medarbejder");

        jLabel9.setText("Adgangsniveau");

        jLabel10.setText("Password");

        jLabel11.setText("Efternavn");

        textFieldPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPassword2ActionPerformed(evt);
            }
        });

        comboBoxAccessLevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        jLabel12.setText("Navn");

        jLabel13.setText("Initialer");

        jButton1.setText("Opret");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonDeleteUser.setText("Fjern");
        buttonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteUserActionPerformed(evt);
            }
        });

        buttonUpdateUser.setText("Rediger");
        buttonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateUserActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Navn", "Efternavn", "Brugernavn", "Adgangsniveau", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxAccessLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textFieldFirstName)
                                        .addComponent(textFieldLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldShortName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton1)))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDeleteUser)
                            .addComponent(comboBoxDeleteUserList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldName2)
                                    .addComponent(textFieldLastname2)
                                    .addComponent(textFieldShortname2)
                                    .addComponent(textFieldPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxAccessLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(buttonUpdateUser)))
                        .addContainerGap(474, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldShortName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxAccessLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxDeleteUserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buttonDeleteUser))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldLastname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldShortname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxAccessLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(buttonUpdateUser)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPassword2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Controller.dbHandler.createUserInUserDB(null, textFieldFirstName.getText(), textFieldLastName.getText(), textFieldShortName.getText(), textFieldPassword.getText(), Integer.parseInt(comboBoxAccessLevel.getSelectedItem().toString()));
            Controller.fillTableWithUser(jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

 
    
    private void buttonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateUserActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
        try {
            Controller.dbHandler.updateUserInUserDB(textFieldName2.getText(),
                    textFieldLastname2.getText(),
                    textFieldShortname2.getText(),
                    textFieldPassword2.getText(),
                    Integer.parseInt(modelTable.getValueAt(jTable1.getSelectedRow(), 4).toString()),
                    Integer.parseInt(modelTable.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            Controller.fillTableWithUser(jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonUpdateUserActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();
        textFieldName2.setText(modelTable.getValueAt(jTable1.getSelectedRow(), 1).toString());
        textFieldLastname2.setText(modelTable.getValueAt(jTable1.getSelectedRow(), 2).toString());
        textFieldShortname2.setText(modelTable.getValueAt(jTable1.getSelectedRow(), 3).toString());
        comboBoxAccessLevel2.setSelectedItem(modelTable.getValueAt(jTable1.getSelectedRow(), 4).toString());
        textFieldPassword2.setText(modelTable.getValueAt(jTable1.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteUserActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) jTable1.getModel();

        try {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Sikker på du vil fjerne " + modelTable.getValueAt(jTable1.getSelectedRow(), 3).toString(), "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Controller.dbHandler.deleteUserInUserDB(Integer.parseInt(modelTable.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                Controller.fillTableWithUser(jTable1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserHandlingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteUser;
    private javax.swing.JButton buttonUpdateUser;
    private javax.swing.JComboBox comboBoxAccessLevel;
    private javax.swing.JComboBox comboBoxAccessLevel2;
    private javax.swing.JComboBox comboBoxDeleteUserList;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textFieldFirstName;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldLastname2;
    private javax.swing.JTextField textFieldName2;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldPassword2;
    private javax.swing.JTextField textFieldShortName;
    private javax.swing.JTextField textFieldShortname2;
    // End of variables declaration//GEN-END:variables
}
