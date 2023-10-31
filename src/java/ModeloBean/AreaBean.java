/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Area;
import Modelo.Clasificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

/**
 *
 * @author David Sean
 */
public class AreaBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public AreaBean() {

    }

    public List listar() {
        ArrayList<Area> list = new ArrayList<>();
        String sql = "select * from areaaccion order by id_areaaccion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Area org = new Area();
                org.setNumero(rs.getString("id_areaaccion"));
                org.setNombre(rs.getString("descripcion"));
                list.add(org);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Pair<String, String>> contarXareas(String fechaInicial, String fechaFinal) {
        //Creo la lista donde voy a devolver los resultados.
        ArrayList<Pair<String, String>> list = new ArrayList<>();

        //Llamo al procedimiento almacenado pasando los argumentos.
        String sql = "call contarxareas('" + fechaInicial + "','" + fechaFinal + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pair<String, String> tupla = new Pair<String, String>(rs.getString("areas"), rs.getString("cantidad"));
                list.add(tupla);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<Pair<String, String>> contarXentidades(String fechaInicial, String fechaFinal) {
        //Creo la lista donde voy a devolver los resultados.
        ArrayList<Pair<String, String>> list = new ArrayList<>();

        //Llamo al procedimiento almacenado pasando los argumentos.
        String sql = "call contarxentidades('" + fechaInicial + "','" + fechaFinal + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pair<String, String> tupla = new Pair<String, String>(rs.getString("nombre"), rs.getString("cantidad"));
                list.add(tupla);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
