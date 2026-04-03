import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class CalendarioDisponible {
    private final List<LocalDate> fechasDisponibles;
    private final List<LocalTime> horasDisponibles;
    public CalendarioDisponible() {
        this.fechasDisponibles = new ArrayList<>();
        this.horasDisponibles = new ArrayList<>();
    }
    public void agregarFechaDisponible(LocalDate fecha) {
        if (!fechasDisponibles.contains(fecha)) {
            fechasDisponibles.add(fecha);
        }
    }
    public void agregarHoraDisponible(LocalTime hora) {
        if (!horasDisponibles.contains(hora)) {
            horasDisponibles.add(hora);
        }
    }
    public boolean estaDisponible(LocalDate fecha, LocalTime hora) {
        return fechasDisponibles.contains(fecha) && horasDisponibles.contains(hora);
    }
    public void mostrarCalendario() {
        System.out.println("\nFECHAS DISPONIBLES:");
        if (fechasDisponibles.isEmpty()) {
            System.out.println("  No hay fechas disponibles.");
        } else {
            for (LocalDate fecha : fechasDisponibles) {
                System.out.println("  • " + fecha);
            }
        }
        System.out.println("\nHORAS DISPONIBLES:");
        if (horasDisponibles.isEmpty()) {
            System.out.println("  No hay horas disponibles.");
        } else {
            for (LocalTime hora : horasDisponibles) {
                System.out.println("  • " + hora);
            }
        }
    }
    public List<LocalDate> getFechasDisponibles() { return fechasDisponibles; }
    public List<LocalTime> getHorasDisponibles() { return horasDisponibles; }
}