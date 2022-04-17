/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UIPackage;

import BDProjectv7.StudentViewController;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Denis
 */
public class VizualizareGrupaPanel extends javax.swing.JPanel {

    
    public DefaultListModel listaParticipantiGrupaModel;
    public DefaultListModel sugestiiParticipantiModel;
    
    public ArrayList<String> participanti;
    public ArrayList<ArrayList<String>> mesaje;
    public ArrayList<ArrayList<String>> sugestiiParticipanti;
    
    public int numarDeSugestii = 5;
    
    public VizualizareGrupaPanel(ActionListener VizualizareGrupaStudiuListener, ActionListener ProgramareActivitateSwitchListener, 
            ActionListener SendMSGListener, ActionListener sendInviteListener, ActionListener ParasireGrupListener) {
        initComponents();
        listaParticipantiGrupaModel = new DefaultListModel();
        sugestiiParticipantiModel = new DefaultListModel();
        buttonIntoarcere.addActionListener(VizualizareGrupaStudiuListener);
        buttonProgramareActivitate.addActionListener(ProgramareActivitateSwitchListener);
        inviteButton.addActionListener(sendInviteListener);
        parasireGrupButton.addActionListener(ParasireGrupListener);
        
        listaParticipantiGrupa.setModel(listaParticipantiGrupaModel);
        sugestiiPartList.setModel(sugestiiParticipantiModel);
        buttonSendMSG.addActionListener(SendMSGListener);
    }
    
    public void updateParticipantiGrupa(ArrayList<String> data){
        listaParticipantiGrupaModel.removeAllElements();
        participanti= data;

        for (int i = 0; i < participanti.size(); i++) {
            listaParticipantiGrupaModel.addElement(participanti.get(i));
        }
    }
    
    public void updateSugestiiGrupa(){
        sugestiiParticipantiModel.removeAllElements();
        
        int i = 0;
        while(i < sugestiiParticipanti.size() && i < numarDeSugestii){
            sugestiiParticipantiModel.addElement(sugestiiParticipanti.get(i).get(1) + " " + sugestiiParticipanti.get(i).get(2));
            i++;
        }
    }
    
    public void updateChatGrupa(ArrayList<ArrayList<String>> data){
        mesaje = data;
        DefaultTableModel model = (DefaultTableModel) tabelChatGrupa.getModel();
        model.setRowCount(0);

        for(int i = 0 ; i < mesaje.size(); i++){
            String var[] = new String[2];
            ArrayList<String> messageEntity = mesaje.get(i);
            String username = messageEntity.get(0);
            String usernameMessage = messageEntity.get(1);
           
           
            model.addRow(new String[]{username, usernameMessage});
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaParticipantiGrupa = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelChatGrupa = new javax.swing.JTable();
        textFieldMSG = new javax.swing.JTextField();
        buttonSendMSG = new javax.swing.JButton();
        buttonProgramareActivitate = new javax.swing.JButton();
        buttonIntoarcere = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sugestiiPartList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        inviteButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        parasireGrupButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        listaParticipantiGrupa.setSelectionBackground(new java.awt.Color(66, 71, 72));
        listaParticipantiGrupa.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(listaParticipantiGrupa);

        jLabel1.setForeground(new java.awt.Color(66, 71, 72));
        jLabel1.setText("Participanti grupa");

        tabelChatGrupa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "Mesaj"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelChatGrupa.setSelectionBackground(new java.awt.Color(66, 71, 72));
        tabelChatGrupa.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tabelChatGrupa);
        if (tabelChatGrupa.getColumnModel().getColumnCount() > 0) {
            tabelChatGrupa.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        buttonSendMSG.setBackground(new java.awt.Color(66, 71, 72));
        buttonSendMSG.setForeground(new java.awt.Color(255, 255, 255));
        buttonSendMSG.setText("Trimite");
        buttonSendMSG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendMSGActionPerformed(evt);
            }
        });

        buttonProgramareActivitate.setBackground(new java.awt.Color(66, 71, 72));
        buttonProgramareActivitate.setForeground(new java.awt.Color(255, 255, 255));
        buttonProgramareActivitate.setText("Programeaza o activitate");

        buttonIntoarcere.setBackground(new java.awt.Color(66, 71, 72));
        buttonIntoarcere.setForeground(new java.awt.Color(255, 255, 255));
        buttonIntoarcere.setText("Intoarcere");
        buttonIntoarcere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIntoarcereActionPerformed(evt);
            }
        });

        sugestiiPartList.setSelectionBackground(new java.awt.Color(66, 71, 72));
        sugestiiPartList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(sugestiiPartList);

        jLabel2.setForeground(new java.awt.Color(66, 71, 72));
        jLabel2.setText("Sugestii participanti");

        inviteButton.setBackground(new java.awt.Color(66, 71, 72));
        inviteButton.setForeground(new java.awt.Color(255, 255, 255));
        inviteButton.setText("Invita");

        parasireGrupButton.setBackground(new java.awt.Color(66, 71, 72));
        parasireGrupButton.setForeground(new java.awt.Color(255, 255, 255));
        parasireGrupButton.setText("Parasire Grup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonIntoarcere, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(parasireGrupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonProgramareActivitate, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(inviteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldMSG, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSendMSG)))))
                .addGap(87, 87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIntoarcere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProgramareActivitate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(parasireGrupButton))
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldMSG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSendMSG)
                    .addComponent(inviteButton))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendMSGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendMSGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSendMSGActionPerformed

    private void buttonIntoarcereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIntoarcereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIntoarcereActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonIntoarcere;
    public javax.swing.JButton buttonProgramareActivitate;
    public javax.swing.JButton buttonSendMSG;
    public javax.swing.JButton inviteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JList<String> listaParticipantiGrupa;
    private javax.swing.JButton parasireGrupButton;
    public javax.swing.JList<String> sugestiiPartList;
    public javax.swing.JTable tabelChatGrupa;
    public javax.swing.JTextField textFieldMSG;
    // End of variables declaration//GEN-END:variables
}