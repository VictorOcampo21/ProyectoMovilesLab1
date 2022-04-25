/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.horario_DAO;
import modelo.logica.Horario;

/**
 *
 * @author jorsu
 */
public class Ent_Horario_Factory {
    
  public static List<Horario> listAll() {
        List<Horario> r = new ArrayList<>();
        horario_DAO ud = new horario_DAO();
        try {
            for (Ent_Horario u : ud.listAll()) {
                r.add(createHorario(u));
            }

        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
        return r;
    }

    public static Horario getHorario(String id) {
        Horario r = null;
        horario_DAO ud = new horario_DAO();

        try {
            Ent_Horario u = ud.retrieve(id);
            r = createHorario(u);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return r;
    }

    public static void agregarHorario(Horario u,String nrc) {
        try {
            horario_DAO ud = new horario_DAO();
            Ent_Horario aux = createEnt_Horario(u,nrc);
            ud.add(String.valueOf(aux.getIdHorario()), aux);
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public static boolean horarioExiste(String id) {
        Horario u = null;
        try {
            u = getHorario(id);
        } catch (IllegalArgumentException e) {

        }
        return u != null;
    }

    private static Horario createHorario(Ent_Horario eu) throws SQLException, IOException {
        Horario u = new Horario(eu.getIdHorario(),eu.getIni(),eu.getFin(), eu.getDia());
        return u;
    }

    private static Ent_Horario createEnt_Horario(Horario u,String nrc) {
        Ent_Horario eu = new Ent_Horario(u.getId(),u.getInicia(),u.getFinaliza(),u.getDia(),nrc);
        return eu;
    }

}
