
package UIPackage;

import BDProjectv7.Activitate;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dari
 */
public class VizActivitatiProfesorPanel extends javax.swing.JPanel {

     public ArrayList<Activitate> activitati;
    
    public VizActivitatiProfesorPanel(ActionListener backToHomePanelListener, ActionListener UpdateActivProfesorListener) {
        initComponents();
        buttonReturn.addActionListener(backToHomePanelListener);
        buttonSave.addActionListener(UpdateActivProfesorListener);
    }
    
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelActivitatiCurent = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelActivitatiTotal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        jLabel1.setForeground(new java.awt.Color(66, 71, 72));
        jLabel1.setText("Activitatiile in ziua curenta");

        jLabel2.setForeground(new java.awt.Color(66, 71, 72));
        jLabel2.setText("Toate activitatiile");

        tabelActivitatiCurent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Tip activitate", "Ora", "Durata"
            }
        ));
        tabelActivitatiCurent.setSelectionBackground(new java.awt.Color(66, 71, 72));
        tabelActivitatiCurent.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tabelActivitatiCurent);
        if (tabelActivitatiCurent.getColumnModel().getColumnCount() > 0) {
            tabelActivitatiCurent.getColumnModel().getColumn(0).setResizable(false);
            tabelActivitatiCurent.getColumnModel().getColumn(1).setResizable(false);
            tabelActivitatiCurent.getColumnModel().getColumn(2).setResizable(false);
            tabelActivitatiCurent.getColumnModel().getColumn(3).setResizable(false);
        }

        TabelActivitatiTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Disciplina", "Tip activitate", "Ora", "Durata", "Ziua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelActivitatiTotal.setSelectionBackground(new java.awt.Color(66, 71, 72));
        TabelActivitatiTotal.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabelActivitatiTotal.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TabelActivitatiTotalInputMethodTextChanged(evt);
            }
        });
        jScrollPane2.setViewportView(TabelActivitatiTotal);
        if (TabelActivitatiTotal.getColumnModel().getColumnCount() > 0) {
            TabelActivitatiTotal.getColumnModel().getColumn(0).setResizable(false);
            TabelActivitatiTotal.getColumnModel().getColumn(1).setResizable(false);
            TabelActivitatiTotal.getColumnModel().getColumn(3).setResizable(false);
            TabelActivitatiTotal.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(66, 71, 72));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Descarcare activitati din ziua curenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(66, 71, 72));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Descarcare toate activitatiile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonReturn.setBackground(new java.awt.Color(66, 71, 72));
        buttonReturn.setForeground(new java.awt.Color(255, 255, 255));
        buttonReturn.setText("Inapoi");

        buttonSave.setBackground(new java.awt.Color(66, 71, 72));
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Salveaza modificarile");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("customer");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0; i < tabelActivitatiCurent.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(tabelActivitatiCurent.getColumnName(i));
               }
               
               for(int j=0;j<tabelActivitatiCurent.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<tabelActivitatiCurent.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(tabelActivitatiCurent.getValueAt(j, k)!=null){
                           cell.setCellValue(tabelActivitatiCurent.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               //openFile(saveFile.toString());
           }else{
               JOptionPane.showMessageDialog(null,"Error la generarea archivei");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("customer");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0; i < TabelActivitatiTotal.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(TabelActivitatiTotal.getColumnName(i));
               }
               
               for(int j=0;j<TabelActivitatiTotal.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<TabelActivitatiTotal.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(TabelActivitatiTotal.getValueAt(j, k) != null){
                           cell.setCellValue(TabelActivitatiTotal.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               //openFile(saveFile.toString());
           }else{
               JOptionPane.showMessageDialog(null,"Error la generarea archivei");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TabelActivitatiTotalInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TabelActivitatiTotalInputMethodTextChanged
       
    }//GEN-LAST:event_TabelActivitatiTotalInputMethodTextChanged

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        TabelActivitatiTotal.repaint();
    }//GEN-LAST:event_buttonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TabelActivitatiTotal;
    public javax.swing.JButton buttonReturn;
    public javax.swing.JButton buttonSave;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabelActivitatiCurent;
    // End of variables declaration//GEN-END:variables
}
