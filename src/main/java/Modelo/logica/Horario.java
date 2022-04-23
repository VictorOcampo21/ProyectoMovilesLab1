package modelo.logica;

public class Horario {

    private String inicia;
    private String finaliza;
    private String dia;
    private String id;

    public String getInicia() {
        return inicia;
    }

    public void setInicia(String inicia) {
        this.inicia = inicia;
    }

    public String getFinaliza() {
        return finaliza;
    }

    public void setFinaliza(String finaliza) {
        this.finaliza = finaliza;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Horario() {
    }

    public Horario(String inicia, String finaliza, String dia) {
        this.inicia = inicia;
        this.finaliza = finaliza;
        this.dia = dia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
