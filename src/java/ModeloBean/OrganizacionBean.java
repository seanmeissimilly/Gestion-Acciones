/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Organizacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class OrganizacionBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public OrganizacionBean() {
    }

    public List listar() {
        ArrayList<Organizacion> list = new ArrayList<>();
        String sql = "select * from organizacion order by id_org";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Organizacion org = new Organizacion();
                org.setNumero(rs.getString("id_org"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List listar(String query) {
        ArrayList<Organizacion> list = new ArrayList<>();
        String sql = "select * from organizacion WHERE id_org like '%" + query + "%' or descripcion like '%" + query + "%' order by id_org";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Organizacion org = new Organizacion();
                org.setNumero(rs.getString("id_org"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List list(String id_org) {
        ArrayList<Organizacion> list = new ArrayList<>();
        String sql = "select * from organizacion where id_org=" + id_org;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Organizacion org = new Organizacion();
                org.setNumero(rs.getString("id_org"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean add(Organizacion org) {
        String sql = "insert into organizacion(descripcion)values('" + org.getNombre() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(String numero) {
        String sql = "delete from organizacion where id_org=" + numero;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    //Para contar la cantidad de registros. 
    public Integer contregistros() {
        Integer cont = 0;
        String sql = "select count(id_org) as cont from organizacion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cont = Integer.valueOf(rs.getString("cont"));
            }

        } catch (Exception e) {
        }

        return cont;
    }

    public boolean edit(Organizacion org, String id_org) {
        String sql = "update organizacion set id_org='" + org.getNumero() + "', descripcion='" + org.getNombre() + "' where id_org=" + id_org;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
