/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author David Sean
 */
public class Accion {

    String id_accion;
    String nombre;
    String fecha_inicial;
    String fecha_final;
    String id_clasificacion;
    String id_formaorganizativa;
    String id_situacion;
    String id_area;
    String ficha;
    String id_entidadejecutora;
    String id_entidad;
    String entidad;
    String id_modalidad;
    boolean masiva;
    boolean exterior;
    boolean extraplan;
    String creditos;
    String id_evaluacionfinal;
    String id_encuestareacc;
    String observaciones;

    public Accion() {
    }

    public String getId_encuestareacc() {
        return id_encuestareacc;
    }

    public void setId_encuestareacc(String id_encuestareacc) {
        this.id_encuestareacc = id_encuestareacc;
    }

    public String getId_entidad() {
        return id_entidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public void setId_entidad(String id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getId_entidadejecutora() {
        return id_entidadejecutora;
    }

    public void setId_entidadejecutora(String id_entidadejecutora) {
        this.id_entidadejecutora = id_entidadejecutora;
    }

    public void setId_accion(String id_accion) {
        this.id_accion = id_accion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public void setId_clasificacion(String id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public void setId_formaorganizativa(String id_formaorganizativa) {
        this.id_formaorganizativa = id_formaorganizativa;
    }

    public void setId_situacion(String id_situacion) {
        this.id_situacion = id_situacion;
    }

    public void setId_area(String id_area) {
        this.id_area = id_area;
    }

    public void setId_modalidad(String id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public void setMasiva(boolean masiva) {
        this.masiva = masiva;
    }

    public void setExterior(boolean exterior) {
        this.exterior = exterior;
    }

    public void setExtraplan(boolean extraplan) {
        this.extraplan = extraplan;
    }

    public boolean getExtraplan() {
        return extraplan;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public void setId_evaluacionfinal(String id_evaluacionfinal) {
        this.id_evaluacionfinal = id_evaluacionfinal;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId_accion() {
        return id_accion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFicha() {
        return ficha;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public String getId_clasificacion() {
        return id_clasificacion;
    }

    public String getId_formaorganizativa() {
        return id_formaorganizativa;
    }

    public String getId_situacion() {
        return id_situacion;
    }

    public String getId_area() {
        return id_area;
    }

    public String getId_modalidad() {
        return id_modalidad;
    }

    public boolean isMasiva() {
        return masiva;
    }

    public boolean isExterior() {
        return exterior;
    }

    public boolean isExtraplan() {
        return extraplan;
    }

    public String getCreditos() {
        return creditos;
    }

    public String getId_evaluacionfinal() {
        return id_evaluacionfinal;
    }

    public String getObservaciones() {
        return observaciones;
    }

}
