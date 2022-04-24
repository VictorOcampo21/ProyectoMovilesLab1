/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.estudiante_DAO;
import modelo.logica.Estudiante;
import modelo.logica.Usuario;

/**
 *
 * @author jorsu
 */
public class Ent_Estudiante_Factory {
     public static List<Estudiante> listAll() {
        List<Estudiante> r = new ArrayList<>();
        estudiante_DAO ud = new estudiante_DAO();
        try {
            for (Ent_Estudiante u : ud.listAll()) {
                r.add(createEstudiante(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Estudiante getEstudiante(String id) {
        Estudiante r = null;
        estudiante_DAO ud = new estudiante_DAO();

        try {
            Ent_Estudiante u = ud.retrieve(id);
            r = createEstudiante(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarEstudiante(Estudiante u) {
        try {
            estudiante_DAO ud = new estudiante_DAO();
            Ent_Estudiante aux = createEnt_Estudiante(u);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean estudianteExiste(String id) {
        Estudiante u = null;
        try {
            u = getEstudiante(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Estudiante createEstudiante(Ent_Estudiante eu) throws SQLException, IOException {
        Usuario aux = Ent_Usuario_Factory.getUsuario(eu.getUsu());
        Estudiante u = new Estudiante(eu.getId(), eu.getNombre(), eu.getTelefono(), eu.getEmail(),aux,eu.getCumple(), eu.getCarrera());
        return u;
    }

    private static Ent_Estudiante createEnt_Estudiante(Estudiante u) {
        Ent_Estudiante eu = new Ent_Estudiante(u.getId(),u.getNombre(),u.getTelefono(),u.getEmail(),u.getUsu().getId(),u.getCumple(),u.getCarrera());
        return eu;
    }
}
