package org.example.venta.perfumeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.entities.Administrador;
import org.example.venta.perfumeria.values.Direccion;

public class PerfumeriaCreada extends DomainEvent {


    private Administrador administrador;
    private Direccion direccion;

    public PerfumeriaCreada(Administrador Administrador, Direccion direccion) {
        super("co.com.sofkau.entrenamiento.heladeria.HeladeriaCreada");

        this.administrador = Administrador;
        this.direccion = direccion;
    }


    public Direccion direccion() {
        return direccion;
    }
    public Administrador administrador() {
        return administrador;
    }
}
