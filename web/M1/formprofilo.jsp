<%-- 
    Document   : formprofilo
    Created on : 30-apr-2018, 12.34.13
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--form per la smodifica del profilo, contiene:
        -   email
        -   Username;       
        -   password;
        -   conferma password;
        -   Nome;
        -   Cognome;
        -   Data di nascita;
        -   url immagine del profilo;
        -   Tipo utente.
-->
<form action="profilo.html?modificato=1" method="post" id="mod-profilo">
    <h2>Dati profilo:</h2>
    <label for="id">Id:</label>
    <!--l'id non può essere modificato-->
    <input type="text" id="id" name="id" value="${utente.getId()}" disabled><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${utente.getEmail()}"><br>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${utente.getUsername()}"><br>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="${utente.getPassword()}"><br>
    
    <label for="confpassword">Conferma password:</label>
    <input type="password" id="confpassword" name="confpassword" value="${utente.getPassword()}"><br>
    
    <label for="img">Url immagine del profilo:</label>
    <input type="text" id="url" name="url" value="${utente.getUrlImgProfilo()}"><br>
    
    <h2>Informazioni anagrafiche:</h2>
    
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${utente.getNome()}"><br>
    
    <label for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome" value="${utente.getCognome()}"><br>
    
    <label for="data">Data di nascita:</label>
    <input type="date" id="datanascita" name="datanascita" value="${utente.dateValue()}"><br>
    
    <h2>Ruolo utente:</h2>
    <!-- INSERIRE TIPO è disabilitato perchè non deve poter essere modificato per questioni gerarchiche -->
    <label for="tipo">Tipo:</label>
    <input type="text" id="tipo" name="tipo" value="${utente.getTipoUtente()}" disabled><br>
    <br>
    <!--Bottone per l'invio-->
    <button type="submit" class="btn">Salva</button>
</form>