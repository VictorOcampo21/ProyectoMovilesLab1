package Modelo.logica;

import java.io.IOException;
import java.util.HashMap;
import modelo.logica.Estudiante;
import modelo.logica.Usuario;

/**
 *
 * @author Vic
 */
public class Universidad {
    
    private static Universidad instance;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Estudiante> estudiantes;

    public Universidad() {
        usuarios = new HashMap<>();
        estudiantes = new HashMap<>();
        usuarios.put("1", new Usuario("1","1", "ADM"));
    }

    public Universidad(HashMap<String, Usuario> usuarios, HashMap<String, Estudiante> estudiantes) {
        this.usuarios = usuarios;
        this.estudiantes = estudiantes;
    }
    
    public static Universidad getInstance() {
        if (instance == null) {
            instance = new Universidad();
        }
        return instance;
    }

    public HashMap<String, Usuario> getListUsus() {
        return usuarios;
    }

    public void setListUsus(HashMap<String, Usuario> listUsus) {
        this.usuarios = listUsus;
    }

    public HashMap<String, Estudiante> getListEstu() {
        return estudiantes;
    }

    public void setListEstu(HashMap<String, Estudiante> listEstu) {
        this.estudiantes = listEstu;
    }
    
    public void agregarUsuario(String id, String clave, String rol){
        Usuario a=new Usuario(id, clave, rol);
        usuarios.put(id, a);
    }
    
    public Usuario validarUsu(String id, String clave) throws IOException{
        HashMap<String, Usuario> users = Universidad.getInstance().getListUsus();
        System.out.printf("USUARIOS: %s\n", users.toString());
        Usuario u = users.get(id);
        if (u != null) {
            if (u.correctPswd(clave)) {
                return u;
            } else {
                throw new IOException("La contraseña digitada no es correcta");
            }
        } else {
            throw new IOException("El usuario digitado no existe");
        }
    }
    
}
