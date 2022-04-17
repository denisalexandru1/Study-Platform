
package UIPackage;

import BDProjectv7.Activitate;
import java.awt.event.ActionListener;
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
public class VizActivitatiStudent extends javax.swing.JPanel {

    public ArrayList<Activitate> activitati;
    
    
    public VizActivitatiStudent(ActionListener backToHomePanelListener, ActionListener parasireActivitateButtonListener) {
        initComponents();
        buttonReturn.addActionListener(backToHomePanelListener);
        parasireActivButton.addActionListener(parasireActivitateButtonListener);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableActivitatiCurrent = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableActivitati = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        parasireActivButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        TableActivitatiCurrent.setForeground(new java.awt.Color(60, 63, 65));
        TableActivitatiCurrent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Tip activitate", "Ora", "Durata"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableActivitatiCurrent.setGridColor(new java.awt.Color(66, 71, 72));
        TableActivitatiCurrent.setOpaque(false);
        TableActivitatiCurrent.setSelectionBackground(new java.awt.Color(66, 71, 72));
        TableActivitatiCurrent.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TableActivitatiCurrent);

        TableActivitati.setForeground(new java.awt.Color(60, 63, 65));
        TableActivitati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Tip activitate", "Ora", "Durata", "Ziua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableActivitati.setGridColor(new java.awt.Color(60, 63, 65));
        TableActivitati.setOpaque(false);
        TableActivitati.setSelectionBackground(new java.awt.Color(66, 71, 72));
        TableActivitati.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(TableActivitati);

        jLabel1.setForeground(new java.awt.Color(66, 71, 72));
        jLabel1.setText("Activitatiile in ziua curenta");

        jLabel2.setForeground(new java.awt.Color(66, 71, 72));
        jLabel2.setText("Toate Activitatiile");

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
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        parasireActivButton.setBackground(new java.awt.Color(66, 71, 72));
        parasireActivButton.setForeground(new java.awt.Color(255, 255, 255));
        parasireActivButton.setText("Parasire Activitate");
        parasireActivButton.setActionCommand("Parasire Activitate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parasireActivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(buttonReturn))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(parasireActivButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(buttonReturn))
                .addContainerGap(48, Short.MAX_VALUE))
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
               for(int i=0; i < TableActivitatiCurrent.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(TableActivitatiCurrent.getColumnName(i));
               }
               
               for(int j=0;j<TableActivitatiCurrent.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<TableActivitatiCurrent.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(TableActivitatiCurrent.getValueAt(j, k)!=null){
                           cell.setCellValue(TableActivitatiCurrent.getValueAt(j, k).toString());
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

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed

    }//GEN-LAST:event_buttonReturnActionPerformed

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
               for(int i=0; i < TableActivitati.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(TableActivitati.getColumnName(i));
               }
               
               for(int j=0;j<TableActivitati.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<TableActivitati.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(TableActivitati.getValueAt(j, k)!=null){
                           cell.setCellValue(TableActivitati.getValueAt(j, k).toString());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TableActivitati;
    public javax.swing.JTable TableActivitatiCurrent;
    public javax.swing.JButton buttonReturn;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton parasireActivButton;
    // End of variables declaration//GEN-END:variables
}
