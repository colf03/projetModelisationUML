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
		      System.out.println("table Film cree");
		      
		      
		      
		      sql="CREATE TABLE CLIENT " +
	                   "(NUMTEL CHAR(10) PRIMARY KEY  ," +
	                   " CODESEC        CHAR(256)    NOT NULL, " +
	                   " NOM            CHAR(50)    NOT NULL, " + 
	                   " PRENOM         CHAR(50) NOT NULL, " + 
	                   " NORUE          CHAR(50) NOT NULL,"+
                           " NOMRUE         CHAR(50) NOT NULL,"+
                           " VILLE         CHAR(50) NOT NULL,"+
                           " PROVINCE         CHAR(50) NOT NULL,"+
                           " CODEPOSTAL         CHAR(50) NOT NULL,"+
	                   " EMAIL          CHAR(50) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Client cree");
		      
		      sql="CREATE TABLE ARTICLE  " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT  ," +
	                   " DESCRIPTION    CHAR(50)    NOT NULL, " + 
	                   " PRIX  FLOAT NOT NULL)"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Article cree");
		      
		      
		      sql="CREATE TABLE VIDEOTHEQUE " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
		    		   " FILM_ID INT  ," +
	                   " VENDABLE   BOOLEAN    NOT NULL, " + 
	                   " LOUE  BOOLEAN    NOT NULL, " + 
	                   " PRIX  FLOAT, "+
	                   " FOREIGN KEY(FILM_ID) REFERENCES FILM(ID) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Videotheque créée");
		      
		      sql="CREATE TABLE VENTE " +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
		    		   " CLIENT_NUMTEL INT , " + 
	                   " PRIX_TOTAL  FLOAT, "+
	                   " MODE_PAIEMENT  CHAR(50), "+
	                   " DATE_TRANSACTION DATE, "+
	                   " FOREIGN KEY(CLIENT_NUMTEL) REFERENCES CLIENT(NUMTEL) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Vente cree");
		      

		      sql="CREATE TABLE LOCATION " +
		    		   "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
	                   " VIDEOTHEQUE_ID INTEGER  ," +
	                   " CLIENT_NUMTEL INT , " + 
	                   " DATE_TRANSACTION DATE, "+
	                   " DATE_RETOUR_LOCATION DATE, "+
	                   " FOREIGN KEY(VIDEOTHEQUE_ID) REFERENCES VIDEOTHEQUE(ID), "+
	                   " FOREIGN KEY(CLIENT_NUMTEL) REFERENCES CLIENT(NUMTEL) )"; 
		      
		      stmt.executeUpdate(sql);
		      System.out.println("table Location cree");
		      
		      
		      
		      
		      
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		// TODO Auto-generated method stub

	}

}
