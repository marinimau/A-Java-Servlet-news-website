<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--topbar con barra che mostra il login attuale-->
        <jsp:include page="topbar.jsp"></jsp:include>
        <!--/#topbar-->
        <!--sidebar: contiene logo, navigazione, e footer,scrollabile idipendentemente nei layout a 2 colonne-->
        <jsp:include page="navibar.jsp"></jsp:include>
        <!--Contenitore del corpo del sito, contiene:
                -   header:
                    -   titolo;
                -   corpo del sito;
        -->
        <article id="content">
            <!--header con titolo articolo-->
            <jsp:include page="article_header.jsp"></jsp:include>
            <!--corpo dell' articolo-->
            <div class="article-text">
                <!--tabella articoli:
                    campi:
                        -   Data: contiene la data di pubblicazione dell'articolo;
                        -   Titolo: contiene il titolo dell'articolo;
                        -   Modifica: contine il bottone per modificare l'articolo;
                        -   Cancella: contiene il bottone per cancellare l'articolo.
                -->
                <!--
                    Se ci sono articoli:
                -->
                <c:if test="${articoli.size()>0}">
                    <table class="article-list">
                            <tr class="intestazione">
                                <th>Data</th>
                                <th>Titolo</th>
                                <th>Modifica</th>
                                <th>Cancella</th>
                            </tr>
                            <!--
                                Li mostro
                            -->
                            <c:set var="i" value="0"></c:set>
                            <c:forEach var="articolo" items="${articoli}">
                                <!--
                                    Controllo  indice riga, serve per sfruttare il layout a righe con colore alternato
                                -->
                                <c:choose>
                                    <c:when test="${i%2==0}">
                                        <tr class="rigaPARI">
                                    </c:when>    
                                    <c:otherwise>
                                        <tr class="rigaDISPARI">
                                    </c:otherwise>
                                </c:choose>
                                    <td>${articolo.dateString()}</td>
                                    <td><a href="notizia.html?id=${articolo.getId()}">${articolo.getTitolo()}</a></td>
                                    <td class="button-cell"><a href="scriviArticolo.html?id=${articolo.getId()}"><img src="/Milestone1/M1/images/edit-icon.png" alt="edit"></a></td>
                                    <td class="button-cell"><a href="eliminaarticolo.html?id_articolo=${articolo.getId()}"><img src="/Milestone1/M1/images/delete-icon.png" alt="delete"></a></td>
                                </tr>
                                <c:set var="i" value="${i+1}"></c:set>
                            </c:forEach> 
                    </table>
                <!--
                    bottone per il nuovo articolo
                -->
                <form action="scriviArticolo.html">
                    <input type="submit" class="btn" value="Nuovo">
                </form>
                </c:if>
                <!--
                    messaggio di errore nel caso non siano presenti articoli, se invece ce ne sono, messaggio sarà vuoto.
                -->
                ${messaggio}
            </div>
        </article>
    </body>
</html>
