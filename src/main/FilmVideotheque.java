package main;

import java.sql.*;
import java.util.ArrayList;

public class FilmVideotheque {

    private Integer id;
    private Film film;
    private boolean vendable;
    private boolean loue;
    private float prix;

    public FilmVideotheque(Integer i, Film f, boolean v, boolean l, float p) {
        this.id = i;
        this.film = f;
        this.vendable = v;
        this.loue = l;
        this.prix = p;
    }

    public FilmVideotheque(Film f, boolean v, boolean l, float p) {
        this.film = f;
        this.vendable = v;
        this.loue = l;
        this.prix = p;
    }

    public static ArrayList<FilmVideotheque> allFilm() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<FilmVideotheque> liste = new ArrayList<FilmVideotheque>();
        String sql = "SELECT * FROM VIDEOTHEQUE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Film f = Film.trouverFilm(rs.getInt("FILM_ID"));
            FilmVideotheque fv = new FilmVideotheque(rs.getInt("ID"), f, rs.getBoolean("VENDABLE"), rs.getBoolean("LOUE"), rs.getFloat("PRIX"));
            liste.add(fv);
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
                    FilmVideotheque fv = new FilmVideotheque(rs.getInt("ID"), film, rs.getBoolean("VENDABLE"), rs.getBoolean("LOUE"), rs.getFloat("PRIX"));
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
            fv = new FilmVideotheque(rs.getInt("ID"), f, rs.getBoolean("VENDABLE"), rs.getBoolean("LOUE"), rs.getFloat("PRIX"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return fv;
    }

    public static void ajouterFilmVideotheque(FilmVideotheque fv) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "INSERT INTO VIDEOTHEQUE(FILM_ID,VENDABLE,LOUE,PRIX) "
                + "VALUES (" + (int) fv.film.getId() + "," + fv.vendable + "," + fv.loue + "," + fv.prix + ");";
        st.executeUpdate(sql);

        cb.fermerConnectionBDD();

    }

    public static void louerFilm(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set LOUE = 1 where ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();

    }

    public static void retourLocationFilm(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set LOUE = 0 where ID=" + id + ";";
        st.executeUpdate(sql);
        cb.fermerConnectionBDD();
    }

    public static void filmVendable(int id, float p) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();;
        String sql = "UPDATE VIDEOTHEQUE set VENDABLE = 1 , PRIX=" + p + " where ID=" + id + ";";
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

    public boolean isLoue() {
        return loue;
    }

    public float getPrix() {
        return prix;
    }
}
