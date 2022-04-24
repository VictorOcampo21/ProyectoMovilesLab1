/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import static Modelo.entidades.Ent_Usuario_Factory.getUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.profesor_DAO;
import model.dao.usuario_DAO;
import modelo.logica.Profesor;
import modelo.logica.Usuario;

/**
 *
 * @author jorsu
 */
public class Ent_Profesor_Factory {

    public static List<Profesor> listAll() {
        List<Profesor> r = new ArrayList<>();
        profesor_DAO ud = new profesor_DAO();
        try {
            for (Ent_Profesor u : ud.listAll()) {
                r.add(createProfesor(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Profesor getProfesor(String id) {
        Profesor r = null;
        profesor_DAO ud = new profesor_DAO();

        try {
            Ent_Profesor u = ud.retrieve(id);
            r = createProfesor(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarProfesor(Profesor u) {
        try {
            profesor_DAO ud = new profesor_DAO();
            Ent_Profesor aux = createEnt_Profesor(u);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean profesorExiste(String id) {
        Profesor u = null;
        try {
            u = getProfesor(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Profesor createProfesor(Ent_Profesor eu) throws SQLException, IOException {
        Usuario aux = Ent_Usuario_Factory.getUsuario(eu.getUsu());
        Profesor u = new Profesor(eu.getId(), eu.getNombre(), eu.getTelefono(), eu.getEmail(),aux);
        return u;
    }

    private static Ent_Profesor createEnt_Profesor(Profesor u) {
        Ent_Profesor eu = new Ent_Profesor(u.getId(),u.getNombre(),u.getTelefono(),u.getEmail(),u.getUsu().getId());
        return eu;
    }
}
