package main;

import java.sql.*;
import java.util.ArrayList;

public class Film {

    private int id;
    private String titre;
    private String description;
    private String genre;

    /**
     *  Constructeur par defaut
     */
    public Film() {
        this.titre = null;
        this.description = null;
        this.genre = null;

    }

    /** 
     * Constructeur pour creer un nouveau film
     * 
     * @param title titre du film
     * @param descrip resume du film
     * @param genr genre du film
     */
    public Film(String title, String descrip, String genr) {
        this.titre = title;
        this.description = descrip;
        this.genre = genr;

    }

    /**
     *  Constructeur pour creer un film recupere depuis la table Film
     * 
     * @param ids id du film dans la table Film
     * @param title titre du film
     * @param descrip resume du film
     * @param genr genre du film
     */
    public Film(Integer ids, String title, String descrip, String genr) {
        this.id = ids;
        this.titre = title;
        this.description = descrip;
        this.genre = genr;

    }

    /** 
     * Methode pour ajouter un film dans la table Film
     * 
     * @param f film a ajouter
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void ajouterFilm(Film f) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        ArrayList<Film> listeFilm = trouverFilm(f.titre);
        if (listeFilm.size() > 0) {
            String sql = "UPDATE FILM "
                    + "SET DESCRIPTION='" + f.description + "',GENRE='" + f.genre + "' "
                    + "WHERE TITRE='" + f.titre + "';";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();

        } else {
            String sql = "INSERT INTO FILM(TITRE,DESCRIPTION,GENRE) "
                    + "VALUES ('" + f.titre + "','" + f.description + "','" + f.genre + "');";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();
        }
    }

    /**
     * Methode pour recuperer un film avec le titre passe en parametre
     * 
     * @param title titre du film
     * @return liste de film avec le titre rentre en parametres
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Film> trouverFilm(String title) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Film> liste = new ArrayList<>();
        String sql = "SELECT * FROM FILM WHERE TITRE='" + title + "';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Film f = new Film(rs.getInt("ID"), rs.getString("TITRE"), rs.getString("DESCRIPTION"), rs.getString("GENRE"));
            liste.add(f);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    /** 
     * Methode pour recuperer une liste de film contenant au moins les caracteres passe en parametres
     * 
     * @param title titre du film
     * @return liste de film
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Film> rechercheFilm(String title) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Film> liste = new ArrayList<>();
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

    /**
     * Methode pour recuperer un film avec l'id passe en parametre
     * 
     * @param id id film
     * @return un film
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
