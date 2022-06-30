package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Celular;
import org.example.venta.perfumeria.envio.values.Direccion;
import org.example.venta.perfumeria.envio.values.Nombre;

public class DestinatarioCambiado extends DomainEvent {
    private final Nombre nombre;
    private final Direccion direccion;
    private final Celular celular;

    public DestinatarioCambiado(Nombre nombre, Direccion direccion, Celular celular) {
        super("org.example.venta.perfumeria.DestinatarioCambiado");
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
    }

    public Celular getCelular() {
        return celular;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
