package co.edu.uniquindio.supletorioParcial1.model;

public class DetalleCompra {

    private int cantidadSeleccionada;
    private double precioAplicado;
    private double subTotal;

    private Producto theProducto;

    public DetalleCompra(Producto theProducto, int cantidadSeleccionada, double precioAplicado, double subTotal) {
        this.theProducto = theProducto;
        this.cantidadSeleccionada = cantidadSeleccionada;
        this.precioAplicado = precioAplicado;
        this.subTotal = subTotal;
    }

    public int getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(int cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }

    public double getPrecioAplicado() {
        return precioAplicado;
    }

    public void setPrecioAplicado(double precioAplicado) {
        this.precioAplicado = precioAplicado;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getTheProducto() {
        return theProducto;
    }

    public void setTheProducto(Producto theProducto) {
        this.theProducto = theProducto;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "producto=" + theProducto.getNombreProducto() +
                ", cantidadSeleccionada=" + cantidadSeleccionada +
                ", precioAplicado=" + precioAplicado +
                ", subTotal=" + subTotal +
                '}';
    }
}