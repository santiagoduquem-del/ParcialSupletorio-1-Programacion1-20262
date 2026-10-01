package co.edu.uniquindio.supletorioParcial1.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String documentoIdentidad;
    private String nombreCliente;
    private String telefonoCliente;
    private String emailCliente;

    private List<Compra> listCompras;

    public Cliente(String documentoIdentidad, String nombreCliente, String telefonoCliente, String emailCliente) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.listCompras = new ArrayList<>();
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public List<Compra> getListCompras() {
        return listCompras;
    }

    public void setListCompras(List<Compra> listCompras) {
        this.listCompras = listCompras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", emailCliente='" + emailCliente + '\'' +
                '}';
    }
}