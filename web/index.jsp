<%-- Document : index Created on : Apr 5, 2022, 2:39:33 PM Author : davidam --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap</title>

    </head>

    <body>
        <%@ include file="login.jspf" %>
        <jsp:include page="navbar.jsp"></jsp:include>

        <% response.sendRedirect("login.jsp");%>


        <main>

        </main>
        <%@ include file="footer.jspf" %>
    </body>

</html>