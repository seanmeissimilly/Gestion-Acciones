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
                        <div class="col-3">
                            <h4 class="text-center">Trabajadores</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Clasificación</th>
                                        <th>Real</th>
                                        <th>Plan</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Técnicos:</label></td>
                                        <td><input type="number" class="form-control" id="num6" name="num6" min="0" value="<%=(reaccion.getTra_real1() != 0) ? reaccion.getTra_real1() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num27" name="num27" min="0" value="<%=(reaccion.getTra_plan1() != 0) ? reaccion.getTra_plan1() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Servicios:</label></td>
                                        <td><input type="number" class="form-control" id="num7" name="num7" min="0"  value="<%=(reaccion.getTra_real2() != 0) ? reaccion.getTra_real2() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num28" name="num28" min="0"  value="<%=(reaccion.getTra_plan2() != 0) ? reaccion.getTra_plan2() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Operarios:</label></td>
                                        <td><input type="number" class="form-control" id="num8" name="num8" min="0" value="<%=(reaccion.getTra_real3() != 0) ? reaccion.getTra_real3() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num29" name="num29" min="0"  value="<%=(reaccion.getTra_plan3() != 0) ? reaccion.getTra_plan3() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Administrativos:</label></td>
                                        <td><input type="number" class="form-control" id="num9" name="num9" min="0" value="<%=(reaccion.getTra_real4() != 0) ? reaccion.getTra_real4() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num30" name="num30" min="0" value="<%=(reaccion.getTra_plan4() != 0) ? reaccion.getTra_plan4() : 0%>"></td>

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-3">
                            <h4 class="text-center">Cuadros</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Clasificación</th>
                                        <th>Real</th>
                                        <th>Plan</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Directivos Superiores:</label></td>
                                        <td><input type="number" class="form-control" id="11" name="num11" min="0"  value="<%=(reaccion.getCua_dirreal1() != 0) ? reaccion.getCua_dirreal1() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num18" name="num18" min="0"  value="<%=(reaccion.getCua_dirplan1() != 0) ? reaccion.getCua_dirplan1() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Directivos Intermedios:</label></td>
                                        <td><input type="number" class="form-control" id="12" name="num12" min="0"  value="<%=(reaccion.getCua_dirreal2() != 0) ? reaccion.getCua_dirreal2() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num19" name="num19" min="0" value="<%=(reaccion.getCua_dirplan2() != 0) ? reaccion.getCua_dirplan2() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Directivos Ejecutivos:</label></td>
                                        <td><input type="number" class="form-control" id="13" name="num13" min="0"  value="<%=(reaccion.getCua_dirreal3() != 0) ? reaccion.getCua_dirreal3() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num20" name="num20" min="0"  value="<%=(reaccion.getCua_dirplan3() != 0) ? reaccion.getCua_dirplan3() : 0%>"></td>

                                    </tr>

                                </tbody>
                            </table>
                        </div>  
                        <div class="col-3">
                            <h4 class="text-center">Reservas</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Tipos</th>
                                        <th>Real</th>
                                        <th>Plan</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Cuadros:</label></td>
                                        <td><input type="number" class="form-control" id="num14" name="num14" min="0"  value="<%=(reaccion.getCuadrosreal() != 0) ? reaccion.getCuadrosreal() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num15" name="num15" min="0"  value="<%=(reaccion.getCuadrosplan() != 0) ? reaccion.getCuadrosplan() : 0%>"></td>
                                    </tr>
                                    <tr>
                                        <td><label>No Cuadros:</label></td>
                                        <td><input type="number" class="form-control" id="num16" name="num16" min="0"  value="<%=(reaccion.getNo_cuadrosreal() != 0) ? reaccion.getNo_cuadrosreal() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num17" name="num17" min="0"  value="<%=(reaccion.getNo_cuadrosplan() != 0) ? reaccion.getNo_cuadrosplan() : 0%>"></td>
                                    </tr>
                                    <tr>
                                        <td><label>Adiestrados:</label></td>
                                        <td><input type="number" class="form-control" id="num21" name="num21" min="0"  value="<%=(reaccion.getAdiestradosreal() != 0) ? reaccion.getAdiestradosreal() : 0%>"></td>
                                        <td><input type="number" class="form-control" id="num22" name="num22" min="0"  value="<%=(reaccion.getAdiestradosplan() != 0) ? reaccion.getAdiestradosplan() : 0%>"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-3">
                            <h4 class="text-center">Resultados Docentes</h4>
                            <table class="table text-center">
                                <thead>
                                    <tr>
                                        <th>Resultado</th>
                                        <th>Cantidad</th>                                        

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><label>Excelente:</label></td>
                                        <td><input type="number" class="form-control" id="num1" name="num1" min="0"  value="<%=(reaccion.getResultado1() != 0) ? reaccion.getResultado1() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Bien:</label></td>
                                        <td><input type="number" class="form-control" id="num2" name="num2" min="0"  value="<%=(reaccion.getResultado2() != 0) ? reaccion.getResultado2() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Regular:</label></td>
                                        <td><input type="number" class="form-control" id="num3" name="num3" min="0"  value="<%=(reaccion.getResultado3() != 0) ? reaccion.getResultado3() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>Mal:</label></td>
                                        <td><input type="number" class="form-control" id="num4" name="num4" min="0"  value="<%=(reaccion.getResultado4() != 0) ? reaccion.getResultado4() : 0%>"></td>

                                    </tr>
                                    <tr>
                                        <td><label>No Evaluados:</label></td>
                                        <td><input type="number" class="form-control" id="num5" name="num5" min="0" value="<%=(reaccion.getResultado5() != 0) ? reaccion.getResultado5() : 0%>"></td>

                                    </tr>
                                </tbody>
                            </table>
                        </div> 

                    </div>                       

                    <input type="hidden" name="user" value=<%=user%>>
                    <input type="hidden" name="number_accion" value=<%=p.getId_accion()%> id="number_accion">                   

                    <div class="row"> 
                        <div class="col-2">

                            <div class="d-grid gap-2 mb-1">
                                <button class="btn btn-success" type="submit" name="accion" value="edit_enc">Siguiente y Guardar</button>
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
