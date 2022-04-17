package UIPackage;
import java.awt.event.ActionListener;

public class WelcomePanel extends javax.swing.JPanel {
    /**
     * Creates new form WelcomePanel
     */
    public WelcomePanel(ActionListener loginButtonListener, ActionListener registerButtonListener) {
        
        initComponents();
        loginButton.addActionListener(loginButtonListener);
        registerButton.addActionListener(registerButtonListener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel1 = new javax.swing.JLabel();
        welcomeLabel2 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 148, 96));

        welcomeLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        welcomeLabel1.setForeground(new java.awt.Color(66, 71, 72));
        welcomeLabel1.setText("Bine ati venit la");

        welcomeLabel2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        welcomeLabel2.setForeground(new java.awt.Color(66, 71, 72));
        welcomeLabel2.setText("platforma de studiu UTCN");
        welcomeLabel2.setIconTextGap(100);

        registerButton.setBackground(new java.awt.Color(66, 71, 72));
        registerButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/012-shield.png"))); // NOI18N
        registerButton.setText("Inregistrare");
        registerButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        registerButton.setIconTextGap(68);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(66, 71, 72));
        loginButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/010-unlocked.png"))); // NOI18N
        loginButton.setText("Logare");
        loginButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginButton.setIconTextGap(100);
        loginButton.setVerifyInputWhenFocusTarget(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(welcomeLabel1)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(welcomeLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(welcomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel2)
                .addGap(29, 29, 29)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

    }//GEN-LAST:event_registerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton loginButton;
    public javax.swing.JButton registerButton;
    private javax.swing.JLabel welcomeLabel1;
    private javax.swing.JLabel welcomeLabel2;
    // End of variables declaration//GEN-END:variables
}
