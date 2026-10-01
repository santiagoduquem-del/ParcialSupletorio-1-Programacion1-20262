package co.edu.uniquindio.supletorioParcial1.model;

public class Producto {

    private String codigoProducto;
    private String nombreProducto;
    private String CategoriaProducto;
    private double precioUnitarioProducto;
    private double disponibilidadProducto;

    public Producto(String codigoProducto, String nombreProducto, String categoriaProducto, double precioUnitarioProducto, double disponibilidadProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        CategoriaProducto = categoriaProducto;
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
        return CategoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        CategoriaProducto = categoriaProducto;
    }

    public double getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(double precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public double getDisponibilidadProducto() {
        return disponibilidadProducto;
    }

    public void setDisponibilidadProducto(double disponibilidadProducto) {
        this.disponibilidadProducto = disponibilidadProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", CategoriaProducto='" + CategoriaProducto + '\'' +
                ", precioUnitarioProducto='" + precioUnitarioProducto + '\'' +
                ", disponibilidadProducto='" + disponibilidadProducto + '\'' +
                '}';
    }
}
