package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.DomiciliarioId;
import org.example.venta.envio.values.Nombre;

public class DomiciliarioAgregado extends DomainEvent {
    private final DomiciliarioId domiciliarioId;
    private final Nombre nombre;

    public DomiciliarioAgregado(DomiciliarioId domiciliarioId, Nombre nombre) {
        super("org.example.venta.perfumeria.DomiciliarioAgregado");
        this.domiciliarioId = domiciliarioId;
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }

    public DomiciliarioId domiciliarioId() {
        return domiciliarioId;
    }
}
