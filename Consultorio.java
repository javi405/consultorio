public class Consultorio {
    private final String numero;
    private final String equipo;
    public Consultorio(String numero, String equipo) {
        this.numero = numero;
        this.equipo = equipo;
    }
    public String getNumero() { return numero; }
    public String getEquipo() { return equipo; }
    @Override
    public String toString() {
        return "Consultorio " + numero + " (" + equipo + ")";
    }
}