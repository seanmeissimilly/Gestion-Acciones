/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Clasificacion;
import Modelo.Organizativa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class ForganizativaBean {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public ForganizativaBean() {
        
    }
    
    public List listar() 
    {
        ArrayList<Organizativa> list = new ArrayList<>();
        String sql = "select * from formaorganizativa";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Organizativa org = new Organizativa();
                org.setNumero(rs.getString("id_formorg"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
