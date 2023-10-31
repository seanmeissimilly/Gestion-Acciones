/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Fecha_GB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author davidam
 */
public class Fecha_GB_Bean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //Para buscar el par relacionado con un usuario.
    public Fecha_GB listar(String username) {
        Fecha_GB fecha = new Fecha_GB();
        fecha.setUsername(username);
        fecha.setFinicial("2020-01-01");
        fecha.setFfinal("2024-01-01");

        String sql = "SELECT * from grafico_barra WHERE username=\"" + username + "\"";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fecha = new Fecha_GB();
                fecha.setFinicial(rs.getString("finicial"));
                fecha.setFfinal(rs.getString("ffinal"));
                fecha.setUsername(rs.getString("username"));

            }
        } catch (Exception e) {
        }
        return fecha;
    }
    
    public Fecha_GB listarfa(String username) {
        Fecha_GB fecha = new Fecha_GB();
        fecha.setUsername(username);
        fecha.setFinicial("2020-01-01");
        fecha.setFfinal("2024-01-01");

        String sql = "SELECT * from grafico_barra WHERE username=\"" + username + "\"";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fecha = new Fecha_GB();
                fecha.setFinicial(rs.getString("finiciala"));
                fecha.setFfinal(rs.getString("ffinala"));
                fecha.setUsername(rs.getString("username"));

            }
        } catch (Exception e) {
        }
        return fecha;
    }

    public void updatedate(Fecha_GB fecha) {
        //Llamo al procedimiento almacenado pasando los argumentos.
        String sql = "call updatedate_grafico('" + fecha.getFinicial() + "','" + fecha.getFfinal() + "','" + fecha.getUsername() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }

    }

    public void updatedateareas(Fecha_GB fecha) {
        //Llamo al procedimiento almacenado pasando los argumentos.
        String sql = "call updatedate_grafico_areas('" + fecha.getFinicial() + "','" + fecha.getFfinal() + "','" + fecha.getUsername() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }
}
