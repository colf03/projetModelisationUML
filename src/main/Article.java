package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Article {
	
	private Integer id;
	private String description ;
	private float prix ;

	
	public Article () 	{
		
		this.description = null ;
		this.prix= 0 ;
		
	}
	
	public Article (String descrip, float p){
		
		this.description=descrip;
		this.prix=p;
		
	}
	
	public Article (Integer ids, String descrip, float p){
		
		this.id=ids;
		this.description=descrip;
		this.prix=p;
		
	}
	
	
	public static void ajouterArticle (Article a) throws ClassNotFoundException, SQLException{
		
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	
    	String sql = "INSERT INTO ARTICLE (DESCRIPTION,PRIX) " +
                "VALUES ('"+a.description+"',"+a.prix+");";
          st.executeUpdate(sql);

          cb.fermerConnectionBDD();
		
	}
	
	
	public static ArrayList<Article> allArticle() throws SQLException, ClassNotFoundException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	ArrayList<Article> liste= new ArrayList<Article>();
    	String sql= "SELECT * FROM ARTICLE;";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	Article a= new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"),rs.getFloat("PRIX"));
        	liste.add(a);
        	
        }
        rs.close();
        cb.fermerConnectionBDD();
    	return liste;	
		
	}
	
	public static ArrayList<Article> trouverArticle (String descrip) throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	ArrayList<Article> liste= new ArrayList<Article>();
    	String sql= "SELECT * ARTICLE WHERE DESCRIPTION LIKE '%"+descrip+"%';";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	Article a= new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"),rs.getFloat("PRIX"));
        	liste.add(a);
        	
        }
        rs.close();
        cb.fermerConnectionBDD();
    	return liste;	
		
		
	}
	
	
	public static Article trouverArticle (int id) throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	Article a=null;
    	String sql= "SELECT * ARTICLE WHERE ID = "+id+";";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	a= new Article(rs.getInt("ID"), rs.getString("DESCRIPTION"),rs.getFloat("PRIX"));
        	
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
