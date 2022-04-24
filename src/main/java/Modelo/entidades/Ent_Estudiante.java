package Modelo.entidades;

public class Ent_Estudiante {

    public Ent_Estudiante() {
    }

    public Ent_Estudiante(String id, String nombre, String telefono, String email, String usu, String cumple, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.usu = usu;
        this.cumple = cumple;
        this.carrera = carrera;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
    private String cumple;
    private String carrera;
}
