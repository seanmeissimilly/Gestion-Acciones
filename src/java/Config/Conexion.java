package Config;

import java.sql.*;

public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gescap", "adminsitios", "Narutob8o9h");
            // con = DriverManager.getConnection("jdbc:mysql://capacitacion.cimex.com.cu:3306/gescap", "adminsitios", "Narutob8o9h");
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }
}
