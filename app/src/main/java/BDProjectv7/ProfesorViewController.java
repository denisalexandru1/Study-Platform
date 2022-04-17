
package BDProjectv7;

import UIPackage.InvitatiiProfesorPanel;
import UIPackage.ProfesorHomePanel;
import UIPackage.UserFrame;
import UIPackage.VizDateProfesorPanel;
import UIPackage.ProgramareActivitateProfesorPanel;
import UIPackage.CursuriProfPanel;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder; 

import UIPackage.VizActivitatiProfesorPanel;
import UIPackage.CatalogProfesorPanel; 
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener; 
import javax.swing.table.TableCellEditor; 

public class ProfesorViewController {
    
    public User currentUser;
    public BDConnection bdconn;
    public UserFrame userFrame;
    public ProfesorHomePanel profesorHomePanel;
    public VizDateProfesorPanel vizDateProfesorPanel;
    public InvitatiiProfesorPanel invitatiiProfesorPanel;
    public VizActivitatiProfesorPanel vizActivitatiProfesorPanel;
    public CatalogProfesorPanel catalogProfesorPanel; 
    
    public ProgramareActivitateProfesorPanel programareActivitateProfesorPanel;
    public CursuriProfPanel cursuriProfPanel;

    public CardLayout cardLayout;
    
    ViewController viewController;
    
    public ProfesorViewController(BDConnection bdconn, ViewController viewController){
        this.bdconn = bdconn;
        this.viewController = viewController;
        generateView();
    }
    
    public void generateView(){
        userFrame = new UserFrame();
        cardLayout = (CardLayout)userFrame.mainPanel.getLayout();
        profesorHomePanel = new ProfesorHomePanel(new LogoutButtonListener(), new VizDateProfesorListener(), 
                new VizInvitatiiListener(), new VizActivitatiProfesorListener(), new CatalogListener(), new ProgramareActivitatiProfListener(), new CursuriProfListener());
        programareActivitateProfesorPanel = new ProgramareActivitateProfesorPanel(new BackToHomePanelListener(), new ProgramareCursListener(),
                new ProgramareLaboratorListener(), new ProgramareSeminarListener(), new ProgramareExamenListener());
        cursuriProfPanel = new CursuriProfPanel(new BackToHomePanelListener(), new CursuriSelectionListener(), new SalvareModificariListener());
        programareActivitateProfesorPanel = new ProgramareActivitateProfesorPanel(new BackToHomePanelListener(), new ProgramareCursListener(),
                new ProgramareLaboratorListener(), new ProgramareSeminarListener(), new ProgramareExamenListener()); 
        vizDateProfesorPanel = new VizDateProfesorPanel(new BackToHomePanelListener());
        invitatiiProfesorPanel = new InvitatiiProfesorPanel(new BackToHomePanelListener(), new AcceptInviteListener());
        
        vizActivitatiProfesorPanel = new VizActivitatiProfesorPanel(new BackToHomePanelListener(), new UpdateActivProfesorListener());
        catalogProfesorPanel = new CatalogProfesorPanel(new BackToHomePanelListener(), new CursSelectionListener(), new UpdateNoteListener()); 
        cursuriProfPanel = new CursuriProfPanel(new BackToHomePanelListener(), new CursuriSelectionListener(),new SalvareModificariListener());
        
        // Adauga toate panourile din card view
        userFrame.mainPanel.add(profesorHomePanel, "profesorhomepanel");
        userFrame.mainPanel.add(vizDateProfesorPanel, "vizdateprofesorpanel");
        userFrame.mainPanel.add(invitatiiProfesorPanel, "invitatiiprofesorpanel");
        userFrame.mainPanel.add(vizActivitatiProfesorPanel, "vizactivitatiprofesoripanel");
        userFrame.mainPanel.add(catalogProfesorPanel, "catalogprofesorpanel"); 
        userFrame.mainPanel.add(cursuriProfPanel, "cursuriprofpanel");
        userFrame.mainPanel.add(programareActivitateProfesorPanel, "programareactivitateprofesorpanel");
        
        cardLayout.show(userFrame.mainPanel, "profesorhomepanel");
        userFrame.setSize(profesorHomePanel.getPreferredSize());
    }
    
