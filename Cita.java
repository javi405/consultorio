import java.time.LocalDate;
import java.time.LocalTime;
public class Cita {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String motivo;
    private final Paciente paciente;
    private final Odontologo odontologo;
    private final Consultorio consultorio;
    public Cita(LocalDate fecha, LocalTime hora, String motivo,
                Paciente paciente, Odontologo odontologo, Consultorio consultorio) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.consultorio = consultorio;
    }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public Paciente getPaciente() { return paciente; }
    public Odontologo getOdontologo() { return odontologo; }
    public String getResumen() {
        return "Cita: " + fecha + " " + hora + " - " + motivo +
               "\n   Paciente: " + paciente.getNombre() +
               "\n   Odontólogo: " + odontologo.getNombre() +
               "\n   " + consultorio;
    }
}