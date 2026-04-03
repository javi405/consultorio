public abstract class Persona {
    protected String nombre;
    protected String documento;
    protected String telefono;
    protected String email;
    public Persona(String nombre, String documento, String telefono, String email) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public abstract String getRol();
    @Override
    public String toString() {
        return getRol() + ": " + nombre + " (Doc: " + documento + ", Tel: " + telefono + ", Email: " + email + ")";
    }
}