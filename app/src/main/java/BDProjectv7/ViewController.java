package BDProjectv7;

import java.awt.CardLayout;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.JPanel;

public class ViewController {
    
    public LoginController loginController;
    public StudentViewController studentViewController;
    public ProfesorViewController profesorViewController;
    public AdminViewController adminViewController;
    public SuperAdminViewController superAdminViewController; 
    public BDConnection bdconn;
    
    public ViewController(BDConnection bdconn){
        this.bdconn = bdconn;
        loginController = new LoginController(bdconn, this);
        studentViewController = new StudentViewController(bdconn, this);
        profesorViewController = new ProfesorViewController(bdconn, this);
        adminViewController = new AdminViewController(bdconn, this);
        superAdminViewController = new SuperAdminViewController(bdconn, this);
        loginController.setFrameVisible(true);
    }
    
    public void switchToUserScreen(String username, String password, String role){
        loginController.setFrameVisible(false);
        switch(role){
            case "student": 
                bdconn.setNewCurrentUser(username, password, role);
                studentViewController.setCurrentUser(bdconn.getUserInformation());
                studentViewController.resetView();
                break;  
                
            case "profesor":
                bdconn.setNewCurrentUser(username, password, role);
                profesorViewController.setCurrentUser(bdconn.getUserInformation());
                profesorViewController.resetView();
                break;
            case "admin":
                bdconn.setNewCurrentUser(username, password, role);
                adminViewController.resetView();
                adminViewController.fillCursesList();
                adminViewController.fillGrupetList();
                break;
                
            case "superAdmin":
                bdconn.setNewCurrentUser(username, password, role);
                superAdminViewController.resetView();
                superAdminViewController.fillCursesList();
                superAdminViewController.fillGrupetList();
                break;
                
                
        }
    }    
    
    public void switchToLoginScreen(){        
        studentViewController.hideView();
        profesorViewController.hideView();
        adminViewController.hideView();
        superAdminViewController.hideView();
        loginController.setFrameVisible(true);
    }
}
