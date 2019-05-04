package it.fpw.marinimau.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mauro
 */
public class UtenteFactory {
    private static UtenteFactory instance;
    private static ArrayList<Utente> listaUtenti = new ArrayList<>();
    
    private UtenteFactory()
    {
        /*
        Utente usr1 = new Utente();
        usr1.setId(1);
        usr1.setNome("Mauro");
        usr1.setCognome("Marini");
        usr1.setData_nascita(1997,4,24);
        usr1.setUsername("marinimau");
        usr1.setPassword("prova");
        usr1.setEmail("mauro.marini97@gmail.com");
        usr1.setTipoUtente(Tipo.AUTORE);
        usr1.setUrlImgProfilo("https://scontent-mxp1-1.cdninstagram.com/vp/44861412bcc26211ac6f78bbb531dd78/5B7C3DE3/t51.2885-19/s320x320/25023065_166506397297516_7853025140102135808_n.jpg");
        
        listaUtenti.add(usr1);
        
        Utente usr2 = new Utente();
        usr2.setId(2);
        usr2.setNome("Marcello");
        usr2.setCognome("Agnese");
        usr2.setData_nascita(1997,6,24);
        usr2.setUsername("marcy.agnese");
        usr2.setPassword("prova");
        usr2.setEmail("marcy.agnese@gmail.com");
        usr2.setTipoUtente(Tipo.LETTORE);
        usr2.setUrlImgProfilo("https://scontent-mxp1-1.cdninstagram.com/vp/8a7eef0c72a17b19eea9da950179fef6/5B7F6638/t51.2885-19/s320x320/17662077_236611843479792_6775231946466263040_a.jpg");
        
        listaUtenti.add(usr2);
        
        Utente usr3 = new Utente();
        usr3.setId(3);
        usr3.setNome("Riccardo");
        usr3.setCognome("Espa");
        usr3.setData_nascita(1997,3,2);
        usr3.setUsername("rich.espa");
        usr3.setPassword("prova");
        usr3.setEmail("espa@gmail.com");
        usr3.setTipoUtente(Tipo.LETTORE);
        usr3.setUrlImgProfilo("https://scontent-mxp1-1.cdninstagram.com/vp/a41bfcdbd6c7d8615d918eabe606797c/5B5A0B71/t51.2885-19/s320x320/26871008_1911778955530868_5875982634974183424_n.jpg");
        
        listaUtenti.add(usr3);
        
        Utente usr4 = new Utente();
        usr4.setId(4);
        usr4.setNome("Enrico");
        usr4.setCognome("Carnio");
        usr4.setData_nascita(1997,4,3);
        usr4.setUsername("enri.carnio");
        usr4.setPassword("prova");
        usr4.setEmail("carnio@gmail.com");
        usr4.setTipoUtente(Tipo.OSPITE);
        usr4.setUrlImgProfilo("https://scontent-mxp1-1.cdninstagram.com/vp/83510b7778f61b5eb60883bf8e10809f/5B695C81/t51.2885-19/s320x320/22500567_132777984112334_4369947142836453376_n.jpg");
        
        listaUtenti.add(usr4);
     */   
    }
    
    public static UtenteFactory getInstance(){
        if (instance == null)
            instance = new UtenteFactory();
        return instance;
    }
    
