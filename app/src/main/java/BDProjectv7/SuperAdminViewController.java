
package BDProjectv7;

import UIPackage.SuperAdminPanel;
import UIPackage.SuperAdminPanel;
import UIPackage.UserFrame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SuperAdminViewController {
    
    public User currentUser;
    public BDConnection bdconn;
    public UserFrame userFrame;
    public SuperAdminPanel superAdminPanel;

    public CardLayout cardLayout;
    
    ViewController viewController;
    
    public SuperAdminViewController(BDConnection bdconn, ViewController viewController){
        this.bdconn = bdconn;
        this.viewController = viewController;
        generateView();
    }
    
    public void generateView(){
        userFrame = new UserFrame();
        cardLayout = (CardLayout)userFrame.mainPanel.getLayout();
        superAdminPanel = new SuperAdminPanel(new LogoutButtonListener(), new SelectButtonListener(), new ComboBoxListener(), new UserSelectionListener(), 
new SaveDateListener(), new CursSelectionListener(), new ProfSelectionListener(), new AddProfesorToCursListener(), new AddNewCursListener(), 
new DeleteStudentFromCursListener(), new DeleteProfesorFromCursListener(), new DeleteCursListener(), new DeleteUserListener(),
new AddStudentToCursListener(), new DeleteGrupaStudiuListener());
        userFrame.mainPanel.add(superAdminPanel);
        
    }
    
    public void resetView(){
        cardLayout.show(userFrame.mainPanel, "supersuperAdminPanel");
        userFrame.setSize(superAdminPanel.getPreferredSize());
        userFrame.setVisible(true);
    }
    
    public void hideView(){
        userFrame.setVisible(false);
    }
 

    void fillUserList(){
        int selection = superAdminPanel.jComboBox1.getSelectedIndex();
        String rol = new String();
        switch (selection){
            case 0:  break;
            case 1:  rol = "student"; break;
            case 2:  rol = "profesor"; break;
            case 3:  rol = "admin"; break;
        }
        String[][] queryData = bdconn.selectMultipleUsers(rol);  
        DefaultListModel listModel = (DefaultListModel) superAdminPanel.allUserListModel;
        listModel.removeAllElements();
        for(int i = 0; i < queryData.length && queryData[i][0] != null; i++){
            String allName = queryData[i][0] + " " + queryData[i][1];
            superAdminPanel.userUsername[i] = queryData[i][2];
            listModel.add(i,allName);
        }
    }

    public void fillCursesList(){
        DefaultListModel listModel = (DefaultListModel) superAdminPanel.cursListModel;
        listModel.removeAllElements();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getAllCursuri();
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillProfesorList(){
        String curs = superAdminPanel.cursList.getSelectedValue();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getProfCursSuper(curs, superAdminPanel);
        DefaultListModel listModel = (DefaultListModel) superAdminPanel.profListModel;
        listModel.removeAllElements();
        
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillStudentList(){
        String curs = superAdminPanel.cursList.getSelectedValue();
        int usernameIndex = superAdminPanel.profList.getSelectedIndex();
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getStudentiProfesorSuper(curs, superAdminPanel.profesorUsername[usernameIndex], superAdminPanel);
        DefaultListModel listModel = (DefaultListModel) superAdminPanel.studentListModel;
        listModel.removeAllElements();
        
        for(int i = 0; i < queryData.size(); i++){
            listModel.addElement(queryData.get(i));
        }
    }

    public void fillGrupetList(){
        
        ArrayList<Integer> queryData = new ArrayList<Integer>();
        queryData = bdconn.getGroups();
        superAdminPanel.grupeStudiu = queryData;
        DefaultListModel listModel = (DefaultListModel) superAdminPanel.grupaStudiuListModel;
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
            data[0] =(String) superAdminPanel.fieldNume.getText();
            data[1] = superAdminPanel.fieldPrenume.getText();
            String[][] queryData = new String[1][11];
            queryData = bdconn.selectOneUser(data);
            superAdminPanel.setAllFields(queryData[0]);

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
                
                int index = superAdminPanel.allUserList.getSelectedIndex();
                String[][] queryData = new String[1][11];
                queryData = bdconn.selectOneUserUsername(superAdminPanel.userUsername[index]);
                superAdminPanel.setAllFields(queryData[0]);
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }

    class SaveDateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] fieldData = superAdminPanel.getAllFields();
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
            date[1] = superAdminPanel.cursList.getSelectedValue();
            date[0] = superAdminPanel.addProfesorField.getText();
            if(!superAdminPanel.checkBoxCurs.isSelected())
                date[2] = "0";
            else
                date[2] = "1";
            if(!superAdminPanel.checkBoxSeminar.isSelected())
                date[3] = "0";
            else
                date[3] = "1";
            if(!superAdminPanel.checkBoxLab.isSelected())
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
            date[0] = superAdminPanel.numeCursField.getText();
            date[1] = superAdminPanel.textMesaj.getText();
            date[2] = superAdminPanel.nrMaxStudentiField.getText();
            bdconn.addNewCurs(date);
            fillCursesList();
        }
    }

    class DeleteStudentFromCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = superAdminPanel.studentUsername[superAdminPanel.studentList.getSelectedIndex()];
            date[1] = superAdminPanel.profesorUsername[superAdminPanel.profList.getSelectedIndex()];
            date[2] = superAdminPanel.cursList.getSelectedValue();
            bdconn.deleteStudentFromCurs(date);
            fillStudentList();
        }
    }

    class DeleteProfesorFromCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = superAdminPanel.profesorUsername[superAdminPanel.profList.getSelectedIndex()];
            date[1] = superAdminPanel.cursList.getSelectedValue();
            bdconn.deleteProfesorFromCurs(date);
            fillProfesorList();
            fillStudentList();
        }
    }

    class DeleteCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String curs = new String();
            curs = superAdminPanel.cursList.getSelectedValue();
            bdconn.deleteCurs(curs);
            superAdminPanel.profListModel.removeAllElements();
            superAdminPanel.studentListModel.removeAllElements();
            fillCursesList();
        }
    }

    class DeleteUserListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String username = new String();
            username = superAdminPanel.dataField1.getText();
            bdconn.deleteUser(username);
            superAdminPanel.setAllFieldsZero();
            fillUserList();
        }
    }

    class AddStudentToCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String[] date = new String[10];
            date[0] = superAdminPanel.profesorUsername[superAdminPanel.profList.getSelectedIndex()];
            date[1] = superAdminPanel.cursList.getSelectedValue();
            date[2] = superAdminPanel.addStudentToCursField.getText();
            bdconn.asignareStudentLaCurs(date);
            fillStudentList();
            superAdminPanel.addStudentToCursField.setText("");
        }
    }

    class DeleteGrupaStudiuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int idGrupa;
            idGrupa = superAdminPanel.grupeStudiu.get(superAdminPanel.grupaStudiuList.getSelectedIndex());
            bdconn.deleteGrupaStudiuAdmin(idGrupa);
            
            fillGrupetList();
        }
    }
    
}
