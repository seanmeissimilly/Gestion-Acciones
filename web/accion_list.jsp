<%--
    Document   : accion_list2
    Created on : 18 may 2023, 12:40:43
    Author     : davidam
--%>

<%@page import="Modelo.Entidad"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Evaluacion"%>
<%@page import="ModeloBean.EvaluacionBean"%>
<%@page import="ModeloBean.EvaluacionBean"%>
<%@page import="Modelo.EntidadEject"%>
<%@page import="ModeloBean.EntidadEjectBean"%>
<%@page import="Modelo.Area"%>
<%@page import="ModeloBean.AreaBean"%>
<%@page import="Modelo.Organizativa"%>
<%@page import="ModeloBean.ForganizativaBean"%>
<%@page import="Modelo.Modalidad"%>
<%@page import="ModeloBean.ModalidadBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="java.util.List"%>
<%@page import="ModeloBean.ClasificacionBean"%>
<%@page import="Modelo.Accion"%>
<%@page import="ModeloBean.AccionBean"%>
<%@page import="Modelo.Persona" %>
<%@page import="ModeloBean.PersonaBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Acciones Listar</title>
    </head>
    <body id="page-top">
        <%@ include file="login.jspf" %>
        <%    Accion accion = null;
        %>

        <jsp:include page="navbar.jsp">
            <jsp:param name="user" value="<%=user%>" />
        </jsp:include>
        <main id="main">
            <div class="container my-4">
                <div class="row">
                    <div class="col-12">
                        <h2 class="centrado">Listado de Acciones</h2>                       
                        <table class="table table-striped text-center" id="datatable_users">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Inicial</th>
                                    <th>Final</th>
                                    <th>Clasificación</th>
                                    <th>Forma Organizativa</th>
                                    <th>Área</th>
                                    <th>Entidad</th>
                                    <th>Entidad Ejecutora</th>
                                    <th>Modalidad</th>                                    
                                    <th>Extraplan</th>
                                    <th>Evalución</th>                                      
                                </tr>
                            </thead>
                            <%

                                AccionBean dao = new AccionBean();
                                List<Accion> list = dao.listar();

                            %>
                            <tbody>
                                <%                                    for (int i = 0; i < list.size(); i++) {

                                        accion = null;
                                        accion = list.get(i);
                                %>

                                <tr>

                                    <td>
                                        <%= accion.getId_accion()%>
                                    </td>
                                    <td>
                                        <%= accion.getNombre()%>
                                    </td>
                                    <td>
                                        <%= accion.getFecha_inicial()%>
                                    </td>
                                    <td>
                                        <%= accion.getFecha_final()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_clasificacion()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_formaorganizativa()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_area()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_entidad()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_entidadejecutora()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_modalidad()%>
                                    </td>                                    
                                    <td>
                                        <%= accion.isExtraplan() ? "Si" : "No"%>
                                    </td> 
                                    <td>
                                        <%= accion.getId_evaluacionfinal() %>
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
