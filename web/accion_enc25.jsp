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

            <form action="Controlador" method="get">
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
                    <div class="row">                   
                        <div class="col">
                            <div>
                                <label for="resultados" class="form-label">Trabajadores Real</label> 
                            </div>
                            <div class="mb-1">  
                                <label>Técnicos:</label>
                                <input type="number" class="form-control-sm" id="num6" name="num6" min="0" placeholder="Técnicos" value="<%=(reaccion.getTra_real1() != 0) ? reaccion.getTra_real1() : 0%>"><br>

                                <label>Servicios:</label>
                                <input type="number" class="form-control-sm" id="num7" name="num7" min="0"  value="<%=(reaccion.getTra_real2() != 0) ? reaccion.getTra_real2() : 0%>"><br>

                                <label>Operarios:</label>
                                <input type="number" class="form-control-sm" id="num8" name="num8" min="0" value="<%=(reaccion.getTra_real3() != 0) ? reaccion.getTra_real3() : 0%>"><br>

                                <label>Administrativos:</label>
                                <input type="number" class="form-control-sm" id="num9" name="num9" min="0" value="<%=(reaccion.getTra_real4() != 0) ? reaccion.getTra_real4() : 0%>"><br>

                                <label>Total:</label>
                                <input type="number" class="form-control-sm" id="num10" name="num10" min="0" placeholder="Total" readonly><br>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <label for="resultados" class="form-label">Cuadros Real</label> 
                            </div>
                            <div class="mb-1">  
                                <label>Directivos 1:</label>
                                <input type="number" class="form-control-sm" id="num11" name="num11" min="0"  value="<%=(reaccion.getCua_dirreal1() != 0) ? reaccion.getCua_dirreal1() : 0%>"><br>

                                <label>Directivos 2:</label>
                                <input type="number" class="form-control-sm" id="num12" name="num12" min="0"  value="<%=(reaccion.getCua_dirreal2() != 0) ? reaccion.getCua_dirreal2() : 0%>"><br>

                                <label>Directivos 3:</label>
                                <input type="number" class="form-control-sm" id="num13" name="num13" min="0"  value="<%=(reaccion.getCua_dirreal3() != 0) ? reaccion.getCua_dirreal3() : 0%>"><br>

                                <label>Ejecutivos 1:</label>
                                <input type="number" class="form-control-sm" id="num14" name="num14" min="0"  value="<%=(reaccion.getCua_ejecreal1() != 0) ? reaccion.getCua_ejecreal1() : 0%>"><br>

                                <label>Ejecutivos 2:</label>
                                <input type="number" class="form-control-sm" id="num15" name="num15" min="0" placeholder="Ejecutivos 2" value="<%=(reaccion.getCua_ejecreal2() != 0) ? reaccion.getCua_ejecreal2() : 0%>"><br>

                                <label>Ejecutivos 3:</label>
                                <input type="number" class="form-control-sm" id="num16" name="num16" min="0" placeholder="Ejecutivos 3" value="<%=(reaccion.getCua_ejecreal3() != 0) ? reaccion.getCua_ejecreal3() : 0%>"><br>

                                <label>Total :</label>
                                <input type="number" class="form-control-sm" id="num17" name="num17" min="0" placeholder="Total" readonly><br>
                            </div>
                        </div>  
                        <div class="col">
                            <div>
                                <label for="resultados" class="form-label">Resultados Docentes</label> 
                            </div>
                            <div class="mb-1">     
                                <label>Excelente:</label>
                                <input type="number" class="form-control-sm" id="num1" name="num1" min="0" placeholder="Excelente" value="<%=(reaccion.getResultado1() != 0) ? reaccion.getResultado1() : 0%>"><br>
                                <label>Bien:</label>
                                <input type="number" class="form-control-sm" id="num2" name="num2" min="0" placeholder="Bien" value="<%=(reaccion.getResultado1() != 0) ? reaccion.getResultado1() : 0%>"><br>
                                <label>Regular:</label>
                                <input type="number" class="form-control-sm" id="num3" name="num3" min="0" placeholder="Regular" value="<%=(reaccion.getResultado2() != 0) ? reaccion.getResultado2() : 0%>"><br>
                                <label>Mal:</label>
                                <input type="number" class="form-control-sm" id="num4" name="num4" min="0" placeholder="Mal" value="<%=(reaccion.getResultado3() != 0) ? reaccion.getResultado3() : 0%>"><br>
                                <label>No Evaluados:</label>
                                <input type="number" class="form-control-sm" id="num5" name="num5" min="0" placeholder="No Evaluados" value="<%=(reaccion.getResultado4() != 0) ? reaccion.getResultado4() : 0%>"><br>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-4">
                            <div>
                                <label for="resultados" class="form-label">Trabajadores Plan</label> 
                            </div>
                            <div class="mb-1">  
                                <label>Técnicos:</label>
                                <input type="number" class="form-control-sm" id="num27" name="num27" min="0" placeholder="Técnicos" value="<%=(reaccion.getTra_plan1() != 0) ? reaccion.getTra_plan1() : 0%>"><br>

                                <label>Servicios:</label>
                                <input type="number" class="form-control-sm" id="num28" name="num28" min="0"  value="<%=(reaccion.getTra_plan2() != 0) ? reaccion.getTra_plan2() : 0%>"><br>

                                <label>Operarios:</label>
                                <input type="number" class="form-control-sm" id="num29" name="num29" min="0"  value="<%=(reaccion.getTra_plan3() != 0) ? reaccion.getTra_plan3() : 0%>"><br>

                                <label>Administrativos:</label>
                                <input type="number" class="form-control-sm" id="num30" name="num30" min="0" value="<%=(reaccion.getTra_plan4() != 0) ? reaccion.getTra_plan4() : 0%>"><br>

                                <label>Total:</label>
                                <input type="number" class="form-control-sm" id="num31" name="num31" min="0"  readonly><br>
                            </div>
                        </div>
                        <div class="col-4">
                            <div>
                                <label for="resultados" class="form-label">Cuadros Plan</label> 
                            </div>
                            <div class="mb-1">  
                                <label>Directivos 1:</label>
                                <input type="number" class="form-control-sm" id="num18" name="num18" min="0"  value="<%=(reaccion.getCua_dirplan1() != 0) ? reaccion.getCua_dirplan1() : 0%>"><br>

                                <label>Directivos 2:</label>
                                <input type="number" class="form-control-sm" id="num19" name="num19" min="0" value="<%=(reaccion.getCua_dirplan2() != 0) ? reaccion.getCua_dirplan2() : 0%>"><br>

                                <label>Directivos 3:</label>
                                <input type="number" class="form-control-sm" id="num20" name="num20" min="0"  value="<%=(reaccion.getCua_dirplan3() != 0) ? reaccion.getCua_dirplan3() : 0%>"><br>

                                <label>Ejecutivos 1:</label>
                                <input type="number" class="form-control-sm" id="num21" name="num21" min="0" placeholder="Ejecutivos 1" value="<%=(reaccion.getCua_ejecplan1() != 0) ? reaccion.getCua_ejecplan1() : 0%>"><br>

                                <label>Ejecutivos 2:</label>
                                <input type="number" class="form-control-sm" id="num22" name="num22" min="0" placeholder="Ejecutivos 2" value="<%=(reaccion.getCua_ejecplan2() != 0) ? reaccion.getCua_ejecplan2() : 0%>"><br>

                                <label>Ejecutivos 3:</label>
                                <input type="number" class="form-control-sm" id="num23" name="num23" min="0" placeholder="Ejecutivos 3" value="<%=(reaccion.getCua_ejecplan3() != 0) ? reaccion.getCua_ejecplan3() : 0%>"><br>

                                <label>Total :</label>
                                <input type="number" class="form-control-sm" id="num24" name="num24" min="0"  readonly><br>
                            </div>
                        </div>
                        <div class="col-4">
                            <div>
                                <label for="resultados" class="form-label">Total Participantes C + T</label> 
                            </div>
                            <div class="mb-1"> 

                                <label>Total Plan:</label>
                                <input type="number" class="form-control-sm" id="num25" min="0" placeholder="Total Plan" readonly><br>
                                <label>Total Real:</label>
                                <input type="number" class="form-control-sm" id="num26" min="0" placeholder="Total Real" readonly><br>
                            </div>
                        </div>
                    </div>    
                </div>
                <input type="hidden" name="user" value=<%=user%>>

                <div class="row"> 
                    <div class="col-2">
                        <div class="d-grid gap-2 mb-1">
                            <button class="btn btn-secondary" type="button" onclick="calcular()">Calcular</button>
                        </div>
                        <div class="d-grid gap-2 mb-1">
                            <button class="btn btn-success" type="submit" name="accion" value="edit_enc">Guardar</button>
                        </div>
                    </div>
                </div>

            </form>

        </main>
        <script src="js/encuesta.js" type="text/javascript"></script>
        <%@ include file="footer.jspf" %>
    </body>
</html>
