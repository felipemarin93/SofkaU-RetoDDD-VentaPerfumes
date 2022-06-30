package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Direccion;

public class DireccionCambiada extends DomainEvent {
    private final Direccion direccion;

    public DireccionCambiada(Direccion direccion) {
        super("org.example.venta.perfumeria.DireccionCambiada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
