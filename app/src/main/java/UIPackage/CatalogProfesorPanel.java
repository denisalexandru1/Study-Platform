
package UIPackage;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dari
 */
public class CatalogProfesorPanel extends javax.swing.JPanel {
    public DefaultListModel cursListModel;
    public String nume_curs;
    public CatalogProfesorPanel(ActionListener backToHomePanelListener, ListSelectionListener CursSelectionListener, ActionListener UpdateNoteListener) {
        initComponents();
        buttonReturn.addActionListener(backToHomePanelListener);
        cursListModel = new DefaultListModel();
        listCurs.setModel(cursListModel);
        listCurs.getSelectionModel().addListSelectionListener(CursSelectionListener);
        buttonSave.addActionListener(UpdateNoteListener);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCurs = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStudenti = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buttonReturn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        jLabel2.setForeground(new java.awt.Color(66, 71, 72));
        jLabel2.setText("Alegeti un curs:");

        listCurs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listCurs.setSelectionBackground(new java.awt.Color(66, 71, 72));
        listCurs.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(listCurs);

        tableStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "1", null, null},
                {null, null, null, null, "2", null, null},
                {null, null, null, null, "2", null, null},
                {null, null, null, null, "3", null, null},
                {null, null, null, null, "5", null, null},
                {null, null, null, null, "4", null, null},
                {null, null, null, null, "6", null, null},
                {null, null, null, null, "7", null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nume", "Prenume", "Username", "Nota Curs", "Nota Seminar", "Nota Laborator", "Nota Finala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableStudenti.setPreferredSize(new java.awt.Dimension(454, 100));
        tableStudenti.setSelectionBackground(new java.awt.Color(66, 71, 72));
        tableStudenti.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tableStudenti);

        jLabel3.setForeground(new java.awt.Color(66, 71, 72));
        jLabel3.setText("Studenti:");

        buttonReturn.setBackground(new java.awt.Color(66, 71, 72));
        buttonReturn.setForeground(new java.awt.Color(255, 255, 255));
        buttonReturn.setText("Inapoi");
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(66, 71, 72));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Descarcare Catalog");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonSave.setBackground(new java.awt.Color(66, 71, 72));
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Salveaza Modificarile");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonReturn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReturnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("customer");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0; i < tableStudenti.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(tableStudenti.getColumnName(i));
               }
               
               for(int j=0;j<tableStudenti.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<tableStudenti.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(tableStudenti.getValueAt(j, k) != null){
                           cell.setCellValue(tableStudenti.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        tableStudenti.repaint();
    }//GEN-LAST:event_buttonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonReturn;
    public javax.swing.JButton buttonSave;
    public javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<String> listCurs;
    public javax.swing.JTable tableStudenti;
    // End of variables declaration//GEN-END:variables
}
