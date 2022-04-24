package modelo.logica;

/**
 *
 * @author Vic
 */
public class Usuario {

    private String id;
    private String clave;
    private String rol;

    public Usuario() {
    }

    public Usuario(String id, String clave, String rol) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
    }
    
    public boolean correctPswd(String pass){
        return pass.equals(this.getClave());
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
