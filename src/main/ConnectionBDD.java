package main;

import java.io.File;
import java.sql.*;

public class ConnectionBDD {

    private Connection c;
    private Statement stmt;

    public ConnectionBDD() throws ClassNotFoundException, SQLException {
        this.c = null;
        this.stmt = null;
        Class.forName("org.sqlite.JDBC");
        File db = new File("BDDvideotheque.db");
        if (!db.exists()){
            bdd.CreationTable.CreerTable();
        }
        this.c = DriverManager.getConnection("jdbc:sqlite:BDDvideotheque.db");
        this.stmt = this.c.createStatement();
    }

    public void fermerConnectionBDD() throws SQLException {
        this.stmt.close();
        this.c.close();
    }

    public Connection getC() {
        return c;
    }

    public Statement getStmt() {
        return stmt;
    }
}
