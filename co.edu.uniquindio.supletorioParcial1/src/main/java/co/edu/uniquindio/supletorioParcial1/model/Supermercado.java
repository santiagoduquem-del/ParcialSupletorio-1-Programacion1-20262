package co.edu.uniquindio.supletorioParcial1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private String nombreComercial;
    private String direccion;
    private String telefono;

    private List<Cliente> listClientes;
    private List<Producto> listProductos;
    private List<Compra> listCompras;

    public Supermercado(String nombreComercial, String direccion, String telefono) {
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listClientes = new ArrayList<>();
        this.listProductos = new ArrayList<>();
        this.listCompras = new ArrayList<>();
    }

    /**
     * Metodo para poder registrar los clientes
     * @param documento
     * @param nombre
     * @param telefono
     * @param email
     * @return
     */

    public boolean registrarCliente(String documento, String nombre, String telefono, String email) {
        if (documento.isEmpty() || nombre.isEmpty()) {
            return false;
        }
        if (buscarCliente(documento) != null) {
            return false; // documento repetido
        }
        listClientes.add(new Cliente(documento, nombre, telefono, email));
        return true;
    }

    /**
     * Metododo para buscar a clientes
     * @param documento
     * @return
     */

    public Cliente buscarCliente(String documento) {
        for (Cliente c : listClientes) {
            if (c.getDocumentoIdentidad().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo para poder actualizar los datos del cliente
     * @param documento
     * @param nombre
     * @param telefono
     * @param email
     * @return
     */

    public boolean actualizarCliente(String documento, String nombre, String telefono, String email) {
        Cliente c = buscarCliente(documento);
        if (c == null || nombre.isEmpty()) {
            return false;
        }
        c.setNombreCliente(nombre);
        c.setTelefonoCliente(telefono);
        c.setEmailCliente(email);
        return true;
    }

    /**
     * Metodo para poder eliminar al cliente
     * @param documento
     * @return
     */

    public boolean eliminarCliente(String documento) {
        Cliente c = buscarCliente(documento);
        if (c == null || !c.getListCompras().isEmpty()) {
            return false; // no existe o ya tiene compras asociadas
        }
        listClientes.remove(c);
        return true;
    }



    /**
     * Metodo para registrar producto
     * @param codigo
     * @param nombre
     * @param categoria
     * @param precio
     * @param disponibilidad
     * @return
     */

    public boolean registrarProducto(String codigo, String nombre, String categoria, double precio, int disponibilidad) {
        if (codigo.isEmpty() || nombre.isEmpty() || precio <= 0 || disponibilidad < 0) {
            return false;
        }
        if (!Producto.esCategoriaValida(categoria) || buscarProducto(codigo) != null) {
            return false;
        }
        listProductos.add(new Producto(codigo, nombre, categoria, precio, disponibilidad));
        return true;
    }


    /**
     * Metodo para buscar un producto
     * @param codigo
     * @return
     */

    public Producto buscarProducto(String codigo) {
        for (Producto p : listProductos) {
            if (p.getCodigoProducto().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Metodo para actualizar un producto
     * @param codigo
     * @param nombre
     * @param categoria
     * @param precio
     * @param disponibilidad
     * @return
     */

    public boolean actualizarProducto(String codigo, String nombre, String categoria, double precio, int disponibilidad) {
        Producto p = buscarProducto(codigo);
        if (p == null || nombre.isEmpty() || precio <= 0 || disponibilidad < 0 || !Producto.esCategoriaValida(categoria)) {
            return false;
        }
        p.setNombreProducto(nombre);
        p.setCategoriaProducto(categoria);
        p.setPrecioUnitarioProducto(precio);
        p.setDisponibilidadProducto(disponibilidad);
        return true;
    }

    /**
     * Metodo para eliminar un producto
     * @param codigo
     * @return
     */

    public boolean eliminarProducto(String codigo) {
        Producto p = buscarProducto(codigo);
        if (p == null) {
            return false;
        }
        listProductos.remove(p);
        return true;
    }

    /**
     * Metodo para crear compra
     * @param codigo
     * @param fecha
     * @param metodoPago
     * @param cliente
     * @return
     */

    public boolean crearCompra(int codigo, LocalDate fecha, String metodoPago, Cliente cliente) {
        if (codigo <= 0 || fecha == null || cliente == null || !Compra.esMetodoPagoValido(metodoPago)) {
            return false;
        }
        if (buscarCompra(codigo) != null) {
            return false; // código repetido
        }
        Compra compra = new Compra(codigo, fecha, metodoPago, cliente);
        listCompras.add(compra);
        cliente.getListCompras().add(compra);
        return true;
    }


    /**
     * Metodo para buscar compra
     * @param codigo
     * @return
     */

    public Compra buscarCompra(int codigo) {
        for (Compra c : listCompras) {
            if (c.getCodigoCompra() == codigo) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo para agregar producto a la compra
     * @param compra
     * @param producto
     * @param cantidad
     * @return
     */

    // Valida disponibilidad antes de agregar el producto a la compra
    public boolean agregarProductoACompra(Compra compra, Producto producto, int cantidad) {
        if (compra.isConfirmada() || cantidad <= 0) {
            return false;
        }
        // si el producto ya estaba en la compra se suma lo ya seleccionado
        int total = cantidad + compra.cantidadYaSeleccionada(producto);
        if (!producto.hayDisponibilidad(total)) {
            return false;
        }
        double precio = producto.getPrecioUnitarioProducto();
        compra.getListDetalleCompras().add(new DetalleCompra(producto, cantidad, precio));
        compra.setValorTotalCompra(compra.calcularTotal());
        return true;
    }

    /**
     * Metodo para confirmamr la compra
     * @param compra
     * @return
     */

    // Al confirmar se actualiza el inventario
    public boolean confirmarCompra(Compra compra) {
        if (compra.isConfirmada() || compra.getListDetalleCompras().isEmpty()) {
            return false;
        }
        // revalida la disponibilidad, porque otra compra pudo haber consumido el inventario
        for (DetalleCompra d : compra.getListDetalleCompras()) {
            Producto p = d.getTheProducto();
            if (!p.hayDisponibilidad(compra.cantidadYaSeleccionada(p))) {
                return false;
            }
        }
        for (DetalleCompra d : compra.getListDetalleCompras()) {
            Producto p = d.getTheProducto();
            p.descontarInventario(d.getCantidadSeleccionada());
        }
        compra.setConfirmada(true);
        return true;
    }

    /**
     * Metodo para calcular ventas en una fecha determinada
     * @param fecha
     * @return
     */

    public double calcularVentasPorFecha(LocalDate fecha) {
        double total = 0;
        for (Compra c : listCompras) {
            if (c.isConfirmada() && c.getFechaRealizacionCompra().equals(fecha)) {
                total += c.getValorTotalCompra();
            }
        }
        return total;
    }

    /**
     * Metodo para calcular ventas en un periodo
     * @param fechaInicio
     * @param fechaFin
     * @return
     */

    // Incluye tanto la fecha de inicio como la fecha de fin
    public double calcularVentasPorIntervalo(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = 0;
        for (Compra c : listCompras) {
            LocalDate fecha = c.getFechaRealizacionCompra();
            if (c.isConfirmada() && !fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                total += c.getValorTotalCompra();
            }
        }
        return total;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Compra> getListCompras() {
        return listCompras;
    }

    public void setListCompras(List<Compra> listCompras) {
        this.listCompras = listCompras;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}