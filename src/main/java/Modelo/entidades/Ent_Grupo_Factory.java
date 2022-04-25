/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.grupo_DAO;
import modelo.logica.Grupo;

/**
 *
 * @author jorsu
 */
public class Ent_Grupo_Factory {

    public static List<Grupo> listAll() {
        List<Grupo> r = new ArrayList<>();
        grupo_DAO ud = new grupo_DAO();
        try {
            for (Ent_Grupo u : ud.listAll()) {
                r.add(createGrupo(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Grupo getGrupo(String id) {
        Grupo r = null;
        grupo_DAO ud = new grupo_DAO();

        try {
            Ent_Grupo u = ud.retrieve(id);
            r = createGrupo(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarProfesor(Grupo u) {
        try {
            grupo_DAO ud = new grupo_DAO();
            Ent_Grupo aux = createEnt_Grupo(u);
            ud.add(String.valueOf(aux.getNrc()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean horarioExiste(String id) {
        Grupo u = null;
        try {
            u = getGrupo(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Grupo createGrupo(Ent_Grupo eu) throws SQLException, IOException {

        Grupo u = new Grupo(eu.getNrc(), eu.getIdProfe(), eu.getNumGrup(), eu.getCurso(), eu.getNomCiclo());
        return u;
    }

    private static Ent_Grupo createEnt_Grupo(Grupo u) {
        Ent_Grupo eu = new Ent_Grupo(u.getNrc(),u.getIdProfe(), u.getNumGrup(), u.getCurso(),u.getNomCiclo(),u.getCurso());
        return eu;
    }
}
