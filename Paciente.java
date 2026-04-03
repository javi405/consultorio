import java.util.ArrayList;
import java.util.List;
public class Paciente extends Persona {
    private final List<Cita> citas;
    public Paciente(String nombre, String documento, String telefono, String email) {
        super(nombre, documento, telefono, email);
        this.citas = new ArrayList<>();
    }
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }
    public List<Cita> getCitas() {
        return citas;
    }
    @Override
    public String getRol() {
        return "Paciente";
    }
}