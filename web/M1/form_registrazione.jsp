<%-- 
    Document   : form_registrazione
    Created on : 21-mag-2018, 11.40.18
    Author     : mauro
--%>
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
<form action="registrazione.html" method="post" id="registra-profilo">
    <h2>Dati profilo:</h2>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>

    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    
    <label for="confpassword">Conferma password:</label>
    <input type="password" id="confpassword" name="confpassword"><br>
    
    <label for="img">Url immagine del profilo:</label>
    <input type="text" id="urlImgProfilo" name="urlImgProfilo"><br>
    
    <h2>Informazioni anagrafiche:</h2>
    
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome"><br>
    
    <label for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome"><br>
    
    <label for="data">Data di nascita:</label>
    <input type="date" id="datanascita" name="datanascita"><br>
    
    <h2>Ruolo utente:</h2>
    <!-- INSERIRE TIPO è disabilitato perchè non deve poter essere modificato per questioni gerarchiche -->
    <label for="tipo">Tipo:</label>
    <input type="text" id="tipo" name="tipo" value="OSPITE" disabled><br>
    <br>
    <!--Bottone per l'invio-->
    <button type="submit" class="btn">Registrati</button>
</form>
