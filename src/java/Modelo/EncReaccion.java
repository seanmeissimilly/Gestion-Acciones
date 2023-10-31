/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author davidam
 */
public class EncReaccion {

    int id_accion;
    int id_encuestareacc;

    //Tipos de trabajadores real y plan.
    int tra_real1;
    int tra_real2;
    int tra_real3;
    int tra_real4;

    int tra_plan1;
    int tra_plan2;
    int tra_plan3;
    int tra_plan4;

    //Tipos de cuadros real y plan.
    int cua_dirreal1;
    int cua_dirreal2;
    int cua_dirreal3;

    int cua_dirplan1;
    int cua_dirplan2;
    int cua_dirplan3;

    //Tipos de reservas real y plan.
    int no_cuadrosreal;
    int cuadrosreal;

    int no_cuadrosplan;
    int cuadrosplan;

    //Adiestrados
    int adiestradosreal;
    int adiestradosplan;

    //Resultados Docentes
    int resultado1;
    int resultado2;
    int resultado3;
    int resultado4;
    int resultado5;

    //Preguntas
    int[] pregunta1;
    int[] pregunta2;
    int[] pregunta3;
    int[] pregunta4;
    int[] pregunta5;

    //Comentarios preguntas
    String comentario1;
    String comentario2;
    String comentario3;
    String comentario4;
    String comentario5;
    
    //Encuestados
    int encuestados;

    public EncReaccion() {
        this.tra_real1 = 0;
        this.tra_real2 = 0;
        this.tra_real3 = 0;
        this.tra_real4 = 0;
        this.tra_plan1 = 0;
        this.tra_plan2 = 0;
        this.tra_plan3 = 0;
        this.tra_plan4 = 0;
        this.cua_dirreal1 = 0;
        this.cua_dirreal2 = 0;
        this.cua_dirreal3 = 0;
        this.cua_dirplan1 = 0;
        this.cua_dirplan2 = 0;
        this.cua_dirplan3 = 0;
        this.no_cuadrosreal = 0;
        this.cuadrosreal = 0;
        this.no_cuadrosplan = 0;
        this.cuadrosplan = 0;
        this.resultado1 = 0;
        this.resultado2 = 0;
        this.resultado3 = 0;
        this.resultado4 = 0;
        this.resultado5 = 0;
        this.pregunta1 = new int[4];
        this.pregunta2 = new int[4];
        this.pregunta3 = new int[4];
        this.pregunta4 = new int[4];
        this.pregunta5 = new int[4];
        this.comentario1 = "";
        this.comentario2 = "";
        this.comentario3 = "";
        this.comentario4 = "";
        this.comentario5 = "";
        this.encuestados=0;
        this.adiestradosreal=0;
        this.adiestradosplan=0;
        
    }

    public int getTra_real1() {
        return tra_real1;
    }

    public void setTra_real1(int tra_real1) {
        this.tra_real1 = tra_real1;
    }

    public int getTra_real2() {
        return tra_real2;
    }

    public void setTra_real2(int tra_real2) {
        this.tra_real2 = tra_real2;
    }

    public int getTra_real3() {
        return tra_real3;
    }

    public void setTra_real3(int tra_real3) {
        this.tra_real3 = tra_real3;
    }

    public int getTra_real4() {
        return tra_real4;
    }

    public void setTra_real4(int tra_real4) {
        this.tra_real4 = tra_real4;
    }

    public int getTra_plan1() {
        return tra_plan1;
    }

    public void setTra_plan1(int tra_plan1) {
        this.tra_plan1 = tra_plan1;
    }

    public int getTra_plan2() {
        return tra_plan2;
    }

    public void setTra_plan2(int tra_plan2) {
        this.tra_plan2 = tra_plan2;
    }

    public int getTra_plan3() {
        return tra_plan3;
    }

    public void setTra_plan3(int tra_plan3) {
        this.tra_plan3 = tra_plan3;
    }

    public int getTra_plan4() {
        return tra_plan4;
    }

    public void setTra_plan4(int tra_plan4) {
        this.tra_plan4 = tra_plan4;
    }

    public int getCua_dirreal1() {
        return cua_dirreal1;
    }

    public void setCua_dirreal1(int cua_dirreal1) {
        this.cua_dirreal1 = cua_dirreal1;
    }

    public int getCua_dirreal2() {
        return cua_dirreal2;
    }

    public void setCua_dirreal2(int cua_dirreal2) {
        this.cua_dirreal2 = cua_dirreal2;
    }

