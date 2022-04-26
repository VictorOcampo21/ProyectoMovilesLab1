
package Modelo.entidades;

/**
 *
 * @author jorsu
 */
public class Ent_Historial {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstudiante_id() {
        return Estudiante_id;
    }

    public void setEstudiante_id(String Estudiante_id) {
        this.Estudiante_id = Estudiante_id;
    }

    public Ent_Historial() {
    }

    public Ent_Historial(String id, String curso, double nota, String grupo, String Estudiante_id) {
        this.id = id;
        this.curso = curso;
        this.nota = nota;
        this.grupo = grupo;
        this.Estudiante_id = Estudiante_id;
    }

    private String id;
    private String curso;
    private double nota;
    private String grupo;
    private String Estudiante_id;
}
