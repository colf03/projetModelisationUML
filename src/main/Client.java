package main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Client {

    private String numTel;
    private String codeSecret;
    private String nom;
    private String prenom;
    private String email;
    private String noRue;
    private String nomRue;
    private String ville;
    private String province;
    private String codePostal;

    /**
     * Constructeur client pour insertion dans la table Client
     * 
     * @param num numero telephone du client
     * @param code code du client
     * @param n nom du client
     * @param p prenom du client
     * @param mail mail du client
     * @param noRue numero de rue
     * @param nomRue nom de la rue
     * @param ville ville du client
     * @param province province du client
     * @param codePostal code postal du client
     */
    public Client(String num, char[] code, String n, String p, String mail, String noRue, String nomRue, String ville, String province, String codePostal) {
        this.numTel = num;
        this.codeSecret = saltHash(code);
        this.nom = n;
        this.prenom = p;
        this.noRue = noRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.email = mail;
    }

    
    /**
     * Constructeur client pour recuperer client dans la table Client
     * 
     * @param num numero du client
     * @param code code du client
     * @param n nom du client
     * @param p prenom du client
     * @param mail mail du client
     * @param noRue numero de rue
     * @param nomRue nom de la rue
     * @param ville ville du client
     * @param province province du client
     * @param codePostal code postal du client
     */
    public Client(String num, String code, String n, String p, String mail, String noRue, String nomRue, String ville, String province, String codePostal) {
        this.numTel = num;
        this.codeSecret = code;
        this.nom = n;
        this.prenom = p;
        this.email = mail;
        this.noRue = noRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
    }

    /**
     * Methode pour ajouter un client dans la table Client
     * 
     * @param cl client 
     * @param code code client
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws UnautorizedException
     */
    public static void ajouterClient(Client cl, char[] code) throws ClassNotFoundException, SQLException, UnautorizedException {
        try {
            trouverClient(cl.numTel, code);
            ConnectionBDD cb = new ConnectionBDD();
            Statement st = cb.getStmt();

            String sql = "UPDATE CLIENT "
                    + "SET CODESEC='" + cl.codeSecret + "',NOM='" + cl.nom + "',PRENOM='" + cl.prenom + "',EMAIL='" + cl.email + "',NORUE='" + cl.noRue + "',NOMRUE='" + cl.nomRue + "',VILLE='" + cl.ville + "',PROVINCE='" + cl.province + "',CODEPOSTAL='" + cl.codePostal + "' "
                    + "WHERE NUMTEL='" + cl.numTel + "'";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();
        } catch (NotFoundException ex) {
            ConnectionBDD cb = new ConnectionBDD();
            Statement st = cb.getStmt();

            String sql = "INSERT INTO CLIENT (NUMTEL,CODESEC,NOM,PRENOM,EMAIL,NORUE,NOMRUE,VILLE,PROVINCE,CODEPOSTAL) "
                    + "VALUES ('" + cl.numTel + "','" + cl.codeSecret + "','" + cl.nom + "','" + cl.prenom + "','" + cl.email + "','" + cl.noRue + "','" + cl.nomRue + "','" + cl.ville + "','" + cl.province + "','" + cl.codePostal + "');";
            st.executeUpdate(sql);

            cb.fermerConnectionBDD();
        }

    }

    /**
     * Methode pour modifier un client dans la table Client
     * 
     * @param cl client 
     * @param codeSecret code client
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws UnautorizedException
     */
    public static void modifierClient(Client cl, char[] codeSecret) throws ClassNotFoundException, SQLException, UnautorizedException {

        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "INSERT INTO CLIENT (NUMTEL,CODESEC,NOM,PRENOM,EMAIL,NORUE,NOMRUE,VILLE,PROVINCE,CODEPOSTAL) "
                + "VALUES ('" + cl.numTel + "','" + cl.codeSecret + "','" + cl.nom + "','" + cl.prenom + "','" + cl.email + "','" + cl.noRue + "','" + cl.nomRue + "','" + cl.ville + "','" + cl.province + "','" + cl.codePostal + "');";
        st.executeUpdate(sql);

        cb.fermerConnectionBDD();
    }

    /** 
     * Methode pour recuperer tout les clients de la table client
     * 
     * @return liste de tout les client
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Client> allClient() throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Client> liste = new ArrayList<Client>();
        String sql = "SELECT * FROM CLIENT;";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Client c = new Client(rs.getString("NUMTEL"), rs.getString("CODESEC"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"), rs.getString("NORUE"), rs.getString("NOMRUE"), rs.getString("VILLE"), rs.getString("PROVINCE"), rs.getString("CODEPOSTAL"));
            liste.add(c);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    /**
     * Methode pour verifier si un client existe dans la table Client
     * 
     * @param num numero telephone client
     * @param code code client
     * @return boolean si client existe ou non
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NotFoundException
     */
    public static boolean verifierClient(String num, char[] code) throws ClassNotFoundException, SQLException, NotFoundException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        String sql = "SELECT CODESEC FROM CLIENT WHERE NUMTEL = '" + num + "';";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            String codeDB = rs.getString("CODESEC");
            rs.close();
            cb.fermerConnectionBDD();
            return verifierCode(code, codeDB);
        } else {
            rs.close();
            cb.fermerConnectionBDD();
            throw new NotFoundException();
        }
    }

    /**
     * Methode pour recuperer un client specifique dans la table Client
     * 
     * @param num numero telephone client
     * @param code code client
     * @return un client
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws UnautorizedException
     * @throws NotFoundException
     */
    public static Client trouverClient(String num, char[] code) throws ClassNotFoundException, SQLException, UnautorizedException, NotFoundException {
        if (!verifierClient(num, code)) {
            throw new UnautorizedException();
        }
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        Client c = null;
        String sql = "SELECT * FROM CLIENT WHERE NUMTEL = '" + num + "';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            c = new Client(rs.getString("NUMTEL"), rs.getString("CODESEC"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"), rs.getString("NORUE"), rs.getString("NOMRUE"), rs.getString("VILLE"), rs.getString("PROVINCE"), rs.getString("CODEPOSTAL"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return c;
    }
    
    public static Client trouverClient(String num) throws ClassNotFoundException, SQLException{
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        Client c = null;
        String sql = "SELECT * FROM CLIENT WHERE NUMTEL = '" + num + "';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            c = new Client(rs.getString("NUMTEL"), rs.getString("CODESEC"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"), rs.getString("NORUE"), rs.getString("NOMRUE"), rs.getString("VILLE"), rs.getString("PROVINCE"), rs.getString("CODEPOSTAL"));
        }
        rs.close();
        cb.fermerConnectionBDD();
        return c;
    }

    /**
     * Methode pour recuperer tout les client comprenant les caracterere passe en parametres
     * 
     * @param nom nom client
     * @return liste clients
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Client> trouverClients(String nom) throws SQLException, ClassNotFoundException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();
        ArrayList<Client> liste = new ArrayList<Client>();
        String sql = "SELECT * FROM CLIENT  WHERE NOM LIKE '%" + nom + "%';";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Client c = new Client(rs.getString("NUMTEL"), rs.getString("CODESEC"), rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("EMAIL"), rs.getString("NORUE"), rs.getString("NOMRUE"), rs.getString("VILLE"), rs.getString("PROVINCE"), rs.getString("CODEPOSTAL"));
            liste.add(c);
        }
        rs.close();
        cb.fermerConnectionBDD();
        return liste;
    }

    /**
     *  Methode pour supprimer un client de la table Client
     * 
     * @param numtel numero telephone
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void supprimerClient(int numtel) throws ClassNotFoundException, SQLException {
        ConnectionBDD cb = new ConnectionBDD();
        Statement st = cb.getStmt();

        String sql = "DELETE from CLIENT WHERE NUMTEL = " + numtel + ";";
        st.executeUpdate(sql);

        cb.fermerConnectionBDD();
    }

    /**
     * Methode pour hasher le codeSecret d 'un client pour la table
     * 
     * @param codeSecret codeSecret du client
     * @return
     */
    private static String saltHash(char[] codeSecret) {
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(32);
            return Base64.getEncoder().encodeToString(salt) + '$' + hash(codeSecret, salt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private static String hash(char[] codeSecret, byte[] salt) {
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey cle = f.generateSecret(new PBEKeySpec(
                    codeSecret, salt, 20 * 1000, 256)
            );
            return Base64.getEncoder().encodeToString(cle.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    private static boolean verifierCode(char[] codeSecret, String codeDB) {
        String[] saltEtCode = codeDB.split("\\$");
        String hash = hash(codeSecret, Base64.getDecoder().decode(saltEtCode[0]));
        return hash.equals(saltEtCode[1]);
    }

    public String getNumTel() {
        return numTel;
    }

    public String getCodeSecret() {
        return codeSecret;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getNoRue() {
        return noRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public String getVille() {
        return ville;
    }

    public String getProvince() {
        return province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public static class UnautorizedException extends Exception {

        public UnautorizedException() {
        }
    }

    public static class NotFoundException extends Exception {

        public NotFoundException() {
        }
    }
}
