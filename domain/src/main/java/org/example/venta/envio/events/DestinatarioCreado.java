package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.DestinatarioId;
import org.example.venta.envio.values.Celular;
import org.example.venta.envio.values.Direccion;
import org.example.venta.envio.values.Nombre;

public class DestinatarioCreado extends DomainEvent {
    private final Nombre nombre;
    private final Direccion direccion;
    private final Celular celular;
    private final DestinatarioId destinatarioId;

    public DestinatarioCreado(Nombre nombre, Direccion direccion, Celular celular, DestinatarioId destinatarioId) {
        super("org.example.venta.perfumeria.DestinatarioCreado");
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.destinatarioId = destinatarioId;
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

    public DestinatarioId destinatarioId() {
        return destinatarioId;
    }
}
