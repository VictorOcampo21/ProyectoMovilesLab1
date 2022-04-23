package modelo.logica;

public class HistorialEstudiante {

    public HistorialEstudiante(String curso, double nota, String grupo) {
        this.curso = curso;
        this.nota = nota;
        this.grupo = grupo;
    }

    public HistorialEstudiante() {
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

    private String curso;
    private double nota;
    private String grupo;

}
