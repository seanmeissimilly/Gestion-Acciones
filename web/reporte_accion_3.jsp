<%-- 
    Document   : reporte_accion_3
    Created on : 11 jun 2023, 17:33:15
    Author     : davidam
--%>

<%@page import="ModeloBean.EntidadBean"%>
<%@page import="Modelo.Entidad"%>
<%@page import="Modelo.EntidadEject"%>
<%@page import="ModeloBean.EntidadEjectBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <%@ include file="header.jspf" %>

        <title>GesCap Reporte Encuenta Reacción</title>

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
                        <h2>Reporte Encuenta Reacción</h2>
                        <form name="form_accion" action="report_accion_3.jsp">
                            <div class="mb-3">
                                <label for="labelid_accion" class="form-label">Id de Acción</label>
                                <input type="number" class="form-control" id="id_accion"
                                       name="id_accion" required="required" min="1">
                            </div>                                 

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="send_reporteaccionlist">Visualizar Reporte</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="footer.jspf" %>
    </body>

</html>
