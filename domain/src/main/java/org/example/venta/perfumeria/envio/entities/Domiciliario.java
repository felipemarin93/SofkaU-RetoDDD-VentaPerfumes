package org.example.venta.perfumeria.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.envio.values.DomiciliarioId;
import org.example.venta.perfumeria.envio.values.Nombre;

public class Domiciliario extends Entity<DomiciliarioId> {
    protected Nombre nombre;

    public Domiciliario(DomiciliarioId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
