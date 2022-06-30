package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Celular;
import org.example.venta.perfumeria.envio.values.DestinatarioId;
import org.example.venta.perfumeria.envio.values.Direccion;
import org.example.venta.perfumeria.envio.values.EnvioId;

public class DireccionCambiada extends DomainEvent {
    private final Direccion direccion;
    private final EnvioId envioId;
    private final DestinatarioId destinatarioId;

    public DireccionCambiada(EnvioId envioId, DestinatarioId destinatarioId, Direccion direccion) {
        super("org.example.venta.perfumeria.DireccionCambiada");
        this.envioId = envioId;
        this.destinatarioId = destinatarioId;
        this.direccion = direccion;
    }

    public Direccion direccion() {
        return direccion;
    }

    public DestinatarioId destinatarioId() {
        return destinatarioId;
    }

    public EnvioId envioId() {
        return envioId;
    }
}