    public void updateCursuriProfPanel(){
        currentUser = bdconn.getUserInformation();
        String numeCurs = cursuriProfPanel.listaCursuri.getSelectedValue();
        ArrayList<Double> queryDataPonderi = new ArrayList<Double>();
        queryDataPonderi = bdconn.getPonderi(numeCurs);
        
        ArrayList<Integer> queryDataCLS = new ArrayList<Integer>();
        queryDataCLS = bdconn.getCursLabSem();
        
        if (queryDataCLS.get(0) == 0){
            cursuriProfPanel.fieldPondereCurs.setEnabled(false);
            queryDataPonderi.set(0, 0.0);
        }
        if (queryDataCLS.get(1) == 0){
            cursuriProfPanel.fieldPondereLab.setEnabled(false);
            queryDataPonderi.set(1, 0.0);
        }
        if (queryDataCLS.get(2) == 0){
            cursuriProfPanel.fieldPondereSeminar.setEnabled(false);
            queryDataPonderi.set(2, 0.0);
        }
        cursuriProfPanel.fieldPondereCurs.setText(queryDataPonderi.get(0).toString());
        cursuriProfPanel.fieldPondereLab.setText(queryDataPonderi.get(1).toString());
        cursuriProfPanel.fieldPondereSeminar.setText(queryDataPonderi.get(2).toString());
        
        
    }
    
    public void initializeProgramareActProfPanel(){
        ArrayList<String> queryData = new ArrayList<String>();
        queryData = bdconn.getCoursesProf();
        programareActivitateProfesorPanel.updateListaCursuriProf(queryData);
        
        ArrayList<Integer> queryDataCLS = new ArrayList<Integer>();
        queryDataCLS = bdconn.getCursLabSem();
        
        if (queryDataCLS.get(0) == 0)
            programareActivitateProfesorPanel.buttonProgramareCurs.setEnabled(false);
        
        if (queryDataCLS.get(1) == 0)
            programareActivitateProfesorPanel.buttonProgramareLab.setEnabled(false);
        
        if (queryDataCLS.get(2) == 0)
            programareActivitateProfesorPanel.buttonProgramareSeminar.setEnabled(false);
        
        }
    
    public void initializeCursuriProf(){
        ArrayList<String> queryData = new ArrayList<>();
        queryData = bdconn.getCoursesProf();
        cursuriProfPanel.updateListaCursuriProf(queryData);
        
    }
    
    public void changePanel(String stringPanel){
        cardLayout.show(userFrame.mainPanel, stringPanel);
        userFrame.pack();
        /* 
        
        userFrame.mainPanel.add(profesorHomePanel, "profesorhomepanel");
        userFrame.mainPanel.add(vizDateProfesorPanel, "vizdateprofesorpanel");
        userFrame.mainPanel.add(invitatiiProfesorPanel, "invitatiiprofesorpanel");
        userFrame.mainPanel.add(vizActivitatiProfesorPanel, "vizactivitatiprofesoripanel");
        userFrame.mainPanel.add(catalogProfesorPanel, "catalogprofesorpanel"); 
        userFrame.mainPanel.add(cursuriProfPanel, "cursuriprofpanel");
        userFrame.mainPanel.add(programareActivitateProfesorPanel, "programareactivitateprofesorpanel");
        
        */
        
        switch(stringPanel){
            case "profesorhomepanel":
                userFrame.setSize(profesorHomePanel.getPreferredSize());
                break;
            case "vizdateprofesorpanel":
                userFrame.setSize(vizDateProfesorPanel.getPreferredSize());
                break;
            case "invitatiiprofesorpanel":
                userFrame.setSize(invitatiiProfesorPanel.getPreferredSize());
                break;
            case "vizactivitatiprofesoripanel":
                userFrame.setSize(vizActivitatiProfesorPanel.getPreferredSize());
                break;
            case "catalogprofesorpanel":
                userFrame.setSize(catalogProfesorPanel.getPreferredSize());
                break;
            case "cursuriprofpanel":
                userFrame.setSize(cursuriProfPanel.getPreferredSize());
                break;
            case "programareactivitateprofesorpanel":
                userFrame.setSize(programareActivitateProfesorPanel.getPreferredSize());
                break;
                
        }
        
    }
    
