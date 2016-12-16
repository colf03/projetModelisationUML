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

    public Vente() {
        super();

    }

    public Vente(int idNumtel) {
        super(idNumtel);

    }

    private Vente(Integer ids, int idNum, float totaux, String mdpmt, String date) {
        super(idNum, date);
        this.id = ids;
        this.modePaiement = mdpmt;
        this.total = totaux;

    }

    public void ajouterArticle(Article a, int qte) {

        this.listeA.add(new LigneArticle(a, qte));
    }

    public void ajouterFilm(FilmVideotheque fv) {

        this.listeF.add(fv);
    }

    public void ajouterIdClient(int id) {

        this.numTel = id;
    }

    //voir tableau pour choisir mode de paiement
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

    public static ArrayList<Vente> allVente() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Vente> liste = new ArrayList<Vente>();
        String sql = "SELECT * FROM VENTE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vente v = new Vente(rs.getInt("ID"), rs.getInt("CLIENT_NUMTEL"), rs.getFloat("TOTAL"),
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
