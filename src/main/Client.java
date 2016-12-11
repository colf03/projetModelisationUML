package main;


import java.sql.*;
import java.util.ArrayList;

public class Client {
	
	private int numTel;
	private int codeSecret;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	

	public Client (int num, int code, String n, String p, String adr, String mail){
		this.numTel=num;
		this.codeSecret=code;
		this.nom=n;
		this.prenom=p;
		this.adresse=adr;
		this.email=mail;
	}
	
	
	public static void ajouterClient (Client cl) throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	
    	String sql = "INSERT INTO CLIENT (NUMTEL,CODESEC,NOM,PRENOM,ADRESSE,EMAIL) " +
                "VALUES ("+cl.numTel+","+cl.codeSecret+",'"+cl.nom+"','"+cl.prenom+"','"+cl.adresse+"','"+cl.email+"');";
          st.executeUpdate(sql);

          cb.fermerConnectionBDD();
    	
    }
	
	public static ArrayList<Client> allClient()throws ClassNotFoundException, SQLException{
    	ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	ArrayList<Client> liste= new ArrayList<Client>();
    	String sql= "SELECT * FROM CLIENT;";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	Client c= new Client(rs.getInt("NUMTEL"), rs.getInt("CODESEC"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("ADRESSE"),rs.getString("EMAIL"));
        	liste.add(c);
        	
        }
        rs.close();
        cb.fermerConnectionBDD();
    	return liste;	
	}
	
	public static Client trouverClient (int num , int code) throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	Client c=null;
    	String sql= "SELECT * FROM CLIENT WHERE NUMTEL = "+num+" AND CODESEC ="+code+";";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	c= new Client(rs.getInt("NUMTEL"), rs.getInt("CODESEC"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("ADRESSE"),rs.getString("EMAIL"));
        	
        	
        }
        rs.close();
        cb.fermerConnectionBDD();
    	return c;	
    }
	
	public static  ArrayList<Client> trouverClient (String nom)throws SQLException, ClassNotFoundException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	ArrayList<Client> liste= new ArrayList<Client>();
    	String sql= "SELECT * FROM CLIENT  WHERE NOM LIKE '%"+nom+"%';";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	Client c= new Client(rs.getInt("NUMTEL"), rs.getInt("CODESEC"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("ADRESSE"),rs.getString("EMAIL"));
        	liste.add(c);
        	
        }
        rs.close();
        cb.fermerConnectionBDD();
    	return liste;	
	}
	
	 public static void SupprimerClient(int numtel) throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
	    Statement st=cb.getStmt();
	    	
	    String sql = "DELETE from CLIENT WHERE NUMTEL = "+numtel+";";
	    st.executeUpdate(sql);

        cb.fermerConnectionBDD();
    }


	public int getNumTel() {
		return numTel;
	}


	public int getCodeSecret() {
		return codeSecret;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public String getEmail() {
		return email;
	}
		
		
	
		
		
	
	

}
