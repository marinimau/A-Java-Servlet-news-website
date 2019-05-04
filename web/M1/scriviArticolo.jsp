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
                <!--
                    se sono loggato e sono un autore mostro il form per scrivere o modificare un articolo
                -->
                <c:if test="${loggedIn==true && tipo=='AUTORE'}">
                   <jsp:include page="form_nuovoarticolo.jsp"></jsp:include> 
                </c:if>
                <!--
                    eventuale messaggio di errore
                -->
                <p>${messaggio}</p>
            </div>
        </article>
    </body>
</html>