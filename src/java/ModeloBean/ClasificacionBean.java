/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Clasificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class ClasificacionBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ClasificacionBean() {

    }

    public List listar() {
        ArrayList<Clasificacion> list = new ArrayList<>();
        String sql = "SELECT * FROM clasificacionaccion order by id_clafcaccion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clasificacion org = new Clasificacion();
                org.setNumero(rs.getString("id_clafcaccion"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