    public int getCua_dirreal3() {
        return cua_dirreal3;
    }

    public void setCua_dirreal3(int cua_dirreal3) {
        this.cua_dirreal3 = cua_dirreal3;
    }

    public int getCua_dirplan1() {
        return cua_dirplan1;
    }

    public void setCua_dirplan1(int cua_dirplan1) {
        this.cua_dirplan1 = cua_dirplan1;
    }

    public int getCua_dirplan2() {
        return cua_dirplan2;
    }

    public void setCua_dirplan2(int cua_dirplan2) {
        this.cua_dirplan2 = cua_dirplan2;
    }

    public int getCua_dirplan3() {
        return cua_dirplan3;
    }

    public void setCua_dirplan3(int cua_dirplan3) {
        this.cua_dirplan3 = cua_dirplan3;
    }

    public int getResultado1() {
        return resultado1;
    }

    public void setResultado1(int resultado1) {
        this.resultado1 = resultado1;
    }

    public int getResultado2() {
        return resultado2;
    }

    public void setResultado2(int resultado2) {
        this.resultado2 = resultado2;
    }

    public int getResultado3() {
        return resultado3;
    }

    public void setResultado3(int resultado3) {
        this.resultado3 = resultado3;
    }

    public int getResultado4() {
        return resultado4;
    }

    public void setResultado4(int resultado4) {
        this.resultado4 = resultado4;
    }

    public int getResultado5() {
        return resultado5;
    }

    public void setResultado5(int resultado5) {
        this.resultado5 = resultado5;
    }

    public int getId_accion() {
        return id_accion;
    }

    public void setId_accion(int id_accion) {
        this.id_accion = id_accion;
    }

    public int getId_encuestareacc() {
        return id_encuestareacc;
    }

    public void setId_encuestareacc(int id_encuestareacc) {
        this.id_encuestareacc = id_encuestareacc;
    }

    public int getNo_cuadrosreal() {
        return no_cuadrosreal;
    }

    public void setNo_cuadrosreal(int no_cuadrosreal) {
        this.no_cuadrosreal = no_cuadrosreal;
    }

    public int getCuadrosreal() {
        return cuadrosreal;
    }

    public void setCuadrosreal(int cuadrosreal) {
        this.cuadrosreal = cuadrosreal;
    }

    public int getNo_cuadrosplan() {
        return no_cuadrosplan;
    }

    public void setNo_cuadrosplan(int no_cuadrosplan) {
        this.no_cuadrosplan = no_cuadrosplan;
    }

    public int getCuadrosplan() {
        return cuadrosplan;
    }

    public void setCuadrosplan(int cuadrosplan) {
        this.cuadrosplan = cuadrosplan;
    }

    public int getAdiestradosreal() {
        return adiestradosreal;
    }

    public void setAdiestradosreal(int adiestradosreal) {
        this.adiestradosreal = adiestradosreal;
    }

    public int getAdiestradosplan() {
        return adiestradosplan;
    }

    public void setAdiestradosplan(int adiestradosplan) {
        this.adiestradosplan = adiestradosplan;
    }

    public int[] getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(int data, int index) {
        this.pregunta1[index] = data;
    }

    public int[] getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(int data, int index) {
        this.pregunta2[index] = data;
    }

    public int[] getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(int data, int index) {
        this.pregunta3[index] = data;
    }

    public int[] getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(int data, int index) {
        this.pregunta4[index] = data;
    }

    public int[] getPregunta5() {
        return pregunta5;
    }

    public void setPregunta5(int data, int index) {
        this.pregunta5[index] = data;
    }

    public String getComentario1() {
        return comentario1;
    }

    public void setComentario1(String comentario1) {
        this.comentario1 = comentario1;
    }

    public String getComentario2() {
        return comentario2;
    }

    public void setComentario2(String comentario2) {
        this.comentario2 = comentario2;
    }

    public String getComentario3() {
        return comentario3;
    }

    public void setComentario3(String comentario3) {
        this.comentario3 = comentario3;
    }

    public String getComentario4() {
        return comentario4;
    }

    public void setComentario4(String comentario4) {
        this.comentario4 = comentario4;
    }

    public String getComentario5() {
        return comentario5;
    }

    public void setComentario5(String comentario5) {
        this.comentario5 = comentario5;
    }

    public int getEncuestados() {
        return encuestados;
    }

    public void setEncuestados(int encuestados) {
        this.encuestados = encuestados;
    }
    

}
