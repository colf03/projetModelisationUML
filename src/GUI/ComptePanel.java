/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import main.Client;
import main.FilmVideotheque;
import main.Location;

/**
 *
 * @author Bobby
 */
public class ComptePanel extends javax.swing.JPanel {

    /**
     * Creates new form ComptePanel
     */
    public ComptePanel() {
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

        infoClientPanel = infoClientPanel = new GUI.InfoClientPanel(true);
        histLocationPanel = new javax.swing.JPanel();
        jlblHistLocation = new javax.swing.JLabel();
        jscpHistLocation = new javax.swing.JScrollPane();
        jtblHistLocation = new javax.swing.JTable();
        histAchatPanel = new javax.swing.JPanel();
        jlblHistAchat = new javax.swing.JLabel();
        jscpHistAchat = new javax.swing.JScrollPane();
        jtblHistAchat = new javax.swing.JTable();

        infoClientPanel.addActionListenerToSubmit(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Client client = infoClientPanel.getClient();
                if (client != null)
                loadClient(client);
            }
        });

        histLocationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        histLocationPanel.setMinimumSize(new java.awt.Dimension(400, 227));
        histLocationPanel.setPreferredSize(new java.awt.Dimension(400, 227));

        jlblHistLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHistLocation.setText("Historique des locations");

        jtblHistLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Durée de location", "Date de location", "Date de retour", "Retard"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        jtblHistLocation.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jscpHistLocation.setViewportView(jtblHistLocation);

        javax.swing.GroupLayout histLocationPanelLayout = new javax.swing.GroupLayout(histLocationPanel);
        histLocationPanel.setLayout(histLocationPanelLayout);
        histLocationPanelLayout.setHorizontalGroup(
            histLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(histLocationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(histLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblHistLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jscpHistLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        histLocationPanelLayout.setVerticalGroup(
            histLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(histLocationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHistLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpHistLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        histAchatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        histAchatPanel.setMinimumSize(new java.awt.Dimension(400, 227));
        histAchatPanel.setPreferredSize(new java.awt.Dimension(400, 227));

        jlblHistAchat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHistAchat.setText("Historique des transactions");

        jtblHistAchat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Date", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jscpHistAchat.setViewportView(jtblHistAchat);

        javax.swing.GroupLayout histAchatPanelLayout = new javax.swing.GroupLayout(histAchatPanel);
        histAchatPanel.setLayout(histAchatPanelLayout);
        histAchatPanelLayout.setHorizontalGroup(
            histAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(histAchatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(histAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblHistAchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jscpHistAchat, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addContainerGap())
        );
        histAchatPanelLayout.setVerticalGroup(
            histAchatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(histAchatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblHistAchat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpHistAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(histLocationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(histAchatPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoClientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(histLocationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(histAchatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private Client client;
    
    private void loadClient(Client client){
        try {
            this.client = client;
            List<Location> locations = Location.allLocation(client.getNumTel());
            DefaultTableModel model = (DefaultTableModel)jtblHistLocation.getModel();
            for (Location location : locations){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTransaction = df.parse(location.getDate_transaction());
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateTransaction);
                cal.add(Calendar.DATE, location.getDureeLocation());
                Date dateLimite = cal.getTime();
                boolean retard = new Date().after(dateLimite);
                model.addRow(new Object[]{location.getId(), FilmVideotheque.trouverFilm(location.getVideothequeId()).getFilm().getTitre(), location.getDureeLocation(), location.getDate_transaction(), location.getDate_retour(), retard});
            }
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComptePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ComptePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ComptePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel histAchatPanel;
    private javax.swing.JPanel histLocationPanel;
    private GUI.InfoClientPanel infoClientPanel;
    private javax.swing.JLabel jlblHistAchat;
    private javax.swing.JLabel jlblHistLocation;
    private javax.swing.JScrollPane jscpHistAchat;
    private javax.swing.JScrollPane jscpHistLocation;
    private javax.swing.JTable jtblHistAchat;
    private javax.swing.JTable jtblHistLocation;
    // End of variables declaration//GEN-END:variables
}
