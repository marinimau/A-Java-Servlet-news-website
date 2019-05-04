<%-- 
    Document   : notiziaTrovata_JSON
    Created on : 29-mag-2018, 10.36.40
    Author     : mauro
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="notizia" items="${notizie}">
        <json:object>
            <json:property name="id" value="${notizia.getId()}"/> 
            <json:property name="titolo" value="${notizia.getTitolo()}"/>
            <json:property name="corpo" value="${notizia.tagliaCorpo()}"/>
            <json:property name="dataScrittura" value="${notizia.dateString()}"/> 
            <json:property name="urlImg" value="${notizia.getUrlImg()}"/>
            <json:property name="didascaliaImg" value="${notizia.getDidascaliaImg()}"/>
            <json:property name="autore" value="${notizia.getAutore().getUsername()}"/>
            <json:property name="categoria" value="${notizia.getCategoria().getNome()}"/>
            <json:property name="colore" value="${notizia.getCategoria().getColore()}"/> 
        </json:object>
    </c:forEach>
</json:array>

