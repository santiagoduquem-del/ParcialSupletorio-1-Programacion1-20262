package co.edu.uniquindio.supletorioParcial1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private int codigoCompra;
    private LocalDate fechaRealizacionCompra;
    private String metodoPago;
    private double valorTotalCompra;
    private boolean confirmada;

    private Cliente theCliente;
    private List<DetalleCompra> listDetalleCompras;

    public Compra(int codigoCompra, LocalDate fechaRealizacionCompra, String metodoPago, Cliente theCliente) {
        this.codigoCompra = codigoCompra;
        this.fechaRealizacionCompra = fechaRealizacionCompra;
        this.metodoPago = metodoPago;
        this.theCliente = theCliente;
        this.valorTotalCompra = 0;
        this.confirmada = false;
        this.listDetalleCompras = new ArrayList<>();
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

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public Cliente getTheCliente() {
        return theCliente;
    }

    public void setTheCliente(Cliente theCliente) {
        this.theCliente = theCliente;
    }

    public List<DetalleCompra> getListDetalleCompras() {
        return listDetalleCompras;
    }

    public void setListDetalleCompras(List<DetalleCompra> listDetalleCompras) {
        this.listDetalleCompras = listDetalleCompras;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigoCompra=" + codigoCompra +
                ", fechaRealizacionCompra=" + fechaRealizacionCompra +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotalCompra=" + valorTotalCompra +
                ", confirmada=" + confirmada +
                '}';
    }
}