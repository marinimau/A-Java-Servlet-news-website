<%-- 
    Document   : topbar
    Created on : 21-apr-2018, 15.23.38
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<main id="topbar">
            <div id="login-box">
                <c:set var="message" value="non sei loggato"></c:set>
                <c:set var="link" value="login.html"></c:set>
                <c:set var="user" value=""></c:set>
                <c:set var="link_message" value="Login"></c:set>
                <!--Se l'utente è loggato vanno cambiate le variabili-->
                <c:if test="${loggedIn==true}">
                    <c:set var="message" value="Ciao "></c:set>
                    <c:set var="link" value="login.html?logout=true"></c:set>
                    <c:set var="user" value="${username}"></c:set>
                    <c:set var="link_message" value="Logout"></c:set>
                </c:if>
                <!--stampo il messaggio-->
                <p>${message} ${user}, <a href="${link}">${link_message}</a></p>
            </div>
</main>
