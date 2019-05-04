
/*
 * Author:  mauro
 * Created: 8-mag-2018
 *
 */


#-------------------------------------------------------------------
#
#                          CREAZIONE TABELLE
#
#-------------------------------------------------------------------
create table categoria (
  idCategoria serial primary key,
  nomeCategoria char(10) not null,
  colore char(6) not null
);

create table tipoutente (
  idTipoUtente serial primary key,
  ruolo char(10) not null
);


create table utente (
  idUtente serial primary key,
  nome char(25) not null,
  cognome char(25) not null,
  data_nascita date not null,
  username char(20) not null,
  email char(30) not null,
  pwd char(30) not null,
  idTipoUtente bigint(1) unsigned not null,
  urlImgProfile varchar(600) not null,
  foreign key (idTipoUtente) references tipoutente(idTipoUtente) on delete cascade
);

create table articolo (
  idArticolo serial primary key,
  titolo char(80) not null,
  corpo mediumtext not null,
  dataScrittura date not null,
  urlImg varchar(600) null,
  didascaliaImg char(100) null,
  idAutore bigint(6) unsigned not null,
  idCategoria bigint(1) unsigned not null,
  foreign key (idAutore) references utente(idUtente) on delete cascade,
  foreign key (idCategoria) references categoria(idCategoria) on delete cascade
);

create table commento (
  idCommento serial primary key,
  dataCommento date not null,
  corpo char(140) not null,
  idAutore bigint(6) unsigned not null,
  idArticolo bigint(6) unsigned not null,
  foreign key (idAutore) references utente(idUtente) on delete cascade,
  foreign key (idArticolo) references articolo(idArticolo) on delete cascade
    
);

#-------------------------------------------------------------------
#
#                          INSERIMENTO DATI
#
#-------------------------------------------------------------------

insert into categoria (idCategoria, nomeCategoria, colore) values
(1, 'Cronaca', 'e64344'),
(2, 'Sport', '2f6750'),
(3, 'Tecnologia', '245f4d'),
(4, 'Politica', '061414'),
(5, 'Gossip', 'f75352'),
(6, 'Cultura', '89804e');


insert into tipoutente (idTipoUtente, ruolo) values
(1, 'AUTORE'),
(2, 'LETTORE'),
(3, 'OSPITE');


insert into utente (idUtente, nome, cognome, data_nascita, username, email, pwd, idTipoUtente, urlImgProfile) values
(1, 'Mauro', 'Marini', '1997-04-24', 'marinimau', 'mauro.marini97@gmail.com', 'prova', 1, 'https://scontent-mxp1-1.cdninstagram.com/vp/44861412bcc26211ac6f78bbb531dd78/5B7C3DE3/t51.2885-19/s320x320/25023065_166506397297516_7853025140102135808_n.jpg'),
(2, 'Marcello', 'Agnese', '1997-06-24', 'marcy.agnese', 'marcy.agnese@gmail.com', 'prova', 2, 'https://scontent-mxp1-1.cdninstagram.com/vp/8a7eef0c72a17b19eea9da950179fef6/5B7F6638/t51.2885-19/s320x320/17662077_236611843479792_6775231946466263040_a.jpg'),
(3, 'Riccardo', 'Espa', '1997-03-02', 'rick.espa', 'rick.espa@gmail.com', 'prova', 2, 'https://scontent-mxp1-1.cdninstagram.com/vp/a41bfcdbd6c7d8615d918eabe606797c/5B5A0B71/t51.2885-19/s320x320/26871008_1911778955530868_5875982634974183424_n.jpg'),
(4, 'Enrico', 'Carnio', '1997-04-03', 'enri.carnio', 'carnio@gmail.com', 'prova', 3, 'https://scontent-mxp1-1.cdninstagram.com/vp/83510b7778f61b5eb60883bf8e10809f/5B695C81/t51.2885-19/s320x320/22500567_132777984112334_4369947142836453376_n.jpg');


