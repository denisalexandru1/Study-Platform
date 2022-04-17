package BDProjectv7;


import UIPackage.InscriereActivitatePanel;
import UIPackage.InscriereCursPanel;
import UIPackage.StudentHomePanel;
import UIPackage.VizDateStudentPanel;
import UIPackage.VizNoteStudentPanel;
import UIPackage.VizActivitatiStudent;
import UIPackage.GrupStudiuPanel;
import UIPackage.SelectareCursGrupaPanel;
import UIPackage.VizualizareGrupaPanel;
import UIPackage.ProgramareActivitateGrupaPanel; 
import UIPackage.UserFrame;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentViewController {

    public User currentUser;
    public BDConnection bdconn;
    public UserFrame userFrame;
    public StudentHomePanel studentHomePanel;
    public VizDateStudentPanel vizDateStudentPanel;
    public InscriereCursPanel inscriereCursPanel;
    public InscriereActivitatePanel inscriereActivitatePanel;
    public VizNoteStudentPanel vizNoteStudentPanel;
    public VizActivitatiStudent vizActivitatiStudent;
    
    public GrupStudiuPanel grupStudiuPanel;
    public SelectareCursGrupaPanel selectareCursGrupaPanel;
    public VizualizareGrupaPanel vizualizareGrupaPanel;
    public ProgramareActivitateGrupaPanel programareActivitateGrupaPanel;
    
    public NotaStudent NotaStudent;
   /* public RegisterPanel registerPanel; //panourile
    public WelcomePanel welcomePanel; */
    public CardLayout cardLayout;
    
    ViewController viewController;
    
    public StudentViewController(BDConnection bdconn, ViewController viewController){
        this.bdconn = bdconn;
        this.viewController = viewController;
        generateView();
    }
    
    public void generateView(){
        userFrame = new UserFrame();
        cardLayout = (CardLayout)userFrame.mainPanel.getLayout();
        studentHomePanel = new StudentHomePanel(new LogoutButtonListener(), new VizDateStudentListener(), new InscriereCursuriListener(), 
                new InscriereActivitatiListener(), new VizualizareNoteListener(), new VizActivitatiListener(), new VizualizareGrupaStudiuListener());
        
        vizDateStudentPanel = new VizDateStudentPanel(new BackToHomePanelListener());
        inscriereCursPanel = new InscriereCursPanel(new BackToHomePanelListener(), new CursuriCurenteSelectionListener(), new InscriereCursListener(), new ParasireCursListener());
        inscriereActivitatePanel = new InscriereActivitatePanel(new BackToHomePanelListener(), new InscriereActivitateListener());
        
        vizNoteStudentPanel = new VizNoteStudentPanel(new BackToHomePanelListener());
        vizActivitatiStudent = new VizActivitatiStudent(new BackToHomePanelListener(), new ParasireActivitateListener());
        
        grupStudiuPanel = new GrupStudiuPanel(new BackToHomePanelListener(), new CreareGrupaNouaListener(),new InscriereGrupaListener(), new VizualizareGrupaListener(), new GrupeSelectionListener(), new AcceptInviteListener());
        selectareCursGrupaPanel = new SelectareCursGrupaPanel(new OkButtonListener()); /// de implementat listener 
        vizualizareGrupaPanel = new VizualizareGrupaPanel(new VizualizareGrupaStudiuListener(), new ProgramareActivitateSwitchListener(),
                new SendMSGListener(), new SendInviteGroupListener(), new ParasireGrupListener());
        programareActivitateGrupaPanel = new ProgramareActivitateGrupaPanel(new BackToVizGrupaListener(), new ProgramareActivitateInsertListener());
                
        userFrame.mainPanel.add(studentHomePanel, "studenthomepanel");
        userFrame.mainPanel.add(vizDateStudentPanel, "vizdatestudentpanel");
        userFrame.mainPanel.add(inscriereCursPanel, "inscrierecurspanel");
        userFrame.mainPanel.add(vizNoteStudentPanel, "viznotestudentpanel");
        userFrame.mainPanel.add(inscriereActivitatePanel, "inscriereactivitatipanel");
        userFrame.mainPanel.add(vizActivitatiStudent, "vizactivitatistudent");
        
        userFrame.mainPanel.add(grupStudiuPanel, "grupstudiupanel");
        userFrame.mainPanel.add(selectareCursGrupaPanel, "selectareCursGrupaPanel");
        userFrame.mainPanel.add(vizualizareGrupaPanel, "vizualizareGrupaPanel");
        userFrame.mainPanel.add(programareActivitateGrupaPanel, "programareActivitateGrupaPanel");
        
        
        cardLayout.show(userFrame.mainPanel, "studenthomepanel");
        userFrame.setSize(studentHomePanel.getPreferredSize());
    }
    
    public void resetView(){
        cardLayout.show(userFrame.mainPanel, "studenthomepanel");
        userFrame.setSize(studentHomePanel.getPreferredSize());
        userFrame.setVisible(true);
    }
    
    public void hideView(){
        userFrame.setVisible(false);
    }
    
    public void setCurrentUser(User currentUser){
        this.currentUser = currentUser;
    }
    
    public void changePanel(String stringPanel){
        
        
        
        
        cardLayout.show(userFrame.mainPanel, stringPanel);
        userFrame.pack();
        
        switch(stringPanel){
            case "studenthomepanel":
                userFrame.setSize(studentHomePanel.getPreferredSize());
                break;
            case "vizdatestudentpanel":
                userFrame.setSize(vizDateStudentPanel.getPreferredSize());
                break;
            case "inscrierecurspanel":
                userFrame.setSize(inscriereCursPanel.getPreferredSize());
                break;
            case "inscriereactivitatipanel":
                userFrame.setSize(inscriereActivitatePanel.getPreferredSize());
                break;
            case "viznotestudentpanel":
                userFrame.setSize(vizNoteStudentPanel.getPreferredSize());
                break;
            case "vizactivitatistudent":
                userFrame.setSize(vizActivitatiStudent.getPreferredSize());
                break;
            case "grupstudiupanel":
                userFrame.setSize(grupStudiuPanel.getPreferredSize());
                break;
            case "selectareCursGrupaPanel":
                userFrame.setSize(selectareCursGrupaPanel.getPreferredSize());
                break;
            case "vizualizareGrupaPanel":
                userFrame.setSize(vizualizareGrupaPanel.getPreferredSize());
                break;
            case "programareActivitateGrupaPanel":
                userFrame.setSize(programareActivitateGrupaPanel.getPreferredSize());
                break;
                
        }
        
        
    }
    
    public void initializeVizDatePanel(){
        currentUser = bdconn.getUserInformation();
        vizDateStudentPanel.adresaField.setText(currentUser.adresa); 
        vizDateStudentPanel.anstudiuField.setText(Integer.toString(((Student)currentUser).an_studiu)); 
        vizDateStudentPanel.cnpField.setText(currentUser.CNP); 
        vizDateStudentPanel.emailField.setText(currentUser.email); 
        vizDateStudentPanel.nrOreField.setText(Integer.toString(((Student)currentUser).nr_ore)); 
        vizDateStudentPanel.nrcontractField.setText(currentUser.nr_contract); 
        vizDateStudentPanel.nrtelefonField.setText(currentUser.nr_telefon); 
        vizDateStudentPanel.numeField.setText(currentUser.nume); 
        vizDateStudentPanel.prenumeField.setText(currentUser.prenume); 
        vizDateStudentPanel.usernameField.setText(currentUser.username); 
        
    }
    
    public void initializeInscriereCursuriPanel(){
        
        // initializare cursuri active
        
        ArrayList<ArrayList<String>> activeQueryData;
        activeQueryData = bdconn.getStudentActiveCourses(); // 
        inscriereCursPanel.updateCursuriCurenteData(activeQueryData);
        
        // setare primul curs la vizualizare
        if(!activeQueryData.isEmpty())
        {
            inscriereCursPanel.descriereTextBox.setText(activeQueryData.get(0).get(1));
            String numeprenume = activeQueryData.get(0).get(2) + " " +  activeQueryData.get(0).get(3);
            inscriereCursPanel.profesorCursField.setText(numeprenume);
        }
        // initializare cursuri posibile
        ArrayList<String> possibleQueryData;
        possibleQueryData = bdconn.getStudentPossibleCourses();
        inscriereCursPanel.updateCursuriPosibileData(possibleQueryData);
        
    }
    
    
    public void initializeGrupeStudiu(){
        ArrayList<Integer> toateGrupele = bdconn.getGroups();
        ArrayList<String> numeCursuri = new ArrayList<String>();
        for(int i = 0; i < toateGrupele.size(); i++){
            String numeCurs = bdconn.getCursGrupa(toateGrupele.get(i));
            numeCursuri.add(numeCurs);
        }
        grupStudiuPanel.updateListaGrupe(toateGrupele, numeCursuri);
        ArrayList<Integer> invitatii = bdconn.getInvitatiiGrupa();
        grupStudiuPanel.invitatii = invitatii;
        grupStudiuPanel.updateListaInvitatii();
        
    }
    
    public void initializeCursuriGrupe(){
        ArrayList<ArrayList<String>> queryData = bdconn.getStudentActiveCourses();
        ArrayList<String> numeCursuri = new ArrayList<String>();
        for(int i = 0; i < queryData.size(); i++){
            numeCursuri.add(queryData.get(i).get(0));
        }
        selectareCursGrupaPanel.updateListaGrupe(numeCursuri);
    }
    
    public void initializeParticipantiGrupa(int idGrupa){
        ArrayList<String> queryData = new ArrayList<String>();
        queryData = bdconn.getColegi(idGrupa);
        vizualizareGrupaPanel.updateParticipantiGrupa(queryData);
    }
    
    public void initializeSugestiiGrupa(int idGroup){
        ArrayList<ArrayList<String>> sugestii = bdconn.getSuggestedStudentsForGroup(idGroup);
        vizualizareGrupaPanel.sugestiiParticipanti = sugestii;
        vizualizareGrupaPanel.updateSugestiiGrupa();
    }
    
    public void initializeGrupaChat(int idGrupa){
        ArrayList<ArrayList<String>> queryData = new ArrayList<ArrayList<String>>();
        queryData = bdconn.getChat(idGrupa);

        vizualizareGrupaPanel.updateChatGrupa(queryData);
    }
    
    public void initializeInscriereActivitatiPanel(){
           
           inscriereActivitatePanel.listaActivitati = bdconn.getPossibleActivities();

           DefaultTableModel model = (DefaultTableModel)inscriereActivitatePanel.activitatiTable.getModel();
           model.setRowCount(0);
           
           // sortam row dupa nume curs;
           // TO DO
           
           for(int i = 0; i < inscriereActivitatePanel.listaActivitati.size(); i++){
               model.addRow(new Object[]{inscriereActivitatePanel.listaActivitati.get(i).numeCurs, inscriereActivitatePanel.listaActivitati.get(i).tipActivitate,
                   inscriereActivitatePanel.listaActivitati.get(i).zi, inscriereActivitatePanel.listaActivitati.get(i).oraString, inscriereActivitatePanel.listaActivitati.get(i).durata});
           }
    }
    
    public void initializeVizNoteStudentPanel(){
        ArrayList<NotaStudent> queryData = new ArrayList<NotaStudent>();
        queryData = bdconn.getStudentNote();

        DefaultTableModel model = (DefaultTableModel) vizNoteStudentPanel.TableVizNote.getModel();
        model.setRowCount(0);
        for(int i = 0; i < queryData.size(); i++){
            String data[] = new String[5];
            data[0] = queryData.get(i).nume_curs;
            data[1] = Double.toString(queryData.get(i).nota_curs);
            data[2] = Double.toString(queryData.get(i).nota_seminar);
            data[3] = Double.toString(queryData.get(i).nota_laborator);
            data[4] = Integer.toString(queryData.get(i).nota_finala);
            if(data[0] == null)
                break;
            model.addRow(data);
        }
        
    }
    
    public void getActivitatiZiuaCurenta(){
        String[][] queryData = new String[5][4];
        queryData = bdconn.getCurrentDayActiv();

        DefaultTableModel model = (DefaultTableModel) vizActivitatiStudent.TableActivitatiCurrent.getModel();
        model.setRowCount(0);

        for(int i = 0; i < queryData.length && queryData[i][0] != null; i++)
            model.addRow(queryData[i]);
    }
    
    public void getActivitatiStudent(){
        ArrayList<Activitate> activitati = bdconn.getActivitatiStudent();
        vizActivitatiStudent.activitati = activitati;
        DefaultTableModel model = (DefaultTableModel) vizActivitatiStudent.TableActivitati.getModel();
        model.setRowCount(0);

        for(int i = 0; i < activitati.size(); i++){
            model.addRow(new Object[]{activitati.get(i).numeCurs, 
                activitati.get(i).tipActivitate, activitati.get(i).oraString,
                activitati.get(i).durata, activitati.get(i).zi});
        }
    }
    
    
    // ---- EVENT LISTENERS ----
    
    // INSRIERE CURSURI LISTENERS
    class CursuriCurenteSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                int index = inscriereCursPanel.cursuriCurenteList.getSelectedIndex();
                inscriereCursPanel.descriereTextBox.setText(inscriereCursPanel.cursuriCurenteData.get(index).get(1));
                String numeprenume = inscriereCursPanel.cursuriCurenteData.get(index).get(2) + " " +  inscriereCursPanel.cursuriCurenteData.get(index).get(3);
                inscriereCursPanel.profesorCursField.setText(numeprenume);
            }
            catch(IndexOutOfBoundsException ex){
            }
        }
    }
    class InscriereCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            String cursSelectat = inscriereCursPanel.cursuriPosibileList.getSelectedValue();
            bdconn.inscriereUserLaCurs(cursSelectat);
            initializeInscriereCursuriPanel();
        }
    }
    // INSCRIERE ACTIVITATE LISTENERS'
    class InscriereActivitateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = inscriereActivitatePanel.activitatiTable.getSelectedRow();
            int idActivitate = inscriereActivitatePanel.listaActivitati.get(index).id_activ;
            bdconn.inscriereUserLaActivitate(idActivitate);
            
            initializeInscriereActivitatiPanel();
        }
    }
    
    // VIZUALIZARE ACTIVITATE LISTENER
    
    class ParasireActivitateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = vizActivitatiStudent.TableActivitati.getSelectedRow();
            int idActivitate = vizActivitatiStudent.activitati.get(index).id_activ;
            
            bdconn.parasireActivitateUser(idActivitate);
            
            getActivitatiStudent();
            getActivitatiZiuaCurenta();
            
            
        }
    }
    
    class ParasireCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String numeCurs = inscriereCursPanel.cursuriCurenteList.getSelectedValue();
            
            bdconn.parasireCursUser(numeCurs);
            initializeInscriereCursuriPanel();
            
            
        }
    }
    
    class ParasireGrupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
            int idGrupa = grupStudiuPanel.grupe.get(index);
            
            bdconn.parasireGrupUser(idGrupa);
 
            initializeGrupeStudiu();
            changePanel("grupstudiupanel");          
            
        }
    }

    // MAIN PANEL LISTENERS
    class VizualizareGrupaStudiuListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeGrupeStudiu();
            changePanel("grupstudiupanel");
        }
    }
    
    class LogoutButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewController.switchToLoginScreen();
        }
    }
    class VizDateStudentListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeVizDatePanel();
            changePanel("vizdatestudentpanel");
        }
    }    
    class InscriereCursuriListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeInscriereCursuriPanel();
            changePanel("inscrierecurspanel");
        }
    }
    class InscriereActivitatiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeInscriereActivitatiPanel();
            changePanel("inscriereactivitatipanel");
        }
    }
    
       
    class BackToHomePanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            changePanel("studenthomepanel");
        }
    }

    class VizualizareNoteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        initializeVizNoteStudentPanel();
            changePanel("viznotestudentpanel");
        }
    }
    class VizActivitatiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            getActivitatiZiuaCurenta();
            getActivitatiStudent();
            changePanel("vizactivitatistudent");
        }
    }
    
    //GRUPE STUDIU LISTENERS
    
    class CreareGrupaNouaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeCursuriGrupe();
            changePanel("selectareCursGrupaPanel");
        }
    }
    
    class InscriereGrupaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
            int idGr = grupStudiuPanel.grupe.get(index);
            bdconn.InscriereGrupaStudiu(currentUser.username, idGr);
            initializeGrupeStudiu();
            initializeParticipantiGrupa(idGr);
            grupStudiuPanel.buttonInscriereGrupa.setEnabled(false);
        }
    }
    
    class ProgramareActivitateSwitchListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // update profesori posibil de invitat in grupa
            int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
            int idGr = grupStudiuPanel.grupe.get(index);
            programareActivitateGrupaPanel.sugestiiProfesori = bdconn.getSuggestedProfessorsForGroup(bdconn.getCursByGroupID(idGr));
            programareActivitateGrupaPanel.updateSugestiiProfesor();
            
            changePanel("programareActivitateGrupaPanel");
        }
    }
    
    class ProgramareActivitateInsertListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = programareActivitateGrupaPanel.getAllFields();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    programareActivitateGrupaPanel.errorLabel.setText("Va rugam sa completati toate campurile");
                    toExit = true;
                }
            }
            if(toExit == false)    {
                    int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
                    int idGr = grupStudiuPanel.grupe.get(index);
                    bdconn.InsertActivitateGrupa(textFields, idGr);
                    programareActivitateGrupaPanel.errorLabel.setText("Activitate programata cu succes");
                
            }
            if(toExit) return;
            
            if(programareActivitateGrupaPanel.solicitProfCheckBox.isSelected()){
                bdconn.insertInviteToProfesorAtLastGroupActivity(programareActivitateGrupaPanel.sugestiiProfesori.get(programareActivitateGrupaPanel.selectareProfComboBox.getSelectedIndex()).get(0));
            }
            
            
        }
    }
    
    class AcceptInviteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = grupStudiuPanel.invitatiiGrupaList.getSelectedIndex();
            int idGr = grupStudiuPanel.invitatii.get(index);
            bdconn.InscriereGrupaStudiu(currentUser.username, idGr);
            
            bdconn.deleteInviteGrupa(currentUser.username, idGr);
            
            initializeGrupeStudiu();
            
        }
    }
    
    
    class BackToVizGrupaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            changePanel("vizualizareGrupaPanel");
        }
    }
    
    class VizualizareGrupaListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
            int idGr = grupStudiuPanel.grupe.get(index);
            initializeParticipantiGrupa(idGr);
            currentUser = bdconn.getUserInformation();
                if(bdconn.VerificareInscriereStudentGrupa(currentUser.username, idGr)){
                    vizualizareGrupaPanel.buttonProgramareActivitate.setEnabled(true);
                    vizualizareGrupaPanel.inviteButton.setEnabled(true);
                    vizualizareGrupaPanel.buttonSendMSG.setEnabled(true);
                    initializeGrupaChat(idGr);
                }
                else{
                    vizualizareGrupaPanel.buttonProgramareActivitate.setEnabled(false);
                    vizualizareGrupaPanel.inviteButton.setEnabled(false);
                    vizualizareGrupaPanel.buttonSendMSG.setEnabled(false);
                    initializeGrupaChat(-1);
                }
                
            // set-up sugestii participanti
            initializeSugestiiGrupa(idGr);
            
            changePanel("vizualizareGrupaPanel");
        }
    }
    
    class SendMSGListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
            int idGr = grupStudiuPanel.grupe.get(index);
            
            String msg = vizualizareGrupaPanel.textFieldMSG.getText();
            
            bdconn.SendMSG(currentUser.username, msg, idGr);
            initializeGrupaChat(idGr);
        }
    }
    
    class SendInviteGroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = vizualizareGrupaPanel.sugestiiPartList.getSelectedIndex();
            String usernameDestinatar = vizualizareGrupaPanel.sugestiiParticipanti.get(index).get(0);
            
            int idGrupa = grupStudiuPanel.grupe.get(grupStudiuPanel.listaGrupe.getSelectedIndex());
            bdconn.insertInvitatieGrupa(idGrupa, usernameDestinatar);
            
            initializeSugestiiGrupa(idGrupa);
            
        }
    }
    
    //selectare curs pentru creare grupa
    class OkButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String var = selectareCursGrupaPanel.listaCursuriGrupa.getSelectedValue();
            bdconn.InsertGrupaStudiu(var);
            initializeGrupeStudiu();
            changePanel("grupstudiupanel");
        }
    }
    
    class GrupeSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                int index = grupStudiuPanel.listaGrupe.getSelectedIndex();
                int idGr = grupStudiuPanel.grupe.get(index);
                currentUser = bdconn.getUserInformation();
                if(bdconn.VerificareInscriereStudentGrupa(currentUser.username, idGr)){
                    grupStudiuPanel.buttonInscriereGrupa.setEnabled(false);
                }
                else{
                    grupStudiuPanel.buttonInscriereGrupa.setEnabled(true);
                }
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }
    
    
    
    
    
    
}
