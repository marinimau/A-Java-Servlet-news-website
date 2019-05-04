<%-- 
    Document   : navibar
    Created on : 21-apr-2018, 15.12.01
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--sidebar: contiene logo, navigazione, e footer,scrollabile idipendentemente nei layout a 2 colonne-->
        <aside id="left-sidebar">
            <!--logo-->
            <div id="logo"></div>
            <!--navigazione, avremo: form di ricerca (sempre presente),menu di navigazione:
                    -   mobile: presente solo nei layout a una colonna, i  font sono più grandi e le varie categorie vengono racchiuse in pochi link;
                    -   navigazione normale, comprende:
                            -   pagine del sito;
                            -   categorie;   
                            -   autori;
                        è visibile solo nei layout a 2 colonne, autori e categorie saranno due link e non due menù indipendenti nella navigazione mobile.-->
            <nav class="navigation">
                <!--form per la ricerca-->
                <h3>Cerca nel sito:</h3>
                <div id="cerca-div">
                    <input type="text" name="cerca" id="cerca" placeholder="cerca...">
                </div>
            </nav>
            <!--navigazione mobile unica, visibile solo nei layout a una colonna-->
            <nav class="navigation" id="mobile">
                <ul>
                    <li><a href="login.html"><h3>HOME</h3></a></li>
                    <!--
                        Se sono loggato e autore, mostro le voci
                            -scrivi articolo
                            -articoli
                    -->
                    <c:if test="${loggedIn==true && tipo=='AUTORE'}">
                        <li><a href="articoli.html"><h3>ARTICOLI</h3></a></li>
                        <li><a href="scriviArticolo.html"><h3>SCRIVI ARTICOLO</h3></a></li>
                    </c:if>
                    <li><a href="notizie.html"><h3>NOTIZIE</h3></a></li>
                    <!--
                        Se sono loggato mostro la voce profilo, sennò mostro la voce login
                    -->
                    <c:choose>
                        <c:when test="${loggedIn==true}">
                            <li><a href="profilo.html"><h3>PROFILO</h3></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="login.html"><h3>LOGIN</h3></a></li>
                            <li><a href="registrazione.html"><h3>REGISTRAZIONE</h3></a></li>
                        </c:otherwise>   
                    </c:choose>
                    <li><a href="#"><h3>CATEGORIE</h3></a></li>
                    <li><a href="#"><h3>AUTORI</h3></a></li>
                </ul>                  
            </nav>
            <!--navigazione pagine del sito, visibile solo nei layout a 2 colonne-->
            <nav class="navigation" id="pagine">
                <h3>Pagine del sito:</h3>
                <ul>
                    <li><a href="notizie.html">Home</a></li>
                    <!--
                        Se sono loggato e autore, mostro le voci
                            -scrivi articolo
                            -articoli
                    -->
                    <c:if test="${loggedIn==true && tipo=='AUTORE'}">
                        <li><a href="articoli.html">Articoli</a></li>
                        <li><a href="scriviArticolo.html">Scrivi Articolo</a></li>
                    </c:if>                    
                    <li><a href="notizie.html">Notizie</a></li>
                    <!--
                        Se sono loggato mostro la voce profilo, sennò mostro la voce login
                    -->
                    <c:choose>
                        <c:when test="${loggedIn==true}">
                            <li><a href="profilo.html">Profilo</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="registrazione.html">Registrazione</a></li>
                        </c:otherwise>   
                    </c:choose>
                </ul>
            </nav>
            <!--navigazione categorie, visibile solo nei layout a 2 colonne-->
            <nav class="navigation" id="categorie">
                <!--
                    se esistono delle categorie le mostro
                -->
                 <c:if test="${categorie.size()>=1}">
                    <h3>Categorie:</h3>
                    
                    <ul>
                        <div id="listaCategorie">
                            <li><a href="notizie.html">Tutto</a></li>
                            <c:forEach var="categoria" items="${categorie}">
                                <li><a href="notizie.html?categoria=${categoria.getId()}">${categoria.getNome()}</a></li>
                            </c:forEach>
                        </div>
                    </ul>
                    
                </c:if>                
            </nav>
            <!--navigazione autori, visibile solo nei layout a 2 colonne-->
            <nav class="navigation" id="autori">
                <!--
                    se esistono autori, li mostro
                -->
                <c:if test="${autori.size()>=1}">
                    <h3>Autori:</h3>
                    <ul>
                        <div id="listaAutori">
                            <c:forEach var="autore" items="${autori}">
                                <li><img src="${autore.getUrlImgProfilo()}"><a href="notizie.html?autore=${autore.getId()}">${autore.getNome()} ${autore.getCognome()}</a></li>
                            </c:forEach>
                        </div>
                    </ul>
                </c:if>
            </nav>
            <!--dati del footer-->
            <div id="copy">
                <p>
                    Milestone1 | Mauro Marini 65354 email: <a href="mailto:mauro.marini97@gmail.com">mauro.marini97@gmail.com</a>
                </p>
            </div>
        </aside>
