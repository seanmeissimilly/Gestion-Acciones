<%-- Document : entidad_list Created on : 9 abr 2022, 1:12:44 Author : David Sean --%>

<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Organizacion"%>
<%@page import="ModeloBean.OrganizacionBean"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Entidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Entidades</title>
    </head>

    <body>
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
                        <h2>Entidades</h2>
                        <form action="Controlador">                           
                            <div class="mb-3">
                                <label for="nombre_entidad" class="form-label">Nombre de la Entidad</label>
                                <input type="text" class="form-control" id="nombre_entidad"
                                       placeholder="Nombre de la Entidad" name="txtnombre_entidad" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="prefix_entidad" class="form-label">Prefijo de la Entidad</label>
                                <input type="text" class="form-control" id="prefix_entidad"
                                       placeholder="Prefijo de la Entidad" name="txtprefix_entidad" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="nombre_organizacion" class="form-label">Organización</label>
                                <select class="form-select" name="txtnumero_organizacion" id="nombre_organizacion">
                                    <%                                        OrganizacionBean organizaciones = new OrganizacionBean();
                                        List<Organizacion> lista = organizaciones.listar();
                                        Iterator<Organizacion> x = lista.iterator();
                                        Organizacion org = null;
                                        while (x.hasNext()) {
                                            org = x.next();

                                    %> 
                                    <option value="<%= org.getNumero()%>"><%= org.getNombre()%></option>
                                    <%}%> 
                                </select>                               
                            </div>


                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="add_entidad">Agregar</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
                        <h2 class="centrado">Listado de Entidades</h2>                        
                        <table class="table table-striped" id="datatable_users">
                            <thead>
                                <tr>                                    
                                    <th>Nombre</th>
                                    <th>Organización</th>
                                    <th>Prefijo</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <%

                                Entidad ent;

                                EntidadBean dao = new EntidadBean();
                                List<Entidad> list = dao.listar();

                            %>
                            <tbody><%                                for (int i = 0; i < list.size(); i++) {

                                    ent = list.get(i);%>
                                <tr>                                    
                                    <td><%= ent.getNombre()%></td>
                                    <td><%= ent.getname_org()%></td>
                                    <td><%= ent.getPrefix()%></td>
                                    <td class="text-center">
                                        <a class="btn btn-sm btn-primary my-1"
                                           href="Controlador?accion=entidad_edit&id_entidad=<%= ent.getid_entidad()%>" aria-label="Editar"><i
                        class="fa-solid fa-pencil"></i></a>                                    
                                        <a class="btn btn-sm btn-danger"
                                           href="Controlador?accion=entidad_delete&numero=<%= ent.getid_entidad()%>" aria-label="Borrar"><i
                        class="fa-solid fa-trash-can"></i></a>                                           
                                    </td>
                                </tr>
                                <%}%> 
                            </tbody>
                        </table>                        

                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jspf" %>       

    </body>

</html>