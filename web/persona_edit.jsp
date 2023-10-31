<%-- Document : edit Created on : Apr 5, 2022, 2:39:33 PM Author : davidam --%>
<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Persona" %>
<%@page import="ModeloBean.PersonaBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <%@ include file="header.jspf" %> 
        <title>GesCap Editar Persona</title>
    </head>

    <body id="page-top">
        <%@ include file="login.jspf" %> 
        <jsp:include page="navbar.jsp">
            <jsp:param name="user" value="<%=user%>" />  
        </jsp:include>
        
        
        <!-- Busco el usuario en la base de datos para saber si puede acceer a esta pagina -->
                <%
                    //Busco en la base de datos el usuario.                  
                    Usuario userapp = new UsuarioBean().list(user);
                    
                    //reviso si el usuario tiene un rol diferente de admin.
                    if (!userapp.getRol().equals("3")) {
                            response.sendRedirect("./dashboard");
                        }
                %>

        <main id="main" class="main">
            <div class="container my-4">
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4">
                        <h4>Modificar Persona</h4>
                        <form action="Controlador">
                            <% PersonaBean dao = new PersonaBean();
                                String id = ((String) request.getAttribute("ci"));
                                Persona p = (Persona) dao.list(id);%>
                            <div class="mb-3">
                                <label for="Cinew" class="form-label">CI</label> 
                                <input class="form-control" type="text" name="txtCinuevo"
                                       value="<%= p.getCi()%>" id="Cinew">
                            </div>
                            <div class="mb-3">
                                <label for="nombrenew" class="form-label">Nombre</label>
                                <input class="form-control" type="text" name="txtNombre"
                                       value="<%= p.getNombre()%>" id="nombrenew">
                            </div>
                            <div class="mb-3">
                                <label for="primer_apellidonew" class="form-label">Primer Apellido</label> 
                                <input class="form-control" type="text" name="txtPrimerApellido"
                                       value="<%= p.getPrimerApellido()%>" id="primer_apellidonew">
                            </div>
                            <div class="mb-3">
                                <label for="segundo_apellidonew" class="form-label">Segundo Apellido</label>
                                <input class="form-control" type="text" name="txtSegundoApellido"
                                       value="<%= p.getSegundoApellido()%>" id="segundo_apellidonew">
                            </div>
                            <div class="mb-3">
                                <!-- Para pasar el numero de carnet antiguo -->
                                <input type="hidden" name="txtCi" value="<%= p.getCi()%>">
                            </div>

                            <div class="d-grid gap-2">
                                <input class="btn btn-success" type="submit" name="accion"
                                       value="Actualizar">
                            </div>                            
                        </form>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jspf" %>
    </body>

</html>