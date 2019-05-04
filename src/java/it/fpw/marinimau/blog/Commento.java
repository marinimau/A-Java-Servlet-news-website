package it.fpw.marinimau.blog;

import java.util.GregorianCalendar;

/**
 *
 * @author mauro
 */


public class Commento {
    private int id;
    private GregorianCalendar data;
    private String corpo;
    private Utente autore;
    private Articolo articolo;
    
    public Commento(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(String data) {
        String[] parts = data.split("-");
        int year= Integer.parseInt( parts[0]);
        int month= Integer.parseInt( parts[1]);
        int day= Integer.parseInt( parts[2]);
        GregorianCalendar aux= new GregorianCalendar(year,month,day);
        this.data=aux;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }
    
    
    public String dateString(){
        int day,month,year;
        day = data.get(GregorianCalendar.DATE);
        month = data.get(GregorianCalendar.MONTH);
        year = data.get(GregorianCalendar.YEAR);
        return (year+"/"+month+"/"+day);
    }
    
    public String dateValue(){
        int day,month,year;
        day = data.get(GregorianCalendar.DATE);
        month = data.get(GregorianCalendar.MONTH);
        year = data.get(GregorianCalendar.YEAR);
        return (year+"-"+month+"-"+day);
    }

}
