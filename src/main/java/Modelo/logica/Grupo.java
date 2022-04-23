package modelo.logica;

import static java.sql.DriverManager.println;
import java.util.ArrayList;

/**
 *
 * @author Vic
 */
public class Grupo {

    private String nrc;
    private String idProfe;
    private int numGrup;
    private String curso;
    private String nomCiclo;
    private ArrayList<Estudiante> listEstu;
    private ArrayList<Horario> listHorario;

    public Grupo(String nrc, String idProfe, int numGrup, String curso, String nomCiclo, ArrayList<Estudiante> listEstu, ArrayList<Horario> listHorario) {
        this.nrc = nrc;
        this.idProfe = idProfe;
        this.numGrup = numGrup;
        this.curso = curso;
        this.nomCiclo = nomCiclo;
        this.listEstu = listEstu;
        this.listHorario = listHorario;
    }

    public Grupo() {
    }

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

    public ArrayList<Estudiante> getListEstu() {
        return listEstu;
    }

    public void setListEstu(ArrayList<Estudiante> listEstu) {
        this.listEstu = listEstu;
    }

    public ArrayList<Horario> getListHorario() {
        return listHorario;
    }

    public void setListHorario(ArrayList<Horario> listHorario) {
        this.listHorario = listHorario;
    }

    public void agregarEstudiante(Estudiante e) {
        if (e != null) {
            listEstu.add(e);
        }
    }

    public Estudiante buscarEstu(String id) {
        for (int i = 0; i < listEstu.size(); i++) {
            if (listEstu.get(i).getId().equals(id)) {
                return listEstu.get(i);
            }
        }
        println("No existe estudiante con esa identificacion");
        return null;
    }

    public ArrayList<Estudiante> todosEstudiantes() {
        if (listEstu != null) {
            return listEstu;
        }
        println("No hay estudiantes");
        return null;
    }

    public void agregarHorario(Horario o) {
        if (o != null) {
            listHorario.add(o);
        }
    }
    
    public Horario buscarHorario(String dia){
        for (int i = 0; i < listHorario.size(); i++) {
            if(listHorario.get(i).getDia().equals(dia)){
                return listHorario.get(i);
            }
        }
        println("No existe el horario de ese dia");
        return null;
    }

    public ArrayList<Horario> todosHorarios() {
        if (listHorario != null) {
            return listHorario;
        }
        println("No hay horarios");
        return null;
    }

}
