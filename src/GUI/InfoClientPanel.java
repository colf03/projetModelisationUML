/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.JTextComponent;
import main.Client;

/**
 *
 * @author Bobby
 */
public class InfoClientPanel extends javax.swing.JPanel {

    /**
     * Creates new form InfoClientPanel
     */
    public InfoClientPanel(boolean editable) {
        this.editable = editable;
        initComponents();
        jtfNom.setEditable(editable);
        jtfPrenom.setEditable(editable);
        jtfEmail.setEditable(editable);
        jtfNoRue.setEditable(editable);
        jtfNomRue.setEditable(editable);
        jtfVille.setEditable(editable);
        jtfProvince.setEditable(editable);
        jtfCodePostal.setEditable(editable);
        jbtnSoumettre.setVisible(editable);
    }

    public InfoClientPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblClient = new javax.swing.JLabel();
        jlblNoTel = new javax.swing.JLabel();
        jftfNoTel = new javax.swing.JFormattedTextField();
        jlblCodeSecret = new javax.swing.JLabel();
        jpsfCodeSecret = new javax.swing.JPasswordField();
        jbtnCharger = new javax.swing.JButton();
        ajouterModifierPanel = new javax.swing.JPanel();
        jlblNom = new javax.swing.JLabel();
        jtfNom = new javax.swing.JTextField();
        jlblPrenom = new javax.swing.JLabel();
        jtfPrenom = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlblAddresse = new javax.swing.JLabel();
        jlblNoRue = new javax.swing.JLabel();
        jtfNoRue = new javax.swing.JTextField();
        jlblNomRue = new javax.swing.JLabel();
        jtfNomRue = new javax.swing.JTextField();
        jlblVille = new javax.swing.JLabel();
        jtfVille = new javax.swing.JTextField();
        jlblProvince = new javax.swing.JLabel();
        jtfProvince = new javax.swing.JTextField();
        jlblCodePostal = new javax.swing.JLabel();
        jtfCodePostal = new javax.swing.JTextField();
        jlblEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jbtnSoumettre = new javax.swing.JButton();
        jlblErreur = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setForeground(new java.awt.Color(153, 0, 0));
        setMinimumSize(new java.awt.Dimension(400, 460));
        setPreferredSize(new java.awt.Dimension(400, 460));

        jlblClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblClient.setText("Informations du Client");

        jlblNoTel.setText("Numéro de téléphone : ");

