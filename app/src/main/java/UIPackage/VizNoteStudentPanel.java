package UIPackage;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dari
 */
public class VizNoteStudentPanel extends javax.swing.JPanel {

    public VizNoteStudentPanel(ActionListener backToHomePanelListener) {
        initComponents();
        buttonReturn.addActionListener(backToHomePanelListener);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPaneVizNote = new javax.swing.JScrollPane();
        TableVizNote = new javax.swing.JTable();
        buttonReturn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        TableVizNote.setForeground(new java.awt.Color(60, 63, 65));
        TableVizNote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Nota curs", "Nota seminar", "Nota laborator", "Nota finala"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableVizNote.setGridColor(new java.awt.Color(66, 71, 72));
        TableVizNote.setInheritsPopupMenu(true);
        TableVizNote.setOpaque(false);
        TableVizNote.setSelectionBackground(new java.awt.Color(66, 71, 72));
        TableVizNote.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ScrollPaneVizNote.setViewportView(TableVizNote);

        buttonReturn.setBackground(new java.awt.Color(66, 71, 72));
        buttonReturn.setForeground(new java.awt.Color(255, 255, 255));
        buttonReturn.setText("Intoarcere");
        buttonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ScrollPaneVizNote)
                    .addComponent(buttonReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(ScrollPaneVizNote, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane ScrollPaneVizNote;
    public javax.swing.JTable TableVizNote;
    public javax.swing.JButton buttonReturn;
    // End of variables declaration//GEN-END:variables
}
