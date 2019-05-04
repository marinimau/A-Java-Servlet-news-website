<%-- 
    Document   : profilo
    Created on : 30-apr-2018, 12.33.04
    Author     : mauro
--%>

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
                <!--se sono loggato includo il form del profilo-->
                <c:if test="${loggedIn==true}">
                   <jsp:include page="formprofilo.jsp"></jsp:include>
                   <h4><a href="eliminaprofilo.html">Elimina il tuo profilo</a></h4>
                </c:if>
                <!--eventuale messaggio d'errore-->
                <p>${messaggio}</p>
            </div>
        </article>
    </body>
</html>
