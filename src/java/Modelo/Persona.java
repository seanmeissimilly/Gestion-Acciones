
package Modelo;

public class Persona {    
    String ci;
    String nombre;
    String primerapellido;
    String segundoapellido;

    public Persona() {
    }

    public Persona(String ci, String nombre,String primerapellido,String segundoapellido) {
        this.ci = ci;
        this.nombre = nombre;
        this.primerapellido=primerapellido;
        this.segundoapellido=segundoapellido;
    }    

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPrimerApellido() {
        return primerapellido;
    }

    public void setPrimerApellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }
    
     public String getSegundoApellido() {
        return segundoapellido;
    }

    public void setSegundoApellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }
    
}
