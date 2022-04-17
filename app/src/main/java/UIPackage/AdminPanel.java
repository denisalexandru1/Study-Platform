
package UIPackage;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author dari
 */
public class AdminPanel extends javax.swing.JPanel {

    public String[] userUsername;
    public String[] profesorUsername;
    public String[] studentUsername;
    public DefaultListModel allUserListModel;
    public DefaultListModel cursListModel;
    public DefaultListModel profListModel;
    public DefaultListModel studentListModel;
    public DefaultListModel grupaStudiuListModel;
    
    public ArrayList<Integer> grupeStudiu;
    

    public AdminPanel(ActionListener logoutButtonListener, ActionListener SelectButtonListener, ActionListener ComboBoxListener, 
ListSelectionListener UserSelectionListener, ActionListener SaveDateListener, ListSelectionListener CursSelectionListener, ListSelectionListener ProfSelectionListener, 
ActionListener AddProfesorToCurs, ActionListener AddNewCursListener, ActionListener DeleteStudentFromCursListener, ActionListener DeleteProfesorFromCursListener, 
ActionListener DeleteCursListener, ActionListener DeleteUserListener, ActionListener AddStudentToCursListener, ActionListener DeleteGrupaStudiuListener) {
        initComponents();

        
        buttonLogOut.addActionListener(logoutButtonListener);
        buttonSelect.addActionListener(SelectButtonListener);
        buttonSaveDate.addActionListener(SaveDateListener);
        buttonAddProf.addActionListener(AddProfesorToCurs);
        buttonAddCurs.addActionListener(AddNewCursListener);
        buttonDeleteStudent.addActionListener(DeleteStudentFromCursListener);
        buttonDeleteProfesor.addActionListener(DeleteProfesorFromCursListener);
        buttonDeleteCurs.addActionListener(DeleteCursListener);
        buttonDeleteUser.addActionListener(DeleteUserListener);
        buttonAddStudent.addActionListener(AddStudentToCursListener);
        buttonDeleteGrupa.addActionListener(DeleteGrupaStudiuListener);
        jComboBox1.addActionListener(ComboBoxListener);

        allUserListModel = new DefaultListModel();
        allUserList.setModel(allUserListModel);
        cursListModel = new DefaultListModel();
        cursList.setModel(cursListModel);
        profListModel = new DefaultListModel();
        profList.setModel(profListModel);
        studentListModel = new DefaultListModel();
        studentList.setModel(studentListModel);
        grupaStudiuListModel = new DefaultListModel();
        grupaStudiuList.setModel(grupaStudiuListModel);

        userUsername = new String[100];
        profesorUsername = new String[100];
        studentUsername = new String[100];

        allUserList.getSelectionModel().addListSelectionListener(UserSelectionListener);
        cursList.getSelectionModel().addListSelectionListener(CursSelectionListener);
        profList.getSelectionModel().addListSelectionListener(ProfSelectionListener);
    }

    public String[] getAllFields(){
        String[] fieldArray = new String[10];
        fieldArray[0] = dataField1.getText();
        fieldArray[1] = dataField2.getText();
        fieldArray[2] = dataField3.getText();
        fieldArray[3] = dataField4.getText();
        fieldArray[4] = dataField5.getText();
        fieldArray[5] = dataField6.getText();
        fieldArray[6] = dataField7.getText();
        fieldArray[7] = dataField8.getText();
        fieldArray[8] = dataField9.getText();
        fieldArray[9] = dataField10.getText();
        return fieldArray;
    }

    public void setAllFields(String[] fieldArray){
        dataField1.setText(fieldArray[0]);
        dataField2.setText(fieldArray[1]);
        dataField3.setText(fieldArray[2]);
        dataField4.setText(fieldArray[3]);
        dataField5.setText(fieldArray[4]);
        dataField6.setText(fieldArray[5]);
        dataField7.setText(fieldArray[6]);
        dataField8.setText(fieldArray[7]);
        dataField9.setText(fieldArray[8]);
        dataField10.setText(fieldArray[9]);
    }

