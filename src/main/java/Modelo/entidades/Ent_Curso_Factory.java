/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.curso_DAO;
import modelo.logica.Curso;

/**
 *
 * @author jorsu
 */
public class Ent_Curso_Factory {

    public static List<Curso> listAll() {
        List<Curso> r = new ArrayList<>();
        curso_DAO ud = new curso_DAO();
        try {
            for (Ent_Curso u : ud.listAll()) {
                r.add(createCurso(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Curso getCurso(String id) {
        Curso r = null;
        curso_DAO ud = new curso_DAO();

        try {
            Ent_Curso u = ud.retrieve(id);
            r = createCurso(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarCurso(Curso u, String Ciclo_id, String Carrera_id) {
        try {
            curso_DAO ud = new curso_DAO();
            Ent_Curso aux = createEnt_Curso(u, Ciclo_id, Carrera_id);
            ud.add(String.valueOf(aux.getId()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean cursoExiste(String id) {
        Curso u = null;
        try {
            u = getCurso(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Curso createCurso(Ent_Curso eu) throws SQLException, IOException {
        boolean estado = (eu.getEstado() == 100);
        Curso u = new Curso(eu.getId(), eu.getNombre(), eu.getCredito(), estado, eu.getHoras());
        return u;
    }

    public static int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    private static Ent_Curso createEnt_Curso(Curso u, String Ciclo_id, String Carrera_id) {

        Ent_Curso eu = new Ent_Curso(u.getId(), u.getNombre(), u.getCredito(), boolToInt(u.isEstado()), u.getHoras(),Ciclo_id,Carrera_id);
        return eu;
    }
}
