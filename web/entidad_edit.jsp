<%-- 
    Document   : entidad_edit
    Created on : 14 jun 2022, 15:50:48
    Author     : David Sean
--%>

<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Organizacion"%>
<%@page import="ModeloBean.OrganizacionBean"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Entidad"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Editar Entidad</title>
    </head>
    <body id="page-top">
        <%@ include file="login.jspf" %> 
       <!-- Busco el usuario en la base de datos para saber si puede acceer a esta pagina -->
                <%
                    //Busco en la base de datos el usuario.                  
                    Usuario userapp = new UsuarioBean().list(user);
                    
                    //reviso si el usuario tiene un rol diferente de admin.
                    if (!userapp.getRol().equals("3")) {
                            response.sendRedirect("./dashboard");
                        }
                %>

        <jsp:include page="navbar.jsp">
            <jsp:param name="user" value="<%=user%>" />  
        </jsp:include>


        <main id="main" class="main">
            <div class="container my-4">
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4">
                        <h4>Modificar Entidad</h4>
                        <form action="Controlador">
                            <% EntidadBean dao = new EntidadBean();
                                String id = ((String) request.getAttribute("id_entidad"));
                                Entidad p = (Entidad) dao.list(id).get(0);%>

                            <div class="mb-3">
                                <label for="nombre_entidadnew" class="form-label">Nombre de la
                                    Entidad</label>
                                <input type="text" class="form-control" id="nombre_entidadnew"
                                       name="txtnombre_entidadnew" value="<%= p.getNombre()%>">
                            </div> 
                            <div class="mb-3">
                                <label for="prefix_entidadnew" class="form-label">Prefijo de la Entidad</label>
                                <input type="text" class="form-control" id="prefix_entidadnew"
                                       name="prefix_entidadnew" value="<%= p.getPrefix()%>">
                            </div>

                            <div class="mb-3">                               
                                <input type="hidden" name="txtnumero_entidad" value="<%= p.getid_entidad()%>">
                            </div>                          

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="edit_entidad">Actualizar</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </main>

        <%@ include file="footer.jspf" %>
    </body>
</html>
