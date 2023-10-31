/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Modelo.Accion;
import Config.Conexion;
import Modelo.EncReaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class AccionBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Accion accion = new Accion();

    public AccionBean() {

    }

    public boolean add(Accion accion) {
        String sql = "insert into accioncapacitacion(`creditos`, `nombre`, `fechainicio`, `fechafinal`, `id_evalfinal`, `id_clafcaccion`, `id_formorg`, `id_areaaccion`, `id_entejecutora`, `id_modaccion`, `planificada`, `observaciones`,`ficha`,`id_entidad`)values('" + accion.getCreditos() + "','" + accion.getNombre() + "','" + accion.getFecha_inicial() + "','" + accion.getFecha_final() + "','" + accion.getId_evaluacionfinal() + "','" + accion.getId_clasificacion() + "','" + accion.getId_formaorganizativa() + "','" + accion.getId_area() + "','" + accion.getId_entidadejecutora() + "','" + accion.getId_modalidad() + "','" + ((accion.isExtraplan()) ? "1" : "0") + "','" + accion.getObservaciones() + "','" + accion.getFicha() + "','" + accion.getId_entidad() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public List listar() {
        ArrayList<Accion> list = new ArrayList<>();
        String sql = "SELECT accioncapacitacion.id_accion as id_accion,entidad.descripcion AS id_entidad,accioncapacitacion.id_encuestareacc AS id_encuestareacc, accioncapacitacion.creditos as creditos, accioncapacitacion.observaciones as observaciones, accioncapacitacion.planificada as planificada, accioncapacitacion.nombre as nombre, accioncapacitacion.fechainicio as fechainicio, accioncapacitacion.fechafinal as fechafinal, clasificacionaccion.descripcion as id_clafcaccion, formaorganizativa.descripcion as id_formorg, areaaccion.descripcion as id_areaaccion, entidadejecutora.descripcion as id_entejecutora, evalfinal.descripcion as id_evalfinal, accioncapacitacion.ficha as ficha, modalidadaccion.descripcion as id_modaccion FROM accioncapacitacion, entidad, formaorganizativa, clasificacionaccion, areaaccion, entidadejecutora, evalfinal, modalidadaccion WHERE clasificacionaccion.id_clafcaccion=accioncapacitacion.id_clafcaccion AND formaorganizativa.id_formorg=accioncapacitacion.id_formorg AND areaaccion.id_areaaccion=accioncapacitacion.id_areaaccion AND entidadejecutora.id_entejecutora=accioncapacitacion.id_entejecutora AND evalfinal.id_evalfinal=accioncapacitacion.id_evalfinal AND accioncapacitacion.id_modaccion=modalidadaccion.id_modaccion AND entidad.id_entidad = accioncapacitacion.id_entidad ORDER BY accioncapacitacion.id_accion DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accion accion = new Accion();
                accion.setId_accion(rs.getString("id_accion"));
                accion.setCreditos(rs.getString("creditos"));
                accion.setObservaciones(rs.getString("observaciones"));
                accion.setExtraplan(rs.getBoolean("planificada"));
                accion.setNombre(rs.getString("nombre"));
                accion.setFecha_inicial(rs.getString("fechainicio"));
                accion.setFecha_final(rs.getString("fechafinal"));
                accion.setId_evaluacionfinal(rs.getString("id_evalfinal"));
                accion.setId_clasificacion(rs.getString("id_clafcaccion"));
                accion.setId_formaorganizativa(rs.getString("id_formorg"));
                accion.setFicha(rs.getString("ficha"));
                accion.setId_area(rs.getString("id_areaaccion"));
                accion.setId_entidadejecutora(rs.getString("id_entejecutora"));
                accion.setId_entidad(rs.getString("id_entidad"));
                accion.setId_modalidad(rs.getString("id_modaccion"));
                accion.setId_encuestareacc(rs.getString("id_encuestareacc"));
                list.add(accion);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean eliminar(String id) {
        String sql = "delete from accioncapacitacion where id_accion=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public ArrayList<Accion> list(String id) {
        ArrayList<Accion> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	accioncapacitacion.id_accion AS id_accion,\n"
                + "	accioncapacitacion.creditos AS creditos,\n"
                + "	accioncapacitacion.observaciones AS observaciones,\n"
                + "	accioncapacitacion.planificada AS planificada,\n"
                + "	accioncapacitacion.nombre AS nombre,\n"
                + "	accioncapacitacion.fechainicio AS fechainicio,\n"
                + "	accioncapacitacion.fechafinal AS fechafinal,\n"
                + "	clasificacionaccion.descripcion AS id_clafcaccion,\n"
                + "	formaorganizativa.descripcion AS id_formorg,\n"
                + "	modalidadaccion.descripcion AS id_modaccion,\n"
                + "	areaaccion.descripcion AS id_areaaccion,\n"
                + "	entidadejecutora.descripcion AS id_entejecutora,\n"
                + "	entidad.descripcion AS id_entidad,\n"
                + "	evalfinal.descripcion AS id_evalfinal,\n"
                + "	accioncapacitacion.id_entidad AS entidad,\n"
                + "	accioncapacitacion.id_encuestareacc AS id_encuestareacc,\n"
                + "	accioncapacitacion.ficha AS ficha \n"
                + "FROM\n"
                + "	accioncapacitacion,\n"
                + "	entidad,\n"
                + "	formaorganizativa,\n"
                + "	clasificacionaccion,\n"
                + "	areaaccion,\n"
                + "	entidadejecutora,\n"
                + "	evalfinal,\n"
                + "	modalidadaccion \n"
                + "WHERE\n"
                + "	clasificacionaccion.id_clafcaccion = accioncapacitacion.id_clafcaccion \n"
                + "	AND formaorganizativa.id_formorg = accioncapacitacion.id_formorg \n"
                + "	AND areaaccion.id_areaaccion = accioncapacitacion.id_areaaccion \n"
                + "	AND entidadejecutora.id_entejecutora = accioncapacitacion.id_entejecutora \n"
                + "	AND evalfinal.id_evalfinal = accioncapacitacion.id_evalfinal \n"
                + "	AND modalidadaccion.id_modaccion = accioncapacitacion.id_modaccion\n"
                + "	AND entidad.id_entidad = accioncapacitacion.id_entidad\n"
                + "	AND id_accion='" + id + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accion accion = new Accion();
                accion.setId_accion(rs.getString("id_accion"));
                accion.setNombre(rs.getString("nombre"));
                accion.setFecha_inicial(rs.getString("fechainicio"));
                accion.setFecha_final(rs.getString("fechafinal"));
                accion.setId_clasificacion(rs.getString("id_clafcaccion"));
                accion.setId_formaorganizativa(rs.getString("id_formorg"));
                accion.setId_area(rs.getString("id_areaaccion"));
                accion.setId_entidadejecutora(rs.getString("id_entejecutora"));
                accion.setId_entidad(rs.getString("id_entidad"));
                accion.setId_modalidad(rs.getString("id_modaccion"));
                accion.setExtraplan(rs.getString("planificada").equals("1"));
                accion.setCreditos(rs.getString("creditos"));
                accion.setId_evaluacionfinal(rs.getString("id_evalfinal"));
                accion.setObservaciones(rs.getString("observaciones"));
                accion.setFicha(rs.getString("ficha"));
                accion.setEntidad(rs.getString("entidad"));
                accion.setId_encuestareacc(rs.getString("id_encuestareacc"));
                list.add(accion);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean edit(Accion accion, String id_accion) {
        String sql = "update accioncapacitacion set nombre='" + accion.getNombre() + "', fechainicio='" + accion.getFecha_inicial() + "', fechafinal='" + accion.getFecha_final() + "', id_entidad='" + accion.getId_entidad() + "', id_evalfinal='" + accion.getId_evaluacionfinal() + "', id_clafcaccion='" + accion.getId_clasificacion() + "', id_formorg='" + accion.getId_formaorganizativa() + "', id_areaaccion='" + accion.getId_area() + "', id_entejecutora='" + accion.getId_entidadejecutora() + "', id_modaccion='" + accion.getId_modalidad() + "', creditos='" + accion.getCreditos() + "', ficha='" + accion.getFicha() + "', observaciones='" + accion.getObservaciones() + "', planificada='" + ((accion.isExtraplan()) ? "1" : "0") + "' where id_accion=" + id_accion;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public List listar(String query) {
        ArrayList<Accion> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "	accioncapacitacion.id_accion AS id_accion,\n"
                + "	accioncapacitacion.creditos AS creditos,\n"
                + "	accioncapacitacion.observaciones AS observaciones,\n"
                + "	accioncapacitacion.planificada AS planificada,\n"
                + "	accioncapacitacion.nombre AS nombre,\n"
                + "	accioncapacitacion.fechainicio AS fechainicio,\n"
                + "	accioncapacitacion.fechafinal AS fechafinal,\n"
                + "	clasificacionaccion.descripcion AS id_clafcaccion,\n"
                + "	formaorganizativa.descripcion AS id_formorg,\n"
                + "	areaaccion.descripcion AS id_areaaccion,\n"
                + "	entidadejecutora.descripcion AS id_entejecutora,\n"
                + "	evalfinal.descripcion AS id_evalfinal,\n"
                + "	accioncapacitacion.ficha AS ficha,\n"
                + "	accioncapacitacion.id_encuestareacc AS id_encuestareacc,\n"
                + "	modalidadaccion.descripcion AS id_modaccion \n"
                + "FROM\n"
                + "	accioncapacitacion,\n"
                + "	formaorganizativa,\n"
                + "	clasificacionaccion,\n"
                + "	areaaccion,\n"
                + "	entidadejecutora,\n"
                + "	evalfinal,\n"
                + "	modalidadaccion \n"
                + "WHERE\n"
                + "	clasificacionaccion.id_clafcaccion = accioncapacitacion.id_clafcaccion \n"
                + "	AND formaorganizativa.id_formorg = accioncapacitacion.id_formorg \n"
                + "	AND areaaccion.id_areaaccion = accioncapacitacion.id_areaaccion \n"
                + "	AND entidadejecutora.id_entejecutora = accioncapacitacion.id_entejecutora \n"
                + "	AND evalfinal.id_evalfinal = accioncapacitacion.id_evalfinal \n"
                + "	AND accioncapacitacion.id_modaccion = modalidadaccion.id_modaccion \n"
                + "	AND (\n"
                + "		nombre LIKE '%" + query + "%' \n"
                + "		OR clasificacionaccion.descripcion LIKE '%" + query + "%' \n"
                + "		OR formaorganizativa.descripcion LIKE '%" + query + "%' \n"
                + "	OR areaaccion.descripcion LIKE '%" + query + "%' \n"
                + "	OR entidadejecutora.descripcion LIKE '%" + query + "%'\n"
                + "	OR modalidadaccion.descripcion LIKE '%" + query + "%')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accion accion = new Accion();
                accion.setId_accion(rs.getString("id_accion"));
                accion.setCreditos(rs.getString("creditos"));
                accion.setObservaciones(rs.getString("observaciones"));
                accion.setExtraplan(rs.getBoolean("planificada"));
                accion.setNombre(rs.getString("nombre"));
                accion.setFecha_inicial(rs.getString("fechainicio"));
                accion.setFecha_final(rs.getString("fechafinal"));
                accion.setId_evaluacionfinal(rs.getString("id_evalfinal"));
                accion.setId_clasificacion(rs.getString("id_clafcaccion"));
                accion.setId_formaorganizativa(rs.getString("id_formorg"));
                accion.setFicha(rs.getString("ficha"));
                accion.setId_area(rs.getString("id_areaaccion"));
                accion.setId_entidadejecutora(rs.getString("id_entejecutora"));
                accion.setId_modalidad(rs.getString("id_modaccion"));
                accion.setId_encuestareacc(rs.getString("id_encuestareacc"));
                list.add(accion);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void encreaccion(Accion accion, EncReaccion reaccion) {

        //creo la semilla de la reaccion.
        EncReaccionBean reaccionbean = new EncReaccionBean();

        //Reviso si tengo que adiccionar la reaccion o solo actualizar.
        if (accion.getId_encuestareacc() != null) {

            reaccionbean.update(reaccion);

        } else {

            //la inserto en la base de datos.
            if (reaccionbean.add(reaccion)) {

                EncReaccion rea = reaccionbean.list(reaccion.getId_accion());

                accion.setId_encuestareacc(Integer.toString(rea.getId_encuestareacc()));
                edit2(accion, accion.getId_accion());
            }
        }

    }

    public boolean edit2(Accion accion, String id_accion) {
        String sql = "UPDATE accioncapacitacion SET id_encuestareacc=" + accion.getId_encuestareacc() + " WHERE id_accion = " + id_accion;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
