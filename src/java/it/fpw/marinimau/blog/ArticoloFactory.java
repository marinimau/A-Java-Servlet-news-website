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
public class ArticoloFactory {
    private static ArticoloFactory singleton;
    private static ArrayList<Articolo> listaArticoli = new ArrayList<>();
            
    public static ArticoloFactory getInstance(){
        if(singleton == null){
            singleton = new ArticoloFactory();
        }
        
        return singleton;
    }
    
    private ArticoloFactory(){
        /*
        UtenteFactory uf = UtenteFactory.getInstance();
        CategoriaFactory cf = CategoriaFactory.getInstance();
        
        
        Articolo art1 = new Articolo();
        art1.setId(1);
        art1.setTitolo("Maltempo diffuso fino a sabato");
        art1.setCorpo("Rischio nubifragi da domani in Sardegna, con venti di Maestrale fino a 100 km/h, e maltempo diffuso in tutta Italia: secondo le previsioni del Centro Epson Meteo-Meteo.it il vortice di bassa pressione che accompagna la perturbazione numero 1 di maggio insisterà sull'Italia fino a sabato. \"Ci attendono quindi - spiegano - molte piogge, venti a tratti burrascosi anche sulla Sicilia e sullo Ionio e mari agitati. Le giornate più ventose saranno quelle di oggi e domani, poi gradualmente da sabato i venti tenderanno ad attenuarsi\".\n" +
"\n" +
"La regione in assoluto più colpita dalle piogge, con rischio nubifragi e forti temporali anche insistenti, sarà la Sardegna, \"dove sono quindi attese giornate ad elevata criticità idro-geologica, con accumuli fino a 200 litri su metro quadrato\". Caleranno anche le temperature, che quasi dappertutto torneranno su valori normali per il periodo, con la fine quindi del caldo fuori stagione che ha caratterizzato la scorsa settimana. Addirittura nel Nord Italia - concludono i meteorologi di Epson Meteo - le temperature faranno registrare valori per lo più sotto la media stagionale\". Domenica la situazione sarà molto simile ma con precipitazioni meno probabili al Nordest e sulla Sicilia. La prossima settimana inizierà all'insegna di un timido miglioramento, con tempo ancora instabile e con fenomeni possibili nelle ore più calde della giornata a partire dai rilievi.");
        art1.setData(2018,4,24);
        art1.setUrlImg("http://www.ansa.it/webimages/img_395x275/2018/5/2/8d1b27eb4627a0f2227428ab24fe9664.jpg");
        art1.setDidascaliaImg("Immagine meteo");
        art1.setAutore(uf.getUtenteById(2));
        art1.setCategoria(cf.getCategoriaById(1));
        
        listaArticoli.add(art1);

        Articolo art2 = new Articolo();
        art2.setId(2);
        art2.setTitolo("Napolitano trasferito in reparto, in ottime condizioni");
        art2.setCorpo("Il presidente Emerito Giorgio Napolitano è stato trasferito, lunedì 30 aprile, dalla Terapia intensiva cardiochirurgica al reparto di degenza della cardiochirurgia diretto da Francesco Musumeci. Lo rende noto l'Ospedale San Camillo nell'ultimo bollettini medico.\n" +
"\n" +
"Il presidente ha già iniziato il programma di riabilitazione cardio-respiratoria e motoria. E' \"autonomo nell'alimentazione ed in ottime condizioni neuro-cognitive e psicologiche\". Il 24 aprile è stato sottoposto a un intervento chirurgico all'aorta superiore.\n" +
"\n" +
"Il decorso post operatorio del presidente Emerito Napolitano, si sottolinea nel bollettino medico dell'Ospedale San Camillo, \"procede regolarmente in relazione alla complessità dell'intervento e all'età del paziente\".");
        art2.setData(2017,5,2);
        art2.setUrlImg("http://www.ansa.it/webimages/ch_620x438/2018/4/24/073b74259bce0349a3b3634113fd4180.jpg");
        art2.setDidascaliaImg("Giorgio Napolitano");
        art2.setAutore(uf.getUtenteById(1));
        art2.setCategoria(cf.getCategoriaById(1));
        
        listaArticoli.add(art2);
        
        
        Articolo art3 = new Articolo();
        art3.setId(3);
        art3.setTitolo("Scontro Di Maio-Salvini");
        art3.setCorpo("Resta in stallo la trattativa sulla formazione del governo a due mesi dal voto. Il Pd si prepara alla direzione mentre continuano i botta e risposta tra Matteo Salvini e Luigi Di Maio. Il leader del Carroccio ribadisce di voler fare \"di tutto\" per tentare la formazione di un governo ma si dice anche a disposizione di un tavolo con i pentastellati sulle riforme. \n" +
"Non è possibile nessun governo del cambiamento con Berlusconi e il centrodestra. Salvini ha cambiato idea e si è piegato a lui solo per le poltrone. Si torni subito al voto!\", ha scritto su Twitter Di Maio postando una dichiarazione del leader leghista del 2012 in cui Salvini diceva \"no a possibili assi tra Carroccio e il Cavaliere\", \"nessun leghista è disposto a puntare ancora su un'alleanza con Berlusconi.\n" +
"Sono umilmente a disposizione da oggi pomeriggio, quando e dove si vuole, con chi si vuole, in diretta o non in diretta, a sederci attorno a un tavolo con il M5S - dice Salvini - partendo dalla riforma delle pensioni, del lavoro, del sistema fiscale, del sistema giudiziario, del sistema scolastico, punto per punti, senza professoroni, per decidere come si fanno queste riforme.");
        art3.setData(2018,5,2);
        art3.setUrlImg("http://www.ansa.it/webimages/img_457x/2018/4/20/618291dd1e9d69c05c4b495069d3885e.jpg");
        art3.setDidascaliaImg("Matteo Salvini e Luigi Di Maio (combo)");
        art3.setAutore(uf.getUtenteById(1));
        art3.setCategoria(cf.getCategoriaById(4));
        
        listaArticoli.add(art3);
        
        Articolo art4 = new Articolo();
        art4.setId(4);
        art4.setTitolo("Museo Egizio, 187mln ricadute per Torino");
        art4.setCorpo("TORINO, 2 MAG - Il Museo Egizio porta a Torino 187 milioni di euro l'anno, una ricaduta economica di rilievo che coinvolge molti settori. Lo sottolinea una ricerca del Centro Studi Silvia Santagata, che analizza la tipologia di visitatori e l'impatto economico sul territorio.\n" +
"Più di un intervistato su quattro indica proprio nella visita all'Egizio il motivo principale del suo viaggio a Torino, viaggio che porta ciascun turista a spendere circa 81 euro al giorno. Il 61,4% del pubblico arriva da altre regioni d'Italia, circa il 15% dall'estero. \"Siamo orgogliosi per l'esito di questa indagine che consideriamo un punto di partenza per definire le future strategie e per affermare il ruolo del Museo Egizio sia in ambito scientifico sia turistico\", commenta la presidente Evelina Christillin. \"Dal 2015 il Museo ha deciso di porre la ricerca al centro - spiega il direttore Christian Greco - e, oggi, la bontà di questa scelta è confermata dai risultati di questa indagine. Investire in ricerca ha un'importanza fondamentale\".");
        art4.setData(2017,5,1);
        art4.setUrlImg("http://www.ansa.it/webimages/img_457x/2018/5/2/5eb12b5cf068ffb5d9f81ab68af7aa41.jpg");
        art4.setDidascaliaImg("Fila fuori dal museo egizio");
        art4.setAutore(uf.getUtenteById(1));
        art4.setCategoria(cf.getCategoriaById(6));
        
        listaArticoli.add(art4);
        
        Articolo art5 = new Articolo();
        art5.setId(5);
        art5.setTitolo("Uomo accoltellato davanti ingresso scuola a Bari");
        art5.setCorpo("Un uomo di 45 anni, della provincia di Bari e senza fissa dimora, è stato soccorso dagli operatori del 118 dopo essere stato accoltellato da persone non ancora identificate davanti all'ingresso della scuola media Amedeo D'Aosta al quartiere Japigia a Bari. L'uomo è ferito e non è in pericolo di vita. Secondo una prima ricostruzione l'aggressione sarebbe avvenuta tra le sette e le otto di questa mattina. A chiamare i soccorsi è stato un passante che ha visto il corpo dell'uomo, colpito al torace, riverso per terra.\n" +
"\n" +
"L'accoltellamento è avvenuto nei pressi della rampa d'accesso disabili dell'istituto. Dalle prime indiscrezioni raccolte, i carabinieri avrebbero rinvenuto il coltello con cui sarebbe avvenuto il ferimento. Molti dei ragazzi che già si trovavano a scuola hanno telefonato ai genitori allarmati e hanno chiesto di poter ritornare a casa. Un folto gruppo di genitori si trova tuttora nei pressi dell'ingresso della scuola.\n" +
"\n" +
"   Il 45enne ha raccontato di avere subito uno spintone mentre dormiva da un uomo che ha cercato di rubargli un borsello con gli effetti personali. Ne sarebbe quindi nata una colluttazione nel corso della quale lo sconosciuto lo ha ferito con un coltello a scatto con la lama da 8 centimetri. L'arma è stata ritrovata dai carabinieri. Gli investigatori stanno verificato l'attendibilità di questa ricostruzione e stanno acquisendo i video delle telecamere di sorveglianza della zona. ");
        art5.setData(2017,6,24);
        art5.setUrlImg("http://www.ansa.it/webimages/img_457x/2018/5/2/d19b5036760c8625d920b9230f95d5cd.jpg");
        art5.setDidascaliaImg("Uomo accoltellato davanti ingresso scuola a Bari");
        art5.setAutore(uf.getUtenteById(1));
        art5.setCategoria(cf.getCategoriaById(1));
        
        listaArticoli.add(art5);
        
        Articolo art6 = new Articolo();
        art6.setId(6);
        art6.setTitolo("Champions: Roma Liverpool, c'è Schick ");
        art6.setCorpo("Stasera all'Olimpico Roma-Liverpool, l'atteso ritorno di semifinale di Champions League con l'allerta sicurezza dopo gli scontri dell'andata. DIRETTA E FOTO \n" +
"\n" +
"i Francesco alla fine ha scelto di tornare all'antico. La Roma proverà a raggiungere la finale di Champions League di Kiev abbandonando la difesa a 3 e rispolverando il fidato 4-3-3. In difesa contro il Liverpool spazio alla coppia Manolas-Fazio, con Florenzi a destra e Kolarov a sinistra. In cabina di regia c'è De Rossi, mentre Pellegrini e Nainggolan completano la linea mediana. Attacco guidato da Dzeko, con Schick ed El Shaarawy ai fianchi del bosniaco. Nessuna novità nemmeno nel Liverpool di Klopp che, forte del 5-2 di Anfield, si affida a Karius tra i pali, Alexander-Arnold, Lovren, van Dijk e Robertson in difesa, Wijnaldum, Henderson e Milner a centrocampo, Firmino, Mané, e l'ex Salah in attacco\n" +
"\n" +
"Di Francesco cerca la \"grande rimonta\", dopo il 5-2 dell'andata. Strootman fuori dalla rosa dei convocati. Klopp: \"non siamo il Barcellona, vogliamo la finale");
        art6.setData(2017,5,2);
        art6.setUrlImg("http://www.ansa.it/webimages/img_457x/2018/5/2/5788127567394fee92cd2763747f0a79.jpg");
        art6.setDidascaliaImg("Tifosi romanisti");
        art6.setAutore(uf.getUtenteById(1));
        art6.setCategoria(cf.getCategoriaById(2));
        
        listaArticoli.add(art6);
        
        Articolo art7 = new Articolo();
        art7.setId(7);
        art7.setTitolo("Dilaga disintossicazione da social media");
        art7.setCorpo("Aumentano i centri per il trattamento delle dipendenze da social media, diffuse tra i ragazzi americani: nonostante non sia un disturbo ancora ufficialmente riconosciuto, l'assuefazione dei giovanissimi americani ai messaggini, snap-chat, twitter, facebook, instagram, sta finendo per spedirne sempre di più nei rehab center, centri per la riabilitazione, dove gli adolescenti vengono lasciati senza smartphone e internet e indirizzati a seguire programmi specializzati. Secondo le analisi di Common-Sense Media, una organizzazione che monitora l'uso dei social, il 50% dei ragazzi Usa si sente dipendente da telefonini e tablet. Il Centro 'Paradigm' in California, sostiene ad esempio di avere un tasso di successo pari all'80% sui teenager che arrivano assuefatti ad usare gli smartphone 6-7 ore al giorno. La retta può arrivare a costare 50.000 dollari, ma alcune assicurazioni sanitarie ne rimborsano una parte.\n" +
"\n" +
"Alcuni ragazzi intervistati dalle tv Usa hanno raccontato l'ansia, la vergogna, lo stress causato dal continuo uso dei social media. \"Avevo ansia intensa e non me ne rendevo conto - ha raccontato David Mayer, 17 anni dell'Ohio - avevo creato identità immaginarie di me stesso sui social, stavo collegato 7 ore al giorno. I miei genitori mi hanno spedito in clinica. Ora, dopo 30 giorni senza internet e iphone, sono quasi pronto a cancellare le mie presenze sui principali siti\".(ANSA).");
        art7.setData(2017,4,29);
        art7.setUrlImg("http://www.ansa.it/webimages/img_700/2018/2/14/7aa16b295adf5be410366e881a87b209.jpg");
        art7.setDidascaliaImg("Smartphone");
        art7.setAutore(uf.getUtenteById(1));
        art7.setCategoria(cf.getCategoriaById(3));
        
        listaArticoli.add(art7);
   */
    }
    
  
    public Articolo getArticoloById(int id){
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where idArticolo = ?";
            Articolo articoloDaRestituire = new Articolo();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if (set.next()) //Se ho trovato l'utente
            {
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
            }
            
            stmt.close();
            conn.close();
            
            return articoloDaRestituire;
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
 
    
    public ArrayList<Articolo> getNewsByDate(){
        ArrayList<Articolo> articoliOrdinati = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo order by dataScrittura desc";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato l'utente
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                articoliOrdinati.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articoliOrdinati;
    }
    
    public ArrayList<Articolo> getNews(){
        ArrayList<Articolo> articoli = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato l'articolo
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                articoli.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articoli;
    }
    
    public ArrayList<Articolo> getNewsByAuthor(Utente autore){
        ArrayList<Articolo> articoliDellAutore = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where idAutore=? order by dataScrittura desc";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autore.getId());
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho trovato articoli dell'autore
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                articoliDellAutore.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articoliDellAutore;
    }

    public ArrayList<Articolo> getNewsByCategory(Categoria categoria){
        ArrayList<Articolo> articoliDellaCategoria = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where idCategoria=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoria.getId());
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho la categoria
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                articoliDellaCategoria.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articoliDellaCategoria;
    }
    
