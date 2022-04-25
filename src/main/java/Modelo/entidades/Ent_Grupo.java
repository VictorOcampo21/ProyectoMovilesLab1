/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

/**
 *
 * @author jorsu
 */
public class Ent_Grupo {

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(String idProfe) {
        this.idProfe = idProfe;
    }

    public int getNumGrup() {
        return numGrup;
    }

    public void setNumGrup(int numGrup) {
        this.numGrup = numGrup;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNomCiclo() {
        return nomCiclo;
    }

    public void setNomCiclo(String nomCiclo) {
        this.nomCiclo = nomCiclo;
    }

    public String getCurso_id() {
        return Curso_id;
    }

    public void setCurso_id(String Curso_id) {
        this.Curso_id = Curso_id;
    }

    public Ent_Grupo() {
    }

    public Ent_Grupo(String nrc, String idProfe, int numGrup, String curso, String nomCiclo, String Curso_id) {
        this.nrc = nrc;
        this.idProfe = idProfe;
        this.numGrup = numGrup;
        this.curso = curso;
        this.nomCiclo = nomCiclo;
        this.Curso_id = Curso_id;
    }


    private String nrc;
    private String idProfe;
    private int numGrup;
    private String curso;
    private String nomCiclo;
    private String Curso_id;

}
