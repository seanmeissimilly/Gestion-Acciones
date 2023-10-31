/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author davidam
 */
public class Ldap {

    String ip_ldap;
    String user_ldap;
    String pass_ldap;
    String date;
    String userapp;

    public Ldap(String ip_ldap, String user_ldap, String pass_ldap, String date, String userapp) {
        this.ip_ldap = ip_ldap;
        this.user_ldap = user_ldap;
        this.pass_ldap = pass_ldap;
        this.date = date;
        this.userapp = userapp;
    }

    public Ldap() {
    }

    public String getIp_ldap() {
        return ip_ldap;
    }

    public void setIp_ldap(String ip_ldap) {
        this.ip_ldap = ip_ldap;
    }

    public String getUser_ldap() {
        return user_ldap;
    }

    public void setUser_ldap(String user_ldap) {
        this.user_ldap = user_ldap;
    }

    public String getPass_ldap() {
        return pass_ldap;
    }

    public void setPass_ldap(String pass_ldap) {
        this.pass_ldap = pass_ldap;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserapp() {
        return userapp;
    }

    public void setUserapp(String userapp) {
        this.userapp = userapp;
    }
    
    
}
