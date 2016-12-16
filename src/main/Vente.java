package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Vente extends Transaction {

    private Integer id;
    private float total;
    private ArrayList<Article> listeA = new ArrayList<Article>();
    private ArrayList<FilmVideotheque> listeF = new ArrayList<FilmVideotheque>();

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
    private Vente(Integer ids, String numTel, float totaux, String date) {
        super(numTel, date);
        this.id = ids;

        this.total = totaux;

    }

    /**
     * Methode pour ajouter un article a une vente
     * @param a article
     * @param qte quantite
     */
    public void ajouterArticle(Article a) {

        this.listeA.add(a);
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
    public void terminerVente() throws ClassNotFoundException, SQLException {
        float totaux = 0;
        for (Article l : listeA) {
            totaux += l.getPrix();
        }
        for (FilmVideotheque f : listeF) {
            totaux += f.getPrixVente();
        }
        this.total = totaux;
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        if (numTel == null) {
            String sql = "INSERT INTO VENTE(CLIENT_NUMTEL,PRIX_TOTAL,DATE_TRANSACTION) "
                    + "VALUES (" + null + "," + total + ",'" + date_transaction + "');";
            st.executeUpdate(sql);
            cb.fermerConnectionBDD();

        } else {

            String sql = "INSERT INTO VENTE(CLIENT_NUMTEL,PRIX_TOTAL,DATE_TRANSACTION) "
                    + "VALUES ('" + numTel + "'," + total + ",'" + date_transaction + "');";
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
            Vente v = new Vente(rs.getInt("ID"), rs.getString("CLIENT_NUMTEL"), rs.getFloat("PRIX_TOTAL"),
                    rs.getString("DATE_TRANSACTION"));
            liste.add(v);

        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }
    
    public static ArrayList<Vente> allVente(String numTel) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Vente> liste = new ArrayList<Vente>();
        String sql = "SELECT * FROM VENTE WHERE CLIENT_NUMTEL = '" + numTel + "';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vente v = new Vente(rs.getInt("ID"), rs.getString("CLIENT_NUMTEL"), rs.getFloat("PRIX_TOTAL"),
                    rs.getString("DATE_TRANSACTION"));
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

    public ArrayList<Article> getListeA() {
        return listeA;
    }

    public ArrayList<FilmVideotheque> getListeF() {
        return listeF;
    }

}
