package it.fpw.marinimau.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class CommentoFactory {
    private static CommentoFactory singleton;
    private static ArrayList<Commento> listaCommenti;
    
    public static CommentoFactory getInstance(){
        if(singleton == null){
            singleton = new CommentoFactory();
        }
        
        return singleton;
    }
    
    private CommentoFactory(){

        /*UtenteFactory uf = UtenteFactory.getInstance();
        listaCommenti = new ArrayList<>();
        ArticoloFactory art = ArticoloFactory.getInstance();
        
        Commento comm1 = new Commento();
        comm1.setId(1);
        comm1.setData(2018,4,30);
        comm1.setCorpo("Questo è il commento 1.");
        comm1.setAutore(uf.getUtenteById(2));
        comm1.setArticolo(art.getArticoloById(1));
        
        listaCommenti.add(comm1);
        
        
        Commento comm2 = new Commento();
        comm2.setId(2);
        comm2.setData(2018,5,1);
        comm2.setCorpo("Questo è il commento 2.");
        comm2.setAutore(uf.getUtenteById(1));
        comm2.setArticolo(art.getArticoloById(2));
        
        listaCommenti.add(comm2);
        
        Commento comm3 = new Commento();
        comm3.setId(3);
        comm3.setData(2018,5,1);
        comm3.setCorpo("Questo è il commento 3.");
        comm3.setAutore(uf.getUtenteById(3));
        comm3.setArticolo(art.getArticoloById(3));
        
        listaCommenti.add(comm3);
        
        Commento comm4 = new Commento();
        comm4.setId(4);
        comm4.setData(2018,5,1);
        comm4.setCorpo("Questo è il commento 4.");
        comm4.setAutore(uf.getUtenteById(1));
        comm4.setArticolo(art.getArticoloById(4));
        
        listaCommenti.add(comm4);
        
        Commento comm5 = new Commento();
        comm5.setId(5);
        comm5.setData(2018,5,1);
        comm5.setCorpo("Questo è il commento 5.");
        comm5.setAutore(uf.getUtenteById(3));
        comm5.setArticolo(art.getArticoloById(5));
        
        listaCommenti.add(comm5);
        
        
        Commento comm6 = new Commento();
        comm6.setId(6);
        comm6.setData(2018,5,1);
        comm6.setCorpo("Questo è il commento 6.");
        comm6.setAutore(uf.getUtenteById(2));
        comm6.setArticolo(art.getArticoloById(6));
        
        listaCommenti.add(comm6);
        
        
        Commento comm7 = new Commento();
        comm7.setId(7);
        comm7.setData(2018,5,1);
        comm7.setCorpo("Questo è il commento 7.");
        comm7.setAutore(uf.getUtenteById(3));
        comm7.setArticolo(art.getArticoloById(1));
        
        listaCommenti.add(comm7);
        
        Commento comm8 = new Commento();
        comm8.setId(8);
        comm8.setData(2018,5,1);
        comm8.setCorpo("Questo è il commento 8.");
        comm8.setAutore(uf.getUtenteById(2));
        comm8.setArticolo(art.getArticoloById(1));
        
        listaCommenti.add(comm8);
        
        Commento comm9 = new Commento();
        comm9.setId(9);
        comm9.setData(2018,5,1);
        comm9.setCorpo("Questo è il commento 9.");
        comm9.setAutore(uf.getUtenteById(1));
        comm9.setArticolo(art.getArticoloById(2));
        
        listaCommenti.add(comm9);
        
        Commento comm10 = new Commento();
        comm10.setId(10);
        comm10.setData(2018,5,1);
        comm10.setCorpo("Questo è il commento 10.");
        comm10.setAutore(uf.getUtenteById(2));
        comm10.setArticolo(art.getArticoloById(4));
        
        listaCommenti.add(comm10);
        
        Commento comm11 = new Commento();
        comm11.setId(11);
        comm11.setData(2018,5,1);
        comm11.setCorpo("Questo è il commento 11.");
        comm11.setAutore(uf.getUtenteById(2));
        comm11.setArticolo(art.getArticoloById(5));
        
        listaCommenti.add(comm11);
        
        Commento comm12 = new Commento();
        comm12.setId(12);
        comm12.setData(2018,5,1);
        comm12.setCorpo("Questo è il commento 12.");
        comm12.setAutore(uf.getUtenteById(1));
        comm12.setArticolo(art.getArticoloById(5));
        
        listaCommenti.add(comm12);
        
        
        Commento comm13 = new Commento();
        comm13.setId(13);
        comm13.setData(2018,5,1);
        comm13.setCorpo("Questo è il commento 13.");
        comm13.setAutore(uf.getUtenteById(3));
        comm13.setArticolo(art.getArticoloById(3));
        
        listaCommenti.add(comm13);
        
        Commento comm14 = new Commento();
        comm14.setId(14);
        comm14.setData(2018,5,1);
        comm14.setCorpo("Questo è il commento 14.");
        comm14.setAutore(uf.getUtenteById(1));
        comm14.setArticolo(art.getArticoloById(6));
        
        listaCommenti.add(comm14);
        
        Commento comm15 = new Commento();
        comm15.setId(15);
        comm15.setData(2018,5,1);
        comm15.setCorpo("Questo è il commento 15.");
        comm15.setAutore(uf.getUtenteById(1));
        comm15.setArticolo(art.getArticoloById(1));
        
        listaCommenti.add(comm15);
        */
    }
    
    
    public ArrayList<Commento> getCommentobyAutore(Utente autore){
       ArrayList<Commento> commenti = new ArrayList<>();
       UtenteFactory uf=UtenteFactory.getInstance();
       ArticoloFactory af=ArticoloFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from commento where idAutore=? order by dataCommento desc";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autore.getId());
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato l'articolo
            {
                Commento commentoDaRestituire=new Commento();
                commentoDaRestituire.setId(set.getInt("idCommento"));
                commentoDaRestituire.setData(set.getString("dataCommento"));
                commentoDaRestituire.setCorpo(set.getString("corpo"));
                commentoDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                commentoDaRestituire.setArticolo(af.getArticoloById(set.getInt("idArticolo")));
                commenti.add(commentoDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return commenti;
    }
    
    public ArrayList<Commento> getCommentobyArticolo(Articolo articolo){
       ArrayList<Commento> commenti = new ArrayList<>();
       UtenteFactory uf=UtenteFactory.getInstance();
       ArticoloFactory af=ArticoloFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from commento where idArticolo=? order by dataCommento desc";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, articolo.getId());
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato l'articolo
            {
                Commento commentoDaRestituire=new Commento();
                commentoDaRestituire.setId(set.getInt("idCommento"));
                commentoDaRestituire.setData(set.getString("dataCommento"));
                commentoDaRestituire.setCorpo(set.getString("corpo"));
                commentoDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                commentoDaRestituire.setArticolo(af.getArticoloById(set.getInt("idArticolo")));
                commenti.add(commentoDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return commenti;
    }
}