/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import static Modelo.entidades.Ent_Curso_Factory.boolToInt;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.carrera_DAO;
import modelo.logica.Carrera;

/**
 *
 * @author jorsu
 */
public class Ent_Carrera_Factory {
    public static List<Carrera> listAll() {
        List<Carrera> r = new ArrayList<>();
        carrera_DAO ud = new carrera_DAO();
        try {
            for (Ent_Carrera u : ud.listAll()) {
                r.add(createCarrera(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Carrera getCarrera(String id) {
        Carrera r = null;
        carrera_DAO ud = new carrera_DAO();

        try {
            Ent_Carrera u = ud.retrieve(id);
            r = createCarrera(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarCarrera(Carrera u, String Ciclo_id, String Carrera_id) {
        try {
            carrera_DAO ud = new carrera_DAO();
            Ent_Carrera aux = createEnt_Carrera(u);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean carreraExiste(String id) {
        Carrera u = null;
        try {
            u = getCarrera(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Carrera createCarrera(Ent_Carrera eu) throws SQLException, IOException {
        Carrera u = new Carrera(eu.getId(),eu.getNombre(),eu.getTitulo());
        return u;
    }

    private static Ent_Carrera createEnt_Carrera(Carrera u) {
        Ent_Carrera eu = new Ent_Carrera(u.getId(),u.getNombre(),u.getTitulo());
        return eu;
    }
}
