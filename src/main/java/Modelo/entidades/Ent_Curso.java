/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;

/**
 *
 * @author jorsu
 */
public class Ent_Curso {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getCiclo_id() {
        return Ciclo_id;
    }

    public void setCiclo_id(String Ciclo_id) {
        this.Ciclo_id = Ciclo_id;
    }

    public String getCarrera_id() {
        return Carrera_id;
    }

    public void setCarrera_id(String Carrera_id) {
        this.Carrera_id = Carrera_id;
    }

    public Ent_Curso() {
    }

    public Ent_Curso(String id, String nombre, int credito, int estado, int horas, String Ciclo_id, String Carrera_id) {
        this.id = id;
        this.nombre = nombre;
        this.credito = credito;
        this.estado = estado;
        this.horas = horas;
        this.Ciclo_id = Ciclo_id;
        this.Carrera_id = Carrera_id;
    }



    private String id;
    private String nombre;
    private int credito;
    private int estado;
    private int horas;
    private String Ciclo_id;
    private String Carrera_id;
}
