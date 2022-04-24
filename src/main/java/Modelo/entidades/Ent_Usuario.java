package Modelo.entidades;

public class Ent_Usuario {

    public Ent_Usuario() {
    }

    public Ent_Usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
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
}
