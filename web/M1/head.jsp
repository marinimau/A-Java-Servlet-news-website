<%-- 
    Document   : head
    Created on : 21-apr-2018, 15.57.53
    Author     : mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Mauro Marini - Milestone pt.1 > <%=request.getParameter("title")%></title>
    <!--metadati-->
    <jsp:include page="meta.jsp"></jsp:include>
    <!--link a fogli di stile e script-->
    <jsp:include page="head_link.jsp"></jsp:include>
</head>
