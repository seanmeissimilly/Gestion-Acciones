<%-- 
    Document   : accion_enc
    Created on : 21 jun 2023, 19:45:22
    Author     : davidam
--%>
<%@page import="ModeloBean.EncReaccionBean"%>
<%@page import="Modelo.EncReaccion"%>
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
        <title>GesCap</title>
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

            //reviso si el usuario tiene un rol diferente de admin o editor.
            if (userapp.getRol().equals("1")) {
                response.sendRedirect("./dashboard");
            }
        %>

        <main id="main" class="main">
            <%
                AccionBean accion = new AccionBean();
                String id = ((String) request.getAttribute("id"));

                List<Accion> ss = accion.list(id);
                Accion p = ss.get(0);

                EncReaccion reaccion = new EncReaccion();
                EncReaccionBean reacciondao = new EncReaccionBean();
                reaccion = reacciondao.list(Integer.parseInt(p.getId_accion()));
            %>           


            <div class="container text-end">
                <div class="row"> 
                    <div class="col-4">
                        <div class="mb-2">
                            <label>ID :</label>
                            <input class="form-control-sm" type="text" name="number_accion"
                                   value="<%= p.getId_accion()%>" id="number_accion" readonly><br>
                            <label>Nombre :</label>
                            <input class="form-control-sm" type="text" name="nombre_accion"
                                   value="<%= p.getNombre()%>" id="nombre_accion" readonly><br>                               

                        </div>                            
                    </div>
                </div> 
            </div>
            <form action="Controlador" method="get">
                <div class="container text-end">
                    <div class="row">                   
                        <div class="col">
                            <h4 class="text-center">Aseguramiento y Organización</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Criterio</th>
                                        <th>Cantidad</th>                                    

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Totalmente:</label></td>
                                        <td><input type="number" class="form-control" id="num1" name="num1" min="0" value="<%=(reaccion.getPregunta1()[0] != 0) ? reaccion.getPregunta1()[0] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Gran Medida:</label></td>
                                        <td><input type="number" class="form-control" id="num2" name="num2" min="0" value="<%=(reaccion.getPregunta1()[1] != 0) ? reaccion.getPregunta1()[1] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Parte:</label></td>
                                        <td><input type="number" class="form-control" id="num3" name="num3" min="0" value="<%=(reaccion.getPregunta1()[2] != 0) ? reaccion.getPregunta1()[2] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>No se:</label></td>
                                        <td><input type="number" class="form-control" id="num4" name="num4" min="0" value="<%=(reaccion.getPregunta1()[3] != 0) ? reaccion.getPregunta1()[3] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Comentario:</label></td>
                                        <td><textarea type="text" class="form-control" id="text1" name="text1" rows="3"><%= reaccion.getComentario1()%></textarea></td>                     

                                    </tr>


                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <h4 class="text-center">Gestión Profesoral</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Criterio</th>
                                        <th>Cantidad</th>                                       

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Totalmente:</label></td>
                                        <td><input type="number" class="form-control" id="num5" name="num5" min="0" value="<%=(reaccion.getPregunta2()[0] != 0) ? reaccion.getPregunta2()[0] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Gran Medida:</label></td>
                                        <td><input type="number" class="form-control" id="num6" name="num6" min="0" value="<%=(reaccion.getPregunta2()[1] != 0) ? reaccion.getPregunta2()[1] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Parte:</label></td>
                                        <td><input type="number" class="form-control" id="num7" name="num7" min="0" value="<%=(reaccion.getPregunta2()[2] != 0) ? reaccion.getPregunta2()[2] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>No se:</label></td>
                                        <td><input type="number" class="form-control" id="num8" name="num8" min="0" value="<%=(reaccion.getPregunta2()[3] != 0) ? reaccion.getPregunta2()[3] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Comentario:</label></td>
                                        <td><textarea type="text" class="form-control" id="text2" name="text2" rows="3"><%= reaccion.getComentario2()%></textarea></td>                     

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <h4 class="text-center">Conocimientos Adquiridos</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Criterio</th>
                                        <th>Cantidad</th>                                       

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Totalmente:</label></td>
                                        <td><input type="number" class="form-control" id="num9" name="num9" min="0" value="<%=(reaccion.getPregunta3()[0] != 0) ? reaccion.getPregunta3()[0] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Gran Medida:</label></td>
                                        <td><input type="number" class="form-control" id="num10" name="num10" min="0" value="<%=(reaccion.getPregunta3()[1] != 0) ? reaccion.getPregunta3()[1] : 0%>"></td>                     

                                    </tr><tr>
                                        <td><label>En Parte:</label></td>
                                        <td><input type="number" class="form-control" id="num11" name="num11" min="0" value="<%=(reaccion.getPregunta3()[2] != 0) ? reaccion.getPregunta3()[2] : 0%>"></td>                     

                                    </tr><tr>
                                        <td><label>No se:</label></td>
                                        <td><input type="number" class="form-control" id="num12" name="num12" min="0" value="<%=(reaccion.getPregunta3()[3] != 0) ? reaccion.getPregunta3()[3] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Comentario:</label></td>
                                        <td><textarea type="text" class="form-control" id="text3" name="text3" rows="3"><%= reaccion.getComentario3()%></textarea></td>                     

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <h4 class="text-center">Aplicación de contenidos</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Criterio</th>
                                        <th>Cantidad</th>                                       

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Totalmente:</label></td>
                                        <td><input type="number" class="form-control" id="num13" name="num13" min="0" value="<%=(reaccion.getPregunta4()[0] != 0) ? reaccion.getPregunta4()[0] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>En Gran Medida:</label></td>
                                        <td><input type="number" class="form-control" id="num14" name="num14" min="0" value="<%=(reaccion.getPregunta4()[1] != 0) ? reaccion.getPregunta4()[1] : 0%>"></td>                     

                                    </tr><tr>
                                        <td><label>En Parte:</label></td>
                                        <td><input type="number" class="form-control" id="num15" name="num15" min="0" value="<%=(reaccion.getPregunta4()[2] != 0) ? reaccion.getPregunta4()[2] : 0%>"></td>                     

                                    </tr><tr>
                                        <td><label>No se:</label></td>
                                        <td><input type="number" class="form-control" id="num16" name="num16" min="0" value="<%=(reaccion.getPregunta4()[3] != 0) ? reaccion.getPregunta4()[3] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Comentario:</label></td>
                                        <td><textarea type="text" class="form-control" id="text4" name="text4" rows="3"><%= reaccion.getComentario4()%></textarea></td>                    

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col">
                            <h4 class="text-center">Calificación Final</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Criterio</th>
                                        <th>Cantidad</th>                                       

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Excelente:</label></td>
                                        <td><input type="number" class="form-control" id="num17" name="num17" min="0" value="<%=(reaccion.getPregunta5()[0] != 0) ? reaccion.getPregunta5()[0] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Bien:</label></td>
                                        <td><input type="number" class="form-control" id="num18" name="num18" min="0" value="<%=(reaccion.getPregunta5()[1] != 0) ? reaccion.getPregunta5()[1] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Mal:</label></td>
                                        <td><input type="number" class="form-control" id="num19" name="num19" min="0" value="<%=(reaccion.getPregunta5()[2] != 0) ? reaccion.getPregunta5()[2] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>No se:</label></td>
                                        <td><input type="number" class="form-control" id="num20" name="num20" min="0" value="<%=(reaccion.getPregunta5()[3] != 0) ? reaccion.getPregunta5()[3] : 0%>"></td>                     

                                    </tr>
                                    <tr>
                                        <td><label>Comentario:</label></td>
                                        <td><textarea type="text" class="form-control" id="text5" name="text5" rows="3" ><%= reaccion.getComentario5()%></textarea></td>                    

                                    </tr>

                                </tbody>
                            </table>
                        </div>


                    </div>
                    <div class="row">
                        <div class="col-2 mb-3 my-1">
                            <label class="form-label">Encuestados:</label>
                            <input type="number" class="form-control-sm" id="num21" name="num21" min="0" value="<%=(reaccion.getEncuestados() != 0) ? reaccion.getEncuestados() : 0%>">
                        </div>
                    </div>

                    <input type="hidden" name="user" value=<%=user%>>
                    <input type="hidden" name="number_accion" value=<%=p.getId_accion()%> id="number_accion">                   

                    <div class="row"> 
                        <div class="col-2">

                            <div class="d-grid gap-2 mb-1">
                                <button class="btn btn-success" type="submit" name="accion" value="edit_enc2">Guardar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </main>
        <script src="js/encuesta.js" type="text/javascript"></script>
        <%@ include file="footer.jspf" %>
    </body>
</html>
