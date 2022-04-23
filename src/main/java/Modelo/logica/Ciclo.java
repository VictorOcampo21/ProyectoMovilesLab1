package modelo.logica;

import static java.sql.DriverManager.println;
import java.util.ArrayList;

/**
 *
 * @author Vic
 */
public class Ciclo {

    private String anio;
    private String num;
    private String inicio;
    private String fin;
    private ArrayList<Curso> listCursos;

    public Ciclo() {
    }

    public Ciclo(String anio, String num, String inicio, String fin, ArrayList<Curso> listCursos) {
        this.anio = anio;
        this.num = num;
        this.inicio = inicio;
        this.fin = fin;
        this.listCursos = listCursos;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public ArrayList<Curso> getListCursos() {
        return listCursos;
    }

    public void setListCursos(ArrayList<Curso> listCursos) {
        this.listCursos = listCursos;
    }

    public void agregarCurso(Curso c) {
        if (c != null) {
            listCursos.add(c);
        }
    }

    public Curso buscarCurso(String id) {
        for (int i = 0; i < listCursos.size(); i++) {
            if (listCursos.get(i).getId().equals(id)) {
                return listCursos.get(i);
            }
        }
        println("No existe un curso con ese identificador");
        return null;
    }

    public ArrayList<Curso> todosCursos() {
        if (listCursos != null) {
            return listCursos;
        }
        println("No hay Cursos");
        return null;
    }

}
