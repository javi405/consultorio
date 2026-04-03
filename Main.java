import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Asistente assistente;
    static Odontologo odontologo;
    public static void main(String[] args) {
        System.out.println("\n----------------------------------------------");
        System.out.println("\n-----SISTEMA DE CONSULTORIO ODONTOLÓGICO------");
        System.out.println("\n----------------------------------------------");
        try {
            configurarAsistente();
            configurarOdontologoYConsultorio();
            configurarCalendario();
        } catch (Exception e) {
            System.out.println("Error en la configuración inicial: " + e.getMessage());
            return;
        }
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                opcion = 0;
                continue;
            }
            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> assistente.mostrarCalendarioDisponible();
                case 3 -> pedirCita();
                case 4 -> verHistorial();
                case 5 -> editarHistorial();
                case 6 -> System.out.println(" Saliendo...");
                default -> System.out.println(" Opción inválida. Elija 1-6.");
            }
        } while (opcion != 6);
        sc.close();
    }
    static void mostrarMenu() {
        System.out.println(" _____________________________________________");
        System.out.println("|            MENÚ PRINCIPAL                   |");
        System.out.println("|_____________________________________________|");
        System.out.println("| 1. Registrar paciente                       |");
        System.out.println("| 2. Ver calendario disponible                |");
        System.out.println("| 3. Pedir cita                               |");
        System.out.println("| 4. Ver mi historial clínico                 |");
        System.out.println("| 5. Editar/Crear historial                   |");
        System.out.println("| 6. Salir                                    |");
        System.out.println("|_____________________________________________|");
        System.out.print("Opción: ");
    }
    static void configurarAsistente() {
        System.out.println("\n----------------------------------------------");
        System.out.println("-----------REGISTRO DE ASISTENTE--------------");
        System.out.println("\n----------------------------------------------");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Turno (mañana/tarde/noche): ");
        String turno = sc.nextLine();
        assistente = new Asistente(nombre, documento, telefono, email, turno);
        System.out.println("Asistente registrado\n");
        System.out.println(assistente);
        System.out.println();
    }
    static void configurarOdontologoYConsultorio() {
        System.out.println("\n-------------------------------");
        System.out.println("----REGISTRO DE ODONTÓLOGO----");
        System.out.println("\n-------------------------------");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();
        System.out.print("Número de consultorio: ");
        String numConsultorio = sc.nextLine();
        System.out.print("Equipo del consultorio: ");
        String equipo = sc.nextLine();
        Consultorio consultorio = new Consultorio(numConsultorio, equipo);
        odontologo = new Odontologo(nombre, documento, telefono, email, especialidad, consultorio);
        System.out.println("Odontólogo y consultorio registrados\n");
        System.out.println(odontologo);
    }
    static void configurarCalendario() {
        System.out.println("\n----------------------------------------------");
        System.out.println("\n----CONFIGURACIÓN DE CALENDARIO DISPONIBLE----");
        System.out.println("\n----------------------------------------------");
        System.out.println("El asistente " + assistente.getNombre() + " indica qué días y horas están disponibles.");
        int numFechas = 0;
        while (numFechas <= 0) {
            System.out.print("¿Cuántas fechas disponibles? ");
            try {
                numFechas = Integer.parseInt(sc.nextLine());
                if (numFechas <= 0) {
                    System.out.println("Debe ingresar al menos 1 fecha.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
        for (int i = 0; i < numFechas; i++) {
            while (true) {
                System.out.print("Fecha " + (i + 1) + " (YYYY-MM-DD): ");
                try {
                    LocalDate fecha = LocalDate.parse(sc.nextLine());
                    assistente.agregarFechaDisponible(fecha);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato inválido. Use YYYY-MM-DD (ej: 2026-04-20)");
                }
            }
        }
        int numHoras = 0;
        while (numHoras <= 0) {
            System.out.print("¿Cuántas horas disponibles? ");
            try {
                numHoras = Integer.parseInt(sc.nextLine());
                if (numHoras <= 0) {
                    System.out.println("Debe ingresar al menos 1 hora.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
        for (int i = 0; i < numHoras; i++) {
            while (true) {
                System.out.print("Hora " + (i + 1) + " (HH:MM): ");
                try {
                    LocalTime hora = LocalTime.parse(sc.nextLine());
                    assistente.agregarHoraDisponible(hora);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato inválido. Use HH:MM ");
                }
            }
        }
        System.out.println("Calendario configurado por " + assistente.getNombre() + "\n");
        assistente.mostrarCalendarioDisponible();
    }
    static void registrarPaciente() {
        System.out.println("\n----------------------------");
        System.out.println("\n----REGISTRO DE PACIENTE----");
        System.out.println("\n----------------------------");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        Paciente p = new Paciente(nombre, documento, telefono, email);
        assistente.registrarPaciente(p);
    }
    static void pedirCita() {
        System.out.print("\nDocumento del paciente: ");
        String documento = sc.nextLine();
        Paciente paciente = assistente.buscarPaciente(documento);
        if (paciente == null) {
            System.out.println("Paciente no encontrado. Primero regístrelo (opción 1).");
            return;
        }
        System.out.println("\nEl asistente " + assistente.getNombre() + " consulta el calendario disponible:");
        assistente.mostrarCalendarioDisponible();
        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print("\nFecha deseada (YYYY-MM-DD): ");
            try {
                fecha = LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use YYYY-MM-DD");
            }
        }
        LocalTime hora = null;
        while (hora == null) {
            System.out.print("Hora deseada (HH:MM): ");
            try {
                hora = LocalTime.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use HH:MM");
            }
        }
        if (!assistente.verificarDisponibilidad(fecha, hora)) {
            System.out.println("Fecha u hora NO disponible. La cita no puede asignarse.");
            System.out.println("   Consulte el calendario disponible (opción 2).");
            return;
        }
        System.out.print("Motivo de la cita: ");
        String motivo = sc.nextLine();
        Cita cita = new Cita(fecha, hora, motivo,
                paciente, odontologo, odontologo.getConsultorio());
        assistente.asignarCita(cita);
    }
    static void verHistorial() {
        System.out.print("\nDocumento del paciente: ");
        String documento = sc.nextLine();
        Paciente p = assistente.buscarPaciente(documento);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        System.out.println("\nEl asistente " + assistente.getNombre() + " muestra el historial de " + p.getNombre());
        assistente.mostrarHistorialPaciente(documento);
    }
    static void editarHistorial() {
        System.out.println("\nACCESO RESTRINGIDO - SOLO ODONTÓLOGO");
        System.out.print("Documento del odontólogo: ");
        String documento = sc.nextLine();
        if (!documento.equals(odontologo.getDocumento())) {
            System.out.println("Acceso denegado. Solo el odontólogo puede editar historiales.");
            return;
        }
        System.out.print("Documento del paciente: ");
        String documentoPaciente = sc.nextLine();
        Paciente p = assistente.buscarPaciente(documentoPaciente);
        if (p == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }
        System.out.println("Escriba el nuevo historial clínico para " + p.getNombre());
        String nuevoHistorial = sc.nextLine();
        assistente.guardarHistorial(odontologo, documentoPaciente, nuevoHistorial);
    }
}