package it.fpw.marinimau.blog;


import java.util.GregorianCalendar;

/**
 *
 * @author mauro
 */


public class Utente {
    
    private int id;
    private String nome;
    private String cognome;
    private GregorianCalendar data_nascita;
    private String username;
    private String password;
    private String email;
    private Tipo tipoUtente;
    private String urlImgProfilo;

    public Utente(){
        //this.data_nascita=GregorianCalendar.getInstance();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public GregorianCalendar getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(String data_acquisita) {
        String[] parts = data_acquisita.split("-");
        int year= Integer.parseInt( parts[0]);
        int month= Integer.parseInt( parts[1]);
        int day= Integer.parseInt( parts[2]);
        GregorianCalendar aux= new GregorianCalendar(year,month,day);
        this.data_nascita=aux;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tipo getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(Tipo tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlImgProfilo() {
        return urlImgProfilo;
    }

    public void setUrlImgProfilo(String urlImgProfilo) {
        this.urlImgProfilo = urlImgProfilo;
    }
    
    public String dateString(){
        int day,month,year;
        day = data_nascita.get(GregorianCalendar.DATE);
        month = data_nascita.get(GregorianCalendar.MONTH);
        year = data_nascita.get(GregorianCalendar.YEAR);
        return (day+"/"+month+"/"+year);
    }
    
    //serve per i campi date nei form
    public String dateValue(){
        int day,month,year;
        day = data_nascita.get(GregorianCalendar.DATE);
        month = data_nascita.get(GregorianCalendar.MONTH);
        year = data_nascita.get(GregorianCalendar.YEAR);
        return (year+"-"+month+"-"+day);
    }

    void setData_nascita(GregorianCalendar date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}



