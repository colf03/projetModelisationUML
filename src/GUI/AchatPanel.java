/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import main.Article;
import main.FilmVideotheque;

/**
 *
 * @author Bobby
 */
public class AchatPanel extends javax.swing.JPanel {

    /**
     * Creates new form achatPanel
     */
    public AchatPanel() {
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

        infoAchatPanel = new javax.swing.JPanel();
        jlblAchat = new javax.swing.JLabel();
        jlblTitre = new javax.swing.JLabel();
        jbtnAjouter = new javax.swing.JButton();
        jscpAchatInfo = new javax.swing.JScrollPane();
        jtblAchatInfo = new javax.swing.JTable();
        jcbTitre = new javax.swing.JComboBox<>();
        jbtnConfirmer = new javax.swing.JButton();
        jbtnAnnuler = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jftfTotal = new javax.swing.JFormattedTextField();
        infoClientPanel = infoClientPanel = new GUI.InfoClientPanel(false);

        infoAchatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        infoAchatPanel.setMinimumSize(new java.awt.Dimension(400, 400));

        jlblAchat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblAchat.setText("Informations de la Vente");

        jlblTitre.setText("Titre : ");

        jbtnAjouter.setText("Ajouter");

        jtblAchatInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titre", "Description", "Prix"
            }
        ));
        jscpAchatInfo.setViewportView(jtblAchatInfo);

        jcbTitre.setEditable(true);
        jcbTitre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbTitre.setSelectedItem("");
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

        jbtnConfirmer.setText("Comfirmer l'achat");

        jbtnAnnuler.setText("Annuler");

        jLabel2.setText("Total : ");

        jftfTotal.setEditable(false);
        jftfTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jftfTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftfTotal.setMinimumSize(new java.awt.Dimension(100, 20));
        jftfTotal.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout infoAchatPanelLayout = new javax.swing.GroupLayout(infoAchatPanel);
        infoAchatPanel.setLayout(infoAchatPanelLayout);
        infoAchatPanelLayout.setHorizontalGroup(
            infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoAchatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscpAchatInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(jlblAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(infoAchatPanelLayout.createSequentialGroup()
                        .addComponent(jlblTitre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTitre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnAjouter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoAchatPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoAchatPanelLayout.createSequentialGroup()
                                .addComponent(jbtnAnnuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnConfirmer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoAchatPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        infoAchatPanelLayout.setVerticalGroup(
            infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoAchatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblAchat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbTitre)
                        .addComponent(jbtnAjouter))
                    .addComponent(jlblTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpAchatInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jftfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnConfirmer)
                    .addComponent(jbtnAnnuler))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoAchatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoAchatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private List<Article> articles;
    private float total;
    
    private void clearAchat(){
        DefaultTableModel model = (DefaultTableModel)jtblAchatInfo.getModel();
        model.setRowCount(0);
        articles = new ArrayList<Article>();
        total = 0;
        jftfTotal.setValue(total);
        ((JTextField)jcbTitre.getEditor().getEditorComponent()).setText("");
    }
    
    private void jcbTitreUpdate() {                                     
        try {
            JTextField tf = (JTextField)jcbTitre.getEditor().getEditorComponent();
            String text = tf.getText();
            List<FilmVideotheque> listeFilm = FilmVideotheque.rechercheFilm(text);
            String[] listeTitre = listeFilm.stream().map(e -> e.getFilm().getTitre()).collect(Collectors.toList()).toArray(new String[0]);
            jcbTitre.removeAllItems();
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel)jcbTitre.getModel();
            for(String titre : listeTitre){
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel infoAchatPanel;
    private GUI.InfoClientPanel infoClientPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnAjouter;
    private javax.swing.JButton jbtnAnnuler;
    private javax.swing.JButton jbtnConfirmer;
    private javax.swing.JComboBox<String> jcbTitre;
    private javax.swing.JFormattedTextField jftfTotal;
    private javax.swing.JLabel jlblAchat;
    private javax.swing.JLabel jlblTitre;
    private javax.swing.JScrollPane jscpAchatInfo;
    private javax.swing.JTable jtblAchatInfo;
    // End of variables declaration//GEN-END:variables
}
