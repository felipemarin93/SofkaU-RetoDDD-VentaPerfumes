package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.entities.Destinatario;
import org.example.venta.envio.values.EnvioId;

public class DestinatarioAgregado extends DomainEvent {
    private final EnvioId envioId;
    private final Destinatario destinatario;

    public DestinatarioAgregado(EnvioId envioId, Destinatario destinatario) {
        super("org.example.venta.perfumeria.DestinatarioAgregado");
        this.envioId = envioId;
        this.destinatario = destinatario;
    }

    public EnvioId envioId() {
        return envioId;
    }

    public Destinatario destinatario() {
        return destinatario;
    }
}
