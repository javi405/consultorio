public class HistoriaClinica {
    private final String pacienteDocumento;
    private String historial;
    public HistoriaClinica(String pacienteDocumento, String historial) {
        this.pacienteDocumento = pacienteDocumento;
        this.historial = historial;
    }
    public String getHistorial() { return historial; }
    public void setHistorial(String historial) { this.historial = historial; }
    public String getPacienteDocumento() { return pacienteDocumento; }
}