<%-- 
    Document   : foods
    Created on : Nov 24, 2019, 11:16:34 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:forEach var="foods" items="${foodList}">
    <h3>${foods.name}</h3>
    
</c:forEach>