    public ArrayList<Articolo> getNewsByCategoryOrdinate(Categoria categoria){
        ArrayList<Articolo> articoliDellaCategoriaOrdinati = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from articolo where idCategoria=? order by dataScrittura desc";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoria.getId());
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho la categoria
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                articoliDellaCategoriaOrdinati.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return articoliDellaCategoriaOrdinati;
    }
    
    public boolean modificaArticolo(Articolo art){
        boolean modify_OK = false;
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            
            String sql = "update articolo set titolo=?, corpo=?, urlImg=?, didascaliaImg=?, idCategoria=?  WHERE idArticolo = ?;";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, art.getTitolo());
            stmt.setString(2, art.getCorpo());
            stmt.setString(3, art.getUrlImg());
            stmt.setString(4, art.getDidascaliaImg());
            stmt.setInt(5, art.getCategoria().getId());
            stmt.setInt(6, art.getId());

            
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
    
    public int inserisciArticolo(Articolo art){
        int insert_OK = -1;
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            
            /*
             * Inizio transazione, dovrò rendere atomica l'inserimento e la select dell'id dell'articolo 
             * appena inserito che ci servià per caricare la pagina di modifica 
             *(voglio evitare che se nel mentre qualcuno inserisse un nuovo articolo venga caricato l'id di un articolo differente)
             */
            conn.setAutoCommit(false);
            
            /*Inserisco l'articolo*/
            String sql = "insert into articolo values (default, ?, ?, now(), ?, ?, ?, ?);";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, art.getTitolo());
            stmt.setString(2, art.getCorpo());
            stmt.setString(3, art.getUrlImg());
            stmt.setString(4, art.getDidascaliaImg());
            stmt.setInt(5, art.getAutore().getId());
            stmt.setInt(6, art.getCategoria().getId());

            
            int rows = stmt.executeUpdate();
            /*controllo l'inserimento*/
            if(rows == 1){
                /*Se ha avuto successo recupero l'id dell'articolo appena inserito*/
                System.out.println("Insert ok!");
                /*recupero l'ultimo articolo*/
                String ultimo = "select idArticolo from articolo order by idArticolo desc limit 1";
                PreparedStatement stmt_ultimo = conn.prepareStatement(ultimo);
                ResultSet set = stmt_ultimo.executeQuery();
                if (set.next()){
                    insert_OK=set.getInt("idArticolo");
                }
            }
            
