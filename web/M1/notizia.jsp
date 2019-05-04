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
            <c:set var="title" value="${art.getTitolo()}"></c:set>
            <jsp:include page="article_header.jsp"></jsp:include>
            <!--corpo dell' articolo-->
            <div class="article-text">
                <!--Info articolo:
                    -   Categoria articolo;
                    -   Data di pubblicazione;
                    -   Autore;
                -->
                <div class="info-categoria">
                    <div class="logo" style="background-color: ${art.getCategoria().getColore()}"></div>
                    <div class="info-text">
                        <h4><b>Categoria: </b> ${art.getCategoria().getNome()}</h4>
                        <h4><b>Data: </b>${art.dateString()}</h4>
                        <h4><b>Autore: </b>${art.getAutore().getUsername()}</h4>
                        
                        
                    </div>
                </div>
                <!--Corpo dell'articolo-->
                <img src="${art.getUrlImg()}" alt="Immagine dell'articolo"/>
                <div class="image-description">
                    ${art.getDidascaliaImg()}
                </div>
                <p class="corpo">
                    ${art.getCorpo()}
                </p>
                <!--includo la gestione dei commenti-->
                <jsp:include page="commenti.jsp"></jsp:include>
            </div>
        </article>
    </body>
</html>