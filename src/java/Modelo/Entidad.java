/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Sean
 */
public class Entidad {

    String id_entidad;
    String nombre;
    String name_org;
    String id_org;
    String prefix;

    public Entidad() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setid_entidad(String id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getid_entidad() {
        return id_entidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getname_org() {
        return name_org;
    }

    public void setname_org(String name_org) {
        this.name_org = name_org;
    }
    
    public String getid_org() {
        return id_org;
    }
    
    public void setid_org(String id_org) {
        this.id_org = id_org;
    }

}
