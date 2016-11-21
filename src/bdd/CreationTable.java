package bdd;
import java.sql.*;
public class CreationTable {

	public static void main(String[] args) {
		
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:BDDvideotheque.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE FILM " +
		                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
		                   " TITRE         CHAR(50)    NOT NULL, " + 
		                   " DESCRIPTION     CHAR(500), " + 
		                   " GENRE       CHAR(50) )"; 
		      stmt.executeUpdate(sql);
		      System.out.println("table Film cr�e");
		      
		      
		      
		      sql="CREATE TABLE CLIENT " +
	                   "(CODE INT PRIMARY KEY  ," +
	                   " NOM         CHAR(50)    NOT NULL, " + 
	                   " PRENOM     CHAR(50) NOT NULL, " + 
	                   " ADRESSE     CHAR(50) NOT NULL,"+
	                   " EMAIL  CHAR(50) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Client cr�e");
		      
		      sql="CREATE TABLE ARTICLE  " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT  ," +
	                   " DESCRIPTION    CHAR(50)    NOT NULL, " + 
	                   " PRIX  FLOAT NOT NULL)"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Article cr�e");
		      
		      
		      sql="CREATE TABLE VIDEOTHEQUE " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
		    		   " FILM_ID INT  ," +
	                   " VENDABLE   BOOLEAN    NOT NULL, " + 
	                   " LOUE  BOOLEAN    NOT NULL, " + 
	                   " PRIX  FLOAT, "+
	                   " FOREIGN KEY(FILM_ID) REFERENCES FILM(ID) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Videotheque cr�e");
		      
		      sql="CREATE TABLE Vente " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
		    		   " CLIENT_CODE INT , " + 
	                   " PRIX_TOTAL  FLOAT, "+
	                   " MODE_PAIEMENT  CHAR(50), "+
	                   " DATE_VENTE DATE, "+
	                   " FOREIGN KEY(CLIENT_CODE) REFERENCES CLIENT(CODE) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Vente cr�e");
		      

		      sql="CREATE TABLE LOCATION " +
	                   "(VIDEOTHEQUE_ID INTEGER  ," +
	                   " CLIENT_CODE INT , " + 
	                   " DATE_LOCATION DATE, "+
	                   " DATE_RETOUR_LOCATION DATE, "+
	                   " FOREIGN KEY(VIDEOTHEQUE_ID) REFERENCES VIDEOTHEQUE(ID), "+
	                   " FOREIGN KEY(CLIENT_CODE) REFERENCES CLIENT(CODE) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Location cr�e");
		      
		      
		      
		      
		      
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		// TODO Auto-generated method stub

	}

}