    public ArrayList<Utente> getUsers(){
        ArrayList<Utente> usersFromDB = new ArrayList<>();
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from utente";
            ResultSet set = stmt.executeQuery(sql);
            
            while (set.next()) {
                Utente UtenteDaAggiungere = new Utente();
                UtenteDaAggiungere.setId(set.getInt("idUtente"));
                UtenteDaAggiungere.setNome(set.getString("nome"));
                UtenteDaAggiungere.setCognome(set.getString("cognome"));
                UtenteDaAggiungere.setData_nascita(set.getString("data_nascita"));
                UtenteDaAggiungere.setUsername(set.getString("username"));
                UtenteDaAggiungere.setEmail(set.getString("email"));
                UtenteDaAggiungere.setPassword(set.getString("pwd"));
                UtenteDaAggiungere.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                UtenteDaAggiungere.setUrlImgProfilo(set.getString("urlImgProfile"));
                
                usersFromDB.add(UtenteDaAggiungere);
                
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return usersFromDB;
    }

    public ArrayList<Utente> getAutori(){
        ArrayList<Utente> usersFromDB = new ArrayList<>();
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from utente where idTipoUtente=1";
            ResultSet set = stmt.executeQuery(sql);
            
            while (set.next()) {
                Utente UtenteDaAggiungere = new Utente();
                UtenteDaAggiungere.setId(set.getInt("idUtente"));
                UtenteDaAggiungere.setNome(set.getString("nome"));
                UtenteDaAggiungere.setCognome(set.getString("cognome"));
                UtenteDaAggiungere.setData_nascita(set.getString("data_nascita"));
                UtenteDaAggiungere.setUsername(set.getString("username"));
                UtenteDaAggiungere.setEmail(set.getString("email"));
                UtenteDaAggiungere.setPassword(set.getString("pwd"));
                UtenteDaAggiungere.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                UtenteDaAggiungere.setUrlImgProfilo(set.getString("urlImgProfile"));
                
                usersFromDB.add(UtenteDaAggiungere);
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return usersFromDB;
    }
    
    public Utente getUtenteById(int id){
      try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where idUtente = ?";
            Utente utenteDaRestituire = new Utente();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            GregorianCalendar cal;
            
            if (set.next()) //Se ho trovato l'utente
            {
                utenteDaRestituire.setId(set.getInt("idUtente"));
                utenteDaRestituire.setNome(set.getString("nome"));
                utenteDaRestituire.setCognome(set.getString("cognome"));
                utenteDaRestituire.setData_nascita(set.getString("data_nascita"));                
                utenteDaRestituire.setUsername(set.getString("username"));
                utenteDaRestituire.setEmail(set.getString("email"));
                utenteDaRestituire.setPassword(set.getString("pwd"));
                utenteDaRestituire.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                utenteDaRestituire.setUrlImgProfilo(set.getString("urlImgProfile"));
            }
            
            stmt.close();
            conn.close();
            
            return utenteDaRestituire;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Utente getUtenteByName(String name){
      try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where nome = ?";
            Utente utenteDaRestituire = new Utente();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, name );
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()) //Se ho trovato l'utente
            {
                utenteDaRestituire.setId(set.getInt("idUtente"));
                utenteDaRestituire.setNome(set.getString("name"));
                utenteDaRestituire.setCognome(set.getString("cognome"));
                utenteDaRestituire.setData_nascita(set.getString("data_nascita"));                
                utenteDaRestituire.setUsername(set.getString("username"));
                utenteDaRestituire.setEmail(set.getString("email"));
                utenteDaRestituire.setPassword(set.getString("pwd"));
                utenteDaRestituire.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                utenteDaRestituire.setUrlImgProfilo(set.getString("urlImgProfile"));
            }
            
            stmt.close();
            conn.close();
            
            return utenteDaRestituire;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Utente getUtenteByEmail(String email){
      try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where email = ?";
            Utente utenteDaRestituire = new Utente();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email );
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()) //Se ho trovato l'utente
            {
                utenteDaRestituire.setId(set.getInt("idUtente"));
                utenteDaRestituire.setNome(set.getString("nome"));
                utenteDaRestituire.setCognome(set.getString("cognome"));
                utenteDaRestituire.setData_nascita(set.getString("data_nascita"));                
                utenteDaRestituire.setUsername(set.getString("username"));
                utenteDaRestituire.setEmail(set.getString("email"));
                utenteDaRestituire.setPassword(set.getString("pwd"));
                utenteDaRestituire.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                utenteDaRestituire.setUrlImgProfilo(set.getString("urlImgProfile"));
            }
            
            stmt.close();
            conn.close();
            
            return utenteDaRestituire;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean login(String email, String password){
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utente where email = ? and " + "pwd = ?";
            Boolean loggedIn = false;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet set = stmt.executeQuery();
            
            loggedIn = set.next();
            
            stmt.close();
            conn.close();
  
            return loggedIn;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public boolean aggiungiUtente(String nome, String cognome, String data_nascita, String username, String password, String email, Tipo tipo_utente, String urlImgProfilo){
        boolean insert_OK = false;
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            
            String sql = "insert into utente values"
                    + "(default, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, data_nascita);
            stmt.setString(4, username);
            stmt.setString(5, email);
            stmt.setString(6, password);
            stmt.setInt(7, tipo_utente.ordinal());
            stmt.setString(8, urlImgProfilo);

            int rows = stmt.executeUpdate();
            if(rows == 1){
                System.out.println("Insert ok!");
                insert_OK = true;
            }
            // chiudo lo statement
            stmt.close();
            // chiusura della connessione
            conn.close();    
            
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return insert_OK;     
    }
    
    public boolean modficaUtente(Utente utente){
        boolean modify_OK = false;
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            
            String sql = "update utente set nome=?, cognome=?, data_nascita=?, username=?, email=?, pwd=?, urlImgProfile =?  WHERE idUtente = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, utente.getNome());
            stmt.setString(2, utente.getCognome());
            stmt.setString(3, utente.dateValue());
            stmt.setString(4, utente.getUsername());
            stmt.setString(5, utente.getEmail());
            stmt.setString(6, utente.getPassword());
            stmt.setString(7, utente.getUrlImgProfilo());
            stmt.setInt(8, utente.getId());
            
            int rows = stmt.executeUpdate();
            if(rows == 1){
                System.out.println("Insert ok!");
                modify_OK = true;
            }
            // chiudo lo statement
            stmt.close();
            // chiusura della connessione
            conn.close();    
            
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return modify_OK;
    }
    
    public boolean eliminaUtente(Utente utente){
        Connection conn=null;
        try{
            conn = DbManager.getInstance().getDbConnection();
            
            //metto l'autoCommit a false per iniziare la transazione
            conn.setAutoCommit(false);
            
            //elimino i comment dell'autore
            String comm = "delete from commento where idAutore = ?";
            PreparedStatement removeCommento = conn.prepareStatement(comm);
            removeCommento.setInt(1, utente.getId());
            removeCommento.executeUpdate();
            
            //elimino le notizie dell'utente
            String post = "delete from articolo where idAutore = ?";
            PreparedStatement removeNotizia = conn.prepareStatement(post);
            removeNotizia.setInt(1, utente.getId());
            removeNotizia.executeUpdate();
            
            //infine rimuovo l'utente
            String user = "delete from utente where idUtente = ?";
            PreparedStatement removeUtente = conn.prepareStatement(user);
            removeUtente.setInt(1, utente.getId());
            removeUtente.executeUpdate();
            
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, e);
            if(conn!=null){
                try{
                    conn.rollback();
                }catch(SQLException ex){
                    Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }  
    }
    
public ArrayList<Utente> cercaAutore(String toSearch){
        ArrayList<Utente> risultati = new ArrayList<>();    
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            //query per cercare gli autori che soddisfano la ricerca
            String sql = "select * from utente where idTipoUtente=1 and (nome like ? or cognome like ?) order by cognome";
            //character stuffing per gestire il caso in cui toSearch contenga i simboli di seguito elencati
            /*toSearch = toSearch
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");*/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + toSearch + "%");
            stmt.setString(2, "%" + toSearch + "%");
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho la categoria
            {
                Utente utenteDaRestituire=new Utente();
                utenteDaRestituire.setId(set.getInt("idUtente"));
                utenteDaRestituire.setNome(set.getString("nome"));
                utenteDaRestituire.setCognome(set.getString("cognome"));
                utenteDaRestituire.setData_nascita(set.getString("data_nascita"));
                utenteDaRestituire.setUsername(set.getString("username"));
                utenteDaRestituire.setEmail(set.getString("email"));
                utenteDaRestituire.setPassword(set.getString("pwd"));
                utenteDaRestituire.setTipoUtente(Tipo.values()[set.getInt("idTipoUtente")-1]);
                utenteDaRestituire.setUrlImgProfilo(set.getString("urlImgProfile"));
                
                risultati.add(utenteDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return risultati;
    }
    
}
