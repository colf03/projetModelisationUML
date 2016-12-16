package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Location extends Transaction {

    private Integer id;
    private int dureeLocation;
    private Integer videothequeId;
    private String date_retour;

    private Location(Integer id, Integer idFilm, String numTel, int dureeLocation, String dateTransac, String dateRetour) {
        super(numTel, dateTransac);
        this.id = id;
        this.videothequeId = idFilm;
        this.dureeLocation = dureeLocation;
        this.date_transaction = dateTransac;
        this.date_retour = dateRetour;
    }

    public Location(String numTel, Integer idFilm, int dureeLocation) {
        super(numTel);
        this.videothequeId = idFilm;
        this.dureeLocation = dureeLocation;
    }

    public void ajouterLocation() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "INSERT INTO LOCATION(VIDEOTHEQUE_ID,CLIENT_NUMTEL,DUREE_LOCATION,DATE_TRANSACTION,DATE_RETOUR_LOCATION) "
                + "VALUES (" + videothequeId + ",'" + numTel + "'," + dureeLocation + ",'" + date_transaction + "','" + date_retour + "');";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();

        FilmVideotheque.louerFilm(videothequeId);
    }

    public static ArrayList<Location> allLocation() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Location> liste = new ArrayList<Location>();
        String sql = "SELECT * FROM VENTE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Location l = new Location(rs.getInt("ID"), rs.getInt("VIDEOTHEQUE_ID"), rs.getString("CLIENT_NUMTEL"), rs.getInt("DUREE_LOCATION"), 
                    new SimpleDateFormat("yyy-MM-dd").format(rs.getDate("DATE_TRANSACTION")),
                    new SimpleDateFormat("yyy-MM-dd").format(rs.getDate("DATE_RETOUR_LOCATION ")));
            liste.add(l);

        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;

    }

    public Integer getId() {
        return id;
    }

    public Integer getVideothequeId() {
        return videothequeId;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public int getDureeLocation() {
        return dureeLocation;
    }
}
