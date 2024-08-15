/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracion.de.conocimientos.pkg1;
import javax.swing.JOptionPane;
/**
 *
 * @author josem
 */
public class GestionHotel {
private Habitacion[] habitaciones = new Habitacion[15];

public void precargarHabitaciones() {
    // Pre-cargado de las habitaciones
    habitaciones[0] = new Habitacion("101", "Simple", "Libre", 30);
    habitaciones[1] = new Habitacion("102", "Simple", "Libre", 30);
    habitaciones[2] = new Habitacion("103", "Doble", "Libre", 40);
    habitaciones[3] = new Habitacion("104", "Doble", "Libre", 40);
    habitaciones[4] = new Habitacion("105", "Simple", "Libre", 40);
    habitaciones[5] = new Habitacion("201", "Simple", "Libre", 30);
    habitaciones[6] = new Habitacion("202", "Doble", "Libre", 40);
    habitaciones[7] = new Habitacion("203", "Doble", "Libre", 30);
    habitaciones[8] = new Habitacion("204", "Doble", "Ocupada", 40);
    habitaciones[9] = new Habitacion("205", "Simple", "Sucia", 40);
    habitaciones[10] = new Habitacion("301", "Doble", "Sucia", 50);
    habitaciones[11] = new Habitacion("302", "Doble", "Libre", 50);
    habitaciones[12] = new Habitacion("303", "Doble", "Libre", 30);
    habitaciones[13] = new Habitacion("304", "Doble", "Libre", 40);
    habitaciones[14] = new Habitacion("305", "Simple", "Sucia", 40);
}

public void mostrarHabitaciones() {
    StringBuilder s = new StringBuilder();

    s.append("Piso 5:\n");
    agregarHabitacionesPorPiso(s, 10, 14);  // Habitaciones 301-305

    s.append("Piso 4:\n");
    agregarHabitacionesPorPiso(s, 5, 9);  // Habitaciones 201-205

    s.append("Piso 3:\n");
    agregarHabitacionesPorPiso(s, 0, 4);  // Habitaciones 101-105

    JOptionPane.showMessageDialog(null, s.toString(), "Habitaciones", JOptionPane.INFORMATION_MESSAGE);
}

private void agregarHabitacionesPorPiso(StringBuilder s, int inicio, int fin) {
    for (int i = inicio; i <= fin; i++) {
        s.append(habitaciones[i].getNumero()).append(" - ")
            .append(habitaciones[i].getTipo()).append(" - ")
            .append(habitaciones[i].getEstado()).append(" - $")
            .append(habitaciones[i].getPrecioPorNoche()).append("\n");
    }
    s.append("\n");
}

public void modificarHabitacion() {
    //lista de habitaciones
    String[] numerosHabitaciones = new String[habitaciones.length];
    for (int i = 0; i < habitaciones.length; i++) {
        numerosHabitaciones[i] = habitaciones[i].getNumero();
    }

    //Lista de los números de la habitación
    int habitacionSeleccionada = JOptionPane.showOptionDialog(null,
            "Seleccione el número de la habitación a modificar:",
            "Modificar Habitación",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            numerosHabitaciones,
            numerosHabitaciones[0]);

    if (habitacionSeleccionada >= 0 && habitacionSeleccionada < numerosHabitaciones.length) {
        // Buscador de la habitación seleccionada
        Habitacion habitacion = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero().equals(numerosHabitaciones[habitacionSeleccionada])) {
                habitacion = h;
                break;
            }
        }

        if (habitacion != null) {
            // Opciones para el tipo de habitación
            String[] tipos = {"Simple", "Doble"};
            int tipoSeleccionado = JOptionPane.showOptionDialog(null,
                    "Seleccione el nuevo tipo de habitación:",
                    "Modificar Tipo de Habitación",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    tipos,
                    tipos[0]);
            if (tipoSeleccionado >= 0 && tipoSeleccionado < tipos.length) {
                habitacion.setTipo(tipos[tipoSeleccionado]);
            }

            // Opciones para el estado de la habitación
            String[] estados = {"Libre", "Ocupada", "Sucia"};
            int estadoSeleccionado = JOptionPane.showOptionDialog(null,
                    "Seleccione el nuevo estado de la habitación:",
                    "Modificar Estado de Habitación",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    estados,
                    estados[0]);
            if (estadoSeleccionado >= 0 && estadoSeleccionado < estados.length) {
                habitacion.setEstado(estados[estadoSeleccionado]);
            }

            // Entrada de texto para el nuevo precio por noche
            String precioInput = JOptionPane.showInputDialog(null, "Digite el nuevo precio por noche:");
            try {
                double precio = Double.parseDouble(precioInput);
                habitacion.setPrecioPorNoche(precio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio inválido, por favor ingrese un número.");
            }
        }
    }
}

public void mostrarResumenHotel() {
    int libres = 0, ocupadas = 0, sucias = 0;
    int ganancias = 0;

    for (Habitacion habitacion : habitaciones) {
        switch (habitacion.getEstado()) {
            case "Libre":
                libres++;
                break;
            case "Ocupada":
                ocupadas++;
                ganancias += habitacion.getPrecioPorNoche();
                break;
            case "Sucia":
                sucias++;
                break;
        }
    }

    int totalHabitaciones = habitaciones.length;
    
    // Cálculos 
    int porcentajeLibres = (libres * 100) / totalHabitaciones;
    int porcentajeOcupadas = (ocupadas * 100) / totalHabitaciones;
    int porcentajeSucias = (sucias * 100) / totalHabitaciones;

    String resumen = "Total de habitaciones: " + totalHabitaciones + "\n" +
            "Habitaciones libres: " + libres + " (" + porcentajeLibres + "%)\n" +
            "Habitaciones ocupadas: " + ocupadas + " (" + porcentajeOcupadas + "%)\n" +
            "Habitaciones sucias: " + sucias + " (" + porcentajeSucias + "%)\n" +
            "Ganancias actuales: $" + ganancias;

    JOptionPane.showMessageDialog(null, resumen);
    }
}

