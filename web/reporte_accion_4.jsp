<%-- 
    Document   : report_accion_4
    Created on : Oct 2, 2023, 8:38:25 AM
    Author     : davidam
--%>

<%@page import="Modelo.Entidad"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="Modelo.EntidadEject"%>
<%@page import="java.util.List"%>
<%@page import="ModeloBean.EntidadEjectBean"%>
<%@page import="ModeloBean.EntidadEjectBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="header.jspf" %>
        <title>GesCap Paticipación por Acciones</title>
    </head>

    <body id="page-top">
        <%@ include file="login.jspf" %> 
        <jsp:include page="navbar.jsp">
            <jsp:param name="user" value="<%=user%>" />  
        </jsp:include>

        <main id="main" class="main">
            <div class="container my-4">
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4">
                        <h2>Paticipación por Acciones</h2>
                        <form name="form_accion" action="report_accion_4.jsp">
                            <div class="mb-3">
                                <label for="fechainicial_accion" class="form-label">Fecha Inicial</label>
                                <input type="date" class="form-control" id="fechainicial_accion"
                                       name="fechainicial_accion" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="fechafinal_accion" class="form-label">Fecha Final</label>
                                <input type="date" class="form-control" id="fechafinal_accion"
                                       name="fechafinal_accion" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="entidad_accion" class="form-label">Entidad Ejecutora</label>
                                <select class="form-select" name="entidad_accion" id="entidad_accion">
                                    <option value="-1"><%= "Todas"%></option>
                                    <%                                        EntidadEjectBean daoentidadejec = new EntidadEjectBean();
                                        List<EntidadEject> listentidad = daoentidadejec.listar();

                                        EntidadEject entidad = null;
                                        for (int i = 0; i < listentidad.size(); i++) {
                                            entidad = listentidad.get(i);

                                    %> 
                                    <option value="<%= entidad.getid_entidad()%>"><%= entidad.getNombre()%></option>
                                    <%}%>

                                </select>   
                            </div>
                            <div class="mb-3">
                                <label for="entidad_p" class="form-label">Entidad</label>
                                <select class="form-select" name="entidad_p" id="entidad_p">
                                    <option value="-1"><%= "Todas"%></option>
                                    <%
                                        EntidadBean daoentidad = new EntidadBean();
                                        List<Entidad> listent = daoentidad.listar();

                                        Entidad entp = null;
                                        for (int i = 0; i < listent.size(); i++) {
                                            entp = listent.get(i);

                                    %> 
                                    <option value="<%= entp.getid_entidad()%>"><%= entp.getNombre()%></option>
                                    <%}%>                                     
                                </select>                               
                            </div>

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="send_reporteaccion4">Visualizar Reporte</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>

        <%@ include file="footer.jspf" %>
    </body>
</html>
