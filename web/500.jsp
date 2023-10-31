<%-- Document : 404 Created on : 14 jun 2022, 17:25:04 Author : David Sean --%>

<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap 500 Error</title>
    </head>

    <body>
        <%@ include file="login.jspf" %>
        <jsp:include page="navbar.jsp">
            <jsp:param name="user" value="<%=user%>" />  
        </jsp:include>


        <main id="main" class="main">
            <section class="page-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-4">
                            <div class="text-center mt-4">
                                <img class="mb-4 img-error" src="img/500-Internal-Error-Page.jpg" alt="" />                              
                                <p class="lead">Algo salió mal.</p>
                                <a href="./login.jsp">
                                    <i class="fas fa-arrow-left me-1"></i>
                                    Retornar a Inicio.
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>

        <%@ include file="footer.jspf" %>
    </body>

</html>