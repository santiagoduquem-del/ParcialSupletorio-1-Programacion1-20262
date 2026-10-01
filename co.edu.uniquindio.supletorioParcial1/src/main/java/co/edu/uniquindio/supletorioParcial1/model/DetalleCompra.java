package co.edu.uniquindio.supletorioParcial1.model;

public class DetalleCompra {

    private Producto producto;
    private int cantidadSeleccionada;
    private double precioAplicado;
    private double subTotal;

    // Constructor que calcula automáticamente el subtotal al instanciar
    public DetalleCompra(Producto producto, int cantidadSeleccionada) {
        this.producto = producto;
        this.cantidadSeleccionada = cantidadSeleccionada;
        this.precioAplicado = producto.getPrecioUnitarioProducto();
        this.subTotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return this.cantidadSeleccionada * this.precioAplicado;
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.precioAplicado = producto.getPrecioUnitarioProducto();
        this.subTotal = calcularSubtotal();
    }

    public int getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(int cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
        this.subTotal = calcularSubtotal();
    }

    public double getPrecioAplicado() {
        return precioAplicado;
    }

    public double getSubTotal() {
        return subTotal;
    }
}

