package main;

import java.sql.*;
import java.util.ArrayList;

public class Film {

    private int id;
    private String titre;
    private String description;
    private String genre;

    public Film() {
        this.titre = null;
        this.description = null;
        this.genre = null;

    }

    public Film(String title, String descrip, String genr) {
        this.titre = title;
        this.description = descrip;
        this.genre = genr;

    }

    public Film(Integer ids, String title, String descrip, String genr) {
        this.id = ids;
        this.titre = title;
        this.description = descrip;
        this.genre = genr;

    }

    public static void ajouterFilm(Film f) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "INSERT INTO FILM(TITRE,DESCRIPTION,GENRE) "
                + "VALUES ('" + f.titre + "','" + f.description + "','" + f.genre + "');";
        st.executeUpdate(sql);

        cb.fermerConnectionBDD();;

    }

    public static ArrayList<Film> trouverFilm(String title) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Film> liste = new ArrayList<Film>();
        String sql = "SELECT * FROM FILM WHERE TITRE LIKE '%" + title + "%';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Film f = new Film(rs.getInt("ID"), rs.getString("TITRE"), rs.getString("DESCRIPTION"), rs.getString("GENRE"));
            liste.add(f);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    public static Film trouverFilm(int id) throws SQLException, ClassNotFoundException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        Film f = null;
        String sql = "SELECT * FROM FILM WHERE ID = " + id + ";";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            f = new Film(rs.getInt("ID"), rs.getString("TITRE"), rs.getString("DESCRIPTION"), rs.getString("GENRE"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return f;
    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }
}