            //fine della transazione
            conn.commit();
            conn.setAutoCommit(true);
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
    
    public boolean eliminaArticolo(Articolo articolo){
        Connection conn=null;
        try{
            conn = DbManager.getInstance().getDbConnection();
            
            //metto l'autoCommit a false per iniziare la transazione
            conn.setAutoCommit(false);
            
            //elimino i commenti all'articolo
            String comm = "delete from commento where idArticolo = ?";
            PreparedStatement removeCommento = conn.prepareStatement(comm);
            removeCommento.setInt(1, articolo.getId());
            removeCommento.executeUpdate();
            
            //elimino l'articolo
            String post = "delete from articolo where idArticolo = ?";
            PreparedStatement removeArticolo = conn.prepareStatement(post);
            removeArticolo.setInt(1, articolo.getId());
            removeArticolo.executeUpdate();
            
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
    
    
    public boolean eliminaArticolo(int id_articolo){
        Connection conn=null;
        try{
            conn = DbManager.getInstance().getDbConnection();
            
            //metto l'autoCommit a false per iniziare la transazione
            conn.setAutoCommit(false);
            
            //elimino i commenti all'articolo
            String comm = "delete from commento where idArticolo = ?";
            PreparedStatement removeCommento = conn.prepareStatement(comm);
            removeCommento.setInt(1, id_articolo);
            removeCommento.executeUpdate();
            
            //elimino l'articolo
            String post = "delete from articolo where idArticolo = ?";
            PreparedStatement removeArticolo = conn.prepareStatement(post);
            removeArticolo.setInt(1, id_articolo);
            removeArticolo.executeUpdate();
            
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
    
    public ArrayList<Articolo> cercaArticolo(String toSearch){
        ArrayList<Articolo> risultati = new ArrayList<>();    
        UtenteFactory uf=UtenteFactory.getInstance();
        CategoriaFactory cf=CategoriaFactory.getInstance();
         try {
            Connection conn = DbManager.getInstance().getDbConnection();
            //String sql = "select * from articolo where titolo like ? or corpo like ? order by dataScrittura desc";
            //preferisco solo titolo ma funzionano entrambe
            String sql = "select * from articolo where titolo like ? order by dataScrittura desc";
            //character stuffing per gestire il caso in cui toSearch contenga i simboli di seguito elencati
            toSearch = toSearch
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + toSearch + "%");
            //stmt.setString(2, "%" + toSearch + "%");
            
            ResultSet set = stmt.executeQuery();
            
            while (set.next()) //Se ho la categoria
            {
                Articolo articoloDaRestituire=new Articolo();
                articoloDaRestituire.setId(set.getInt("idArticolo"));
                articoloDaRestituire.setTitolo(set.getString("titolo"));
                articoloDaRestituire.setCorpo(set.getString("corpo"));
                articoloDaRestituire.setData(set.getString("dataScrittura"));                
                articoloDaRestituire.setUrlImg(set.getString("urlImg"));
                articoloDaRestituire.setDidascaliaImg(set.getString("didascaliaImg"));
                articoloDaRestituire.setAutore(uf.getUtenteById(set.getInt("idAutore")));
                articoloDaRestituire.setCategoria(cf.getCategoriaById(set.getInt("idCategoria")));
                
                risultati.add(articoloDaRestituire);
            
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return risultati;
    }
    
}
