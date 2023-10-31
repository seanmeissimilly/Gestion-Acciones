<%-- 
    Document   : admin
    Created on : 29 may 2023, 13:48:07
    Author     : davidam
--%>
<%@page import="ModeloBean.LdapBean"%>
<%@page import="Modelo.Ldap"%>
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
        <title>GesCap Administración</title>
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
            if (!userapp.getRol().equals("3")) {
                response.sendRedirect("./dashboard");
            }
        %>


        <main id="main" class="main">


            <div class="container my-4">
                <div class="row">
                    <div class="col-4">
                        <h2>Administración</h2>
                        <form name="form_accion" action="Controlador">                            
                            <%
                                Ldap ldap = new LdapBean().listar();

                            %>
                            <div class="mb-3">
                                <label for="ldap_ip" class="form-label">Servidor LDAP</label>
                                <input type="text" class="form-control" id="ip_ldap"
                                       value="<%= ldap.getIp_ldap()%>" name="ip_ldap" required="required">
                            </div>
                            <div class="mb-3">
                                <label for="ldap_user" class="form-label">Usuario</label>
                                <input type="text" class="form-control" id="user_ldap"
                                       name="user_ldap" required="required" value="<%= ldap.getUser_ldap()%>">
                            </div>
                            <div class="mb-3">
                                <label for="ldap_pass" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="pass_ldap"
                                       name="pass_ldap" required="required" value="<%= ldap.getPass_ldap()%>">
                            </div>

                            <input type="hidden" name="user" value=<%=user%>>

                            <div class="d-grid gap-2">
                                <button class="btn btn-success" type="submit" name="accion" value="update_ldap">Actualizar</button>
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </main>
        <%@ include file="footer.jspf" %>
    </body>
</html>
