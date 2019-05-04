<%-- 
    Document   : elenconotizie
    Created on : 26-apr-2018, 16.55.44
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
            <c:set var="title" value="Notizie: ${categoria}"></c:set>
            <jsp:include page="article_header.jsp"></jsp:include>
            <!--corpo dell' articolo-->
            <div class="article-text" id="article-text">
                <!--
                    setto il messaggio di errore
                -->
                <c:set var="messaggio" value="nessuna notizia"></c:set>
                <!--
                    controllo se ci sono notizie
                -->
                <div id="box-notizie">
                    <c:if test="${notizie.size()>0}">
                        <!--
                           se ci sono, elimino il contenuto del messaggio di errore e le stampo
                        -->
                        <c:set var="messaggio" value=""></c:set>
                        <c:forEach var="notizia" items="${notizie}">
                            <div class="news-box">
                                <!--
                                    Ogni categoria ha un colore associato, l'header del box di ogni notizia 
                                    avrà il colore associato alla categoria della notizia
                                -->
                                <div class="box-titolo" id="${notizia.getId()}-news" style="background-color: ${notizia.getCategoria().getColore()}">
                                    <h1>[${notizia.getCategoria().getNome()}]  ${notizia.getTitolo()}</h1>
                                </div>
                                <div class="box-contenuto">
                                    <div class="box-immagine">
                                         <a href="notizia.html?id=${notizia.getId()}">
                                             <img src="${notizia.getUrlImg()}"/>
                                         </a>
                                    </div>
                                    <div class="box-data">
                                        <h4>${notizia.getAutore().getUsername()} - ${notizia.dateString()}</h4>
                                        <p>${notizia.tagliaCorpo()} [...]</p>
                                        <p><a class="art_btn" href="notizia.html?id=${notizia.getId()}" style="background-color: ${notizia.getCategoria().getColore()}">Leggi di più</a></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                ${messaggio}
            </div>
        </article>
    </body>
</html>
