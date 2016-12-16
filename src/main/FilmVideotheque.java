package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmVideotheque {

    private Integer id;
    private Film film;
    private boolean vendable;
    private int qtee;
    private int dureeLocation;
    private float prixLocation;
    private float prixVente;

    public FilmVideotheque(Integer id, Film film, boolean vendable, int qtee, int dureeLocation, float prixLocation, float prixVente) {
        this.id = id;
        this.film = film;
        this.vendable = vendable;
        this.qtee = qtee;
        this.dureeLocation = dureeLocation;
        this.prixLocation = prixLocation;
        this.prixVente = prixVente;
    }

    public FilmVideotheque(Film film, boolean vendable, int qtee, int dureeLocation, float prixLocation, float prixVente) {
        this.film = film;
        this.vendable = vendable;
        this.qtee = qtee;
        this.dureeLocation = dureeLocation;
        this.prixLocation = prixLocation;
        this.prixVente = prixVente;
    }

    public static ArrayList<FilmVideotheque> allFilm() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<FilmVideotheque> liste = new ArrayList<FilmVideotheque>();
        String sql = "SELECT * FROM VIDEOTHEQUE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Film f = Film.trouverFilm(rs.getInt("FILM_ID"));
            FilmVideotheque fv = new FilmVideotheque(rs.getInt("ID"), f, rs.getString("VENDABLE").equals(Boolean.toString(true)), rs.getInt("QTEE"), rs.getInt("DUREE_LOCATION"), rs.getFloat("PRIX_LOCATION"), rs.getFloat("PRIX_VENTE"));
            liste.add(fv);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }
    
    public static List<FilmVideotheque> rechercheFilm(String titre) throws ClassNotFoundException, SQLException{
        return rechercheFilm(titre, false);
    }

    public static List<FilmVideotheque> rechercheFilm(String title, boolean onlyVendable) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        List<FilmVideotheque> liste = new ArrayList<FilmVideotheque>();
        String sql = "SELECT * FROM VIDEOTHEQUE;";
        ResultSet rs = st.executeQuery(sql);
        List<Film> f = Film.rechercheFilm(title);
        while (rs.next()) {
            for (Film film : f) {
                if ((int) film.getId() == rs.getInt("FILM_ID")) {
                    FilmVideotheque fv = new FilmVideotheque(rs.getInt("ID"), film, rs.getString("VENDABLE").equals(Boolean.toString(true)), rs.getInt("QTEE"), rs.getInt("DUREE_LOCATION"), rs.getFloat("PRIX_LOCATION"), rs.getFloat("PRIX_VENTE"));
                    if (!onlyVendable || fv.isVendable())
                        liste.add(fv);
                }
            }
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }
    
    public static ArrayList<FilmVideotheque> trouverFilm(String title) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<FilmVideotheque> liste = new ArrayList<FilmVideotheque>();
        String sql = "SELECT * FROM VIDEOTHEQUE;";
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Film> f = Film.trouverFilm(title);
        while (rs.next()) {
            for (Film film : f) {
                if ((int) film.getId() == rs.getInt("FILM_ID")) {
                    FilmVideotheque fv = new FilmVideotheque(rs.getInt("ID"), film, rs.getString("VENDABLE").equals(Boolean.toString(true)), rs.getInt("QTEE"), rs.getInt("DUREE_LOCATION"), rs.getFloat("PRIX_LOCATION"), rs.getFloat("PRIX_VENTE"));
                    liste.add(fv);
                }
            }
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    public static FilmVideotheque trouverFilm(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        String sql = "SELECT * FROM VIDEOTHEQUE WHERE ID = " + id + ";";
        ResultSet rs = st.executeQuery(sql);
        FilmVideotheque fv = null;
        while (rs.next()) {
            Film f = Film.trouverFilm(rs.getInt("FILM_ID"));
            fv = new FilmVideotheque(rs.getInt("ID"), f, rs.getString("VENDABLE").equals(Boolean.toString(true)), rs.getInt("QTEE"), rs.getInt("DUREE_LOCATION"), rs.getFloat("PRIX_LOCATION"), rs.getFloat("PRIX_VENTE"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return fv;
    }

    public static void ajouterFilmVideotheque(FilmVideotheque fv) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        ArrayList<FilmVideotheque> listeFilm = trouverFilm(fv.getFilm().getTitre());
        if (listeFilm.size() > 0){
            String sql = "UPDATE VIDEOTHEQUE " +
                "SET VENDABLE='" + fv.vendable + "',QTEE='" + fv.qtee + "',DUREE_LOCATION=" + fv.dureeLocation + ",PRIX_LOCATION=" + fv.prixLocation + ",PRIX_VENTE=" + fv.prixVente + " " +
                "WHERE FILM_ID=" + fv.film.getId() + ";";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();
        }else{
            String sql = "INSERT INTO VIDEOTHEQUE(FILM_ID,VENDABLE,QTEE,DUREE_LOCATION,PRIX_LOCATION, PRIX_VENTE) "
                + "VALUES (" + (int) fv.film.getId() + ",'" + fv.vendable + "','" + fv.qtee + "'," + fv.dureeLocation + ","+ fv.prixLocation + "," + fv.prixVente + ");";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();
        }
    }

    public static void louerFilm(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set QTEE = QTEE - 1 where ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();

    }

    public static void retourLocationFilm(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set QTEE = QTEE + 1 where ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();
    }

    public static void filmVendable(int id, float p) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set VENDABLE = 'true' , PRIX=" + p + " where ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();
    }

    public static void filmVendu(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "DELETE FROM VIDEOTHEQUE WHERE ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();
    }

    public Integer getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public boolean isVendable() {
        return vendable;
    }

    public int getQtee() {
        return qtee;
    }
    
    public int getDureeLocation(){
        return dureeLocation;
    }

    public float getPrixLocation() {
        return prixLocation;
    }
    
    public float getPrixVente() {
        return prixVente;
    }
}
