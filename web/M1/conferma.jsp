<%-- 
    Document   : conferma.jsp
    Created on : 22-mag-2018, 15.38.35
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
            <!--header con titolo pagina-->
            <jsp:include page="article_header.jsp"></jsp:include>
            <!--corpo dell' articolo-->
            <div class="article-text">
                <!--se sono loggato controllo per cosa sto chiedendo conferma-->
                <c:if test="${loggedIn==true}">
                    <c:choose>
                        <c:when test="${elimina_profilo==true}">
                            <form action="eliminaprofilo.html" method="post">
                        </c:when>
                        <c:when test="${elimina_articolo==true}">
                            <form action="eliminaarticolo.html" method="post">
                            <input type="hidden" name="id_articolo" id="id_articolo" value="${id_articolo}">
                        </c:when>
                        <c:otherwise>
                            <form action="#" method="post">
                        </c:otherwise>
                    </c:choose>    
                        <label for="password">Inserire la password per procedere:</label>
                        <input type="password" name="password" id="password" placeholder="your password"><br>
                        <input type="submit" value="conferma" class="btn">
                    </form>  
                </c:if>
                ${messaggio}
            </div>
        </article>
    </body>
</html>
