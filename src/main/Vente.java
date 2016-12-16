package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Vente extends Transaction {

    private Integer id;
    private float total;
    private String modePaiement;
    private ArrayList<LigneArticle> listeA;
    private ArrayList<FilmVideotheque> listeF;

    /**
     *  Constructeur par defaut pour cree une nouvelle vente
     */
    public Vente() {
        super();

    }

    /**
     * Constructeur pour initialiser une vente a un client donné
     * @param numTel numero de telephone
     */
    public Vente(String numTel) {
        super(numTel);

    }

    /**
     * Constructeur pour creer une vente recuperer de la table Vente
     * 
     * @param ids id vente
     * @param numTel numero telephone client
     * @param totaux prix total de la vente
     * @param mdpmt mode paiement
     * @param date date vente
     */
    private Vente(Integer ids, String numTel, float totaux, String mdpmt, String date) {
        super(numTel, date);
        this.id = ids;
        this.modePaiement = mdpmt;
        this.total = totaux;

    }

    /**
     * Methode pour ajouter un article a une vente
     * @param a article
     * @param qte quantite
     */
    public void ajouterArticle(Article a, int qte) {

        this.listeA.add(new LigneArticle(a, qte));
    }

    /**
     * Methode pour ajouter un film a une vente
     * @param fv filmVideotheque
     */
    public void ajouterFilm(FilmVideotheque fv) {

        this.listeF.add(fv);
    }

    /**
     * Methode pour associer une vente a un client
     * @param numTel numero telephone
     */
    public void ajouterIdClient(String numTel) {

        this.numTel = numTel;
    }

    //voir tableau pour choisir mode de paiement
    /**
     * Methode pour terminer une vente et l enregistrer dans la table Vente
     * 
     * @param modePmt mode de paiement
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void terminerVente(int modePmt) throws ClassNotFoundException, SQLException {
        String[] tMode = {"carte debit", "carte crebit", "argent comptant", "cheque"};
        this.modePaiement = tMode[modePmt];
        float totaux = 0;
        for (LigneArticle l : listeA) {
            totaux += l.getSousTotal();
        }
        for (FilmVideotheque f : listeF) {
            totaux += f.getPrixVente();
        }
        this.total = totaux;
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        if (listeF.size() < 1) {
            String sql = "INSERT INTO VENTE(CLIENT_NUMTEL,PRIX_TOTAL,MODE_PAIEMENT,DATE_TRANSACTION) "
                    + "VALUES (" + null + "," + total + ",'" + modePaiement + "'," + date_transaction + ");";
            st.executeUpdate(sql);
            cb.fermerConnectionBDD();

        } else {

            String sql = "INSERT INTO VENTE(CLIENT_NUMTEL,PRIX_TOTAL,MODE_PAIEMENT,DATE_TRANSACTION) "
                    + "VALUES (" + numTel + "," + total + ",'" + modePaiement + "'," + date_transaction + ");";
            st.executeUpdate(sql);
            cb.fermerConnectionBDD();
            for (FilmVideotheque film : listeF) {
                FilmVideotheque.filmVendu(film.getId());
            }

        }

    }

    /**
     * 
     * Methode pour retourner toute les ventes de la table Vente
     * @return liste vente
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Vente> allVente() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Vente> liste = new ArrayList<Vente>();
        String sql = "SELECT * FROM VENTE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vente v = new Vente(rs.getInt("ID"), rs.getString("CLIENT_NUMTEL"), rs.getFloat("TOTAL"),
                    rs.getString("MODE_PAIEMENT"), new SimpleDateFormat("yyy-MM-dd").format(rs.getDate("DATE_TRANSACTION")));
            liste.add(v);

        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;

    }

    public Integer getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public ArrayList<LigneArticle> getListeA() {
        return listeA;
    }

    public ArrayList<FilmVideotheque> getListeF() {
        return listeF;
    }

}
