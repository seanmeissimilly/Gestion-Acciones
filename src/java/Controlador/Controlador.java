package Controlador;

import Modelo.Accion;
import Modelo.Coordinador;
import Modelo.Cursista;
import Modelo.EncReaccion;
import Modelo.Entidad;
import Modelo.Fecha_GB;
import Modelo.Ldap;
import Modelo.Organizacion;
import Modelo.Persona;
import Modelo.Profesor;
import Modelo.Usuario;
import ModeloBean.AccionBean;
import ModeloBean.AreaBean;
import ModeloBean.EncReaccionBean;
import ModeloBean.EntidadBean;
import ModeloBean.Fecha_GB_Bean;
import ModeloBean.LdapBean;
import ModeloBean.OrganizacionBean;
import ModeloBean.PersonaBean;
import ModeloBean.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    //Referencias a las paginas
    String persona_list = "persona_list.jsp";
    String persona_add = "persona_add.jsp";
    String persona_edit = "persona_edit.jsp";
    String usuario_edit = "usuario_edit.jsp";
    String usuario_list = "usuario_list.jsp";
    String organizacion_list = "organizacion_list.jsp";
    String entidad_list = "entidad_list.jsp";
    String admin = "admin.jsp";
    String organizacion_edit = "organizacion_edit.jsp";
    String entidad_edit = "entidad_edit.jsp";
    String login = "login.jsp";
    String panel = "./dashboard";
    String accion_add = "./accion_add";
    String accion_edit = "./accion_edit";
    String accion_enc = "accion_enc.jsp";
    String accion_enc2 = "accion_enc2.jsp";
    String accion_enct = "accion_enct.jsp";
    String urol_edit = "rol_edit.jsp";
    String urol_list = "rol_list.jsp";
    String reporte_accion_1 = "reporte_accion_1.jsp";
    String reporte_accion_2 = "reporte_accion_2.jsp";

    Persona persona = new Persona();
    Usuario user = new Usuario();
    Profesor profe = new Profesor();
    Coordinador coordinador = new Coordinador();
    Cursista cursista = new Cursista();
    Organizacion organizacion = new Organizacion();
    Entidad entidad = new Entidad();
    Accion accion = new Accion();

    PersonaBean dao = new PersonaBean();
    AreaBean areadao = new AreaBean();
    UsuarioBean userdao = new UsuarioBean();
    OrganizacionBean orgdao = new OrganizacionBean();
    EntidadBean entdao = new EntidadBean();
    AccionBean acciondao = new AccionBean();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        switch (action) {

            case "persona_list": {

                acceso = persona_list;

                break;

            }

            case "organizacion_edit": {

                request.setAttribute("id", request.getParameter("id"));
                acceso = organizacion_edit;

                break;

            }
            case "procesar-fechas": {

                //Recibo los parametros del formulario del panel            
                Fecha_GB fecha = new Fecha_GB();
                fecha.setFinicial(request.getParameter("fechaInicial"));
                fecha.setFfinal(request.getParameter("fechaFinal"));
                fecha.setUsername(request.getParameter("user"));

                //Genero una fecha bean.
                Fecha_GB_Bean gra = new Fecha_GB_Bean();

                //Actualizo las fechas en la base de datos.
                gra.updatedate(fecha);

                //Vuelvo a pintar.
                acceso = panel;

                break;

            }
            case "procesar-fechas2": {

                //Recibo los parametros del formulario del panel            
                Fecha_GB fecha = new Fecha_GB();
                fecha.setFinicial(request.getParameter("fechaIniciala"));
                fecha.setFfinal(request.getParameter("fechaFinala"));
                fecha.setUsername(request.getParameter("user"));

                //Genero una fecha bean.
                Fecha_GB_Bean gra = new Fecha_GB_Bean();

                //Actualizo las fechas en la base de datos.
                gra.updatedateareas(fecha);

                //Vuelvo a pintar.
                acceso = panel;

                break;

            }
            case "entidad_edit": {

                request.setAttribute("id_entidad", request.getParameter("id_entidad"));
                request.setAttribute("page", request.getParameter("page"));
                acceso = entidad_edit;

                break;

            }

            case "persona_add": {

                acceso = persona_add;

                break;

            }
            case "edit_enc": {

                userdao = new UsuarioBean();
                String id = null;
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    id = request.getParameter("number_accion");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        //Empiezo a asignarle los valores.
                        EncReaccion reaccion = new EncReaccion();

                        //Ingreso el id de la accion.
                        reaccion.setId_accion(Integer.parseInt(id));

                        //Trabajadores Plan
                        reaccion.setTra_plan1(Integer.parseInt(request.getParameter("num27")));
                        reaccion.setTra_plan2(Integer.parseInt(request.getParameter("num28")));
                        reaccion.setTra_plan3(Integer.parseInt(request.getParameter("num29")));
                        reaccion.setTra_plan4(Integer.parseInt(request.getParameter("num30")));

                        //Trabajadores Real
                        reaccion.setTra_real1(Integer.parseInt(request.getParameter("num6")));
                        reaccion.setTra_real2(Integer.parseInt(request.getParameter("num7")));
                        reaccion.setTra_real3(Integer.parseInt(request.getParameter("num8")));
                        reaccion.setTra_real4(Integer.parseInt(request.getParameter("num9")));

                        //Cuadros Plan
                        reaccion.setCua_dirplan1(Integer.parseInt(request.getParameter("num18")));
                        reaccion.setCua_dirplan2(Integer.parseInt(request.getParameter("num19")));
                        reaccion.setCua_dirplan3(Integer.parseInt(request.getParameter("num20")));

                        //Cuadros Real
                        reaccion.setCua_dirreal1(Integer.parseInt(request.getParameter("num11")));
                        reaccion.setCua_dirreal2(Integer.parseInt(request.getParameter("num12")));
                        reaccion.setCua_dirreal3(Integer.parseInt(request.getParameter("num13")));

                        //Reservas
                        reaccion.setCuadrosreal(Integer.parseInt(request.getParameter("num14")));
                        reaccion.setCuadrosplan(Integer.parseInt(request.getParameter("num15")));

                        reaccion.setNo_cuadrosreal(Integer.parseInt(request.getParameter("num16")));
                        reaccion.setNo_cuadrosplan(Integer.parseInt(request.getParameter("num17")));

                        //Adiestrados
                        reaccion.setAdiestradosreal(Integer.parseInt(request.getParameter("num21")));
                        reaccion.setAdiestradosplan(Integer.parseInt(request.getParameter("num22")));

                        //Resultados Docentes.
                        reaccion.setResultado1(Integer.parseInt(request.getParameter("num1")));
                        reaccion.setResultado2(Integer.parseInt(request.getParameter("num2")));
                        reaccion.setResultado3(Integer.parseInt(request.getParameter("num3")));
                        reaccion.setResultado4(Integer.parseInt(request.getParameter("num4")));
                        reaccion.setResultado5(Integer.parseInt(request.getParameter("num5")));

                        acciondao.encreaccion(ac, reaccion);

                    }
                }

                request.setAttribute("id", id);
                request.setAttribute("user", user.getUsername());
                acceso = accion_enc2;
                break;

            }
            case "edit_enc2": {

                userdao = new UsuarioBean();
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("number_accion");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        //Empiezo a asignarle los valores.
                        EncReaccion reaccion = new EncReaccion();

                        //Ingreso el id de la accion.
                        reaccion.setId_accion(Integer.parseInt(id));

                        //Pregunta 1
                        reaccion.setPregunta1(Integer.parseInt(request.getParameter("num1")), 0);
                        reaccion.setPregunta1(Integer.parseInt(request.getParameter("num2")), 1);
                        reaccion.setPregunta1(Integer.parseInt(request.getParameter("num3")), 2);
                        reaccion.setPregunta1(Integer.parseInt(request.getParameter("num4")), 3);

                        //Pregunta 2
                        reaccion.setPregunta2(Integer.parseInt(request.getParameter("num5")), 0);
                        reaccion.setPregunta2(Integer.parseInt(request.getParameter("num6")), 1);
                        reaccion.setPregunta2(Integer.parseInt(request.getParameter("num7")), 2);
                        reaccion.setPregunta2(Integer.parseInt(request.getParameter("num8")), 3);

                        //Pregunta 3
                        reaccion.setPregunta3(Integer.parseInt(request.getParameter("num9")), 0);
                        reaccion.setPregunta3(Integer.parseInt(request.getParameter("num10")), 1);
                        reaccion.setPregunta3(Integer.parseInt(request.getParameter("num11")), 2);
                        reaccion.setPregunta3(Integer.parseInt(request.getParameter("num12")), 3);

                        //Pregunta 4
                        reaccion.setPregunta4(Integer.parseInt(request.getParameter("num13")), 0);
                        reaccion.setPregunta4(Integer.parseInt(request.getParameter("num14")), 1);
                        reaccion.setPregunta4(Integer.parseInt(request.getParameter("num15")), 2);
                        reaccion.setPregunta4(Integer.parseInt(request.getParameter("num16")), 3);

                        //Pregunta 5
                        reaccion.setPregunta5(Integer.parseInt(request.getParameter("num17")), 0);
                        reaccion.setPregunta5(Integer.parseInt(request.getParameter("num18")), 1);
                        reaccion.setPregunta5(Integer.parseInt(request.getParameter("num19")), 2);
                        reaccion.setPregunta5(Integer.parseInt(request.getParameter("num20")), 3);

                        //Comentatios
                        reaccion.setComentario1(request.getParameter("text1"));
                        reaccion.setComentario2(request.getParameter("text2"));
                        reaccion.setComentario3(request.getParameter("text3"));
                        reaccion.setComentario4(request.getParameter("text4"));
                        reaccion.setComentario5(request.getParameter("text5"));

                        //Encuestados
                        reaccion.setEncuestados(Integer.parseInt(request.getParameter("num21")));

                        EncReaccionBean enc = new EncReaccionBean();
                        enc.addupdate(reaccion);

                    }
                }

                acceso = panel;
                break;

            }
            case "edit_accion": {

                userdao = new UsuarioBean();
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("number_accion");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        //Empiezo a asignarle los valores.
                        accion.setNombre(request.getParameter("nombre_accion"));
                        accion.setFecha_inicial(request.getParameter("fechainicial_accion"));
                        accion.setFecha_final(request.getParameter("fechafinal_accion"));
                        accion.setId_clasificacion(request.getParameter("clasificacion_accion"));
                        accion.setId_formaorganizativa(request.getParameter("forganizativa_accion"));
                        accion.setId_area(request.getParameter("area_accion"));
                        accion.setId_entidadejecutora(request.getParameter("entidad_accion"));
                        accion.setId_entidad(request.getParameter("entidad_p"));
                        accion.setId_modalidad(request.getParameter("modalidad_accion"));
                        accion.setExtraplan(request.getParameter("extraplan_accion") != null);

                        //Reviso si el parametro de creditos esta vacio.
                        if (request.getParameter("creditos_accion").equals("")) {
                            accion.setCreditos("0");
                        } else {
                            accion.setCreditos(request.getParameter("creditos_accion"));
                        }

                        accion.setId_evaluacionfinal(request.getParameter("evaluacion_accion"));
                        accion.setObservaciones(request.getParameter("observaciones_accion"));
                        acciondao.edit(accion, id);

                    }
                }

                acceso = accion_add;
                break;

            }
            case "edit_userapp": {
                String username = request.getParameter("txtusername");
                String name = request.getParameter("txtname");
                String id_rol = request.getParameter("id_rol");
                String entidad = request.getParameter("entidad_p");
                userdao = new UsuarioBean();
                user = new Usuario();
                user.setNombre(name);
                user.setUsername(username);
                user.setRol(id_rol);
                user.setEntidad(entidad);
                userdao.edit(user, username);
                acceso = urol_list;

                break;

            }
            case "login": {

                acceso = panel;

                break;

            }
            case "accion_delete": {

                userdao = new UsuarioBean();
                Usuario user = userdao.list(request.getParameter("user"));

                //Reviso si el usuario solo tiene rol de consultor.
                if (!user.getRol().equals("1")) {
                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("id");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere eliminar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {
                        //Borro la accion.
                        acciondao.eliminar(id);
                    }

                }
                request.setAttribute("page", request.getParameter("page"));
                acceso = accion_add;
                break;

            }
            case "accion_edit": {

                userdao = new UsuarioBean();
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("id");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        request.setAttribute("id", id);
                        request.setAttribute("user", user.getUsername());
                        acceso = accion_edit;
                        break;
                    }
                }
                acceso = accion_add;
                break;

            }
            case "accion_encuesta": {

                userdao = new UsuarioBean();
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("id");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        request.setAttribute("id", id);
                        request.setAttribute("user", user.getUsername());
                        acceso = accion_enc;
                        break;
                    }
                }
                acceso = accion_enc;
                break;

            }
            case "accion_encuestat": {

                userdao = new UsuarioBean();
                user = userdao.list(request.getParameter("user"));
                if (!user.getRol().equals("1")) {

                    //Recibo el parametro del id de la accion.
                    String id = request.getParameter("id");

                    //Busco esa accion en la base de datos.
                    acciondao = new AccionBean();
                    Accion ac = acciondao.list(id).get(0);

                    //Reviso si el usuario que quiere editar la accion es de la misma entidad que la accion.
                    if (ac.getEntidad().equals(user.getEntidad()) || user.getRol().equals("3")) {

                        request.setAttribute("id", id);
                        request.setAttribute("user", user.getUsername());
                        acceso = accion_enct;
                        break;
                    }
                }
                acceso = accion_enc;
                break;

            }
            case "urol_edit": {

                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("page", request.getParameter("page"));
                acceso = urol_edit;
                break;

            }
            case "urol_delete": {

                String username = request.getParameter("id");
                userdao.eliminar(username);
                request.setAttribute("page", request.getParameter("page"));
                acceso = urol_list;
                break;

            }

            case "add_person": {

                String ci = request.getParameter("txtCi");
                //Para no entrar espacios vacios
                if (ci.equals("")) {
                    acceso = persona_list;
                    break;
                }
                String nombre = request.getParameter("txtNombre");
                String primerapellido = request.getParameter("txtPrimerApellido");
                String segundoapellido = request.getParameter("txtSegundoApellido");
                persona.setCi(ci);
                persona.setNombre(nombre);
                persona.setPrimerApellido(primerapellido);
                persona.setSegundoApellido(segundoapellido);
                dao.add(persona);
                acceso = persona_list;

                break;

            }
            case "persona_edit": {

                request.setAttribute("ci", request.getParameter("ci"));
                acceso = persona_edit;

                break;

            }
            case "usuario_edit": {

                request.setAttribute("username", request.getParameter("username"));
                acceso = usuario_edit;

                break;

            }
            case "edit_organizacion": {

                String numero_org = request.getParameter("txtnumero_organizacion");
                String nombre = request.getParameter("txtnombre_organizacionnew");
                organizacion.setNumero(numero_org);
                organizacion.setNombre(nombre);
                orgdao.edit(organizacion, numero_org);
                acceso = organizacion_list;

                break;

            }
            case "edit_entidad": {
                String id_entidad = request.getParameter("txtnumero_entidad");
                String nombre = request.getParameter("txtnombre_entidadnew");
                String prefix = request.getParameter("prefix_entidadnew");
                entidad.setid_entidad(id_entidad);
                entidad.setNombre(nombre);
                entidad.setPrefix(prefix);
                entdao.edit(entidad, id_entidad);

                request.setAttribute("page", request.getParameter("page"));

                acceso = entidad_list;

                break;

            }
            case "Actualizar": {

                String cinuevo = request.getParameter("txtCinuevo");
                String ci = request.getParameter("txtCi");
                String nombre = request.getParameter("txtNombre");
                String primerapellido = request.getParameter("txtPrimerApellido");
                String segundoapellido = request.getParameter("txtSegundoApellido");
                persona.setCi(ci);
                persona.setNombre(nombre);
                persona.setPrimerApellido(primerapellido);
                persona.setSegundoApellido(segundoapellido);
                dao.edit(persona, cinuevo);
                acceso = persona_list;

                break;

            }
            case "usuario_delete": {

                String username = request.getParameter("username");
                userdao.eliminar(username);
                acceso = usuario_list;

                break;

            }
            case "persona_delete": {

                String ci = request.getParameter("ci");
                dao.eliminar(ci);
                acceso = persona_list;

                break;

            }
            case "organizacion_delete": {

                String numero = request.getParameter("numero");
                orgdao.eliminar(numero);
                acceso = organizacion_list;

                break;

            }

            case "update_ldap": {

                userdao = new UsuarioBean();
                Usuario user = userdao.list(request.getParameter("user"));

                //Reviso si el usuario si tiene rol de administrador.
                if (user.getRol().equals("3")) {
//Recibo los parametros de la pagina admin.
                    String ip_ldap = request.getParameter("ip_ldap");
                    String user_ldap = request.getParameter("user_ldap");
                    String pass_ldap = request.getParameter("pass_ldap");
                    LocalDate todaysDate = LocalDate.now();

                    //Genero un objeto ldap.
                    Ldap active_directory = new Ldap(ip_ldap, user_ldap, pass_ldap, todaysDate.toString(), user.getUsername());
                    LdapBean ldap = new LdapBean();
                    ldap.update_ldap(active_directory);
                    acceso = admin;
                    break;

                } else {

                    acceso = admin;

                    break;
                }

            }
            case "add_organizacion": {
                String nombre = request.getParameter("txtnombre_organizacion");
                organizacion.setNombre(nombre);
                orgdao.add(organizacion);
                acceso = organizacion_list;
                break;

            }
            case "add_entidad": {

                String nombre = request.getParameter("txtnombre_entidad");
                String numero_org = request.getParameter("txtnumero_organizacion");
                String prefix = request.getParameter("txtprefix_entidad");
                entidad = new Entidad();
                entidad.setNombre(nombre);
                entidad.setid_org(numero_org);
                entidad.setPrefix(prefix);
                entdao.add(entidad);

                acceso = entidad_list;
                break;

            }
            case "add_accion": {

                userdao = new UsuarioBean();
                Usuario user = userdao.list(request.getParameter("user"));

                //Reviso si el usuario solo tiene rol de consultor.
                if (user.getRol().equals("1")) {
                    acceso = accion_add;
                    request.setAttribute("page", request.getParameter("page"));
                    break;

                } else {

                    //creo una nueva accion.
                    accion = new Accion();
                    //Empiezo a asignarle los valores.
                    accion.setNombre(request.getParameter("nombre_accion"));
                    accion.setFecha_inicial(request.getParameter("fechainicial_accion"));
                    accion.setFecha_final(request.getParameter("fechafinal_accion"));
                    accion.setId_clasificacion(request.getParameter("clasificacion_accion"));
                    accion.setId_formaorganizativa(request.getParameter("forganizativa_accion"));
                    accion.setId_area(request.getParameter("area_accion"));
                    accion.setId_entidadejecutora(request.getParameter("entidad_accion"));
                    accion.setId_entidad(request.getParameter("entidad_p"));
                    accion.setId_modalidad(request.getParameter("modalidad_accion"));
                    accion.setExtraplan(request.getParameter("extraplan_accion") != null);

                    //Reviso si el parametro de creditos esta vacio.
                    if (request.getParameter("creditos_accion").equals("")) {
                        accion.setCreditos("0");
                    } else {
                        accion.setCreditos(request.getParameter("creditos_accion"));
                    }

                    accion.setId_evaluacionfinal(request.getParameter("evaluacion_accion"));
                    accion.setObservaciones(request.getParameter("observaciones_accion"));
                    accion.setFicha(request.getParameter("descripcion_accion"));

                    //Reviso si el usuario tiene rol de editor y si esta en su entidad.
                    if (user.getRol().equals("2") && user.getEntidad().equals(accion.getId_entidad()) || user.getRol().equals("3")) {
                        acciondao.add(accion);
                        request.setAttribute("page", request.getParameter("page"));
                        acceso = accion_add;
                        break;

                    }
                    acceso = accion_add;
                    break;
                }

            }

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);

        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
