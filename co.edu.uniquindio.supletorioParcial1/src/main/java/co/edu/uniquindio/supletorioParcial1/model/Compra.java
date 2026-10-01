package co.edu.uniquindio.supletorioParcial1.model;

import java.time.LocalDate;

public class Compra {

    private int codigoCompra;
    private LocalDate fechaRealizacionCompra;
    private String metodoPago;
    private double valorTotalCompra;

    public Compra(int codigoCompra, LocalDate fechaRealizacionCompra, String metodoPago, double valorTotalCompra) {
        this.codigoCompra = codigoCompra;
        this.fechaRealizacionCompra = fechaRealizacionCompra;
        this.metodoPago = metodoPago;
        this.valorTotalCompra = valorTotalCompra;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public LocalDate getFechaRealizacionCompra() {
        return fechaRealizacionCompra;
    }

    public void setFechaRealizacionCompra(LocalDate fechaRealizacionCompra) {
        this.fechaRealizacionCompra = fechaRealizacionCompra;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra=" + codigoCompra +
                ", fechaRealizacionCompra=" + fechaRealizacionCompra +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotalCompra=" + valorTotalCompra +
                '}';
    }
}
