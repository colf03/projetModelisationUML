package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Florian
 *
 */
public class Article {

    private Integer id;
    private String description;
    private float prix;
  
    /**
     *  Constructeur vide 
     */
    public Article() {
        this.description = null;
        this.prix = 0;
    }

    /** 
     * Constructeur pour créer un nouvel article
     * 
     * @param descrip description
     * @param p prix
     */
    public Article(String descrip, float p) {
        this.description = descrip;
        this.prix = p;
    }

    /** 
     * Constructeur pour créer un article recuperer depuis la table Article
     * 
     * @param ids id article dans la table
     * @param descrip description
     * @param p prix
     */
    public Article(Integer ids, String descrip, float p) {
        this.id = ids;
        this.description = descrip;
        this.prix = p;
    }

    /**
     *  Methode ajoutant un article à la table Article
     * 
     * @param a article a ajouter dans la table
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void ajouterArticle(Article a) throws ClassNotFoundException, SQLException {

        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "INSERT INTO ARTICLE (DESCRIPTION,PRIX) "
                + "VALUES ('" + a.description + "'," + a.prix + ");";
        st.executeUpdate(sql);

        cb.fermerConnectionBDD();

    }

    /**
     * 
     * Méthode recuperant tout les articles de la table
     * 
     * @return liste de tout les articles de la table
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Article> allArticle() throws SQLException, ClassNotFoundException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Article> liste = new ArrayList<Article>();
        String sql = "SELECT * FROM ARTICLE;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Article a = new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getFloat("PRIX"));
            liste.add(a);

        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    /**
     * Méthode recuperant une liste d'article
     *  contenant les caracteres rentre en parametre dans la Article
     * 
     * @param descrip nom de l'article
     * @return liste d'article comprenant @descript dans leur nom
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Article> rechercheArticle(String descrip) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Article> liste = new ArrayList<Article>();
        String sql = "SELECT * FROM ARTICLE WHERE DESCRIPTION LIKE '%" + descrip + "%';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Article a = new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getFloat("PRIX"));
            liste.add(a);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    public static ArrayList<Article> trouverArticle(String descrip) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Article> liste = new ArrayList<Article>();
        String sql = "SELECT * FROM ARTICLE WHERE DESCRIPTION ='" + descrip + "';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Article a = new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getFloat("PRIX"));
            liste.add(a);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    /**
     * 
     * Méthode recuperant un article via son id dans la table Article
     * 
     * @param id
     * @return un Article identifier par son id
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Article trouverArticle(int id) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        Article a = null;
        String sql = "SELECT * ARTICLE WHERE ID = " + id + ";";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            a = new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"), rs.getFloat("PRIX"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return a;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }
}
