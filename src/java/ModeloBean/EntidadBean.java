/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class EntidadBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EntidadBean() {

    }

    public List listar() {
        ArrayList<Entidad> list = new ArrayList<>();
        String sql = "select entidad.id_entidad,entidad.descripcion ,organizacion.descripcion, entidad.id_org, entidad.prefix from entidad,organizacion WHERE entidad.id_org=organizacion.id_org ORDER by entidad.id_entidad";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Entidad ent = new Entidad();
                ent.setid_entidad(rs.getString("entidad.id_entidad"));
                ent.setNombre(rs.getString("entidad.descripcion"));
                ent.setname_org(rs.getString("organizacion.descripcion"));
                ent.setid_org(rs.getString("entidad.id_org"));
                ent.setPrefix(rs.getString("entidad.prefix"));
                list.add(ent);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List listar(String query) {
        ArrayList<Entidad> list = new ArrayList<>();
        String sql = "select entidad.id_entidad,entidad.descripcion ,organizacion.descripcion, entidad.id_org, entidad.prefix from entidad,organizacion WHERE entidad.id_org=organizacion.id_org and (entidad.id_entidad like '%" + query + "%' or entidad.prefix like '%" + query + "%' or entidad.descripcion like '%" + query + "%' or organizacion.descripcion like '%" + query + "%')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Entidad ent = new Entidad();
                ent.setid_entidad(rs.getString("entidad.id_entidad"));
                ent.setNombre(rs.getString("entidad.descripcion"));
                ent.setname_org(rs.getString("organizacion.descripcion"));
                ent.setid_org(rs.getString("entidad.id_org"));
                ent.setPrefix(rs.getString("entidad.prefix"));
                list.add(ent);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean eliminar(String numero) {
        String sql = "delete from entidad where id_entidad=" + numero;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean add(Entidad ent) {
        String sql = "insert into entidad(descripcion,id_org, prefix)values('" + ent.getNombre() + "','" + ent.getid_org() + "','" + ent.getPrefix() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }   

    
    public List list(String id_entidad) {
        ArrayList<Entidad> list = new ArrayList<>();
        String sql = "select entidad.id_entidad,entidad.descripcion ,organizacion.descripcion, entidad.id_org, entidad.prefix from entidad,organizacion WHERE entidad.id_org=organizacion.id_org and entidad.id_entidad=" + id_entidad;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Entidad ent = new Entidad();
                ent.setid_entidad(rs.getString("entidad.id_entidad"));
                ent.setNombre(rs.getString("entidad.descripcion"));
                ent.setname_org(rs.getString("organizacion.descripcion"));
                ent.setid_org(rs.getString("entidad.id_org"));
                ent.setPrefix(rs.getString("entidad.prefix"));
                list.add(ent);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean edit(Entidad ent, String id_entidad) {
        String sql = "update entidad set descripcion='" + ent.getNombre() + "', prefix='" + ent.getPrefix() + "' where id_entidad=" + id_entidad;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    //Buscar el numero de entidad segun el prefijo.
    public String searchprefix(String prefix) {

        String sql = "SELECT id_entidad FROM entidad WHERE prefix='" + prefix + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("id_entidad");
            }
        } catch (Exception e) {
        }
        return "41";
    }

}
