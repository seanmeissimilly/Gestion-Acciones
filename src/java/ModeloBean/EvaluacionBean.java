/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Clasificacion;
import Modelo.Evaluacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class EvaluacionBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EvaluacionBean() {

    }

    public List listar() {
        ArrayList<Evaluacion> list = new ArrayList<>();
        String sql = "select * from evalfinal order by id_evalfinal";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Evaluacion org = new Evaluacion();
                org.setNumero(rs.getString("id_evalfinal"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
