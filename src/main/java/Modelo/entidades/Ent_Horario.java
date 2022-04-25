/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

/**
 *
 * @author jorsu
 */
public class Ent_Horario {
        public String getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getGrupo_nrc() {
        return Grupo_nrc;
    }

    public void setGrupo_nrc(String Grupo_nrc) {
        this.Grupo_nrc = Grupo_nrc;
    }

    private String idHorario;
    private String ini;
    private String fin;
    private String dia;
    private String Grupo_nrc;

    public Ent_Horario(String idHorario, String ini, String fin, String dia, String Grupo_nrc) {
        this.idHorario = idHorario;
        this.ini = ini;
        this.fin = fin;
        this.dia = dia;
        this.Grupo_nrc = Grupo_nrc;
    }


    public Ent_Horario() {
    }

}
