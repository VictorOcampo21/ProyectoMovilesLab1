package Modelo.entidades;

public class Ent_Usuario {

    public Ent_Usuario() {
    }

    public Ent_Usuario(String id, String clave, String rol) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    private String id;
    private String clave;
    private String rol;
}
