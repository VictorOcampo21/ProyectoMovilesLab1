package modelo.logica;

/**
 *
 * @author Vic
 */
public class Profesor extends Persona {

    public Profesor() {
    }

    public Profesor(String id, String nombre, String telefono, String email, Usuario usu) {
        super(id, nombre, telefono, email, usu);
    }

}
