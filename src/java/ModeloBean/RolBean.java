/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidam
 */
public class RolBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public RolBean() {
    }

    public List listar() {
        ArrayList<Rol> list = new ArrayList<>();
        String sql = "select * from rol";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Rol per = new Rol();
                per.setId(rs.getString("id_rol"));
                per.setDescripcion(rs.getString("descripcion"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