        try {
            jftfNoTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlblCodeSecret.setText("Code Secret : ");

        jbtnCharger.setText("Charger");
        jbtnCharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChargerActionPerformed(evt);
            }
        });

        ajouterModifierPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlblNom.setText("Nom : ");

        jlblPrenom.setText("Prénom : ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlblAddresse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAddresse.setText("Addresse");

        jlblNoRue.setText("Numéro de rue : ");

        jlblNomRue.setText("Nom de rue : ");

        jlblVille.setText("Ville : ");

        jlblProvince.setText("Province : ");

        jlblCodePostal.setText("Code Postal : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblAddresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNoRue)
                            .addComponent(jlblNomRue)
                            .addComponent(jlblVille)
                            .addComponent(jlblProvince)
                            .addComponent(jlblCodePostal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCodePostal)
                            .addComponent(jtfProvince)
                            .addComponent(jtfVille)
                            .addComponent(jtfNomRue)
                            .addComponent(jtfNoRue))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblAddresse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNoRue)
                    .addComponent(jtfNoRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNomRue)
                    .addComponent(jtfNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblVille)
                    .addComponent(jtfVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblProvince)
                    .addComponent(jtfProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCodePostal)
                    .addComponent(jtfCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlblEmail.setText("Email : ");

        javax.swing.GroupLayout ajouterModifierPanelLayout = new javax.swing.GroupLayout(ajouterModifierPanel);
        ajouterModifierPanel.setLayout(ajouterModifierPanelLayout);
        ajouterModifierPanelLayout.setHorizontalGroup(
            ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajouterModifierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ajouterModifierPanelLayout.createSequentialGroup()
                        .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNom)
                            .addComponent(jlblPrenom)
                            .addComponent(jlblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail)
                            .addComponent(jtfPrenom)
                            .addComponent(jtfNom))))
                .addContainerGap())
        );
        ajouterModifierPanelLayout.setVerticalGroup(
            ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajouterModifierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ajouterModifierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnSoumettre.setText("Soumettre");
        jbtnSoumettre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSoumettreActionPerformed(evt);
            }
        });

        jlblErreur.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNoTel)
                            .addComponent(jlblCodeSecret))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftfNoTel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jpsfCodeSecret)))
                    .addComponent(ajouterModifierPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnSoumettre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlblErreur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnCharger)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblNoTel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftfNoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCodeSecret, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpsfCodeSecret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCharger)
                    .addComponent(jlblErreur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajouterModifierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnSoumettre)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private static final Color errorColor = new Color(255, 232, 232);
    private boolean editable = true;
    private Client client;

    public void addActionListenerToSubmit(java.awt.event.ActionListener listener) {
        jbtnCharger.addActionListener(listener);
    }

    private void resetErrors() {
        jlblErreur.setText("");
        jftfNoTel.setBackground(Color.white);
        jpsfCodeSecret.setBackground(Color.white);
        jtfNom.setBackground(Color.white);
        jtfPrenom.setBackground(Color.white);
        jtfEmail.setBackground(Color.white);
        jtfNoRue.setBackground(Color.white);
        jtfNomRue.setBackground(Color.white);
        jtfVille.setBackground(Color.white);
        jtfProvince.setBackground(Color.white);
        jtfCodePostal.setBackground(Color.white);
    }

    private void emptyFields() {
        jtfNom.setText("");
        jtfPrenom.setText("");
        jtfEmail.setText("");
        jtfNoRue.setText("");
        jtfNomRue.setText("");
        jtfVille.setText("");
        jtfProvince.setText("");
        jtfCodePostal.setText("");
        this.client = null;
    }
    
    public Client getClient(){
        jbtnChargerActionPerformed(null);
        return this.client;
    }

    private void jbtnChargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChargerActionPerformed
        if (editable) {
            resetErrors();
        } else {
            jlblErreur.setText("");
            jftfNoTel.setBackground(Color.white);
            jpsfCodeSecret.setBackground(Color.white);
        }
        try {
            String noTel = jftfNoTel.getText();
            if (!noTel.matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) {
                throw new NumberFormatException();
            }

            Client client = Client.trouverClient(noTel, jpsfCodeSecret.getPassword());

            this.client = client;
            jtfNom.setText(client.getNom());
            jtfPrenom.setText(client.getPrenom());
            jtfEmail.setText(client.getEmail());
            jtfNoRue.setText(client.getNoRue());
            jtfNomRue.setText(client.getNomRue());
            jtfVille.setText(client.getVille());
            jtfProvince.setText(client.getProvince());
            jtfCodePostal.setText(client.getCodePostal());
        } catch (NumberFormatException ex) {
            jftfNoTel.setBackground(new Color(255, 232, 232));
            jlblErreur.setText("Numéro de téléphone invalide");
            emptyFields();
        } catch (Client.UnautorizedException ex) {
            jpsfCodeSecret.setBackground(new Color(255, 232, 232));
            jlblErreur.setText("Code secret invalide");
            emptyFields();
        } catch (SQLException ex) {
            Logger.getLogger(InfoClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Client.NotFoundException ex) {
            jlblErreur.setText("Client inexistant");
            emptyFields();
        }
    }//GEN-LAST:event_jbtnChargerActionPerformed

    private void jbtnSoumettreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSoumettreActionPerformed
        resetErrors();
        try {
            String noTel = jftfNoTel.getText();
            char[] code = jpsfCodeSecret.getPassword();
            String nom = jtfNom.getText();
            String prenom = jtfPrenom.getText();
            String email = jtfEmail.getText();
            String noRue = jtfNoRue.getText();
            String nomRue = jtfNomRue.getText();
            String ville = jtfVille.getText();
            String province = jtfProvince.getText();
            String codePostal = jtfCodePostal.getText();
            if (!noTel.matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) {
                throw new RequiredException(jftfNoTel);
            }
            if (code.length == 0) {
                throw new RequiredException(jpsfCodeSecret);
            }
            if (nom.isEmpty()) {
                throw new RequiredException(jtfNom);
            }
            if (prenom.isEmpty()) {
                throw new RequiredException(jtfPrenom);
            }
            if (email.isEmpty() && email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) // Yay for phat regex expressions! :D
            {
                throw new RequiredException(jtfEmail);
            }
            if (noRue.isEmpty()) {
                throw new RequiredException(jtfNoRue);
            }
            if (nomRue.isEmpty()) {
                throw new RequiredException(jtfNomRue);
            }
            if (ville.isEmpty()) {
                throw new RequiredException(jtfVille);
            }
            if (province.isEmpty()) {
                throw new RequiredException(jtfProvince);
            }
            if (codePostal.isEmpty()) {
                throw new RequiredException(jtfCodePostal);
            }

            Client nouveauClient = new Client(noTel, code, nom, prenom, email, noRue, nomRue, ville, province, codePostal);
            Client.ajouterClient(nouveauClient, code);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InfoClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RequiredException ex) {

        } catch (Client.UnautorizedException ex) {
            jpsfCodeSecret.setBackground(new Color(255, 232, 232));
        }
    }//GEN-LAST:event_jbtnSoumettreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ajouterModifierPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnCharger;
    private javax.swing.JButton jbtnSoumettre;
    private javax.swing.JFormattedTextField jftfNoTel;
    private javax.swing.JLabel jlblAddresse;
    private javax.swing.JLabel jlblClient;
    private javax.swing.JLabel jlblCodePostal;
    private javax.swing.JLabel jlblCodeSecret;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblErreur;
    private javax.swing.JLabel jlblNoRue;
    private javax.swing.JLabel jlblNoTel;
    private javax.swing.JLabel jlblNom;
    private javax.swing.JLabel jlblNomRue;
    private javax.swing.JLabel jlblPrenom;
    private javax.swing.JLabel jlblProvince;
    private javax.swing.JLabel jlblVille;
    private javax.swing.JPasswordField jpsfCodeSecret;
    private javax.swing.JTextField jtfCodePostal;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNoRue;
    private javax.swing.JTextField jtfNom;
    private javax.swing.JTextField jtfNomRue;
    private javax.swing.JTextField jtfPrenom;
    private javax.swing.JTextField jtfProvince;
    private javax.swing.JTextField jtfVille;
    // End of variables declaration//GEN-END:variables
}
