<%-- 
    Document   : commenti
    Created on : 25-apr-2018, 15.00.10
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="commenti">
    <hr />
    <h2>Commenti all'articolo:</h2>
    <!--
        imposto il messaggio di errore
    -->
    <c:set var="messaggio" value="non ci sono ancora commenti a questo articolo."></c:set>
    <!--
        controllo che ci siano commenti
    -->
    <c:if test="${commenti.size()>=1}">
    <!--
        se ce ne sono elimino il valore del messaggio di errore e li mostro
    -->
        <c:set var="messaggio" value=""></c:set>
        <c:forEach var="commento" items="${commenti}"> 
            <div class="istance">
                <div class="img_profilo">
                    <img src="${commento.getAutore().getUrlImgProfilo()} " />
                </div>
                <div class="corpo_commento">
                    <p class="intestazione">${commento.getAutore().getUsername()} - ${commento.dateString()}</p>
                    <p class="commento_corpo">${commento.getCorpo()}</p>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <!--
        mostro il messaggio, se il messaggio è stato cancellato non verrà mostrato nulla.
    -->
    ${messaggio}
</div>