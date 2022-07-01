package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.DestinatarioId;
import org.example.venta.envio.values.Celular;
import org.example.venta.envio.values.EnvioId;

public class CelularDestinatarioCambiado extends DomainEvent {
    private final EnvioId envioId;
    private final Celular celular;
    private final DestinatarioId destinatarioId;

    public CelularDestinatarioCambiado(EnvioId envioId, Celular celular, DestinatarioId destinatarioId) {
        super("org.example.venta.perfumeria.CelularDestinatarioCambiado");

        this.envioId = envioId;
        this.celular = celular;
        this.destinatarioId = destinatarioId;
    }

    public Celular celular() {
        return celular;
    }

    public DestinatarioId destinatarioId() {
        return destinatarioId;
    }

    public EnvioId envioId() {
        return envioId;
    }
}
