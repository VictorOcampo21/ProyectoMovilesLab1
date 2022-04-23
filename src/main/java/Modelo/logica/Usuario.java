package modelo.logica;

/**
 *
 * @author Vic
 */
public class Usuario {

    private String id;
    private String clave;

    public Usuario() {
    }

    public Usuario(String id, String clave) {
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

}