    public void resetView(){
        cardLayout.show(userFrame.mainPanel, "profesorhomepanel");
        userFrame.setSize(profesorHomePanel.getPreferredSize());
        userFrame.setVisible(true);
    }
    public void setCurrentUser(User currentUser){
        this.currentUser = currentUser;
    }
    
    
    public void hideView(){
        userFrame.setVisible(false);
    }
    
    public void updateVizDatePanel(){
        currentUser = bdconn.getUserInformation();
        vizDateProfesorPanel.numeField.setText(currentUser.nume);
        vizDateProfesorPanel.prenumeField.setText(currentUser.prenume);
        vizDateProfesorPanel.usernameField.setText(currentUser.username);
        vizDateProfesorPanel.cnpField.setText(currentUser.CNP);
        vizDateProfesorPanel.adresaField.setText(currentUser.adresa);
        vizDateProfesorPanel.nrtelefonField.setText(currentUser.nr_telefon);
        vizDateProfesorPanel.emailField.setText(currentUser.email);
        vizDateProfesorPanel.nrcontractField.setText(currentUser.nr_contract);
        vizDateProfesorPanel.departamentField.setText(((Profesor)currentUser).departament);
        vizDateProfesorPanel.nrOreMinField.setText(Integer.toString(((Profesor)currentUser).min_ore));
        vizDateProfesorPanel.nrOreMaxField.setText(Integer.toString(((Profesor)currentUser).max_ore));
      
    }
    
    
    public void getActivitatiZiuaCurentaProfesor(){
        String[][] queryData = new String[10][4];
        queryData = bdconn.getCurrentDayActivProfesor();

        DefaultTableModel model = (DefaultTableModel) vizActivitatiProfesorPanel.tabelActivitatiCurent.getModel();
        model.setRowCount(0);

        for(int i = 0; i < queryData.length && queryData[i][0] != null; i++)
            model.addRow(queryData[i]);
    }

    public void getActivitatiProfesor(){
        String[][] activitati = new String[30][5];
        ArrayList<Activitate> queryData = bdconn.getActivitatiProfesor();

        vizActivitatiProfesorPanel.activitati = queryData;
        
        DefaultTableModel model = (DefaultTableModel) vizActivitatiProfesorPanel.TabelActivitatiTotal.getModel();
        model.setRowCount(0);

        for(int i = 0; i < queryData.size(); i++){
            activitati[i][0] = queryData.get(i).numeCurs;
            activitati[i][1] = queryData.get(i).tipActivitate;
            activitati[i][2] = queryData.get(i).oraString;
            activitati[i][3] = Integer.toString(queryData.get(i).durata);
            activitati[i][4] = queryData.get(i).zi;
        }
        
        for(int i = 0; i < activitati.length && activitati[i][0] != null; i++)
            model.addRow(activitati[i]);
    }

    public void getCursuriProfesori(){
        ArrayList<String> queryData = bdconn.getCursuriProfesor();
        DefaultListModel model =  (DefaultListModel) catalogProfesorPanel.cursListModel;
        model.removeAllElements();
        for(int i = 0; i < queryData.size(); i++){
            model.addElement(queryData.get(i));
        }
    }

