<%-- 
    Document   : menu
    Created on : Nov 21, 2019, 11:03:53 AM
    Author     : Dell
--%>
<c:forEach var="food" items="${menus}">
    <h2>${food.typeId.name} => ${food.id} => ${food.name}</h2>
    
</c:forEach>

        
   