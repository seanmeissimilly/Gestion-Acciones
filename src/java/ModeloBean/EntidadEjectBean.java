/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Entidad;
import Modelo.EntidadEject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class EntidadEjectBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EntidadEjectBean() {

    }
    
    public List listar() {
        ArrayList<EntidadEject> list = new ArrayList<>();
        String sql = "SELECT entidadejecutora.id_entejecutora, entidadejecutora.descripcion FROM entidadejecutora ORDER BY id_entejecutora";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EntidadEject ent = new EntidadEject();
                ent.setid_entidad(rs.getString("id_entejecutora"));
                ent.setNombre(rs.getString("descripcion"));                
                list.add(ent);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
