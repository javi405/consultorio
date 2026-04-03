import java.util.ArrayList;
import java.util.List;
public class Asistente extends Persona {
    private String turno;
    private final List<Cita> citas;
    private final List<Paciente> pacientes;
    private final List<HistoriaClinica> historias;
    private final CalendarioDisponible calendario;
    public Asistente(String nombre, String documento, String telefono, String email, String turno) {
        super(nombre, documento, telefono, email);
        this.turno = turno;
        this.citas = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.historias = new ArrayList<>();
        this.calendario = new CalendarioDisponible();
    }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public void registrarPaciente(Paciente p) {
        pacientes.add(p);
        System.out.println("Paciente registrado por " + getNombre() + " (asistente): " + p);
    }
    public void mostrarCalendarioDisponible() {
        calendario.mostrarCalendario();
    }
    public boolean verificarDisponibilidad(java.time.LocalDate fecha, java.time.LocalTime hora) {
        return calendario.estaDisponible(fecha, hora);
    }
    public void agregarFechaDisponible(java.time.LocalDate fecha) {
        calendario.agregarFechaDisponible(fecha);
    }
    public void agregarHoraDisponible(java.time.LocalTime hora) {
        calendario.agregarHoraDisponible(hora);
    }
    public void asignarCita(Cita cita) {
        if (!calendario.estaDisponible(cita.getFecha(), cita.getHora())) {
            System.out.println("La cita NO se puede asignar: fecha u hora no disponible en el calendario.");
            return;
        }
        citas.add(cita);
        cita.getPaciente().agregarCita(cita);
        System.out.println("Cita asignada por " + getNombre() + " (asistente) - disponibilidad confirmada");
        System.out.println(cita.getResumen());
    }
    public void mostrarHistorialPaciente(String documento) {
        for (HistoriaClinica hc : historias) {
            if (hc.getPacienteDocumento().equals(documento)) {
                System.out.println("\nHISTORIAL CLÍNICO (mostrado por asistente " + getNombre() + "):");
                System.out.println(hc.getHistorial());
                return;
            }
        }
        System.out.println("No hay historial clínico para este paciente.");
    }
    public void guardarHistorial(Odontologo odontologo, String pacienteDocumento, String nuevoHistorial) {
        for (HistoriaClinica hc : historias) {
            if (hc.getPacienteDocumento().equals(pacienteDocumento)) {
                hc.setHistorial(nuevoHistorial);
                System.out.println("Historial actualizado por odontólogo " + odontologo.getNombre());
                return;
            }
        }
        historias.add(new HistoriaClinica(pacienteDocumento, nuevoHistorial));
        System.out.println("Nuevo historial creado por odontólogo " + odontologo.getNombre());
    }
    public Paciente buscarPaciente(String documento) {
        for (Paciente p : pacientes) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }
    public CalendarioDisponible getCalendario() {
        return calendario;
    }
    public List<Cita> getCitas() {
        return citas;
    }
    @Override
    public String getRol() {
        return "Asistente";
    }

    @Override
    public String toString() {
        return super.toString() + " - Turno: " + turno;
    }
}