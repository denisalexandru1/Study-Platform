package UIPackage;
        
import java.awt.event.ActionListener;

        
public class StudentHomePanel extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    public StudentHomePanel(ActionListener logoutButtonListener, ActionListener vizDatePersListener, ActionListener inscriereCursuriListener, ActionListener inscriereActivitatiListener, ActionListener VizualizareNoteListener, ActionListener VizActivitatiListener, ActionListener vizGrupaStudiuListener) {
        initComponents();
        buttonLogOut.addActionListener(logoutButtonListener);
        buttonVizDatePers.addActionListener(vizDatePersListener);
        buttonInscriereCurs.addActionListener(inscriereCursuriListener);  
        buttonInscriereActivitati.addActionListener(inscriereActivitatiListener);
        buttonVizNote.addActionListener(VizualizareNoteListener);
        buttonVizActivitati.addActionListener(VizActivitatiListener);
        buttonVizGrupStudiu.addActionListener(vizGrupaStudiuListener);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonVizDatePers = new javax.swing.JButton();
        buttonVizNote = new javax.swing.JButton();
        buttonVizActivitati = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonVizGrupStudiu = new javax.swing.JButton();
        buttonInscriereCurs = new javax.swing.JButton();
        buttonInscriereActivitati = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        buttonVizDatePers.setBackground(new java.awt.Color(66, 71, 72));
        buttonVizDatePers.setForeground(new java.awt.Color(255, 255, 255));
        buttonVizDatePers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/004-graduate.png"))); // NOI18N
        buttonVizDatePers.setText("Vizualizare date personale");
        buttonVizDatePers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVizDatePers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonVizNote.setBackground(new java.awt.Color(66, 71, 72));
        buttonVizNote.setForeground(new java.awt.Color(255, 255, 255));
        buttonVizNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/001-browser.png"))); // NOI18N
        buttonVizNote.setText("Vizualizare note");
        buttonVizNote.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVizNote.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonVizActivitati.setBackground(new java.awt.Color(66, 71, 72));
        buttonVizActivitati.setForeground(new java.awt.Color(255, 255, 255));
        buttonVizActivitati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/005-calendar.png"))); // NOI18N
        buttonVizActivitati.setText("Vizualizare activitati");
        buttonVizActivitati.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVizActivitati.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonLogOut.setBackground(new java.awt.Color(66, 71, 72));
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Log out");

        buttonVizGrupStudiu.setBackground(new java.awt.Color(66, 71, 72));
        buttonVizGrupStudiu.setForeground(new java.awt.Color(255, 255, 255));
        buttonVizGrupStudiu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/009-chat.png"))); // NOI18N
        buttonVizGrupStudiu.setText("Grup de studiu");
        buttonVizGrupStudiu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVizGrupStudiu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonInscriereCurs.setBackground(new java.awt.Color(66, 71, 72));
        buttonInscriereCurs.setForeground(new java.awt.Color(255, 255, 255));
        buttonInscriereCurs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/008-browser-1.png"))); // NOI18N
        buttonInscriereCurs.setText("Inscriere cursuri");
        buttonInscriereCurs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonInscriereCurs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonInscriereActivitati.setBackground(new java.awt.Color(66, 71, 72));
        buttonInscriereActivitati.setForeground(new java.awt.Color(255, 255, 255));
        buttonInscriereActivitati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/007-computer.png"))); // NOI18N
        buttonInscriereActivitati.setText("Inscriere activitati");
        buttonInscriereActivitati.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonInscriereActivitati.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonVizDatePers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonVizGrupStudiu, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInscriereActivitati, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonVizNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonVizActivitati, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonInscriereCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonVizNote, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(buttonVizActivitati, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(buttonVizDatePers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonVizGrupStudiu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInscriereActivitati, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInscriereCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInscriereActivitati;
    public javax.swing.JButton buttonInscriereCurs;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonVizActivitati;
    public javax.swing.JButton buttonVizDatePers;
    public javax.swing.JButton buttonVizGrupStudiu;
    public javax.swing.JButton buttonVizNote;
    // End of variables declaration//GEN-END:variables
}
