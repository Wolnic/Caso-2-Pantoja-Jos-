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
public class Menu {
    //interfaz del menu
    private int opc;

    public void mostrarMenu() {
        GestionHotel gestionHotel = new GestionHotel();
        String[] opciones = {"Precargar habitaciones", "Visualizar habitaciones", "Modificar habitación", "Resumen del hotel", "Salir"};
        
        do {
            opc = JOptionPane.showOptionDialog(null, "***MENÚ PRINCIPAL***", "Sistema de Gestión de Reservas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opc) {
                case 0: {
                    gestionHotel.precargarHabitaciones();
                    JOptionPane.showMessageDialog(null, "Habitaciones precargadas correctamente.");
                    break;
                }
                case 1: {
                    gestionHotel.mostrarHabitaciones();
                    break;
                }
                case 2: {
                    gestionHotel.modificarHabitacion();
                    break;
                }
                case 3: {
                    gestionHotel.mostrarResumenHotel();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "¡Opción incorrecta!");
                }
            }
        } while (opc != 4);
    }
}
