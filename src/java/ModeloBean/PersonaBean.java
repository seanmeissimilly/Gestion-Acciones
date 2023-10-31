package ModeloBean;

import Config.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Sean
 */
public class PersonaBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();

    public PersonaBean() {
    }

    public List listar() {
        ArrayList<Persona> list = new ArrayList<>();
        String sql = "select * from persona order by ci";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setCi(rs.getString("ci"));
                per.setNombre(rs.getString("nombre"));
                per.setPrimerApellido(rs.getString("primerapellido"));
                per.setSegundoApellido(rs.getString("segundoapellido"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List listar(String query) {
        ArrayList<Persona> list = new ArrayList<>();
        String sql = "select * from persona where ci like '%" + query + "%' or nombre like '%"+ query + "%' or primerapellido like '%"+ query + "%' or segundoapellido like '%" + query + "%'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setCi(rs.getString("ci"));
                per.setNombre(rs.getString("nombre"));
                per.setPrimerApellido(rs.getString("primerapellido"));
                per.setSegundoApellido(rs.getString("segundoapellido"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Persona list(String ci) {
        String sql = "select * from persona where ci=" + ci;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setCi(rs.getString("ci"));
                p.setNombre(rs.getString("nombre"));
                p.setPrimerApellido(rs.getString("primerapellido"));
                p.setSegundoApellido(rs.getString("segundoapellido"));

            }
        } catch (Exception e) {
        }
        return p;
    }

    public boolean add(Persona per) {

        String sql = "insert into persona(ci, nombre, primerapellido, segundoapellido)values('" + per.getCi() + "','" + per.getNombre() + "','" + per.getPrimerApellido() + "','" + per.getSegundoApellido() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean edit(Persona per, String cinuevo) {
        String sql = "update persona set ci='" + cinuevo + "', nombre='" + per.getNombre() + "', primerapellido='" + per.getPrimerApellido() + "', segundoapellido='" + per.getSegundoApellido() + "' where ci=" + per.getCi();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(String ci) {
        String sql = "delete from persona where ci=" + ci;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
