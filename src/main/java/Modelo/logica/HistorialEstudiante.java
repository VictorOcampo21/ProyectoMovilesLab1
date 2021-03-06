package modelo.logica;

public class HistorialEstudiante {

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

    public HistorialEstudiante(String id, String curso, double nota, String grupo) {
        this.id = id;
        this.curso = curso;
        this.nota = nota;
        this.grupo = grupo;
    }

    public HistorialEstudiante() {
    }

    private String id;
    private String curso;
    private double nota;
    private String grupo;

}
