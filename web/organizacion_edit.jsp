<%--
    Document   : organizacion_edit
    Created on : 2 jun 2022, 18:47:59
    Author     : David Sean
--%>

<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Organizacion"%>
<%@page import="ModeloBean.OrganizacionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Organizaciones Editar</title>
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
                            <h4>Modificar Organización</h4>
                            <form action="Controlador">
                            <% OrganizacionBean dao = new OrganizacionBean();
                                String id = ((String) request.getAttribute("id"));
                                Organizacion p = (Organizacion) dao.list(id).get(0);%>
                            <div class="mb-3">
                                <label for="nombre_organizacionnew" class="form-label">Nombre de la
                                    Organización</label>
                                <input type="text" class="form-control" id="nombre_organizacionnew"
                                       name="txtnombre_organizacionnew" value="<%= p.getNombre()%>" required="required">
                            </div>
                            <div class="mb-3">
                                <!-- Para pasar el numero de organizacion -->
                                <input type="hidden" name="txtnumero_organizacion" value="<%= p.getNumero()%>">
                            </div>

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="edit_organizacion">Actualizar</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </main>

        <%@ include file="footer.jspf" %>
    </body>
</html>
