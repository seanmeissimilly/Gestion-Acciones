<%-- 
    Document   : report_accion_4p
    Created on : Oct 2, 2023, 8:41:47 AM
    Author     : davidam
--%>

<%@page import="Config.Conexion"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% /*recibo los parametros*/
    String fecha_inicial = request.getParameter("fechainicial_accion");
    String fecha_final = request.getParameter("fechafinal_accion");
    String entidadejecutora = request.getParameter("entidad_accion");
    String entidad = request.getParameter("entidad_p");

    /*Parametros para realizar la conexión*/
    Conexion cn = new Conexion();
    Connection conexion = cn.getConnection();

    /*Establecemos la ruta del reporte*/
    File reportFile = new File(application.getRealPath("Reportes/accion4.jasper"));
    /* Enviamos parámetros, seguiremos el formato del método runReportToPdf*/
    Map parameters = new HashMap();
    parameters.put("entj", entidadejecutora.toString());
    parameters.put("ent", entidad.toString());
    parameters.put("fecha_inicial", fecha_inicial.toString());
    parameters.put("fecha_final", fecha_final.toString());
    
    /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
    /*Indicamos que la respuesta va a ser en formato PDF*/ response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    response.setHeader("Content-Disposition", "attachment; reporte_plan_detallado.pdf"); // Establece la disposición del contenido
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes, 0, bytes.length);
    /*Limpiamos y cerramos flujos de salida*/ ouputStream.flush();
    ouputStream.close();%>
