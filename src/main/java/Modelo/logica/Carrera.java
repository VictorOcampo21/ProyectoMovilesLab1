package modelo.logica;

import java.util.ArrayList;

public class Carrera {

    public Carrera() {
    }

    public Carrera(String id, String nombre, String titulo, ArrayList<Curso> listCursos) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.listCursos = listCursos;
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Curso> getListCursos() {
        return listCursos;
    }

    public void setListCursos(ArrayList<Curso> listCursos) {
        this.listCursos = listCursos;
    }

    private String id;
    private String nombre;
    private String titulo;
    private ArrayList<Curso> listCursos;

}
