package BDProjectv7;

import UIPackage.WelcomePanel;
import UIPackage.RegisterPanel;
import UIPackage.LoginPanel;
import UIPackage.LoginFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginController{
    public BDConnection bdconn;
    public LoginFrame loginFrame;
    public LoginPanel loginPanel;
    public RegisterPanel registerPanel;
    public WelcomePanel welcomePanel;
    public CardLayout cardLayout;
    
    public ViewController viewController;
    
    public LoginController(BDConnection bdconn, ViewController viewController){
        this.bdconn = bdconn;
        this.viewController = viewController;
        generateView();
    }
    
    private void generateView(){
        loginFrame = new LoginFrame();
        cardLayout = (CardLayout)loginFrame.mainPanel.getLayout();
        welcomePanel = new WelcomePanel(new LoginButtonListener(), new RegisterButtonListener());
        loginPanel = new LoginPanel(new LoginValidateButtonListener(), new BackButtonListener());
        registerPanel = new RegisterPanel(new RegisterValidateButtonListener(), new BackButtonListener());
        loginFrame.mainPanel.add(welcomePanel, "welcomepanel");
        loginFrame.mainPanel.add(loginPanel, "loginpanel");
        loginFrame.mainPanel.add(registerPanel, "registerpanel");
        cardLayout.show(loginFrame.mainPanel, "welcomepanel");
        loginFrame.pack();
    }
    
    
    public void setFrameVisible(boolean bul){
        loginFrame.setVisible(bul);
    }
    
    class LoginButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            changePanel("loginpanel");

        }
    }
    class RegisterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JTextField[] fields = registerPanel.getAllFields();
            for(int i = 0; i < fields.length; i++)
                fields[i].setText("");
            
            registerPanel.errorLabel.setText("");
            changePanel("registerpanel");
        }
    }
    class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            changePanel("welcomepanel");
        }
    }
    class LoginValidateButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String role = bdconn.isUserRegistered(loginPanel.getUsername(), loginPanel.getPassword());
            if(role != null){
                loginPanel.setErrorLabel("Logarea s-a realizat cu succes!");
                viewController.switchToUserScreen(loginPanel.getUsername(), loginPanel.getPassword(), role);
            }
            else
            {
                loginPanel.setErrorLabel("Nu s-a putut realiza connectarea...");
            }
        }
    }
    class RegisterValidateButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = registerPanel.getAllFields();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    registerPanel.errorLabel.setText("Va rugam sa completati toate campurile");
                    toExit = true;
                }
                else{
                    f.setBorder(new LineBorder(Color.gray, 1, true));
                }
            }
            if(toExit) return;
            
            
            // Verificam daca username-ul exista deja
            if(bdconn.isUsernameUsed(registerPanel.usernameField.getText())){
                registerPanel.errorLabel.setText("Username-ul este deja folosit de alt utilizator.");
                return;
            }
            //verificam daca parolele coincid
            if(registerPanel.passwordField.getText() == null ? registerPanel.repeatPasswordField.getText() != null : !registerPanel.passwordField.getText().equals(registerPanel.repeatPasswordField.getText())){
                System.out.println(registerPanel.passwordField.getText() + " " + registerPanel.repeatPasswordField.getText());
                registerPanel.errorLabel.setText("Parolele nu coincid.");
                return;
            }
            
            if(registerPanel.studentRadioButton.isSelected()){
                bdconn.registerStudent(registerPanel.usernameField.getText(), 
                                        registerPanel.passwordField.getText(),  
                                         registerPanel.cnpField.getText(),
                                          registerPanel.prenumeField.getText(),    
                                           registerPanel.numeField.getText(), 
                                            registerPanel.adresaField.getText(),
                                             registerPanel.nrTelefonField.getText(), 
                                              registerPanel.emailField.getText(),
                                               registerPanel.ibanField.getText(), 
                                                registerPanel.nrContractField.getText(),
                                                 registerPanel.anStudiuComboBox.getSelectedIndex()+1, 
                                                  20);
            }
            else if(registerPanel.profesorRadioButton.isSelected()){
                bdconn.registerProfesor(registerPanel.usernameField.getText(), 
                                        registerPanel.passwordField.getText(),  
                                         registerPanel.cnpField.getText(),
                                          registerPanel.prenumeField.getText(),    
                                           registerPanel.numeField.getText(),
                                            registerPanel.adresaField.getText(),
                                             registerPanel.nrTelefonField.getText(), 
                                              registerPanel.emailField.getText(),
                                               registerPanel.ibanField.getText(), 
                                                registerPanel.nrContractField.getText(),
                                                 registerPanel.departamentTextField.getText());
            }
            else if(registerPanel.administratorRadioButton.isSelected()){
                bdconn.registerAdministrator(registerPanel.usernameField.getText(), 
                                        registerPanel.passwordField.getText(),  
                                         registerPanel.cnpField.getText(),
                                          registerPanel.prenumeField.getText(),    
                                           registerPanel.numeField.getText(), 
                                            registerPanel.adresaField.getText(),
                                             registerPanel.nrTelefonField.getText(), 
                                              registerPanel.emailField.getText(),
                                               registerPanel.ibanField.getText(), 
                                                registerPanel.nrContractField.getText());
            }
            
            registerPanel.errorLabel.setText("Inregistrarea a avut loc cu succes!");
        }
    }
    
    public void changePanel(String stringPanel){
        cardLayout.show(loginFrame.mainPanel, stringPanel);
        loginFrame.pack();
    }
    
    
}



