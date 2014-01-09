package view.login;

import handlers.Controller;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.User;
import view.Mainframe;

/**
 * @author Marc *
 */
public class Login extends javax.swing.JFrame {

    private int loginStatus;

    public Login() {

        loginStatus = 0;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textFieldUserName = new javax.swing.JTextField();
        passwordFieldPassword = new javax.swing.JPasswordField();
        progressBar = new javax.swing.JProgressBar();
        buttonLogin = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("Brugernavn:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MS Teknik - Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        passwordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldPasswordActionPerformed(evt);
            }
        });

        progressBar.setMaximum(3);

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/ms-teknik-logo.jpg"))); // NOI18N

        jLabel1.setText("Brugernavn:");

        jLabel3.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordFieldPassword))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        // A new thread continously updates the login interface
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                // Initializing connection checks
                loginStatus = 0;
                setMessage("Initialiserer system");
                progressBar.setValue(loginStatus);

                // Validate connection to system database
                validateSystemDBConnection();

                // Validate connection to user database
                validateUserDBConnection();

                // Validate connection to customer database
                validateCustomerDBConnection();
                
                // Validate connection to file database
                validateFileDBConnection();
                        
                // Checking login credentials
                validateLoginCredentials();


            }
        });
        t.start();

        updateProgressView();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void validateSystemDBConnection() {
        loginStatus = 1;
        setMessage("Kontrollerer forbindelse til systemdatabase");
        try {

            Controller.dbHandler.initiateSystemDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        }
        progressBar.setValue(loginStatus);
    }

    private void validateUserDBConnection() {
        loginStatus = 2;
        setMessage("Kontrollerer forbindelse til medarbejderdatabasen");
        try {

            Controller.dbHandler.initiateEmployeeDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til medarbejderdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til medarbejderdatabasen");

        }
        progressBar.setValue(loginStatus);
    }

    private void validateCustomerDBConnection() {
        loginStatus = 3;
        setMessage("Kontrollerer forbindelse til kundedatabase");
        try {

            Controller.dbHandler.initiateCustomerDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til kundedatabase");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til kundedatabase");

        }
        progressBar.setValue(loginStatus);
    }

    private void validateFileDBConnection() {
        loginStatus = 4;
        setMessage("Kontrollerer forbindelse til fildatabasen");
        try {

            Controller.dbHandler.initiateFileDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til fildatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til fildatabasen");

        }
        progressBar.setValue(loginStatus);
    }

    private void validateLoginCredentials() {
        loginStatus = 5;
        setMessage("Kontrollerer forbindelse til kundedatabase");
        try {

            ArrayList<User> users = Controller.dbHandler.SPgetUsers();
            String username = textFieldUserName.getText();
            char[] pw = passwordFieldPassword.getPassword();
            String enteredPassword = new String(pw);
            boolean userFound = false;
            boolean passwordMatch = false;
            int counter = 0;
            while (!userFound && counter < users.size()) {
                if (users.get(counter).getUserName().equals(username)) {
                    userFound = true;
                    String pass = users.get(counter).getPassword();
                    if (pass.equals(enteredPassword)) {
                        passwordMatch = true;

                    }
                }
                counter++;
            }
            if (userFound && passwordMatch) {
                progressBar.setValue(loginStatus);
                setMessage("Success");
                login(users.get(counter - 1)); // -1 As it has incremented once and would otherwise create an out of bounds exception

            } else if (!userFound) {
                // User doesnt exist
                setWarningMessage("Brugernavnet kan ikke genkendes");
            } else {
                // Password doesnt match
                setWarningMessage("Passwordet matcher ikke brugernavnet");
            }


        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (ClassNotFoundException ex) {
            // Mainframe couldnt be initialized
            setWarningMessage("Programmet kunne ikke starte - Prøv igen..");

        }
        progressBar.setValue(loginStatus);
    }

    private void passwordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldPasswordActionPerformed
        buttonLoginActionPerformed(evt);
    }//GEN-LAST:event_passwordFieldPasswordActionPerformed

    private void login(User user) throws IOException, SQLException, ClassNotFoundException {

        // INSERT USER INTO CONTROLLER
        // INSERT CONTROLLER INTO MAINFRAME

        setMessage("Initialiserer system.. Vent venligst");
        Mainframe mf = null;
        Controller control = new Controller(user);
        mf = new Mainframe(control);
        mf.setLocationRelativeTo(null);
        Image image = ImageIO.read(getClass().getResource("/ressources/ms-teknik-logo.jpg"));
        mf.setIconImage(image);
        mf.setVisible(true);
    }

    private void updateProgressView() {
        switch (loginStatus) {
            case 0:
                setMessage("Initialiserer system");
                progressBar.setValue(loginStatus);
            case 1:
                setMessage("Kontrollerer internetforbindelse");
                progressBar.setValue(loginStatus);
            case 2:
                setMessage("Kontrollerer databaseforbindelse");
                progressBar.setValue(loginStatus);
            case 3:
                setMessage("Kontrollerer CRM forbindelse");
                progressBar.setValue(loginStatus);
            case 4:
                setMessage("Kontrollerer ERP forbindelse");
                progressBar.setValue(loginStatus);
            case 5:
                setMessage("Validerer loginoplysninger");
                progressBar.setValue(loginStatus);
        }
    }

    private void setWarningMessage(String msg) {
        labelStatus.setForeground(Color.RED);
        labelStatus.setText(msg);
    }

    private void setMessage(String msg) {
        labelStatus.setForeground(Color.BLACK);
        labelStatus.setText(msg);
    }

    /**
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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login login = new Login();
                    Image image = ImageIO.read(getClass().getResource("/ressources/ms-teknik-logo.jpg"));
                    login.setLocationRelativeTo(null);
                    login.setIconImage(image);
                    login.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Login.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables
}
