package bdd;

import java.sql.*;

public class CreationTable {

    public static void CreerTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BDDvideotheque.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE FILM "
                    + "(ID               INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + " TITRE            CHAR(50) NOT NULL UNIQUE, "
                    + " DESCRIPTION      CHAR(500), "
                    + " GENRE            CHAR(50) )";
            stmt.executeUpdate(sql);
            System.out.println("table Film creee");

            sql = "CREATE TABLE LOCATION "
                    + "(ID                       INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " VIDEOTHEQUE_ID           INT NOT NULL, "
                    + " CLIENT_NUMTEL            INT NOT NULL, "
                    + " DUREE_LOCATION           INT NOT NULL, "
                    + " DATE_TRANSACTION         DATE NOT NULL, "
                    + " DATE_RETOUR_LOCATION     DATE, "
                    + " FOREIGN KEY(VIDEOTHEQUE_ID)  REFERENCES VIDEOTHEQUE(ID), "
                    + " FOREIGN KEY(CLIENT_NUMTEL)   REFERENCES CLIENT(NUMTEL) )";

            stmt.executeUpdate(sql);
            System.out.println("table Location creee");

            sql = "CREATE TABLE CLIENT "
                    + "(NUMTEL         CHAR(10) PRIMARY KEY,"
                    + " CODESEC        CHAR(255) NOT NULL, "
                    + " NOM            CHAR(50) NOT NULL, "
                    + " PRENOM         CHAR(50) NOT NULL, "
                    + " EMAIL          CHAR(50) NOT NULL,"
                    + " NORUE          CHAR(50) NOT NULL,"
                    + " NOMRUE         CHAR(50) NOT NULL,"
                    + " VILLE          CHAR(50) NOT NULL,"
                    + " PROVINCE       CHAR(50) NOT NULL,"
                    + " CODEPOSTAL     CHAR(50) NOT NULL )";

            stmt.executeUpdate(sql);
            System.out.println("table Client creee");

            sql = "CREATE TABLE ARTICLE  "
                    + "(ID           INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " DESCRIPTION  CHAR(50) NOT NULL, "
                    + " PRIX         FLOAT NOT NULL)";

            stmt.executeUpdate(sql);
            System.out.println("table Article creee");

            sql = "CREATE TABLE VIDEOTHEQUE "
                    + "(ID               INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + " FILM_ID          INT NOT NULL, "
                    + " VENDABLE         BOOLEAN NOT NULL, "
                    + " QTEE             INT NOT NULL, "
                    + " DUREE_LOCATION   INT NOT NULL, "
                    + " PRIX_LOCATION     FLOAT NOT NULL, "
                    + " PRIX_VENTE        FLOAT, "
                    + " FOREIGN KEY(FILM_ID) REFERENCES FILM(ID) )";

            stmt.executeUpdate(sql);
            System.out.println("table Videotheque creee");

            sql = "CREATE TABLE VENTE "
                    + "(ID               INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " CLIENT_NUMTEL    INT , "
                    + " DESCRIPTION      CHAR(500), "
                    + " PRIX_TOTAL       FLOAT, "
                    + " DATE_TRANSACTION DATE, "
                    + " FOREIGN KEY(CLIENT_NUMTEL) REFERENCES CLIENT(NUMTEL) )";

            stmt.executeUpdate(sql);
            System.out.println("table Vente creee");

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
