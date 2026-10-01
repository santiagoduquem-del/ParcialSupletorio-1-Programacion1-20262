package co.edu.uniquindio.supletorioParcial1.model;

public class Producto {

    private String codigoProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private double precioUnitarioProducto;
    private int disponibilidadProducto;

    public Producto(String codigoProducto, String nombreProducto, String categoriaProducto, double precioUnitarioProducto, int disponibilidadProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioUnitarioProducto = precioUnitarioProducto;
        this.disponibilidadProducto = disponibilidadProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(double precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public int getDisponibilidadProducto() {
        return disponibilidadProducto;
    }

    public void setDisponibilidadProducto(int disponibilidadProducto) {
        this.disponibilidadProducto = disponibilidadProducto;
    }

    /**
     * Metodo para verificar si la categoria del producto es valida
     * @param categoria
     * @return
     */

    public static boolean esCategoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("Alimentos")
                || categoria.equalsIgnoreCase("Bebidas")
                || categoria.equalsIgnoreCase("Productos de aseo")
                || categoria.equalsIgnoreCase("Cuidado personal");
    }

    /**
     * Metodo para verificar si hay unidades suficientes del producto
     * @param cantidad
     * @return
     */

    public boolean hayDisponibilidad(int cantidad) {
        return disponibilidadProducto >= cantidad;
    }

    /**
     * Metodo para descontar unidades del inventario
     * @param cantidad
     */

    public void descontarInventario(int cantidad) {
        disponibilidadProducto -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", categoriaProducto='" + categoriaProducto + '\'' +
                ", precioUnitarioProducto=" + precioUnitarioProducto +
                ", disponibilidadProducto=" + disponibilidadProducto +
                '}';
    }
}