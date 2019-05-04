/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CategoriaFactory {
    private static CategoriaFactory singleton;
    private static final ArrayList<Categoria> listaCategorie = new ArrayList<>();
            
    public static CategoriaFactory getInstance(){
        if(singleton == null){
            singleton = new CategoriaFactory();
        }
        
        return singleton;
    }
    
    private CategoriaFactory(){
        /*
        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNome("Cronaca");
        cat1.setColore("#e64344");
        
        listaCategorie.add(cat1);

        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNome("Sport");
        cat2.setColore("#2f6750");
        
        listaCategorie.add(cat2);
        
        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setNome("Tecnologia");
        cat3.setColore("#245f4d");
        
        listaCategorie.add(cat3);
        
        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNome("Politica");
        cat4.setColore("#061414");
        
        listaCategorie.add(cat4);
        
        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNome("Gossip");
        cat5.setColore("#f75352");
        
        listaCategorie.add(cat5);
        
        Categoria cat6 = new Categoria();
        cat6.setId(6);
        cat6.setNome("Cultura");
        cat6.setColore("#89804e");
        
        listaCategorie.add(cat6);
        */
        
    }
    
    public Categoria getCategoriaById(int id){   
         try {
            Categoria categoriaDaRestituire=new Categoria();
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from categoria where idCategoria=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()) //Se ho trovato l'articolo
            {
                categoriaDaRestituire.setId(set.getInt("idCategoria"));
                categoriaDaRestituire.setNome(set.getString("nomeCategoria"));
                categoriaDaRestituire.setColore("#"+set.getString("colore"));
            }
            
            stmt.close();
            conn.close();
            
            return categoriaDaRestituire;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Categoria> getCategorie(){
        ArrayList<Categoria> categorie = new ArrayList<>();    
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from categoria";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato l'articolo
            {
                Categoria categoriaDaRestituire=new Categoria();
                categoriaDaRestituire.setId(set.getInt("idCategoria"));
                categoriaDaRestituire.setNome(set.getString("nomeCategoria"));
                categoriaDaRestituire.setColore("#"+set.getString("colore"));
                
                categorie.add(categoriaDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categorie;
    }
    
    public ArrayList<Categoria> cercaCategoria(String toSearch){
        ArrayList<Categoria> risultati = new ArrayList<>();    
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            //query per cercare gli autori che soddisfano la ricerca
            String sql = "select * from categoria where nomeCategoria like ? order by nomeCategoria";
            //character stuffing per gestire il caso in cui toSearch contenga i simboli di seguito elencati
            /*toSearch = toSearch
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");*/
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + toSearch + "%");
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho la categoria
            {
                Categoria categoriaDaRestituire=new Categoria();
                categoriaDaRestituire.setId(set.getInt("idCategoria"));
                categoriaDaRestituire.setNome(set.getString("nomeCategoria"));
                categoriaDaRestituire.setColore(set.getString("colore"));
                
                risultati.add(categoriaDaRestituire);           
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return risultati;
    }
    
}
 
