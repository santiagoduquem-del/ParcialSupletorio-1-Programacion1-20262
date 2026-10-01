package co.edu.uniquindio.supletorioParcial1;

import co.edu.uniquindio.supletorioParcial1.model.*;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {

    private static Supermercado supermercado = new Supermercado("MarketPlus", "Calle 10 # 5-20", "3001234567");


    /**
     * Menu principal
     * @param args
     */

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = leerEntero("Menu principal - " + supermercado.getNombreComercial() + "\n\n"
                    + "1. Gestionar clientes\n"
                    + "2. Gestionar productos\n"
                    + "3. Gestionar compras\n"
                    + "4. Reporte de ventas por fecha\n"
                    + "5. Reporte de ventas por intervalo de fechas\n"
                    + "0. Salir");

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuProductos();
                    break;
                case 3:
                    menuCompras();
                    break;
                case 4:
                    reporteVentas();
                    break;
                case 5:
                    reporteVentasIntervalo();
                    break;
                case 0:
                    mostrar("Hasta luego");
                    break;
                default:
                    mostrar("Opción no válida");
            }
        } while (opcion != 0);
    }

    /**
     * submenu clientes
     */

    private static void menuClientes() {
        int opcion;
        do {
            opcion = leerEntero("CLIENTES\n\n"
                    + "1. Registrar cliente\n"
                    + "2. Listar clientes\n"
                    + "3. Actualizar cliente\n"
                    + "4. Eliminar cliente\n"
                    + "0. Volver");

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 0:
                    break;
                default:
                    mostrar("Opción no válida");
            }
        } while (opcion != 0);
    }

    /**
     * Opcios de registrar cliente
     */

    private static void registrarCliente() {
        String documento = leerTexto("Documento de identidad:");
        String nombre = leerTexto("Nombre completo:");
        String telefono = leerTexto("Teléfono:");
        String email = leerTexto("Correo electrónico:");

        if (supermercado.registrarCliente(documento, nombre, telefono, email)) {
            mostrar("Cliente registrado");
        } else {
            mostrar("No se pudo registrar (datos vacíos o documento repetido)");
        }
    }

    /**
     * opcion de listar cliente
     */

    private static void listarClientes() {
        if (supermercado.getListClientes().isEmpty()) {
            mostrar("No hay clientes registrados");
            return;
        }
        String texto = "";
        for (Cliente c : supermercado.getListClientes()) {
            texto += c.getDocumentoIdentidad() + " - " + c.getNombreCliente()
                    + " - " + c.getTelefonoCliente() + " - " + c.getEmailCliente() + "\n";
        }
        mostrar(texto);
    }

    /**
     * opcion de actualizar cliente
     */

    private static void actualizarCliente() {
        String documento = leerTexto("Documento del cliente a actualizar:");
        if (supermercado.buscarCliente(documento) == null) {
            mostrar("Cliente no encontrado");
            return;
        }
        String nombre = leerTexto("Nuevo nombre:");
        String telefono = leerTexto("Nuevo teléfono:");
        String email = leerTexto("Nuevo correo:");

        if (supermercado.actualizarCliente(documento, nombre, telefono, email)) {
            mostrar("Cliente actualizado");
        } else {
            mostrar("No se pudo actualizar");
        }
    }

    /**
     * opcion de eliminar cliente
     */

    private static void eliminarCliente() {
        String documento = leerTexto("Documento del cliente a eliminar:");
        if (supermercado.eliminarCliente(documento)) {
            mostrar("Cliente eliminado");
        } else {
            mostrar("No se pudo eliminar (no existe o tiene compras asociadas)");
        }
    }

    /**
     * Submenu producto
     */

    private static void menuProductos() {
        int opcion;
        do {
            opcion = leerEntero("PRODUCTOS\n\n"
                    + "1. Registrar producto\n"
                    + "2. Listar productos\n"
                    + "3. Actualizar producto\n"
                    + "4. Eliminar producto\n"
                    + "0. Volver");

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 0:
                    break;
                default:
                    mostrar("Opción no válida");
            }
        } while (opcion != 0);
    }

    /**
     * opcion de registar producto
     */

    private static void registrarProducto() {
        String codigo = leerTexto("Código del producto:");
        String nombre = leerTexto("Nombre del producto:");
        String categoria = leerTexto("Categoría (Alimentos, Bebidas, Productos de aseo, Cuidado personal):");
        double precio = leerDecimal("Precio unitario:");
        int disponibilidad = leerEntero("Cantidad disponible:");

        if (supermercado.registrarProducto(codigo, nombre, categoria, precio, disponibilidad)) {
            mostrar("Producto registrado");
        } else {
            mostrar("No se pudo registrar (datos inválidos, categoría incorrecta o código repetido)");
        }
    }

    /**
     * Opcion de listar producto
     */

    private static void listarProductos() {
        if (supermercado.getListProductos().isEmpty()) {
            mostrar("No hay productos registrados");
            return;
        }
        String texto = "";
        for (Producto p : supermercado.getListProductos()) {
            texto += p.getCodigoProducto() + " - " + p.getNombreProducto() + " - " + p.getCategoriaProducto()
                    + " - $" + p.getPrecioUnitarioProducto() + " - Disponibles: " + p.getDisponibilidadProducto() + "\n";
        }
        mostrar(texto);
    }

    /**
     * Opcion de actualizar producto
     */
    private static void actualizarProducto() {
        String codigo = leerTexto("Código del producto a actualizar:");
        if (supermercado.buscarProducto(codigo) == null) {
            mostrar("Producto no encontrado");
            return;
        }
        String nombre = leerTexto("Nuevo nombre:");
        String categoria = leerTexto("Nueva categoría (Alimentos, Bebidas, Productos de aseo, Cuidado personal):");
        double precio = leerDecimal("Nuevo precio unitario:");
        int disponibilidad = leerEntero("Nueva cantidad disponible:");

        if (supermercado.actualizarProducto(codigo, nombre, categoria, precio, disponibilidad)) {
            mostrar("Producto actualizado");
        } else {
            mostrar("No se pudo actualizar (datos inválidos)");
        }
    }

    /**
     * opcion de eliminar producto
     */

    private static void eliminarProducto() {
        String codigo = leerTexto("Código del producto a eliminar:");
        if (supermercado.eliminarProducto(codigo)) {
            mostrar("Producto eliminado");
        } else {
            mostrar("Producto no encontrado");
        }
    }

    /**
     * Submenu de compras
     */

    private static void menuCompras() {
        int opcion;
        do {
            opcion = leerEntero("COMPRAS\n\n"
                    + "1. Crear compra\n"
                    + "2. Agregar producto a una compra\n"
                    + "3. Confirmar compra\n"
                    + "4. Ver detalle de una compra\n"
                    + "5. Ver compras de un cliente\n"
                    + "0. Volver");

            switch (opcion) {
                case 1:
                    crearCompra();
                    break;
                case 2:
                    agregarProductoACompra();
                    break;
                case 3:
                    confirmarCompra();
                    break;
                case 4:
                    verDetalleCompra();
                    break;
                case 5:
                    verComprasDeCliente();
                    break;
                case 0:
                    break;
                default:
                    mostrar("Opción no válida");
            }
        } while (opcion != 0);
    }


    /**
     * Opcion crear compra
     */

    private static void crearCompra() {
        Cliente cliente = supermercado.buscarCliente(leerTexto("Documento del cliente:"));
        if (cliente == null) {
            mostrar("Cliente no encontrado");
            return;
        }
        int codigo = leerEntero("Código de la compra:");
        LocalDate fecha = leerFecha("Fecha de la compra (aaaa-mm-dd):");
        String metodoPago = leerTexto("Método de pago (Tarjeta, Transferencia bancaria, Efectivo):");

        if (supermercado.crearCompra(codigo, fecha, metodoPago, cliente)) {
            mostrar("Compra creada. Ahora puede agregarle productos");
        } else {
            mostrar("No se pudo crear (datos inválidos, fecha incorrecta o código repetido)");
        }
    }

    /**
     * Opcion para agrgar el producto a la compra
     */

    private static void agregarProductoACompra() {
        Compra compra = supermercado.buscarCompra(leerEntero("Código de la compra:"));
        if (compra == null) {
            mostrar("Compra no encontrada");
            return;
        }
        Producto producto = supermercado.buscarProducto(leerTexto("Código del producto:"));
        if (producto == null) {
            mostrar("Producto no encontrado");
            return;
        }
        int cantidad = leerEntero("Cantidad a comprar:");

        if (supermercado.agregarProductoACompra(compra, producto, cantidad)) {
            mostrar("Producto agregado. Total actual: $" + compra.getValorTotalCompra());
        } else {
            mostrar("No se pudo agregar (compra ya confirmada, cantidad inválida o sin disponibilidad)");
        }
    }

    /**
     * Opcion para confirmar la compra
     */

    private static void confirmarCompra() {
        Compra compra = supermercado.buscarCompra(leerEntero("Código de la compra:"));
        if (compra == null) {
            mostrar("Compra no encontrada");
            return;
        }
        if (supermercado.confirmarCompra(compra)) {
            mostrar("Compra confirmada. Total a pagar: $" + compra.getValorTotalCompra());
        } else {
            mostrar("No se pudo confirmar (ya está confirmada, no tiene productos o el inventario ya no alcanza)");
        }
    }

    /**
     * Opcion para ver detalles de la compra(resumen)
     */

    private static void verDetalleCompra() {
        Compra compra = supermercado.buscarCompra(leerEntero("Código de la compra:"));
        if (compra == null) {
            mostrar("Compra no encontrada");
            return;
        }
        mostrar(textoCompra(compra));
    }


    /**
     * Opcion para poder ver las compras del cliente
     */

    private static void verComprasDeCliente() {
        Cliente cliente = supermercado.buscarCliente(leerTexto("Documento del cliente:"));
        if (cliente == null) {
            mostrar("Cliente no encontrado");
            return;
        }
        if (cliente.getListCompras().isEmpty()) {
            mostrar("El cliente no tiene compras");
            return;
        }
        String texto = "Compras de " + cliente.getNombreCliente() + ":\n\n";
        for (Compra c : cliente.getListCompras()) {
            texto += textoCompra(c) + "\n\n";
        }
        mostrar(texto);
    }

    /**
     * Mustra mensaje en pantalla referente al estado de la compra
     * @param compra
     * @return
     */

    private static String textoCompra(Compra compra) {
        String estado = "Pendiente";
        if (compra.isConfirmada()) {
            estado = "Confirmada";
        }
        String texto = "Compra " + compra.getCodigoCompra() + " - " + compra.getFechaRealizacionCompra()
                + "\nPago: " + compra.getMetodoPago()
                + "\nEstado: " + estado
                + "\nProductos:\n";
        for (DetalleCompra d : compra.getListDetalleCompras()) {
            texto += "  - " + d.getTheProducto().getNombreProducto() + " x" + d.getCantidadSeleccionada()
                    + " a $" + d.getPrecioAplicado() + " = $" + d.getSubTotal() + "\n";
        }
        texto += "Total: $" + compra.getValorTotalCompra();
        return texto;
    }

    /**
     * Submenu reporte
     *
     */


    /**
     * Mustra el reporte en una fecha ingresada
     */

    private static void reporteVentas() {
        LocalDate fecha = leerFecha("Fecha a consultar (aaaa-mm-dd):");
        if (fecha == null) {
            mostrar("Fecha no válida");
            return;
        }
        double total = supermercado.calcularVentasPorFecha(fecha);
        mostrar("Total vendido el " + fecha + ": $" + total);
    }


    /**
     * Mustra el reporte en un periodo dado
     */

    private static void reporteVentasIntervalo() {
        LocalDate fechaInicio = leerFecha("Fecha de inicio (aaaa-mm-dd):");
        LocalDate fechaFin = leerFecha("Fecha de fin (aaaa-mm-dd):");
        if (fechaInicio == null || fechaFin == null) {
            mostrar("Fecha no válida");
            return;
        }
        if (fechaInicio.isAfter(fechaFin)) {
            mostrar("La fecha de inicio no puede ser posterior a la fecha de fin");
            return;
        }
        double total = supermercado.calcularVentasPorIntervalo(fechaInicio, fechaFin);
        mostrar("Total vendido entre " + fechaInicio + " y " + fechaFin + ": $" + total);
    }

    /**
     * Metodos que sirven para la lectura de datos
     * @param mensaje
     */

    private static void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static String leerTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        if (texto == null) {
            return "";
        }
        return texto.trim();
    }

    // Devuelve -1 si el dato no es un número entero
    private static int leerEntero(String mensaje) {
        try {
            return Integer.parseInt(leerTexto(mensaje));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Devuelve -1 si el dato no es un número
    private static double leerDecimal(String mensaje) {
        try {
            return Double.parseDouble(leerTexto(mensaje));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Devuelve null si la fecha no tiene el formato correcto
    private static LocalDate leerFecha(String mensaje) {
        try {
            return LocalDate.parse(leerTexto(mensaje));
        } catch (Exception e) {
            return null;
        }
    }
}