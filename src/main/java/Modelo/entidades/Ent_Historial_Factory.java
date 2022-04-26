/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.historialEstudiante_DAO;
import modelo.logica.HistorialEstudiante;

/**
 *
 * @author jorsu
 */
public class Ent_Historial_Factory {

    public static List<HistorialEstudiante> listAll() {
        List<HistorialEstudiante> r = new ArrayList<>();
        historialEstudiante_DAO ud = new historialEstudiante_DAO();
        try {
            for (Ent_Historial u : ud.listAll()) {
                r.add(createHistorialEstudiante(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static HistorialEstudiante getHistorialEstudiante(String id) {
        HistorialEstudiante r = null;
        historialEstudiante_DAO ud = new historialEstudiante_DAO();

        try {
            Ent_Historial u = ud.retrieve(id);
            r = createHistorialEstudiante(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarHistorialEstudiante(HistorialEstudiante u, String idEstudiante) {
        try {
            historialEstudiante_DAO ud = new historialEstudiante_DAO();
            Ent_Historial aux = createEnt_HistorialEstudiante(u, idEstudiante);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean horarioExiste(String id) {
        HistorialEstudiante u = null;
        try {
            u = getHistorialEstudiante(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static HistorialEstudiante createHistorialEstudiante(Ent_Historial eu) throws SQLException, IOException {
        HistorialEstudiante u = new HistorialEstudiante(eu.getId(),eu.getCurso(),eu.getNota(),eu.getGrupo());
        return u;
    }

    private static Ent_Historial createEnt_HistorialEstudiante(HistorialEstudiante u, String idEstudiante) {
        Ent_Historial eu = new Ent_Historial(u.getId(),u.getCurso(),u.getNota(),u.getGrupo(),idEstudiante);
        return eu;
    }

}
