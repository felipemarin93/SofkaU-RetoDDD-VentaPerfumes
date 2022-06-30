package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.DestinatarioId;
import org.example.venta.perfumeria.envio.values.EnvioId;
import org.example.venta.perfumeria.envio.values.Nombre;

public class NombreDomiciliarioCambiado extends DomainEvent {
    private final EnvioId envioId;
    private final Nombre nombre;
    private final DestinatarioId destinatarioId;

    public NombreDomiciliarioCambiado(EnvioId envioId, Nombre nombre, DestinatarioId destinatarioId) {
        super("org.example.venta.perfumeria.NombreDomiciliarioCambiado");
        this.envioId = envioId;
        this.nombre = nombre;
        this.destinatarioId = destinatarioId;
    }

    public EnvioId envioId() {
        return envioId;
    }

    public DestinatarioId destinatarioId() {
        return destinatarioId;
    }

    public Nombre nombre() {
        return nombre;
    }
}
