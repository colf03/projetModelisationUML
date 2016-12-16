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

    public Vente() {
        super();

    }

    public Vente(String numTel) {
        super(numTel);

    }

    private Vente(Integer ids, String numTel, float totaux, String date) {
        super(numTel, date);
        this.id = ids;

        this.total = totaux;

    }

    public void ajouterArticle(Article a) {

        this.listeA.add(a);
    }

    public void ajouterFilm(FilmVideotheque fv) {

        this.listeF.add(fv);
    }

    public void ajouterIdClient(String numTel) {

        this.numTel = numTel;
    }

    //voir tableau pour choisir mode de paiement
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
