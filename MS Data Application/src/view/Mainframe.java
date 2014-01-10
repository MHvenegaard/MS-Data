/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import handlers.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Marc
 */
public class Mainframe extends javax.swing.JFrame {

    private Controller controller;

    /**
     * Creates new form Mainframe
     */
    public Mainframe(Controller control) throws ClassNotFoundException, SQLException, IOException {
        controller = control;

        initComponents();

        setTitle();

        createGUIBasedOnAccessLevel(controller.getUser().getAccessLevel());


        
        

     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        topMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 768));
        setMinimumSize(new java.awt.Dimension(1280, 768));
        setName("MS Teknik"); // NOI18N

        jMenu1.setText("File");
        topMenu.add(jMenu1);

        jMenu2.setText("Edit");
        topMenu.add(jMenu2);

        setJMenuBar(topMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createGUIBasedOnAccessLevel(int accessLevel) throws SQLException, IOException, ClassNotFoundException {

        // Admin
        if (accessLevel == 0) {
            tabPane.add("Hovedside", new Home());
            tabPane.add("Kundehåndtering", new CustomerHandlingPanel());
            tabPane.add("Opgaveoprettelse", new CreateTaskPanel());
            tabPane.add("Opgavehåndtering", new TaskHandlingPanel());
            tabPane.add("Brugerhåndtering", new UserHandlingPanel());
            tabPane.add("Typehåndtering", new TypeAndStatusHandlingPanel());
        }
        // User
        else{
            tabPane.add("Hovedside", new Home());
            tabPane.add("Opgavehåndtering", new TaskHandlingPanel());
        }

    }

    private void setTitle() {

        String userName = controller.getUser().getUserName();
        String accessLevel;
        if (controller.getUser().getAccessLevel() == 0) {
            accessLevel = "Administrator";
        } else {
            accessLevel = "Bruger";
        }
        this.setTitle(userName + " - " + accessLevel);
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Controller ctrl = new Controller();
                    User us = new User(1337, "DummyUser", "Dummy", "User", "admin", 0);
                    ctrl.setUser(us);
                    new Mainframe(ctrl).setVisible(true);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JMenuBar topMenu;
    // End of variables declaration//GEN-END:variables
}
