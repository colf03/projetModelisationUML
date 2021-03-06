/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.Client;
import main.FilmVideotheque;

/**
 *
 * @author Bobby
 */
public class LocationPanel extends javax.swing.JPanel {

    /**
     * Creates new form LocationUI
     */
    public LocationPanel() {
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

        infoLocationPanel = new javax.swing.JPanel();
        jlblLocation = new javax.swing.JLabel();
        jlblTitre = new javax.swing.JLabel();
        jbtnAjouter = new javax.swing.JButton();
        jscpLocationInfo = new javax.swing.JScrollPane();
        jtblLocationInfo = new javax.swing.JTable();
        jcbTitre = new javax.swing.JComboBox<>();
        jbtnConfirmer = new javax.swing.JButton();
        jbtnAnnuler = new javax.swing.JButton();
        jftfTotal = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        infoClientPanel = infoClientPanel = new GUI.InfoClientPanel(false);

        infoLocationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        infoLocationPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        infoLocationPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        jlblLocation.setForeground(java.awt.SystemColor.textInactiveText);
        jlblLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblLocation.setText("Informations de la Location");

        jlblTitre.setForeground(java.awt.SystemColor.textInactiveText);
        jlblTitre.setText("Titre : ");

        jbtnAjouter.setText("Ajouter");
        jbtnAjouter.setEnabled(false);
        jbtnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAjouterActionPerformed(evt);
            }
        });

        jtblLocationInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titre", "Description", "Genre", "Duree de la location", "Prix"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jscpLocationInfo.setViewportView(jtblLocationInfo);

        jcbTitre.setEditable(true);
        jcbTitre.setSelectedItem("");
        jcbTitre.setEnabled(false);
        ((JTextField)jcbTitre.getEditor().getEditorComponent()).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                update();
            }

            public void update(){
                //perform separately, as listener conflicts between the editing component
                //and JComboBox will result in an IllegalStateException due to editing
                //the component when it is locked.

                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run() {
                        jcbTitreUpdate();
                    }
                });
            }
        });

        jbtnConfirmer.setText("Comfirmer la location");
        jbtnConfirmer.setEnabled(false);
        jbtnConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmerActionPerformed(evt);
            }
        });

        jbtnAnnuler.setText("Annuler");
        jbtnAnnuler.setEnabled(false);
        jbtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAnnulerActionPerformed(evt);
            }
        });

        jftfTotal.setEditable(false);
        jftfTotal.setValue(0);
        jftfTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jftfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfTotal.setMinimumSize(new java.awt.Dimension(100, 20));
        jftfTotal.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel2.setText("Total : ");

        javax.swing.GroupLayout infoLocationPanelLayout = new javax.swing.GroupLayout(infoLocationPanel);
        infoLocationPanel.setLayout(infoLocationPanelLayout);
        infoLocationPanelLayout.setHorizontalGroup(
            infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLocationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscpLocationInfo)
                    .addComponent(jlblLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(infoLocationPanelLayout.createSequentialGroup()
                        .addComponent(jlblTitre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTitre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAjouter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLocationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLocationPanelLayout.createSequentialGroup()
                                .addComponent(jbtnAnnuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnConfirmer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLocationPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        infoLocationPanelLayout.setVerticalGroup(
            infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLocationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbTitre)
                        .addComponent(jbtnAjouter))
                    .addComponent(jlblTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpLocationInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnConfirmer)
                    .addComponent(jbtnAnnuler))
                .addContainerGap())
        );

        infoClientPanel.addActionListenerToSubmit(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Client client = infoClientPanel.getClient();
                setLocationState(client != null);
                if (client != null)
                loadClient(client);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLocationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLocationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(infoClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearLocation() {
        DefaultTableModel model = (DefaultTableModel) jtblLocationInfo.getModel();
        model.setRowCount(0);
        films = new ArrayList<FilmVideotheque>();
        total = 0;
        jftfTotal.setValue(total);
        ((JTextField) jcbTitre.getEditor().getEditorComponent()).setText("");
    }

    private void jbtnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAjouterActionPerformed
        try {
            List<FilmVideotheque> listeFilm = FilmVideotheque.trouverFilm((String) jcbTitre.getSelectedItem());
            if (listeFilm.size() > 0) {
                DefaultTableModel model = (DefaultTableModel) jtblLocationInfo.getModel();
                for (FilmVideotheque film : listeFilm) {
                    if (!films.stream().map(e -> e.getId()).collect(Collectors.toList()).contains(film.getId()) && film.getQtee() > 0) {
                        films.add(film);
                        model.addRow(new Object[]{film.getFilm().getId(), film.getFilm().getTitre(), film.getFilm().getDescription(), film.getFilm().getGenre(), film.getDureeLocation(), film.getPrixLocation()});
                        total += film.getPrixLocation();
                        jftfTotal.setValue(total);
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnAjouterActionPerformed

    private void jbtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAnnulerActionPerformed
        clearLocation();
    }//GEN-LAST:event_jbtnAnnulerActionPerformed

    private void jbtnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmerActionPerformed
        try {
            for (FilmVideotheque film : films) {
                main.Location location = new main.Location(client.getNumTel(), film.getId(), film.getDureeLocation());
                location.ajouterLocation();
            }
            JOptionPane.showMessageDialog(jbtnConfirmer, "La location a ete creee avec succès.");
            clearLocation();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnConfirmerActionPerformed

    private Client client;
    private List<FilmVideotheque> films = new ArrayList<FilmVideotheque>();
    private float total = 0;

    private void jcbTitreUpdate() {
        try {
            JTextField tf = (JTextField) jcbTitre.getEditor().getEditorComponent();
            String text = tf.getText();
            List<FilmVideotheque> listeFilm = FilmVideotheque.rechercheFilm(text);
            String[] listeTitre = listeFilm.stream().map(e -> e.getFilm().getTitre()).collect(Collectors.toList()).toArray(new String[0]);
            jcbTitre.removeAllItems();
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel) jcbTitre.getModel();
            for (String titre : listeTitre) {
                model.addElement(titre);
            }
            jcbTitre.setModel(model);
            jcbTitre.setSelectedIndex(-1);
            tf.setText(text);
            jcbTitre.showPopup();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LocationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setLocationState(boolean state) {
        if (state) {
            jlblLocation.setForeground(Color.black);
            jlblTitre.setForeground(Color.black);
        } else {
            jlblLocation.setForeground(SystemColor.textInactiveText);
            jlblTitre.setForeground(SystemColor.textInactiveText);
        }
        jbtnAjouter.setEnabled(state);
        jbtnAnnuler.setEnabled(state);
        jbtnConfirmer.setEnabled(state);
        jcbTitre.setEnabled(state);
    }

    private void loadClient(Client client) {
        this.client = client;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.InfoClientPanel infoClientPanel;
    private javax.swing.JPanel infoLocationPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnAjouter;
    private javax.swing.JButton jbtnAnnuler;
    private javax.swing.JButton jbtnConfirmer;
    private javax.swing.JComboBox<String> jcbTitre;
    private javax.swing.JFormattedTextField jftfTotal;
    private javax.swing.JLabel jlblLocation;
    private javax.swing.JLabel jlblTitre;
    private javax.swing.JScrollPane jscpLocationInfo;
    private javax.swing.JTable jtblLocationInfo;
    // End of variables declaration//GEN-END:variables
}
