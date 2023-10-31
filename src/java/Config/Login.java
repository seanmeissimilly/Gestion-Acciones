/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Modelo.Ldap;
import Modelo.Usuario;
import ModeloBean.EntidadBean;
import ModeloBean.LdapBean;
import ModeloBean.UsuarioBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author davidam
 */
public class Login {

    Usuario usuario;
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    DirContext connection;
    String url;
    Properties env;

    public Login() {
        
        //Busco en la base de datos la direccion del servidor ldap.
        Ldap active_directory= new LdapBean().listar();             

        this.env = new Properties();
        this.url = active_directory.getIp_ldap();
        String user = active_directory.getUser_ldap();
        String password = active_directory.getPass_ldap();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://" + url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, password);

    }

    public boolean authuser(String username, String password) {
        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://" + url);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            String user = searchuserPrincipalName(username);

            //Reviso si el usuario existe.
            if (user.equals("")) {
                return false;

            }
            env.put(Context.SECURITY_PRINCIPAL, user);
            env.put(Context.SECURITY_CREDENTIALS, password);
            DirContext con = new InitialDirContext(env);
            con.close();
            UsuarioBean aux = new UsuarioBean();
            aux.add(usuario);
            aux.update(usuario, username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String searchuserPrincipalName(String username) throws NamingException {
        String userPrincipalName = "";
        connection = new InitialDirContext(env);
        String searchFilter = "(sAMAccountName=" + username + ")";
        String[] reqAtt = {"userPrincipalName", "distinguishedName"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);

        NamingEnumeration users = connection.search("OU=Domain Users,DC=cimex,DC=com,DC=cu", searchFilter, controls);

        SearchResult result = null;
        if (users.hasMore()) {
            result = (SearchResult) users.next();
            Attributes attr = result.getAttributes();
            String aux = attr.get("userPrincipalName").toString();
            userPrincipalName = aux.substring(19, aux.length());

            String prefix = "";
            String distinguishedName = attr.get("distinguishedName").toString();

            int cont = 0;
            for (int i = distinguishedName.length() - 1; i >= 0; i--) {
                char c = distinguishedName.charAt(i);
                if (c == 'U') {
                    cont++;
                }
                if (c == 'U' && cont == 3) {
                    prefix = distinguishedName.substring(i + 2, i + 4);
                    break;
                }
            }

            long millis = System.currentTimeMillis();
            Date date = new java.sql.Date(millis);

            usuario = new Usuario("1", date.toString(), date.toString(), username, new EntidadBean().searchprefix(prefix), searchName(distinguishedName));

        }

        connection.close();
        return userPrincipalName;
    }

    private String searchName(String distinguishedName) {
        String name = "";
        boolean copy = false;

        for (int i = 0; i < distinguishedName.length(); i++) {
            char c = distinguishedName.charAt(i);
            if (c == '=') {
                //para empezar a copiar el nombre en el proximo caracter.
                copy = true;
            } //para saber si ya copie el nombre completo.
            else if (c == ',') {
                break;
            } else if (copy) {
                name += c;
            }
        }
        return name;
    }
}