insert into articolo (idArticolo, titolo, corpo, dataScrittura, urlImg, didascaliaImg, idAutore, idCategoria) values
(1, 'Maltempo diffuso fino a sabato', 'Rischio nubifragi da domani in Sardegna, con venti di Maestrale fino a 100 km/h, e maltempo diffuso in tutta Italia: secondo le previsioni del Centro Epson Meteo-Meteo.it il vortice di bassa pressione che accompagna la perturbazione numero 1 di maggio insisterà sull''Italia fino a sabato. "Ci attendono quindi - spiegano - molte piogge, venti a tratti burrascosi anche sulla Sicilia e sullo Ionio e mari agitati. Le giornate più ventose saranno quelle di oggi e domani, poi gradualmente da sabato i venti tenderanno ad attenuarsi".\r\n\r\nLa regione in assoluto più colpita dalle piogge, con rischio nubifragi e forti temporali anche insistenti, sarà la Sardegna, "dove sono quindi attese giornate ad elevata criticità idro-geologica, con accumuli fino a 200 litri su metro quadrato". Caleranno anche le temperature, che quasi dappertutto torneranno su valori normali per il periodo, con la fine quindi del caldo fuori stagione che ha caratterizzato la scorsa settimana. Addirittura nel Nord Italia - concludono i meteorologi di Epson Meteo - le temperature faranno registrare valori per lo più sotto la media stagionale". Domenica la situazione sarà molto simile ma con precipitazioni meno probabili al Nordest e sulla Sicilia. La prossima settimana inizierà all''insegna di un timido miglioramento, con tempo ancora instabile e con fenomeni possibili nelle ore più calde della giornata a partire dai rilievi.', '2018-04-24', 'http://www.ansa.it/webimages/img_395x275/2018/5/2/8d1b27eb4627a0f2227428ab24fe9664.jpg', 'Immagine meteo', 2, 1),
(2, 'Napolitano trasferito in reparto, in ottime condizioni', 'Il presidente Emerito Giorgio Napolitano è stato trasferito, lunedì 30 aprile, dalla Terapia intensiva cardiochirurgica al reparto di degenza della cardiochirurgia diretto da Francesco Musumeci. Lo rende noto l''Ospedale San Camillo nell''ultimo bollettini medico.\r\n\r\nIl presidente ha già iniziato il programma di riabilitazione cardio-respiratoria e motoria. E'' "autonomo nell''alimentazione ed in ottime condizioni neuro-cognitive e psicologiche". Il 24 aprile è stato sottoposto a un intervento chirurgico all''aorta superiore.\r\n\r\nIl decorso post operatorio del presidente Emerito Napolitano, si sottolinea nel bollettino medico dell''Ospedale San Camillo, "procede regolarmente in relazione alla complessità dell''intervento e all''età del paziente".', '2018-05-02', 'http://www.ansa.it/webimages/ch_620x438/2018/4/24/073b74259bce0349a3b3634113fd4180.jpg', 'Giorgio Napolitano', 1, 1),
(3, 'Salvini chiede pre-incarico. Colle pronto a nuovo giro. Di Maio, ora al voto.', 'Resta in stallo la trattativa sulla formazione del governo a due mesi dal voto. Il Pd si prepara alla direzione mentre continuano i botta e risposta tra Matteo Salvini e Luigi Di Maio. Il leader del Carroccio ribadisce di voler fare "di tutto" per tentare la formazione di un governo ma si dice anche a disposizione di un tavolo con i pentastellati sulle riforme. \r\n\r\n"Non è possibile nessun governo del cambiamento con Berlusconi e il centrodestra. Salvini ha cambiato idea e si è piegato a lui solo per le poltrone. Si torni subito al voto!", ha scritto su Twitter Di Maio postando una dichiarazione del leader leghista del 2012 in cui Salvini diceva "no a possibili assi tra Carroccio e il Cavaliere", "nessun leghista è disposto a puntare ancora su un''alleanza con Berlusconi".\r\n\r\n"Sono umilmente a disposizione da oggi pomeriggio, quando e dove si vuole, con chi si vuole, in diretta o non in diretta, a sederci attorno a un tavolo con il M5S - dice Salvini - partendo dalla riforma delle pensioni, del lavoro, del sistema fiscale, del sistema giudiziario, del sistema scolastico, punto per punti, senza professoroni, per decidere come si fanno queste riforme".\r\n\r\n"Farò tutto il possibile fino all''ultimo minuto per dare un Governo che duri cinque anni agli italiani, per occuparci dell''emergenza del Paese che è il lavoro", ha detto Salvini. "Mi farò portatore nei prossimi giorni di trattative a Roma della diffusione della ''margherita Itala'', perché è la più resistente, vince chi è più resistente, datemi tante ''margherite Itale'', così vediamo di mettere in piedi questo Governo, che è un parto" ha aggiunto Salvini stamani a Genova in visita a Euroflora riferendosi al nuovo fiore che l''Istituto per la floricoltura ligure ha voluto dedicare a Italo Calvino.\r\n\r\n"Noi siamo disponibili a prendere l''attuale legge elettorale e a mettere un premio di maggioranza che garantisca a chi prende un voto in più di governare, non vogliamo perdere due anni di tempo, l''unica modifica possibile è prendere questa legge elettorale aggiungendoci due righe sul premio di maggioranza".\r\n\r\n"Non rispondo a insulti e sciocchezze su soldi e poltrone - ha detto Matteo Salvini a Luigi Di Maio -, per noi lealtà e coerenza valgono più dei ministeri. Voglio dare un governo agli italiani, se i grillini preferiscono litigare lo faremo da soli. Bloccare anche la partenza dei lavori delle commissioni parlamentari è da irresponsabili".\r\n\r\nE Luigi Di Maio in un post sul blog delle Stelle: "Non resta che tornare subito al voto. Noi non abbiamo alcun problema nel farlo perchè ci sostengono i cittadini con le piccole donazioni. Altri invece si oppongono perchè, tra prestiti e fideiussioni, magari hanno qualche problemino con i soldi. Ma l''Italia non può rimanere bloccata per i guai finanziari di un partito. Al voto". \r\n\r\n"In questi 55 giorni i bugiardi Renzi e Berlusconi si sono sempre sentiti ma la verità è che anche Renzi e Salvini si sentivano - ha detto Luigi Di Maio durante la registrazione di Porta a Porta -. Se l''obiettivo era fare un governo Salvini-Berlusconi-Renzi dovevano dirlo subito. Salvini lo dica: se vuole andare al voto non è vero quello che sto dicendo ma se non vogliono andare al voto lo devono dire a tutti gli italiani". "A me è costato molto" offrire un contratto di governo al Pd, ma "il mio obiettivo era dare un governo al Paese". Poi Di Maio aggiunge: "Mi è costato perchè quello che pensavo del Pd lo penso tuttora. Secondo conosco i problemi del Pd e poi molti nostri attivisti e amministratori stanno combattendo il Pd nei territori". \r\n\r\nPoi il segretario della Lega Matteo Salvini, alludendo alle accuse lanciategli da Luigi Di Maio, ha detto: "Le mie sono scelte politiche dettate unicamente dalla coerenza, dalla lealtà e dal rispetto del voto degli italiani. Chiunque parli di soldi, prestiti, fideiussioni, regali e ricatti inesistenti a me e alla Lega, se finora è stato ignorato, da domani sarà querelato".\r\n', '2018-05-02', 'http://www.ansa.it/webimages/img_457x/2018/4/20/618291dd1e9d69c05c4b495069d3885e.jpg', 'Matteo Salvini e Luigi Di Maio (combo)', 1, 4),
(4, 'Museo Egizio, 187mln ricadute per Torino', 'TORINO, 2 MAG - Il Museo Egizio porta a Torino 187 milioni di euro l''anno, una ricaduta economica di rilievo che coinvolge molti settori. Lo sottolinea una ricerca del Centro Studi Silvia Santagata, che analizza la tipologia di visitatori e l''impatto economico sul territorio.\r\n    Più di un intervistato su quattro indica proprio nella visita all''Egizio il motivo principale del suo viaggio a Torino, viaggio che porta ciascun turista a spendere circa 81 euro al giorno. Il 61,4% del pubblico arriva da altre regioni d''Italia, circa il 15% dall''estero. "Siamo orgogliosi per l''esito di questa indagine che consideriamo un punto di partenza per definire le future strategie e per affermare il ruolo del Museo Egizio sia in ambito scientifico sia turistico", commenta la presidente Evelina Christillin. "Dal 2015 il Museo ha deciso di porre la ricerca al centro - spiega il direttore Christian Greco - e, oggi, la bontà di questa scelta è confermata dai risultati di questa indagine. Investire in ricerca ha un''importanza fondamentale".', '2018-03-02', 'http://www.ansa.it/webimages/img_457x/2018/5/2/5eb12b5cf068ffb5d9f81ab68af7aa41.jpg', 'Fila fuori dal museo egizio', 1, 6),
(5, 'Uomo accoltellato davanti ingresso scuola a Bari', 'Un uomo di 45 anni, della provincia di Bari e senza fissa dimora, è stato soccorso dagli operatori del 118 dopo essere stato accoltellato da persone non ancora identificate davanti all''ingresso della scuola media Amedeo D''Aosta al quartiere Japigia a Bari. L''uomo è ferito e non è in pericolo di vita. Secondo una prima ricostruzione l''aggressione sarebbe avvenuta tra le sette e le otto di questa mattina. A chiamare i soccorsi è stato un passante che ha visto il corpo dell''uomo, colpito al torace, riverso per terra.\r\n\r\nL''accoltellamento è avvenuto nei pressi della rampa d''accesso disabili dell''istituto. Dalle prime indiscrezioni raccolte, i carabinieri avrebbero rinvenuto il coltello con cui sarebbe avvenuto il ferimento. Molti dei ragazzi che già si trovavano a scuola hanno telefonato ai genitori allarmati e hanno chiesto di poter ritornare a casa. Un folto gruppo di genitori si trova tuttora nei pressi dell''ingresso della scuola.\r\n\r\n   Il 45enne ha raccontato di avere subito uno spintone mentre dormiva da un uomo che ha cercato di rubargli un borsello con gli effetti personali. Ne sarebbe quindi nata una colluttazione nel corso della quale lo sconosciuto lo ha ferito con un coltello a scatto con la lama da 8 centimetri. L''arma è stata ritrovata dai carabinieri. Gli investigatori stanno verificato l''attendibilità di questa ricostruzione e stanno acquisendo i video delle telecamere di sorveglianza della zona. ', '2017-06-24', 'http://www.ansa.it/webimages/img_457x/2018/5/2/d19b5036760c8625d920b9230f95d5cd.jpg', 'Uomo accoltellato davanti ingresso scuola a Bari', 1, 1),
(6, 'Champions: Roma Liverpool, c''è Schick', 'Sarà il Liverpool a contendere la Champions League al Real Madrid nella finalissima di Kiev il prossimo 26 maggio. Nel ritorno delle semifinali della massima competizione continentale all''Olimpico, alla Roma non basta la vittoria 4-2 (1-2) non riuscendo, così, a ribaltare il 5-2 della partita di andata ad Anfield. Apre le marcature dopo un bel avvio giallorosso il Liverpool con Manè (9'' pt) che sfrutta uno svarione di Nainggolan. Poi la Roma riesce a pareggiare quasi subito grazie ad una rocambolesca autorete di Milner (15'' pt). Pochi minuti e i Reds tornano in vantaggio con Winaldum che sfrutta un errore di Dzeko trasformatosi difensore (25'' pt). Nella ripresa i giallorossi spingono sempre di più: arriva il pari con Dzeko (7'' pt) e nel finale la doppietta tardiva di Nainggolan (41'' st) e (49'' st su rigore). La squadra di Di Francesco vince tra cori e rimpianti, ma a Kiev andranno Salah (in ombra davanti ai suoi ex tifosi) e compagni.\r\n\r\nOvazione Olimpico alla squadra - La Roma batte il Liverpool 4-2 all''Olimpico ma viene eliminata in Champions League a un passo dalla finale. Lo stadio Olimpico a fine partita si alza però in piedi ad applaudire la squadra allenata da Di Francesco, protagonista comunque di una campagna europea che sulla sponda giallorossa del Tevere mancava da oltre 30 anni. Dopo il fischio finale la squadra, con diversi giocatori in lacrime, è andata sotto al Curva Sud per ringraziare i tifosi e il sostegno ricevuto in campo.\r\n\r\nFazio: "Negati due rigori clamorosi" - "Dobbiamo dare continuità nei prossimi anni, dobbiamo pensare all''anno prossimo e imparare dai nostri errori. Questo deve essere l''inizio, dobbiamo continuare in questo modo". Così Federico Fazio dopo l''inutile vittoria della Rima sul Liverpool che manda i Reds in finale di Champions. "Peccato, anche per i due rigori clamorosi che non ci hanno dato - lamenta l''argentino - e anche per i soli tre minuti di recupero. Ma dobbiamo pensare positivo, prendere tutto il buono che abbiamo fatto. Dobbiamo alzare la testa e continuare".\r\n\r\n', '2018-05-02', 'http://www.ansa.it/webimages/img_457x/2018/5/2/5788127567394fee92cd2763747f0a79.jpg', 'Tifosi romanisti', 1, 2),
(7, 'Dilaga disintossicazione da social media', 'Aumentano i centri per il trattamento delle dipendenze da social media, diffuse tra i ragazzi americani: nonostante non sia un disturbo ancora ufficialmente riconosciuto, l''assuefazione dei giovanissimi americani ai messaggini, snap-chat, twitter, facebook, instagram, sta finendo per spedirne sempre di più nei rehab center, centri per la riabilitazione, dove gli adolescenti vengono lasciati senza smartphone e internet e indirizzati a seguire programmi specializzati. Secondo le analisi di Common-Sense Media, una organizzazione che monitora l''uso dei social, il 50% dei ragazzi Usa si sente dipendente da telefonini e tablet. Il Centro ''Paradigm'' in California, sostiene ad esempio di avere un tasso di successo pari all''80% sui teenager che arrivano assuefatti ad usare gli smartphone 6-7 ore al giorno. La retta può arrivare a costare 50.000 dollari, ma alcune assicurazioni sanitarie ne rimborsano una parte.\r\n\r\nAlcuni ragazzi intervistati dalle tv Usa hanno raccontato l''ansia, la vergogna, lo stress causato dal continuo uso dei social media. "Avevo ansia intensa e non me ne rendevo conto - ha raccontato David Mayer, 17 anni dell''Ohio - avevo creato identità immaginarie di me stesso sui social, stavo collegato 7 ore al giorno. I miei genitori mi hanno spedito in clinica. Ora, dopo 30 giorni senza internet e iphone, sono quasi pronto a cancellare le mie presenze sui principali siti".(ANSA).', '2018-04-29', 'http://www.ansa.it/webimages/img_457x/2018/2/14/7aa16b295adf5be410366e881a87b209.jpg', 'Smartphone', 1, 3);


insert into commento (idCommento, dataCommento, corpo, idAutore, idArticolo) values
(1, '2018-05-01', 'Questo è il commento 1.', 2, 1),
(2, '2018-05-01', 'Questo è il commento 2.', 1, 2),
(3, '2018-05-01', 'Questo è il commento 3.', 3, 3),
(4, '2018-05-01', 'Questo è il commento 4.', 1, 4),
(5, '2018-05-01', 'Questo è il commento 5.', 3, 5),
(6, '2018-05-01', 'Questo è il commento 6.', 2, 6),
(7, '2018-05-01', 'Questo è il commento 7.', 3, 1),
(8, '2018-05-01', 'Questo è il commento 8.', 2, 1),
(9, '2018-05-01', 'Questo è il commento 9.', 1, 2),
(10, '2018-05-01', 'Questo è il commento 10.', 2, 4),
(11, '2018-05-01', 'Questo è il commento 11.', 2, 5),
(12, '2018-05-01', 'Questo è il commento 12.', 1, 5),
(13, '2018-05-01', 'Questo è il commento 13.', 3, 3),
(14, '2018-05-01', 'Questo è il commento 14.', 1, 6),
(15, '2018-05-01', 'Questo è il commento 15.', 1, 1);




