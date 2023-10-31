/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.Ldap;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidam
 */
public class LdapBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public LdapBean() {

    }

    public boolean update_ldap(Ldap ldap) {
        String sql = "update ldap set ldap='" + ldap.getIp_ldap() + "',user_ldap = '" + ldap.getUser_ldap() + "', pass_ldap = '" + ldap.getPass_ldap() + "',date = '" + ldap.getDate() + "' WHERE id = '1'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public Ldap listar() {
        Ldap ldap = new Ldap();
        String sql = "SELECT * FROM ldap";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ldap = new Ldap();
                ldap.setIp_ldap(rs.getString("ldap"));
                ldap.setUser_ldap(rs.getString("user_ldap"));
                ldap.setPass_ldap(rs.getString("pass_ldap"));
                ldap.setDate(rs.getString("date"));
                ldap.setUserapp(rs.getString("userapp"));
            }
        } catch (Exception e) {
        }
        return ldap;
    }
}
