package modelo.logica;

import static java.sql.DriverManager.println;
import java.util.ArrayList;

/**
 *
 * @author Vic
 */
public class Curso {

    private String id;
    private String nombre;
    private int credito;
    private boolean estado;
    private int horas;
    private ArrayList<Grupo> listGrup;

    public Curso() {
    }

    public Curso(String id, String nombre, int credito, boolean estado, int horas) {
        this.id = id;
        this.nombre = nombre;
        this.credito = credito;
        this.estado = estado;
        this.horas = horas;
        this.listGrup = new ArrayList<Grupo>();
    }

    public Curso(String id, String nombre, int credito, boolean estado, int horas, ArrayList<Grupo> listGrup) {
        this.id = id;
        this.nombre = nombre;
        this.credito = credito;
        this.estado = estado;
        this.horas = horas;
        this.listGrup = listGrup;
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

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public ArrayList<Grupo> getListGrup() {
        return listGrup;
    }

    public void setListGrup(ArrayList<Grupo> listGrup) {
        this.listGrup = listGrup;
    }

    public void agregarGrupo(Grupo g) {
        if (g != null) {
            listGrup.add(g);
        }
    }

    public Grupo buscarGrup(String nrc) {
        for (int i = 0; i < listGrup.size(); i++) {
            if (listGrup.get(i).getNrc().equals(nrc)) {
                return listGrup.get(i);
            }
        }
        println("No existe un grupo con ese NRC");
        return null;
    }

    public ArrayList<Grupo> todosGrups() {
        if (listGrup != null) {
            return listGrup;
        }
        println("No hay Grupos");
        return null;
    }

}
