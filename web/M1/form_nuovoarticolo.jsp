<%-- 
    Document   : form_nuovoarticolo
    Created on : 21-apr-2018, 15.44.48
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--form per la scrittura dell'articolo, contiene:
        -   Titolo;
        -   Data;
        -   Url immagine;
        -   Didascalia immagine;
        -   Corpo dell'articolo;
        -   Categoria (menÃ¹ a tendina).
-->
<!--
    imposto la action, cambia in caso di modifica di un articolo esistente
-->
<c:choose>
    <c:when test="${articolo!=null}">
        <form action="scriviArticolo.html?id=${articolo.getId()}" method="post" accept-charset="ISO-8859-1">
        <input type="hidden" id="modifica" name="modifica" value="1">
    </c:when>
    <c:otherwise>
        <form action="scriviArticolo.html" method="post" accept-charset="ISO-8859-1">
        <input type="hidden" id="modifica" name="nuovo" value="1">    
    </c:otherwise>
</c:choose>
    <label for="titolo">Titolo dell'articolo:</label>
    <input type="text" id="titolo" name="titolo" value="${articolo.getTitolo()}"><br>

    <label for="data">Data:</label>
    <input type="date" id="data" name="data" disabled value="${articolo.dateValue()}"><br>

    <label for="url">Url dell'Immagine:</label>
    <input type="text" id="url" name="url" value="${articolo.getUrlImg()}"><br>

    <label for="didascalia">Didascalia dell'immagine:</label>
    <input type="text" id="didascalia" name="didascalia" value="${articolo.getDidascaliaImg()}"><br>

    <label for="testo">Corpo dell'articolo:</label>
    <textarea rows="10" cols="50" id="testo" name="testo" >${articolo.getCorpo()}</textarea><br>
    <!-- INSERIRE CATEGORIA -->
    <label for="categoria">Categoria:</label>
    <!--
        Scorro le categorie passate dalla servlet e se sono in modifica e non in nuovo, 
        pre-seleziono la categoria corretta per evitare modifiche accidentali al campo categorie
    -->
    <select name="categoria" id="categoria" name=categoria">
        <c:forEach var="categoria" items="${categorie}">
            <option value="${categoria.getId()}" 
                    <c:if test="${articolo!=null && articolo.getCategoria().getId()==categoria.getId()}">
                        selected
                    </c:if>    
                    >${categoria.getNome()}</option>
        </c:forEach>
    </select>
    <br>
    <!--Bottone per l'invio-->
    <button type="submit" class="btn">Salva</button>
</form>