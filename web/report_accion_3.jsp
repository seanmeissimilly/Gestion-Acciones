<%-- 
    Document   : report_accion_3
    Created on : 13 jun 2023, 9:53:17
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
    
    String id_accion = request.getParameter("id_accion");

    /*Parametros para realizar la conexión*/
    Conexion cn = new Conexion();
    Connection conexion = cn.getConnection();

    /*Establecemos la ruta del reporte*/
    File reportFile = new File(application.getRealPath("Reportes/accion3.jasper"));
    /* No enviamos parámetros porque nuestro reporte no los necesita asi que escriba 
cualquier cadena de texto ya que solo seguiremos el formato del método runReportToPdf*/
    Map parameters = new HashMap();
    parameters.put("id_accion", id_accion);
  
    /*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/
    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
    /*Indicamos que la respuesta va a ser en formato PDF*/ response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    response.setHeader("Content-Disposition", "attachment; reporte_reaccion.pdf"); // Establece la disposición del contenido
    
    ServletOutputStream ouputStream = response.getOutputStream(); // Obtiene el ServletOutputStream    
    ouputStream.write(bytes, 0, bytes.length);
    ouputStream.flush(); // Asegura que todos los datos se hayan escrito en el stream
    ouputStream.close();
%>
