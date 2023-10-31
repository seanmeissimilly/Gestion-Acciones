<%-- 
    Document   : rol_add
    Created on : May 30, 2022, 8:36:12 AM
    Author     : davidam
--%>

<%@page import="Modelo.Entidad"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="ModeloBean.RolBean"%>
<%@page import="Modelo.Rol"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloBean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Editar Usuario</title>
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
                            <h4>Modificar Rol Usuario</h4>
                            <form action="Controlador">
                            <%                                //Para saber el usuario que hay que modificar.
                                UsuarioBean dao = new UsuarioBean();
                                String id = ((String) request.getAttribute("id"));
                                Usuario p = dao.list(id);%>                                

                            <div class="mb-3">

                                <input class="form-control" type="hidden" name="txtusername"
                                       value="<%= p.getUsername()%>" id="username">
                            </div>
                            <div class="mb-3">
                                <label for="name" class="form-label">Nombre</label>
                                <input class="form-control" type="text" name="txtname"
                                       value="<%= p.getNombre()%>" id="name" required="required">
                            </div> 

                            <div class="mb-3">
                                <label for="entidad_p" class="form-label">Entidad</label>
                                <select class="form-select" name="entidad_p" id="entidad_p">
                                    <%
                                        EntidadBean daoentidad = new EntidadBean();
                                        List<Entidad> listent = daoentidad.listar();

                                        Entidad entp = null;
                                        for (int i = 0; i < listent.size(); i++) {
                                            entp = listent.get(i);
                                            String marcado = "";
                                            if (p.getEntidad().equals(entp.getid_entidad())) {
                                                marcado = "selected";
                                            }

                                    %>
                                    <option value="<%= entp.getid_entidad()%>"<%=marcado%>><%= entp.getNombre()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="area_accion" class="form-label">Rol</label>
                                <select class="form-select" name="id_rol" id="id_rol">
                                    <%
                                        RolBean rolbean = new RolBean();
                                        List<Rol> listarol = rolbean.listar();

                                        Rol rol = null;
                                        for (int i = 0; i < listarol.size(); i++) {
                                            rol = listarol.get(i);
                                            String marcado = "";
                                            if (p.getRol().equals(rol.getId())) {
                                                marcado = "selected";
                                            }

                                    %>
                                    <option value="<%= rol.getId()%>" <%=marcado%>><%= rol.getDescripcion()%></option>
                                    <%}%>
                                </select>
                            </div>                       

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="edit_userapp">Actualizar</button>
                            </div>                            
                        </form>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jspf" %>
    </body>
</html>
