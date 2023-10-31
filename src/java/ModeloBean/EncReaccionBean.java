/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloBean;

import Config.Conexion;
import Modelo.EncReaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author davidam
 */
public class EncReaccionBean {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public EncReaccionBean() {
    }

    public boolean add(EncReaccion reaccion) {
        String sql = "INSERT INTO encuestareaccion ("
                + "id_accion,"
                + "resultado1,"
                + "resultado2,"
                + "resultado3,"
                + "resultado4,"
                + "resultado5,"
                + "tra_real1,"
                + "tra_real2,"
                + "tra_real3,"
                + "tra_real4,"
                + "tra_plan1,"
                + "tra_plan2,"
                + "tra_plan3,"
                + "tra_plan4,"
                + "cua_dirreal1,"
                + "cua_dirreal2,"
                + "cua_dirreal3,"
                + "cua_dirplan1,"
                + "cua_dirplan2,"
                + "cua_dirplan3,"
                + "cuadrosreal,"
                + "cuadrosplan,"
                + "no_cuadrosreal,"
                + "no_cuadrosplan,"
                + "adiestradosreal,"
                + "adiestradosplan,"
                + "encuestados"
                + ")"
                + "VALUES"
                + "('" + reaccion.getId_accion() + "','" + reaccion.getResultado1() + "','" + reaccion.getResultado2() + "','" + reaccion.getResultado3() + "','" + reaccion.getResultado4() + "','" + reaccion.getResultado5() + "','" + reaccion.getTra_real1() + "','" + reaccion.getTra_real2() + "','" + reaccion.getTra_real3() + "','" + reaccion.getTra_real4() + "','" + reaccion.getTra_plan1() + "','" + reaccion.getTra_plan2() + "','" + reaccion.getTra_plan3() + "','" + reaccion.getTra_plan4() + "','" + reaccion.getCua_dirreal1() + "','" + reaccion.getCua_dirreal2() + "','" + reaccion.getCua_dirreal3() + "','" + reaccion.getCua_dirplan1() + "','" + reaccion.getCua_dirplan2() + "','" + reaccion.getCua_dirplan3() + "','" + reaccion.getCuadrosreal() + "','" + reaccion.getCuadrosplan() + "','" + reaccion.getNo_cuadrosreal() + "','" + reaccion.getNo_cuadrosplan() + "','" + reaccion.getAdiestradosreal() + "','" + reaccion.getAdiestradosplan() + "','" + reaccion.getEncuestados() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public EncReaccion list(int id_accion) {
        EncReaccion reaccion = new EncReaccion();
        String sql = "SELECT\n"
                + "	encuestareaccion.id_accion,\n"
                + "	encuestareaccion.id_encuestareacc,\n"
                + "	encuestareaccion.resultado1,\n"
                + "	encuestareaccion.resultado2,\n"
                + "	encuestareaccion.resultado3,\n"
                + "	encuestareaccion.resultado4,\n"
                + "	encuestareaccion.resultado5,\n"
                + "	encuestareaccion.tra_real1,\n"
                + "	encuestareaccion.tra_real2,\n"
                + "	encuestareaccion.tra_real3,\n"
                + "	encuestareaccion.tra_real4,\n"
                + "	encuestareaccion.tra_plan1,\n"
                + "	encuestareaccion.tra_plan2,\n"
                + "	encuestareaccion.tra_plan3,\n"
                + "	encuestareaccion.tra_plan4,\n"
                + "	encuestareaccion.cua_dirreal1,\n"
                + "	encuestareaccion.no_cuadrosplan,\n"
                + "	encuestareaccion.cuadrosplan,\n"
                + "	encuestareaccion.no_cuadrosreal,\n"
                + "	encuestareaccion.cuadrosreal,\n"
                + "	encuestareaccion.cua_dirplan3,\n"
                + "	encuestareaccion.cua_dirplan2,\n"
                + "	encuestareaccion.cua_dirplan1,\n"
                + "	encuestareaccion.cua_dirreal3,\n"
                + "	encuestareaccion.comentario1,\n"
                + "	encuestareaccion.comentario2,\n"
                + "	encuestareaccion.comentario3,\n"
                + "	encuestareaccion.comentario4,\n"
                + "	encuestareaccion.comentario5,\n"
                + "	encuestareaccion.preg1valor1,\n"
                + "	encuestareaccion.preg1valor2,\n"
                + "	encuestareaccion.preg1valor3,\n"
                + "	encuestareaccion.preg1valor4,\n"
                + "	encuestareaccion.preg2valor1,\n"
                + "	encuestareaccion.preg2valor2,\n"
                + "	encuestareaccion.preg2valor3,\n"
                + "	encuestareaccion.preg2valor4,\n"
                + "	encuestareaccion.preg3valor1,\n"
                + "	encuestareaccion.preg3valor2,\n"
                + "	encuestareaccion.preg3valor3,\n"
                + "	encuestareaccion.preg3valor4,\n"
                + "	encuestareaccion.preg4valor1,\n"
                + "	encuestareaccion.preg4valor2,\n"
                + "	encuestareaccion.preg4valor3,\n"
                + "	encuestareaccion.preg4valor4,\n"
                + "	encuestareaccion.preg5valor1,\n"
                + "	encuestareaccion.preg5valor2,\n"
                + "	encuestareaccion.preg5valor3,\n"
                + "	encuestareaccion.preg5valor4,\n"
                + "	encuestareaccion.adiestradosreal,\n"
                + "	encuestareaccion.adiestradosplan,\n"
                + "	encuestareaccion.encuestados,\n"
                + "encuestareaccion.cua_dirreal2 \n"
                + "FROM\n"
                + "	encuestareaccion\n"
                + "	INNER JOIN accioncapacitacion ON encuestareaccion.id_accion = accioncapacitacion.id_accion\n"
                + "WHERE\n"
                + "	encuestareaccion.id_accion = '" + id_accion + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                reaccion = new EncReaccion();
                reaccion.setId_encuestareacc(Integer.parseInt(rs.getString("encuestareaccion.id_encuestareacc")));
                reaccion.setId_accion(Integer.parseInt(rs.getString("encuestareaccion.id_accion")));

                reaccion.setResultado1(Integer.parseInt(rs.getString("encuestareaccion.resultado1")));
                reaccion.setResultado2(Integer.parseInt(rs.getString("encuestareaccion.resultado2")));
                reaccion.setResultado3(Integer.parseInt(rs.getString("encuestareaccion.resultado3")));
                reaccion.setResultado4(Integer.parseInt(rs.getString("encuestareaccion.resultado4")));
                reaccion.setResultado5(Integer.parseInt(rs.getString("encuestareaccion.resultado5")));

                reaccion.setTra_real1(Integer.parseInt(rs.getString("encuestareaccion.tra_real1")));
                reaccion.setTra_real2(Integer.parseInt(rs.getString("encuestareaccion.tra_real2")));
                reaccion.setTra_real3(Integer.parseInt(rs.getString("encuestareaccion.tra_real3")));
                reaccion.setTra_real4(Integer.parseInt(rs.getString("encuestareaccion.tra_real4")));

                reaccion.setTra_plan1(Integer.parseInt(rs.getString("encuestareaccion.tra_plan1")));
                reaccion.setTra_plan2(Integer.parseInt(rs.getString("encuestareaccion.tra_plan2")));
                reaccion.setTra_plan3(Integer.parseInt(rs.getString("encuestareaccion.tra_plan3")));
                reaccion.setTra_plan4(Integer.parseInt(rs.getString("encuestareaccion.tra_plan4")));

                reaccion.setCua_dirplan1(Integer.parseInt(rs.getString("encuestareaccion.cua_dirplan1")));
                reaccion.setCua_dirplan2(Integer.parseInt(rs.getString("encuestareaccion.cua_dirplan2")));
                reaccion.setCua_dirplan3(Integer.parseInt(rs.getString("encuestareaccion.cua_dirplan3")));

                reaccion.setCuadrosreal(Integer.parseInt(rs.getString("encuestareaccion.cuadrosreal")));
                reaccion.setCuadrosplan(Integer.parseInt(rs.getString("encuestareaccion.cuadrosplan")));

                reaccion.setCua_dirreal1(Integer.parseInt(rs.getString("encuestareaccion.cua_dirreal1")));
                reaccion.setCua_dirreal2(Integer.parseInt(rs.getString("encuestareaccion.cua_dirreal2")));
                reaccion.setCua_dirreal3(Integer.parseInt(rs.getString("encuestareaccion.cua_dirreal3")));

                reaccion.setNo_cuadrosreal(Integer.parseInt(rs.getString("encuestareaccion.no_cuadrosreal")));
                reaccion.setNo_cuadrosplan(Integer.parseInt(rs.getString("encuestareaccion.no_cuadrosplan")));

                reaccion.setComentario1(rs.getString("encuestareaccion.comentario1"));
                reaccion.setComentario2(rs.getString("encuestareaccion.comentario2"));
                reaccion.setComentario3(rs.getString("encuestareaccion.comentario3"));
                reaccion.setComentario4(rs.getString("encuestareaccion.comentario4"));
                reaccion.setComentario5(rs.getString("encuestareaccion.comentario5"));

                reaccion.setPregunta1(Integer.parseInt(rs.getString("encuestareaccion.preg1valor1")), 0);
                reaccion.setPregunta1(Integer.parseInt(rs.getString("encuestareaccion.preg1valor2")), 1);
                reaccion.setPregunta1(Integer.parseInt(rs.getString("encuestareaccion.preg1valor3")), 2);
                reaccion.setPregunta1(Integer.parseInt(rs.getString("encuestareaccion.preg1valor4")), 3);

                reaccion.setPregunta2(Integer.parseInt(rs.getString("encuestareaccion.preg2valor1")), 0);
                reaccion.setPregunta2(Integer.parseInt(rs.getString("encuestareaccion.preg2valor2")), 1);
                reaccion.setPregunta2(Integer.parseInt(rs.getString("encuestareaccion.preg2valor3")), 2);
                reaccion.setPregunta2(Integer.parseInt(rs.getString("encuestareaccion.preg2valor4")), 3);

                reaccion.setPregunta3(Integer.parseInt(rs.getString("encuestareaccion.preg3valor1")), 0);
                reaccion.setPregunta3(Integer.parseInt(rs.getString("encuestareaccion.preg3valor2")), 1);
                reaccion.setPregunta3(Integer.parseInt(rs.getString("encuestareaccion.preg3valor3")), 2);
                reaccion.setPregunta3(Integer.parseInt(rs.getString("encuestareaccion.preg3valor4")), 3);

                reaccion.setPregunta4(Integer.parseInt(rs.getString("encuestareaccion.preg4valor1")), 0);
                reaccion.setPregunta4(Integer.parseInt(rs.getString("encuestareaccion.preg4valor2")), 1);
                reaccion.setPregunta4(Integer.parseInt(rs.getString("encuestareaccion.preg4valor3")), 2);
                reaccion.setPregunta4(Integer.parseInt(rs.getString("encuestareaccion.preg4valor4")), 3);

                reaccion.setPregunta5(Integer.parseInt(rs.getString("encuestareaccion.preg5valor1")), 0);
                reaccion.setPregunta5(Integer.parseInt(rs.getString("encuestareaccion.preg5valor2")), 1);
                reaccion.setPregunta5(Integer.parseInt(rs.getString("encuestareaccion.preg5valor3")), 2);
                reaccion.setPregunta5(Integer.parseInt(rs.getString("encuestareaccion.preg5valor4")), 3);
                
                reaccion.setAdiestradosreal(Integer.parseInt(rs.getString("encuestareaccion.adiestradosreal")));
                reaccion.setAdiestradosplan(Integer.parseInt(rs.getString("encuestareaccion.adiestradosplan")));
                
                reaccion.setEncuestados(Integer.parseInt(rs.getString("encuestareaccion.encuestados")));

            }
        } catch (Exception e) {
        }
        return reaccion;
    }

    public boolean update(EncReaccion reaccion) {
        String sql = "UPDATE encuestareaccion SET id_accion='" + reaccion.getId_accion() + "',resultado1='" + reaccion.getResultado1() + "',resultado2='" + reaccion.getResultado2() + "',resultado3='" + reaccion.getResultado3() + "',resultado4='" + reaccion.getResultado4() + "',resultado5='" + reaccion.getResultado5() + "',tra_real1='" + reaccion.getTra_real1() + "',tra_real2='" + reaccion.getTra_real2() + "',tra_real3='" + reaccion.getTra_real3() + "',tra_real4='" + reaccion.getTra_real4() + "',tra_plan1='" + reaccion.getTra_plan1() + "',tra_plan2='" + reaccion.getTra_plan2() + "',tra_plan3='" + reaccion.getTra_plan3() + "',tra_plan4='" + reaccion.getTra_plan4() + "',cua_dirreal1='" + reaccion.getCua_dirreal1() + "',cua_dirreal2='" + reaccion.getCua_dirreal2() + "',cua_dirreal3='" + reaccion.getCua_dirreal3() + "',cua_dirplan1='" + reaccion.getCua_dirplan1() + "',cua_dirplan2='" + reaccion.getCua_dirplan2() + "',cua_dirplan3='" + reaccion.getCua_dirplan3() + "',cuadrosreal='" + reaccion.getCuadrosreal() + "',cuadrosplan='" + reaccion.getCuadrosplan() + "',no_cuadrosreal='" + reaccion.getNo_cuadrosreal() + "',no_cuadrosplan='" + reaccion.getNo_cuadrosplan()+ "',adiestradosreal='" + reaccion.getAdiestradosreal() + "',adiestradosplan='" + reaccion.getAdiestradosplan() + "' WHERE encuestareaccion.id_accion='" + reaccion.getId_accion() + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean addupdate(EncReaccion reaccion) {
        String sql = "UPDATE encuestareaccion SET id_accion='" + reaccion.getId_accion() + "',comentario1='" + reaccion.getComentario1() + "',comentario2='" + reaccion.getComentario2() + "',comentario3='" + reaccion.getComentario3() + "',comentario4='" + reaccion.getComentario4() + "',comentario5='" + reaccion.getComentario5() + "',preg1valor1='" + reaccion.getPregunta1()[0] + "',preg1valor2='" + reaccion.getPregunta1()[1] + "',preg1valor3='" + reaccion.getPregunta1()[2] + "',preg1valor4='" + reaccion.getPregunta1()[3] + "',preg2valor1='" + reaccion.getPregunta2()[0] + "',preg2valor2='" + reaccion.getPregunta2()[1] + "',preg2valor3='" + reaccion.getPregunta2()[2] + "',preg2valor4='" + reaccion.getPregunta2()[3] + "',preg3valor1='" + reaccion.getPregunta3()[0] + "',preg3valor2='" + reaccion.getPregunta3()[1] + "',preg3valor3='" + reaccion.getPregunta3()[2] + "',preg3valor4='" + reaccion.getPregunta3()[3] + "',preg4valor1='" + reaccion.getPregunta4()[0] + "',preg4valor2='" + reaccion.getPregunta4()[1] + "',preg4valor3='" + reaccion.getPregunta4()[2] + "',preg4valor4='" + reaccion.getPregunta4()[3] + "',preg5valor1='" + reaccion.getPregunta5()[0] + "',preg5valor2='" + reaccion.getPregunta5()[1] + "',preg5valor3='" + reaccion.getPregunta5()[2] + "',preg5valor4='" + reaccion.getPregunta5()[3]+ "',encuestados='" + reaccion.getEncuestados() + "' WHERE encuestareaccion.id_accion='" + reaccion.getId_accion() + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