    public void setAllFieldsZero(){
        dataField1.setText(" ");
        dataField2.setText(" ");
        dataField3.setText(" ");
        dataField4.setText(" ");
        dataField5.setText(" ");
        dataField6.setText(" ");
        dataField7.setText(" ");
        dataField8.setText(" ");
        dataField9.setText(" ");
        dataField10.setText(" ");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonLogOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldNume = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dataField4 = new javax.swing.JTextField();
        dataField3 = new javax.swing.JTextField();
        dataField2 = new javax.swing.JTextField();
        dataField5 = new javax.swing.JTextField();
        dataField6 = new javax.swing.JTextField();
        dataField7 = new javax.swing.JTextField();
        dataField8 = new javax.swing.JTextField();
        dataField9 = new javax.swing.JTextField();
        dataField1 = new javax.swing.JTextField();
        dataField10 = new javax.swing.JTextField();
        buttonSaveDate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cursList = new javax.swing.JList<>();
        buttonAddCurs = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        profList = new javax.swing.JList<>();
        buttonAddProf = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        addProfesorField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentList = new javax.swing.JList<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane5 = new javax.swing.JScrollPane();
        allUserList = new javax.swing.JList<>();
        fieldPrenume = new javax.swing.JTextField();
        buttonSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMesaj = new javax.swing.JTextArea();
        nrMaxStudentiField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        numeCursField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        buttonDeleteUser = new javax.swing.JButton();
        checkBoxCurs = new javax.swing.JCheckBox();
        checkBoxSeminar = new javax.swing.JCheckBox();
        checkBoxLab = new javax.swing.JCheckBox();
        buttonDeleteStudent = new javax.swing.JButton();
        buttonDeleteProfesor = new javax.swing.JButton();
        buttonDeleteCurs = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        buttonAddStudent = new javax.swing.JButton();
        addStudentToCursField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        grupaStudiuList = new javax.swing.JList<>();
        buttonDeleteGrupa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        buttonLogOut.setBackground(new java.awt.Color(66, 71, 72));
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Log Out ");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 71, 72));
        jLabel1.setText("Interfata Administratorului");

        jLabel2.setForeground(new java.awt.Color(66, 71, 72));
        jLabel2.setText("Selecteaza un utilizator dupa nume:");

        fieldNume.setBackground(new java.awt.Color(66, 71, 72));
        fieldNume.setForeground(new java.awt.Color(255, 255, 255));
        fieldNume.setText("Nume");
        fieldNume.setBorder(null);
        fieldNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNumeActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Alege tipul utilizatorului", "Student", "Profesor"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(66, 71, 72));
        jLabel5.setText("Selecteaza un utilizator din list:");

        jLabel6.setForeground(new java.awt.Color(66, 71, 72));
        jLabel6.setText("Date personale:");

        jLabel3.setForeground(new java.awt.Color(66, 71, 72));
        jLabel3.setText("Username:");

        jLabel4.setForeground(new java.awt.Color(66, 71, 72));
        jLabel4.setText("Password:");

        jLabel7.setForeground(new java.awt.Color(66, 71, 72));
        jLabel7.setText("Nume:");

        jLabel8.setForeground(new java.awt.Color(66, 71, 72));
        jLabel8.setText("Prenume:");

        jLabel9.setForeground(new java.awt.Color(66, 71, 72));
        jLabel9.setText("Contract:");

        jLabel10.setForeground(new java.awt.Color(66, 71, 72));
        jLabel10.setText("CNP:");

        jLabel11.setForeground(new java.awt.Color(66, 71, 72));
        jLabel11.setText("Adresa:");

        jLabel12.setForeground(new java.awt.Color(66, 71, 72));
        jLabel12.setText("Nr Telefon:");

        jLabel13.setForeground(new java.awt.Color(66, 71, 72));
        jLabel13.setText("Email:");

        jLabel14.setForeground(new java.awt.Color(66, 71, 72));
        jLabel14.setText("IBAN:");

        dataField4.setBackground(new java.awt.Color(66, 71, 72));
        dataField4.setForeground(new java.awt.Color(255, 255, 255));
        dataField4.setBorder(null);

        dataField3.setBackground(new java.awt.Color(66, 71, 72));
        dataField3.setForeground(new java.awt.Color(255, 255, 255));
        dataField3.setBorder(null);

        dataField2.setBackground(new java.awt.Color(66, 71, 72));
        dataField2.setForeground(new java.awt.Color(255, 255, 255));
        dataField2.setBorder(null);

        dataField5.setBackground(new java.awt.Color(66, 71, 72));
        dataField5.setForeground(new java.awt.Color(255, 255, 255));
        dataField5.setBorder(null);

        dataField6.setBackground(new java.awt.Color(66, 71, 72));
        dataField6.setForeground(new java.awt.Color(255, 255, 255));
        dataField6.setBorder(null);

        dataField7.setBackground(new java.awt.Color(66, 71, 72));
        dataField7.setForeground(new java.awt.Color(255, 255, 255));
        dataField7.setBorder(null);

        dataField8.setBackground(new java.awt.Color(66, 71, 72));
        dataField8.setForeground(new java.awt.Color(255, 255, 255));
        dataField8.setBorder(null);

        dataField9.setBackground(new java.awt.Color(66, 71, 72));
        dataField9.setForeground(new java.awt.Color(255, 255, 255));
        dataField9.setBorder(null);

        dataField1.setBackground(new java.awt.Color(66, 71, 72));
        dataField1.setForeground(new java.awt.Color(255, 255, 255));
        dataField1.setBorder(null);
        dataField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataField1ActionPerformed(evt);
            }
        });

        dataField10.setBackground(new java.awt.Color(66, 71, 72));
        dataField10.setForeground(new java.awt.Color(255, 255, 255));
        dataField10.setBorder(null);

        buttonSaveDate.setBackground(new java.awt.Color(66, 71, 72));
        buttonSaveDate.setForeground(new java.awt.Color(255, 255, 255));
        buttonSaveDate.setText("Salveaza modificariile");
        buttonSaveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveDateActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(66, 71, 72));
        jLabel15.setText("Selecteaza un curs:");

        cursList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        cursList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        cursList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(cursList);

        buttonAddCurs.setBackground(new java.awt.Color(66, 71, 72));
        buttonAddCurs.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddCurs.setText("Adauga curs");
        buttonAddCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCursActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(66, 71, 72));
        jLabel16.setText("Profesori la cursul selectat:");

        profList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        profList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        profList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(profList);

        buttonAddProf.setBackground(new java.awt.Color(66, 71, 72));
        buttonAddProf.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddProf.setText("Asigneaza profesor");
        buttonAddProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProfActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(66, 71, 72));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Asigneaza un profesor:");

        addProfesorField.setBackground(new java.awt.Color(66, 71, 72));
        addProfesorField.setForeground(new java.awt.Color(255, 255, 255));
        addProfesorField.setBorder(null);
        addProfesorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfesorFieldActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(66, 71, 72));
        jLabel18.setText("Studenti:");

        studentList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        studentList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        studentList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(studentList);

        allUserList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        allUserList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        allUserList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(allUserList);

        fieldPrenume.setBackground(new java.awt.Color(66, 71, 72));
        fieldPrenume.setForeground(new java.awt.Color(255, 255, 255));
        fieldPrenume.setText("Prenume");
        fieldPrenume.setBorder(null);

        buttonSelect.setBackground(new java.awt.Color(66, 71, 72));
        buttonSelect.setForeground(new java.awt.Color(255, 255, 255));
        buttonSelect.setText("Selecteaza");

        textMesaj.setBackground(new java.awt.Color(66, 71, 72));
        textMesaj.setColumns(20);
        textMesaj.setForeground(new java.awt.Color(255, 255, 255));
        textMesaj.setRows(5);
        textMesaj.setBorder(null);
        jScrollPane1.setViewportView(textMesaj);

        nrMaxStudentiField.setBackground(new java.awt.Color(66, 71, 72));
        nrMaxStudentiField.setForeground(new java.awt.Color(255, 255, 255));
        nrMaxStudentiField.setText("Nr. maxim de studenti");
        nrMaxStudentiField.setBorder(null);
        nrMaxStudentiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrMaxStudentiFieldActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(66, 71, 72));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Adauga un nou curs:");

        numeCursField.setBackground(new java.awt.Color(66, 71, 72));
        numeCursField.setForeground(new java.awt.Color(255, 255, 255));
        numeCursField.setText("Nume Curs");
        numeCursField.setBorder(null);

        jLabel20.setForeground(new java.awt.Color(66, 71, 72));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Descrierea cursului:");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel21.setForeground(new java.awt.Color(66, 71, 72));
        jLabel21.setText("Username:");

        buttonDeleteUser.setBackground(new java.awt.Color(66, 71, 72));
        buttonDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteUser.setText("Sterge utilizatorul");
        buttonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteUserActionPerformed(evt);
            }
        });

        checkBoxCurs.setBackground(new java.awt.Color(255, 148, 96));
        checkBoxCurs.setForeground(new java.awt.Color(66, 71, 72));
        checkBoxCurs.setText("Curs");
        checkBoxCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCursActionPerformed(evt);
            }
        });

        checkBoxSeminar.setBackground(new java.awt.Color(255, 148, 96));
        checkBoxSeminar.setForeground(new java.awt.Color(66, 71, 72));
        checkBoxSeminar.setText("Seminar");
        checkBoxSeminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSeminarActionPerformed(evt);
            }
        });

        checkBoxLab.setBackground(new java.awt.Color(255, 148, 96));
        checkBoxLab.setForeground(new java.awt.Color(66, 71, 72));
        checkBoxLab.setText("Laborator");

        buttonDeleteStudent.setBackground(new java.awt.Color(66, 71, 72));
        buttonDeleteStudent.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteStudent.setText("Sterge studentul din curs");

        buttonDeleteProfesor.setBackground(new java.awt.Color(66, 71, 72));
        buttonDeleteProfesor.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteProfesor.setText("Sterge profesorul din curs");
        buttonDeleteProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteProfesorActionPerformed(evt);
            }
        });

        buttonDeleteCurs.setBackground(new java.awt.Color(66, 71, 72));
        buttonDeleteCurs.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteCurs.setText("Sterge cursul");

        jLabel22.setForeground(new java.awt.Color(66, 71, 72));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Asigneaza un student");

        buttonAddStudent.setBackground(new java.awt.Color(66, 71, 72));
        buttonAddStudent.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddStudent.setText("Asigneaza student");
        buttonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddStudentActionPerformed(evt);
            }
        });

        addStudentToCursField.setBackground(new java.awt.Color(66, 71, 72));
        addStudentToCursField.setForeground(new java.awt.Color(255, 255, 255));
        addStudentToCursField.setBorder(null);

        jLabel23.setForeground(new java.awt.Color(66, 71, 72));
        jLabel23.setText("Username:");

        jLabel24.setForeground(new java.awt.Color(66, 71, 72));
        jLabel24.setText("Grupele de studiu");

        grupaStudiuList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        grupaStudiuList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        grupaStudiuList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(grupaStudiuList);

        buttonDeleteGrupa.setBackground(new java.awt.Color(66, 71, 72));
        buttonDeleteGrupa.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteGrupa.setText("Sterge grupul de studiu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonLogOut)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fieldNume, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldPrenume))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(numeCursField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nrMaxStudentiField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                            .addComponent(buttonAddCurs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonDeleteCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(jLabel18)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonDeleteProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonDeleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAddProf, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonAddStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addProfesorField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addStudentToCursField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(checkBoxCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(checkBoxSeminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(checkBoxLab, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane4)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dataField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dataField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel6))
                                    .addComponent(buttonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane6)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(buttonDeleteGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(buttonLogOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dataField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addComponent(buttonSaveDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeleteUser))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldNume, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonSelect)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3)
                                        .addGap(6, 6, 6)))
                                .addComponent(jLabel17)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(numeCursField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel23))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(nrMaxStudentiField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(addProfesorField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(addStudentToCursField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(35, 35, 35))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(buttonAddCurs)
                                                        .addComponent(buttonAddStudent)
                                                        .addComponent(buttonAddProf))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(checkBoxCurs)
                                            .addComponent(checkBoxSeminar)
                                            .addComponent(checkBoxLab)
                                            .addComponent(jLabel22))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(buttonDeleteCurs)
                                                    .addComponent(buttonDeleteStudent)
                                                    .addComponent(buttonDeleteProfesor))))
                                        .addGap(35, 35, 35))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6))
                                .addGap(18, 18, 18)
                                .addComponent(buttonDeleteGrupa)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(46, 46, 46)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLogOutActionPerformed

    private void fieldNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNumeActionPerformed

    private void dataField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataField1ActionPerformed

    private void buttonSaveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSaveDateActionPerformed

    private void addProfesorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProfesorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProfesorFieldActionPerformed

    private void buttonAddCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddCursActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void nrMaxStudentiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrMaxStudentiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nrMaxStudentiFieldActionPerformed

    private void buttonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDeleteUserActionPerformed

    private void checkBoxSeminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSeminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSeminarActionPerformed

    private void checkBoxCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxCursActionPerformed

    private void buttonAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddStudentActionPerformed

    private void buttonDeleteProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDeleteProfesorActionPerformed

    private void buttonAddProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddProfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField addProfesorField;
    public javax.swing.JTextField addStudentToCursField;
    public javax.swing.JList<String> allUserList;
    public javax.swing.JButton buttonAddCurs;
    public javax.swing.JButton buttonAddProf;
    public javax.swing.JButton buttonAddStudent;
    private javax.swing.JButton buttonDeleteCurs;
    public javax.swing.JButton buttonDeleteGrupa;
    private javax.swing.JButton buttonDeleteProfesor;
    private javax.swing.JButton buttonDeleteStudent;
    private javax.swing.JButton buttonDeleteUser;
    public javax.swing.JButton buttonLogOut;
    public javax.swing.JButton buttonSaveDate;
    public javax.swing.JButton buttonSelect;
    public javax.swing.JCheckBox checkBoxCurs;
    public javax.swing.JCheckBox checkBoxLab;
    public javax.swing.JCheckBox checkBoxSeminar;
    public javax.swing.JList<String> cursList;
    public javax.swing.JTextField dataField1;
    public javax.swing.JTextField dataField10;
    public javax.swing.JTextField dataField2;
    public javax.swing.JTextField dataField3;
    public javax.swing.JTextField dataField4;
    public javax.swing.JTextField dataField5;
    public javax.swing.JTextField dataField6;
    public javax.swing.JTextField dataField7;
    public javax.swing.JTextField dataField8;
    public javax.swing.JTextField dataField9;
    public javax.swing.JTextField fieldNume;
    public javax.swing.JTextField fieldPrenume;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    public javax.swing.JList<String> grupaStudiuList;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTextField nrMaxStudentiField;
    public javax.swing.JTextField numeCursField;
    public javax.swing.JList<String> profList;
    public javax.swing.JList<String> studentList;
    public javax.swing.JTextArea textMesaj;
    // End of variables declaration//GEN-END:variables
}
