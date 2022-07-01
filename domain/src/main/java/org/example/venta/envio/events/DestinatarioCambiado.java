package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.Celular;
import org.example.venta.envio.values.Direccion;
import org.example.venta.envio.values.Nombre;

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

    public Celular celular() {
        return celular;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Nombre nombre() {
        return nombre;
    }
}
