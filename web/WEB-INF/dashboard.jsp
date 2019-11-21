<%-- 
    Document   : dashboard.jsp
    Created on : Nov 19, 2019, 10:22:46 AM
    Author     : User
--%>
        <c:forEach var="foodCategory" items="${foodCategories}">
            <h2>${foodCategory.name}</h2>
        </c:forEach>
              
                

    