    public void getStudentiProfesori(String curs){
        String[][] queryData = bdconn.getStudentiProfesor(curs);

        DefaultTableModel model = (DefaultTableModel) catalogProfesorPanel.tableStudenti.getModel();
        model.setRowCount(0);

        for(int i = 0; i < queryData.length && queryData[i][0] != null; i++){
            model.addRow(queryData[i]);
        } 
        model.fireTableDataChanged();
    }

    
    // profesor panel listeners dari
    class VizActivitatiProfesorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            getActivitatiZiuaCurentaProfesor();
            getActivitatiProfesor();
            changePanel("vizactivitatiprofesoripanel");
        }
    }

    class UpdateActivProfesorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
                String data[] = new String[5];
                int rowCount = vizActivitatiProfesorPanel.TabelActivitatiTotal.getRowCount();
                for(int j = 0; j < rowCount; j++)
                {
                    for(int i = 0; i < 5; i++){
                        data[i] = (String) vizActivitatiProfesorPanel.TabelActivitatiTotal.getModel().getValueAt(j,i);
                    }
                    int idActiv = vizActivitatiProfesorPanel.activitati.get(j).id_activ;
                    bdconn.updateActivitatiProfesor(data, idActiv);
                }
          
            }
            
        }
        
    
    // prof panel listener denis
    class ProgramareActivitatiProfListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeProgramareActProfPanel();
            changePanel("programareactivitateprofesorpanel");
        }
    }
    
    class CursuriProfListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            initializeCursuriProf();
            changePanel("cursuriprofpanel");
        }
               
    }
    
    class CursuriSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                //String cursNume = cursuriProfPanel.listaCursuri.getSelectedValue();
                if(!cursuriProfPanel.listaCursuri.isSelectionEmpty())
                    updateCursuriProfPanel();
            }
            catch(IndexOutOfBoundsException ex){
            }
        }
    }
    
    class SalvareModificariListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            ArrayList<Double> ponderi = new ArrayList<Double>();
            String str1 = cursuriProfPanel.fieldPondereCurs.getText();
            String str2 = cursuriProfPanel.fieldPondereLab.getText();
            String str3 = cursuriProfPanel.fieldPondereSeminar.getText();
            ponderi.add(Double.parseDouble(str1));
            ponderi.add(Double.parseDouble(str2));
            ponderi.add(Double.parseDouble(str3));
            
            String cursNume = cursuriProfPanel.listaCursuri.getSelectedValue();

            if(ponderi.get(0) + ponderi.get(1) + ponderi.get(2) == 1)
                {
                    bdconn.insertPonderi(currentUser.username, cursNume, ponderi);
                    cursuriProfPanel.errorLabel.setForeground(Color.black);
                    cursuriProfPanel.errorLabel.setText("Modificarile au fost salvate cu succes!");
                }
            else{
                cursuriProfPanel.errorLabel.setForeground(Color.red);
                cursuriProfPanel.errorLabel.setText("Asigurati-va ca suma ponderilor este 1!");
                
            }
        }
    }
    
    class ProgramareCursListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = programareActivitateProfesorPanel.getAllFieldsCurs();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    toExit = true;
                }
            }
            if(toExit == false)    {
                    String numeCurs = programareActivitateProfesorPanel.listaCursuriProfesor.getSelectedValue();
                    int idAsignProfCurs = bdconn.getIDAsignProfCurs(numeCurs);
                    bdconn.InsertActivitateProf(textFields, "curs", idAsignProfCurs);
            }
            if(toExit) return;
        }
    }
    
    class ProgramareLaboratorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = programareActivitateProfesorPanel.getAllFieldsLab();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    toExit = true;
                }
            }
            if(toExit == false)    {
                    String numeCurs = programareActivitateProfesorPanel.listaCursuriProfesor.getSelectedValue();
                    int idAsignProfCurs = bdconn.getIDAsignProfCurs(numeCurs);
                    bdconn.InsertActivitateProf(textFields, "laborator", idAsignProfCurs);
            }
            if(toExit) return;
        }
    }
    
    class ProgramareSeminarListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = programareActivitateProfesorPanel.getAllFieldsSeminar();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    toExit = true;
                }
            }
            if(toExit == false)    {
                    String numeCurs = programareActivitateProfesorPanel.listaCursuriProfesor.getSelectedValue();
                    int idAsignProfCurs = bdconn.getIDAsignProfCurs(numeCurs);
                    bdconn.InsertActivitateProf(textFields, "seminar", idAsignProfCurs);
            }
            if(toExit) return;
        }
    }
    
    class ProgramareExamenListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            boolean toExit = false;
            JTextField textFields[] = programareActivitateProfesorPanel.getAllFieldsExamen();
            for(JTextField f : textFields){
                if(f.getText().equals("")){
                    f.setBorder(new LineBorder(Color.red, 1, true));
                    toExit = true;
                }
            }
            if(toExit == false)    {
                    String numeCurs = programareActivitateProfesorPanel.listaCursuriProfesor.getSelectedValue();
                    int idAsignProfCurs = bdconn.getIDAsignProfCurs(numeCurs);
                    String tip = programareActivitateProfesorPanel.tipExamen();
                    bdconn.InsertActivitateProf(textFields, tip, idAsignProfCurs);
            }
            if(toExit) return;
        }
    }

    //Catalog Profesor

    class CatalogListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            getCursuriProfesori();
            changePanel("catalogprofesorpanel");
        }
    }

    class CursSelectionListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            try{
                
                String curs = catalogProfesorPanel.listCurs.getSelectedValue();
                catalogProfesorPanel.nume_curs = curs;
                getStudentiProfesori(curs);
            }
            catch(IndexOutOfBoundsException ex){
            }

        }
    }

    class UpdateNoteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            DefaultTableModel model = (DefaultTableModel) catalogProfesorPanel.tableStudenti.getModel();
            int rowCount = model.getRowCount();
            for(int i = 0; i < rowCount; i++){
                String data[] = new String[8];
                for(int j = 0; j < 7; j++){
                    data[j] = (String) catalogProfesorPanel.tableStudenti.getValueAt(i,j);
                }
                data[7] = catalogProfesorPanel.nume_curs;
                bdconn.updateNoteCatalog(data);
            }
            
            getStudentiProfesori(catalogProfesorPanel.listCurs.getSelectedValue());

        }
    }
    
    
    
    // --------------- BUTTONS ACTION LISTENERS -------------------
    
    public void updateInvitatiiPanel(){
        invitatiiProfesorPanel.invitatii = bdconn.getProfessorGroupInvites();
        
        DefaultTableModel model = (DefaultTableModel)invitatiiProfesorPanel.invitatiiTable.getModel();
           model.setRowCount(0);
           
           // sortam row dupa nume curs;
           // TO DO
           
           for(int i = 0; i < invitatiiProfesorPanel.invitatii.size(); i++){
               model.addRow(new Object[]{invitatiiProfesorPanel.invitatii.get(i).tipActivitate, 
                   invitatiiProfesorPanel.invitatii.get(i).start_date,
                   invitatiiProfesorPanel.invitatii.get(i).ora,
               invitatiiProfesorPanel.invitatii.get(i).durata});
           }
    }
    
    
    // MAIN PANEL
    
    class LogoutButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            viewController.switchToLoginScreen();
        }
    }
    
    class VizDateProfesorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            updateVizDatePanel();
            changePanel("vizdateprofesorpanel");
        }
    } 
    
    class VizInvitatiiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            updateInvitatiiPanel();
            changePanel("invitatiiprofesorpanel");
        }
    } 
    
    // VIZ DATE PANEL
    
    class BackToHomePanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            changePanel("profesorhomepanel");
        }
    }
    
    // Invitatii profesor listeners
    
    class AcceptInviteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index = invitatiiProfesorPanel.invitatiiTable.getSelectedRow();
            int idActiv = invitatiiProfesorPanel.invitatii.get(index).id_activ;
            bdconn.inscriereUserLaActivitate(idActiv);
            bdconn.deleteInviteProfesorGrupa(currentUser.username, idActiv);
            
            updateInvitatiiPanel();
        }
    }
    
    
}
