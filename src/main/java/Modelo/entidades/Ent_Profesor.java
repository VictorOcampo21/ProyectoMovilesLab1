
package Modelo.entidades;

import modelo.logica.Usuario;

/**
 *
 * @author jorsu
 */
public class Ent_Profesor {

    public Ent_Profesor() {
    }

    public Ent_Profesor(String id, String nombre, String telefono, String email, String usu) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.usu = usu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    private String id;
    private String nombre;
    private String telefono;
    private String email;
    private String usu;
}
