<%-- 
    Document   : loginform
    Created on : 21-apr-2018, 15.36.54
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--login form-->
<form action="login.html" method="post" class="login-form">
    <div id="logo-login"></div>
    <!--
        controllo se ci sono stati errori nel tentativo di login precedente
        e nel caso stampo un messaggio di errore.
    -->
    <c:if test="${invalidData.equals(true)}">
        <p class="invalid_data"> Dati errati, riprovare </p>
    </c:if>
    <c:if test="${registrazioneRiuscita.equals(true)}">
        <p class="registrazione_riuscita"> Registrazione completata, effettua il login </p>
    </c:if>
    <!--
        Form normale
    -->
    <label for="username">Username:</label>
    <input type="text" id="email" name="email"><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    <button type="submit" class="btn">Login</button>
</form>
