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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import main.Client;
import main.FilmVideotheque;
import main.Location;
import main.Vente;

/**
 *
 * @author Bobby
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
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

        clientsPanel = new javax.swing.JPanel();
        jlblClients = new javax.swing.JLabel();
        jscpClients = new javax.swing.JScrollPane();
        jtblClients = new javax.swing.JTable();
        jTabbedPane = new javax.swing.JTabbedPane();
        locationsPanel = new javax.swing.JPanel();
        jlblLocations = new javax.swing.JLabel();
        jscpLocations = new javax.swing.JScrollPane();
        jtblLocations = new javax.swing.JTable();
        transactionsPanel = new javax.swing.JPanel();
        jlblTransactions = new javax.swing.JLabel();
        jscpTransactions = new javax.swing.JScrollPane();
        jtblTransactions = new javax.swing.JTable();
        jbtnClear = new javax.swing.JButton();

        clientsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        clientsPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        clientsPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        jlblClients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblClients.setText("Liste des clients");

        jscpClients.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jtblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro de téléphone", "Nom, Prenom", "Email", "Addresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        updateClientTable();
        jtblClients.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblClients.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (jtblClients.getRowCount() > 0)
                loadRow(event);
            }
        });
        jscpClients.setViewportView(jtblClients);
        if (jtblClients.getColumnModel().getColumnCount() > 0) {
            jtblClients.getColumnModel().getColumn(0).setMinWidth(120);
            jtblClients.getColumnModel().getColumn(1).setMinWidth(100);
            jtblClients.getColumnModel().getColumn(2).setMinWidth(100);
            jtblClients.getColumnModel().getColumn(3).setMinWidth(250);
        }

        javax.swing.GroupLayout clientsPanelLayout = new javax.swing.GroupLayout(clientsPanel);
        clientsPanel.setLayout(clientsPanelLayout);
        clientsPanelLayout.setHorizontalGroup(
            clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscpClients, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(jlblClients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientsPanelLayout.setVerticalGroup(
            clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblClients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpClients, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        locationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        locationsPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        locationsPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        jlblLocations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblLocations.setText("Liste des locations");

        jtblLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro de téléphone", "ID", "Description", "Durée de location", "Date de transaction", "Date de retour", "Date limite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        updateLocationsTable();
        jtblLocations.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jscpLocations.setViewportView(jtblLocations);
        if (jtblLocations.getColumnModel().getColumnCount() > 0) {
            jtblLocations.getColumnModel().getColumn(0).setMinWidth(120);
            jtblLocations.getColumnModel().getColumn(2).setMinWidth(100);
        }

        javax.swing.GroupLayout locationsPanelLayout = new javax.swing.GroupLayout(locationsPanel);
        locationsPanel.setLayout(locationsPanelLayout);
        locationsPanelLayout.setHorizontalGroup(
            locationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, locationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(locationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscpLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlblLocations, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addContainerGap())
        );
        locationsPanelLayout.setVerticalGroup(
            locationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblLocations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpLocations, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Locations", locationsPanel);

        transactionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        transactionsPanel.setMinimumSize(new java.awt.Dimension(400, 400));

        jlblTransactions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTransactions.setText("Liste des transactions");

        jtblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro de téléphone", "ID", "Date", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
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
        updateTransactionsTable();
        jscpTransactions.setViewportView(jtblTransactions);
        if (jtblTransactions.getColumnModel().getColumnCount() > 0) {
            jtblTransactions.getColumnModel().getColumn(0).setMinWidth(120);
            jtblTransactions.getColumnModel().getColumn(2).setMinWidth(100);
        }

        javax.swing.GroupLayout transactionsPanelLayout = new javax.swing.GroupLayout(transactionsPanel);
        transactionsPanel.setLayout(transactionsPanelLayout);
        transactionsPanelLayout.setHorizontalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscpTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlblTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                .addContainerGap())
        );
        transactionsPanelLayout.setVerticalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTransactions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscpTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Transactions", transactionsPanel);

        jbtnClear.setText("Clear");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnClear))
                    .addComponent(clientsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnClear))
                    .addComponent(jTabbedPane))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
        jtblClients.clearSelection();
        jtblLocations.clearSelection();
        jtblTransactions.clearSelection();
        this.client = null;
        updateClientTable();
        updateLocationsTable();
        updateTransactionsTable();
    }//GEN-LAST:event_jbtnClearActionPerformed

    private Client client;
    private List<Client> allClients;

    private void loadRow(ListSelectionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jtblClients.getModel();
        int row = jtblClients.getSelectedRow();
        if (row >= 0) {
            try {
                this.client = Client.trouverClient((String) model.getValueAt(row, 0));
                updateLocationsTable();
                updateTransactionsTable();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateClientTable() {
        try {
            this.allClients = Client.allClient();
            DefaultTableModel model = (DefaultTableModel) jtblClients.getModel();
            model.setRowCount(0);
            for (Client client : allClients) {
                String nomComplet = client.getNom() + ", " + client.getPrenom();
                String addresse = client.getNoRue() + " " + client.getNomRue() + ", " + client.getVille() + ", " + client.getProvince() + ", " + client.getCodePostal();
                model.addRow(new Object[]{client.getNumTel(), nomComplet, client.getEmail(), addresse});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateLocationsTable() {
        try {
            List<Location> locationList;
            if (this.client == null) {
                locationList = Location.allLocation();
            } else {
                locationList = Location.allLocation(this.client.getNumTel());
            }
            DefaultTableModel model = (DefaultTableModel) jtblLocations.getModel();
            model.setRowCount(0);
            for (Location location : locationList) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dateTransaction = df.parse(location.getDate_transaction());
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateTransaction);
                cal.add(Calendar.DATE, location.getDureeLocation());
                Date dateLimite = cal.getTime();
                String dateLimiteStr = df.format(dateLimite);
                boolean retard = new Date().after(dateLimite);
                String description = FilmVideotheque.trouverFilm(location.getVideothequeId()).getFilm().getTitre();
                
                model.addRow(new Object[]{(String)location.getClientNumTel(), location.getId(), description, location.getDureeLocation(), location.getDate_transaction(), location.getDate_retour(), dateLimiteStr});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTransactionsTable() {
        try {
            List<Vente> venteList;
            if (this.client == null) {
                venteList = Vente.allVente();
            } else {
                venteList = Vente.allVente(this.client.getNumTel());
            }
            DefaultTableModel model = (DefaultTableModel) jtblLocations.getModel();
            model.setRowCount(0);
            for (Vente vente : venteList) {
                String numTel = vente.getClientNumTel() == null ? vente.getClientNumTel() : "";
                model.addRow(new Object[]{numTel, vente.getId(), vente.getDate_transaction(), vente.getTotal()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clientsPanel;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JLabel jlblClients;
    private javax.swing.JLabel jlblLocations;
    private javax.swing.JLabel jlblTransactions;
    private javax.swing.JScrollPane jscpClients;
    private javax.swing.JScrollPane jscpLocations;
    private javax.swing.JScrollPane jscpTransactions;
    private javax.swing.JTable jtblClients;
    private javax.swing.JTable jtblLocations;
    private javax.swing.JTable jtblTransactions;
    private javax.swing.JPanel locationsPanel;
    private javax.swing.JPanel transactionsPanel;
    // End of variables declaration//GEN-END:variables
}
