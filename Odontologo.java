public class Odontologo extends Persona {
    private String especialidad;
    private Consultorio consultorio;
    public Odontologo(String nombre, String documento, String telefono, String email, 
                      String especialidad, Consultorio consultorio) {
        super(nombre, documento, telefono, email);
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Consultorio getConsultorio() { return consultorio; }
    public void setConsultorio(Consultorio consultorio) { this.consultorio = consultorio; }
    @Override
    public String getRol() {
        return "Odontólogo";
    }
    @Override
    public String toString() {
        return super.toString() + " - " + especialidad + " - " + consultorio;
    }
}