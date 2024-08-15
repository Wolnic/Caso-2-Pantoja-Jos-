/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracion.de.conocimientos.pkg1;

/**
 *
 * @author josem
 */
public class Habitacion {
    //atributos del arreglo 
    private String numero;
    private String tipo;
    private String estado;
    private double precioPorNoche;

    public Habitacion() {
        this.numero = "";
        this.tipo = "";
        this.estado = "Libre";
        this.precioPorNoche = 0.00;
    }
    //constructores 
    public Habitacion(String numero, String tipo, String estado, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.precioPorNoche = precioPorNoche;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
}


