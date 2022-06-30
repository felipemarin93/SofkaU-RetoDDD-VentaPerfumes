package org.example.venta.perfumeria.perfumeria;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class PerfumeriaCreada extends DomainEvent {


    protected Administrador administrador;
    private Direccion direccion;

    public PerfumeriaCreada(Administrador Administrador, Direccion direccion) {
        super("co.com.sofkau.entrenamiento.heladeria.HeladeriaCreada");


        this.administrador = Administrador;
        this.direccion = direccion;
    }


    public Direccion getDireccion() {
        return direccion;
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
