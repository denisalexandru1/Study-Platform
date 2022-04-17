
package BDProjectv7;

import UIPackage.AdminPanel;
import UIPackage.UserFrame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminViewController {
    
    public User currentUser;
    public BDConnection bdconn;
    public UserFrame userFrame;
    public AdminPanel adminPanel;
    
    public CardLayout cardLayout;
    
    ViewController viewController;
    
    public AdminViewController(BDConnection bdconn, ViewController viewController){
        this.bdconn = bdconn;
        this.viewController = viewController;
        generateView();
    }
    
    public void generateView(){
        userFrame = new UserFrame();
        cardLayout = (CardLayout)userFrame.mainPanel.getLayout();
        adminPanel = new AdminPanel(new LogoutButtonListener(), new SelectButtonListener(), new ComboBoxListener(), new UserSelectionListener(), 
new SaveDateListener(), new CursSelectionListener(), new ProfSelectionListener(), new AddProfesorToCursListener(), new AddNewCursListener(), 
new DeleteStudentFromCursListener(), new DeleteProfesorFromCursListener(), new DeleteCursListener(), new DeleteUserListener(),
new AddStudentToCursListener(), new DeleteGrupaStudiuListener());
        userFrame.mainPanel.add(adminPanel);
        
    }
    
    public void resetView(){
        cardLayout.show(userFrame.mainPanel, "adminpanel");
        userFrame.setSize(adminPanel.getPreferredSize());
        userFrame.setVisible(true);
    }
    
    public void hideView(){
        userFrame.setVisible(false);
    }
 

    void fillUserList(){
        int selection = adminPanel.jComboBox1.getSelectedIndex();
        String rol = new String();
        switch (selection){
            case 0:  break;
            case 1:  rol = "student"; break;
            case 2:  rol = "profesor"; break;
        }
        String[][] queryData = bdconn.selectMultipleUsers(rol);  
        DefaultListModel listModel = (DefaultListModel) adminPanel.allUserListModel;
        listModel.removeAllElements();
        for(int i = 0; i < queryData.length && queryData[i][0] != null; i++){
            String allName = queryData[i][0] + " " + queryData[i][1];
            adminPanel.userUsername[i] = queryData[i][2];
            listModel.add(i,allName);
        }
    }

    public void fillCursesList(){
        DefaultListModel listModel = (DefaultListModel) adminPanel.cursListModel;
        listModel.removeAllElements();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getAllCursuri();
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillProfesorList(){
        String curs = adminPanel.cursList.getSelectedValue();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getProfCurs(curs, adminPanel);
        DefaultListModel listModel = (DefaultListModel) adminPanel.profListModel;
        listModel.removeAllElements();
        
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillStudentList(){
        String curs = adminPanel.cursList.getSelectedValue();
        int usernameIndex = adminPanel.profList.getSelectedIndex();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getStudentiProfesor(curs, adminPanel.profesorUsername[usernameIndex], adminPanel);
        DefaultListModel listModel = (DefaultListModel) adminPanel.studentListModel;
        listModel.removeAllElements();
        
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillGrupetList(){
        
        ArrayList<Integer> queryData = new ArrayList<Integer>();
        queryData = bdconn.getGroups();
        adminPanel.grupeStudiu = queryData;
        DefaultListModel listModel = (DefaultListModel) adminPanel.grupaStudiuListModel;
        listModel.removeAllElements();
        
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement("Grupa " +queryData.get(i));
        }
    }
    
    // --------------- BUTTONS ACTION LISTENERS -------------------
    
    
    // MAIN PANEL
    
    class LogoutButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewController.switchToLoginScreen();
        }
    }   

    class SelectButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] data = new String[2];
            data[0] =(String) adminPanel.fieldNume.getText();
            data[1] = adminPanel.fieldPrenume.getText();
            String[][] queryData = new String[1][11];
            queryData = bdconn.selectOneUser(data);
            adminPanel.setAllFields(queryData[0]);

        }
    } 

    class ComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            fillUserList();
        }
    } 

    class UserSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                
                int index = adminPanel.allUserList.getSelectedIndex();
                String[][] queryData = new String[1][11];
                queryData = bdconn.selectOneUserUsername(adminPanel.userUsername[index]);
                adminPanel.setAllFields(queryData[0]);
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }

    class SaveDateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] fieldData = adminPanel.getAllFields();
            bdconn.updateDateUser(fieldData);
        }
    }
    
    class CursSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                fillProfesorList();
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }

    class ProfSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                
                fillStudentList();
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }

    class AddProfesorToCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[1] = adminPanel.cursList.getSelectedValue();
            date[0] = adminPanel.addProfesorField.getText();
            if(!adminPanel.checkBoxCurs.isSelected())
                date[2] = "0";
            else
                date[2] = "1";
            if(!adminPanel.checkBoxSeminar.isSelected())
                date[3] = "0";
            else
                date[3] = "1";
            if(!adminPanel.checkBoxLab.isSelected())
                date[4] = "0";
            else
                date[4] = "1";
            bdconn.asignareProfesorLaCurs(date);
            fillProfesorList();
        }
    }

    class AddNewCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = adminPanel.numeCursField.getText();
            date[1] = adminPanel.textMesaj.getText();
            date[2] = adminPanel.nrMaxStudentiField.getText();
            bdconn.addNewCurs(date);
            fillCursesList();   
        }
    }

    class DeleteStudentFromCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = adminPanel.studentUsername[adminPanel.studentList.getSelectedIndex()];
            date[1] = adminPanel.profesorUsername[adminPanel.profList.getSelectedIndex()];
            date[2] = adminPanel.cursList.getSelectedValue();
            bdconn.deleteStudentFromCurs(date);
            fillStudentList();
        }
    }

    class DeleteProfesorFromCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = adminPanel.profesorUsername[adminPanel.profList.getSelectedIndex()];
            date[1] = adminPanel.cursList.getSelectedValue();
            bdconn.deleteProfesorFromCurs(date);
            fillProfesorList();
            fillStudentList();
        }
    }

    class DeleteCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String curs = new String();
            curs = adminPanel.cursList.getSelectedValue();
            bdconn.deleteCurs(curs);
            adminPanel.profListModel.removeAllElements();
            adminPanel.studentListModel.removeAllElements();
            fillCursesList();
        }
    }

    class DeleteUserListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String username = new String();
            username = adminPanel.dataField1.getText();
            bdconn.deleteUser(username);
            adminPanel.setAllFieldsZero();
            fillUserList();
        }
    }

    class AddStudentToCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = adminPanel.profesorUsername[adminPanel.profList.getSelectedIndex()];
            date[1] = adminPanel.cursList.getSelectedValue();
            date[2] = adminPanel.addStudentToCursField.getText();
            bdconn.asignareStudentLaCurs(date);
            fillStudentList();
            adminPanel.addStudentToCursField.setText("");
        }
    }

    class DeleteGrupaStudiuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int idGrupa;
            idGrupa = adminPanel.grupeStudiu.get(adminPanel.grupaStudiuList.getSelectedIndex());
            bdconn.deleteGrupaStudiuAdmin(idGrupa);
            
            fillGrupetList();
        }
    }
    
}
