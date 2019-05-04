<%-- 
    Document   : autori_e_categorie_trovati_JSON
    Created on : 6-giu-2018, 16.11.27
    Author     : mauro
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object>       
       <json:array name="categorie">
           <c:forEach var="categoria" items="${categorie}">
               <json:object>
                   <json:property name="idCategoria" value="${categoria.getId()}"/> 
                   <json:property name="nomeCategoria" value="${categoria.getNome()}"/>
               </json:object>
           </c:forEach>
       </json:array>
       <json:array name="autori">    
               <c:forEach var="autore" items="${autori}">
                   <json:object>
                       <json:property name="idUtente" value="${autore.getId()}"/> 
                       <json:property name="nomeUtente" value="${autore.getNome()}"/>
                       <json:property name="cognomeUtente" value="${autore.getCognome()}"/>
                       <json:property name="urlImgProfilo" value="${autore.getUrlImgProfilo()}"/> 
                   </json:object>
               </c:forEach>  
       </json:array>
</json:object>