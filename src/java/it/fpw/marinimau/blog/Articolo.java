package it.fpw.marinimau.blog;

import java.util.GregorianCalendar;

/**
 *
 * @author mauro
 */
public class Articolo {
    private int id;
    private String titolo;
    private String corpo;
    private GregorianCalendar data;
    private String urlImg;
    private String didascaliaImg;
    private Utente autore;
    private Categoria categoria;

    public Articolo(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(String data_acquisita) {
        String[] parts = data_acquisita.split("-");
        int year= Integer.parseInt( parts[0]);
        int month= Integer.parseInt( parts[1]);
        int day= Integer.parseInt( parts[2]);
        GregorianCalendar aux= new GregorianCalendar(year,month,day);
        this.data=aux;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDidascaliaImg() {
        return didascaliaImg;
    }

    public void setDidascaliaImg(String didascaliaImg) {
        this.didascaliaImg = didascaliaImg;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria cat) {
        this.categoria = cat;
    }
    
     
    /*
     * restituisce i primi 100 caratteri del corpo della notizia
     */
    public String tagliaCorpo(){
       String preview;
        if(this.corpo.length()>100){
            preview=this.corpo.substring(0,100);
            return preview;
        }
        else
            return this.corpo;
    }
    
    public String dateString(){
        int day,month,year;
        day = data.get(GregorianCalendar.DATE);
        month = data.get(GregorianCalendar.MONTH);
        year = data.get(GregorianCalendar.YEAR);
        return (day+"/"+month+"/"+year);
    }
    
    //serve per i campi date nei form
    public String dateValue(){
        int day,month,year;
        day = data.get(GregorianCalendar.DATE);
        month = data.get(GregorianCalendar.MONTH);
        year = data.get(GregorianCalendar.YEAR);
        return (year+"-"+month+"-"+day);
    }
    
}
