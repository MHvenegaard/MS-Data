package view.login;

import com.mysql.jdbc.Connection;
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
public class LoginFrame extends javax.swing.JFrame {

    private int loginStatus;
    private Controller control;

    public LoginFrame() {


        loginStatus = 0;

        initComponents();
        progressBar.setBackground(Color.BLUE);
        progressBar.setForeground(Color.BLUE);

        try {
            control = new Controller();

        } catch (ClassNotFoundException ex) {
            // Database driver could not be loaded
            setWarningMessage("Database driverne kunne ikke lokaliseres");

        } catch (SQLException ex) {
            // Connection to SystemDB could not be established
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (IOException ex) {
            // Connection to SystemDB could not be established
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");
        }

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

        textFieldUserName.setText("MH");

        passwordFieldPassword.setText("1234");
        passwordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldPasswordActionPerformed(evt);
            }
        });

        progressBar.setMaximum(7);

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
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed



        // Gets all users on tasks using a new thread. 
        // This task alone is around 20 seconds



        // A new thread continously updates the login interface
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                //updateProgressView();

                // Validate connection to system database
                validateSystemDBConnection();

                // Validate connection to user database
                validateUserDBConnection();

                // Validate connection to customer database
                validateCustomerDBConnection();

                // Validate connection to file database
                validateFileDBConnection();

                // Checking login credentials
                User user = validateUser();

                if (user != null) {
                    // Fetches the remaining data from the server
                    initiateController();

                    // Login
                    login(user);
                }

            }
        });
        t.start();

        updateProgressView();
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void initiateController() {
        loginStatus = 6;
        updateProgressView();
        try {

            control.initiateController();



        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        }

    }

    private void validateSystemDBConnection() {
        loginStatus = 1;
        updateProgressView();

        try {

            Controller.dbHandler.initiateSystemDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");

        }
        //progressBar.setValue(loginStatus);

    }

    private void validateUserDBConnection() {
        loginStatus = 2;
        updateProgressView();

        try {

            Controller.dbHandler.initiateEmployeeDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til medarbejderdatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til medarbejderdatabasen");

        }
        //progressBar.setValue(loginStatus);

    }

    private void validateCustomerDBConnection() {
        loginStatus = 3;
        updateProgressView();

        try {

            Controller.dbHandler.initiateCustomerDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til kundedatabase");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til kundedatabase");

        }
        //progressBar.setValue(loginStatus);

    }

    private void validateFileDBConnection() {
        loginStatus = 4;
        updateProgressView();
        try {

            Controller.dbHandler.initiateFileDBConn();

        } catch (SQLException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til fildatabasen");

        } catch (IOException ex) {
            // A connection couldnt be established to the database
            setWarningMessage("Der kunne ikke oprettes forbindelse til fildatabasen");

        }
        //progressBar.setValue(loginStatus);

    }

    private User validateUser() {
        loginStatus = 5;
        updateProgressView();
        User user = null;


        try {

            // Get all users
            Connection conn = (Connection) Controller.dbHandler.initiateSystemDBConn()[0];
            ArrayList<User> users = Controller.dbHandler.initiateUserList(conn);

            // Retrieve login credentials
            String username = textFieldUserName.getText();
            char[] pw = passwordFieldPassword.getPassword();
            String enteredPassword = new String(pw);


            // Iterate through all users and compare credentials
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
                user = users.get(counter - 1); // -1 As it has incremented once and would otherwise create an out of bounds exception

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

//        } catch (ClassNotFoundException ex) {
//            //Mainframe couldnt be initialized
//            setWarningMessage("Programmet kunne ikke starte - Prøv igen..");
//
        }
        //progressBar.setValue(loginStatus);


        return user;
    }

    private void passwordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldPasswordActionPerformed
        buttonLoginActionPerformed(evt);
    }//GEN-LAST:event_passwordFieldPasswordActionPerformed

    private void login(User user) {
        loginStatus = 7;
        updateProgressView();

        try {



            Mainframe mf = null;
            control.setUser(user);
            mf = new Mainframe(control);
            mf.setLocationRelativeTo(null);

            Image image = ImageIO.read(getClass().getResource("/ressources/ms-teknik-logo.jpg"));
            mf.setIconImage(image);
            mf.setVisible(true);

        } catch (ClassNotFoundException ex) {
            setWarningMessage("Brugergrænsefladen kunne ikke initialiseres.. Prøv igen");
        } catch (SQLException ex) {
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");
        } catch (IOException ex) {
            setWarningMessage("Der kunne ikke oprettes forbindelse til systemdatabasen");
        }
    }

    private void updateProgressView() {
        System.out.println(loginStatus);
        switch (loginStatus) {
            case 0:
                setMessage("Initialiserer system");
                progressBar.setValue(loginStatus);
                break;
            case 1:
                setMessage("Kontrollerer forbindelse til systemdatabase");
                progressBar.setValue(loginStatus);
                break;
            case 2:
                setMessage("Kontrollerer forbindelse til medarbejderdatabasen");
                progressBar.setValue(loginStatus);
                break;
            case 3:
                setMessage("Kontrollerer forbindelse til kundedatabase");
                progressBar.setValue(loginStatus);
                break;
            case 4:
                setMessage("Kontrollerer forbindelse til fildatabasen");
                progressBar.setValue(loginStatus);
                break;
            case 5:
                setMessage("Validerer login oplysninger");
                progressBar.setValue(loginStatus);
                break;
            case 6:
                setMessage("Henter systemdata");
                progressBar.setValue(loginStatus);
                break;
            case 7:
                setMessage("Initialiserer system.. Vent venligst");
                progressBar.setValue(loginStatus);
                break;

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

                    javax.swing.UIDefaults defaults = javax.swing.UIManager.getLookAndFeelDefaults();
                    defaults.put("nimbusOrange", new Color(15, 110, 25));
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame login = new LoginFrame();
                    Image image = ImageIO.read(getClass().getResource("/ressources/ms-teknik-logo.jpg"));
                    login.setLocationRelativeTo(null);
                    login.setIconImage(image);
                    login.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(LoginFrame.class
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
