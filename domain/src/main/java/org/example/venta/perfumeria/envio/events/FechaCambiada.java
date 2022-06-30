package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Fecha;

public class FechaCambiada extends DomainEvent {
    private final Fecha fecha;

    public FechaCambiada(Fecha fecha) {
        super("org.example.venta.perfumeria.FechaCambiada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
