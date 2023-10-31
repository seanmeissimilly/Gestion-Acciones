<%--
    Document   : accion_add
    Created on : May 30, 2022, 12:42:23 PM
    Author     : davidam
--%>

<%@page import="ModeloBean.UsuarioBean"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Accion"%>
<%@page import="ModeloBean.AccionBean"%>
<%@page import="Modelo.Organizacion"%>
<%@page import="ModeloBean.OrganizacionBean"%>
<%@page import="Modelo.EntidadEject"%>
<%@page import="ModeloBean.EntidadEjectBean"%>
<%@page import="Modelo.Evaluacion"%>
<%@page import="ModeloBean.EvaluacionBean"%>
<%@page import="ModeloBean.ModalidadBean"%>
<%@page import="Modelo.Modalidad"%>
<%@page import="ModeloBean.EntidadBean"%>
<%@page import="Modelo.Entidad"%>
<%@page import="ModeloBean.AreaBean"%>
<%@page import="Modelo.Area"%>
<%@page import="Modelo.Situacion"%>
<%@page import="ModeloBean.SituacionBean"%>
<%@page import="Modelo.Organizativa"%>
<%@page import="ModeloBean.ForganizativaBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="ModeloBean.ClasificacionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>      

        <%@ include file="header.jspf" %>
        <title>GesCap Acciones Addicionar</title>
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

            //Reviso si solo tiene rol de consultor.
            if (userapp.getRol().equals("1")) {
                response.sendRedirect("./dashboard");
            }
        %>

        <main id="main" class="main">
            <div class="container my-4">
                <div class="row">
                    <div class="col-4">
                        <h2>Acciones</h2>
                        <form name="form_accion" action="Controlador" method="get">
                            <div class="mb-3">
                                <label for="nombre_accion" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombre_accion"
                                       placeholder="Nombre de la Acción" name="nombre_accion" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="descripcion_accion" class="form-label">Descripción</label>                                                             
                                <textarea class="form-control" name="descripcion_accion" rows="4" placeholder="Descripción de la Acción"></textarea>
                            </div>
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
                                <label for="clasificacion_accion" class="form-label">Clasificación</label>
                                <select class="form-select" name="clasificacion_accion" id="clasificacion_accion">
                                    <%                                        ClasificacionBean organizaciones = new ClasificacionBean();
                                        List<Clasificacion> lista = organizaciones.listar();
                                        Iterator<Clasificacion> x = lista.iterator();
                                        Clasificacion org = null;
                                        while (x.hasNext()) {
                                            org = x.next();

                                    %> 
                                    <option value="<%= org.getNumero()%>"><%= org.getNombre()%></option>
                                    <%}%> 
                                </select>                               
                            </div>
                            <div class="mb-3">
                                <label for="forganizativa_accion" class="form-label">Forma Organizativa</label>
                                <select class="form-select" name="forganizativa_accion" id="forganizativa_accion">
                                    <%
                                        ForganizativaBean forganizativa = new ForganizativaBean();
                                        List<Organizativa> listafo = forganizativa.listar();

                                        Organizativa formaorg = null;
                                        for (int i = 0; i < listafo.size(); i++) {
                                            formaorg = listafo.get(i);


                                    %> 
                                    <option value="<%= formaorg.getNumero()%>"><%= formaorg.getNombre()%></option>
                                    <%}%>                                     
                                </select>                               
                            </div>                            
                            <div class="mb-3">
                                <label for="area_accion" class="form-label">Área del Conocimiento</label>
                                <select class="form-select" name="area_accion" id="area_accion">
                                    <%
                                        AreaBean areabean = new AreaBean();
                                        List<Area> listarea = areabean.listar();

                                        Area area = null;
                                        for (int i = 0; i < listarea.size(); i++) {
                                            area = listarea.get(i);


                                    %> 
                                    <option value="<%= area.getNumero()%>"><%= area.getNombre()%></option>
                                    <%}%>                                     
                                </select>                               
                            </div>
                            <div class="mb-3">
                                <label for="entidad_accion" class="form-label">Entidad Ejecutora</label>
                                <select class="form-select" name="entidad_accion" id="entidad_accion">
                                    <%
                                        EntidadEjectBean daoentidadejec = new EntidadEjectBean();
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
                            <div class="mb-3">
                                <label for="modalidad_accion" class="form-label">Modalidad</label>
                                <select class="form-select" name="modalidad_accion" id="modalidad_accion">
                                    <%
                                        ModalidadBean modalidadbean = new ModalidadBean();
                                        List<Modalidad> listmodalidad = modalidadbean.listar();

                                        Modalidad modalidad = null;
                                        for (int i = 0; i < listmodalidad.size(); i++) {
                                            modalidad = listmodalidad.get(i);


                                    %> 
                                    <option value="<%= modalidad.getNumero()%>"><%= modalidad.getNombre()%></option>
                                    <%}%>                                     
                                </select>                               
                            </div>                          

                            <div class="mb-3 form-check form-switch">
                                <label for="extraplan_accion" class="form-check-label">Extraplan</label>
                                <input type="checkbox" class="form-check-input" name="extraplan_accion">
                            </div>
                            <div class="mb-3">
                                <label for="creditos_accion" class="form-label">Créditos</label>                                
                                <input type="number" class="form-control" id="creditos_accion"
                                       min="0" max="1000" name="creditos_accion" >
                            </div>
                            <div class="mb-3">
                                <label for="evaluacion_accion" class="form-label">Evaluación</label>
                                <select class="form-select" name="evaluacion_accion" id="evaluacion_accion">
                                    <%
                                        EvaluacionBean evaluacionbean = new EvaluacionBean();
                                        List<Evaluacion> listevaluacion = evaluacionbean.listar();

                                        Evaluacion evaluacion = null;
                                        for (int i = 0; i < listevaluacion.size(); i++) {
                                            evaluacion = listevaluacion.get(i);


                                    %> 
                                    <option value="<%= evaluacion.getNumero()%>"><%= evaluacion.getNombre()%></option>
                                    <%}%>                                     
                                </select>                               
                            </div>
                            <div class="mb-3">
                                <label for="observaciones_accion">Observaciones</label>
                                <textarea class="form-control" name="observaciones_accion" rows="4" placeholder="Sus observaciones"></textarea>
                            </div>

                            <input type="hidden" name="user" value=<%=user%>>
                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="add_accion">Agregar</button>
                            </div>
                        </form>

                    </div>
                    <div class="col-8">
                        <h2 class="centrado">Listado de Acciones</h2>                        

                        <table class="table table-striped text-center" id="datatable_users">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Inicial</th>
                                    <th>Final</th>                                    
                                    <th>Entidad</th>
                                    <th>Entidad Ejecutora</th>                                    
                                    <th></th>
                                    <th>Encuesta</th>
                                </tr>
                            </thead>
                            <%

                                AccionBean dao = new AccionBean();
                                List<Accion> list = dao.listar();

                            %>
                            <tbody>
                                <%                                    for (int i = 0; i < list.size(); i++) {

                                        Accion accion = null;
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
                                        <%= accion.getId_entidad()%>
                                    </td>
                                    <td>
                                        <%= accion.getId_entidadejecutora()%>
                                    </td>

                                    <td class="text-center" >
                                        <a class="btn btn-sm btn-primary my-1" href="Controlador?accion=accion_edit&id=<%= accion.getId_accion()%>&user=<%=user%>" aria-label="Editar"><i
                                                class="fa-solid fa-pencil"></i></a>
                                        <a class="btn btn-sm btn-danger" href="Controlador?accion=accion_delete&id=<%= accion.getId_accion()%>&user=<%=user%>" aria-label="Borrar"><i
                                                class="fa-solid fa-trash-can"></i></a>

                                    </td>
                                    <td class="text-center" >                                       
                                        <a class="btn btn-outline-secondary" href="Controlador?accion=accion_encuesta&id=<%= accion.getId_accion()%>&user=<%=user%>" aria-label="Encuesta">R</a>
                                        <a class="btn btn-outline-secondary" href="Controlador?accion=accion_encuestat&id=<%= accion.getId_accion()%>&user=<%=user%>" aria-label="Encuesta">T</a>

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
