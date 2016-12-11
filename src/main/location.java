package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class Location extends Transaction{
	
	
	private Integer id;
	private Integer videothequeId;
	private String date_retour;
	
	
	
	private Location (Integer i, Integer idFilm, int idNumtel, String dateTransac, String dateRetour ) {
		super (idNumtel,dateTransac);
		this.id=i;
		this.videothequeId=idFilm;
		this.date_transaction=dateTransac;
		this.date_retour=dateRetour;
	}
	
	
	public Location (int idNumtel,Integer idFilm ) {
		super (idNumtel);
		this.videothequeId=idFilm;
		
		//date retour= 14 jour de plus a la date actuelle
		Calendar calendrier = Calendar.getInstance(); 
		calendrier.add(Calendar.DAY_OF_MONTH, 14);
		Date d=calendrier.getTime();
		this.date_retour=new SimpleDateFormat("yyyy-MM-dd").format(d);
	}
	
	
	public void ajouterLocation() throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	
    	String sql = "INSERT INTO LOCATION(VIDEOTHEQUE_ID,CLIENT_NUMTEL,DATE_TRANSACTION,DATE_RETOUR_LOCATION) " +
                "VALUES ("+videothequeId+","+id_numtel+","+date_transaction+","+date_retour+");";
         st.executeUpdate(sql);
         cb.fermerConnectionBDD();
         
         FilmVideotheque.louerFilm(videothequeId);
	}
	
	public static ArrayList<Location> allLocation () throws ClassNotFoundException, SQLException{
		ConnectionBDD cb= new ConnectionBDD();
    	Statement st=cb.getStmt();
    	ArrayList<Location> liste= new ArrayList<Location>();
    	String sql= "SELECT * FROM VENTE;";
        ResultSet rs=st.executeQuery(sql);
        while ( rs.next() ) {
        	Location l = new Location(rs.getInt("ID"), rs.getInt("VIDEOTHEQUE_ID"),rs.getInt("CLIENT_NUMTEL"),
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




	
	
	
	

}
