
package Modelo.entidades;

import Modelo.entidades.Ent_Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.usuario_DAO;
import modelo.logica.Usuario;

public class Ent_Usuario_Factory {
        public static List<Usuario> listAll() {
        List<Usuario> r = new ArrayList<>();
        usuario_DAO ud = new usuario_DAO();
        try {
            for (Ent_Usuario u : ud.listAll()) {
                r.add(createUsuario(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }
    
    public static Usuario getUsuario(String id) {
        Usuario r = null;
        usuario_DAO ud = new usuario_DAO();

        try {
            Ent_Usuario u = ud.retrieve(id);
            r = createUsuario(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }
    
    public static void agregarUsuarios(Usuario u) {
        try {
            usuario_DAO ud = new usuario_DAO();
            Ent_Usuario aux = createEnt_Usuario(u);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public static boolean usuarioExiste(String id) {
        Usuario u = null;
        try {
            u = getUsuario(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    public static String datosCorrectos(String id, String pass) {
        List<Usuario> r = listAll();

        for (Usuario u : r) {
            if (id.equals(u.getId())) {
                if (pass.equals(u.getClave())) {
                    return "correcto";
                } else {
                    return "clave_incorrecta";
                }
            }
        }
        return "nombre_incorrecto";
    }
    
    public static Usuario datosCorrectosUsuario(String id, String pass) {
        List<Usuario> r = listAll();

        for (Usuario u : r) {
            if (id.equals(u.getId())) {
                if (pass.equals(u.getClave())) {
                    return getUsuario(u.getId());
                } else {
                    return null;
                }
            }
        }
        return null;
    }
    
    
    private static Usuario createUsuario(Ent_Usuario eu) throws SQLException, IOException {
        Usuario u = new Usuario(eu.getId(),eu.getClave(),eu.getRol());
        return u;
    }

    private static Ent_Usuario createEnt_Usuario(Usuario u) {
        Ent_Usuario eu = new Ent_Usuario(u.getId(), u.getClave(),u.getRol());
        return eu;
    }
}