<%-- 
    Document   : article_header
    Created on : 21-apr-2018, 15.48.54
    Author     : mauro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="article-header">
    <h1 class="article-title">
        <!--
            Se è un articolo mostro il titolo dell'articolo, oppure se è una pagina 
            ma vi è un titolo specificato, mostro il titolo specificato, 
            altrimenti mostro un titolo generico.
        -->
        <c:choose>
            <c:when test="${art.getTitolo()!=null}">
                 ${art.getTitolo()}
            </c:when>
            <c:when test="${title!=null}">
                ${title}
            </c:when>
            <c:otherwise>
                FPW - Blog
            </c:otherwise>
        </c:choose>
    </h1>
</div>
