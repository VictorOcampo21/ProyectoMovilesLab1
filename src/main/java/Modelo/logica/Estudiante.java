package modelo.logica;

/**
 *
 * @author Vic
 */
public class Estudiante extends Persona {

    private String cumple;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String id, String nombre, String telefono, String email, Usuario usu, String cumple, String carrera) {
        super(id, nombre, telefono, email, usu);
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

}
