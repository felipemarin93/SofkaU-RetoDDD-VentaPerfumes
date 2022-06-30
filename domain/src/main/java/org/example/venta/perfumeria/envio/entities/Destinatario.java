package org.example.venta.perfumeria.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.envio.values.DestinatarioId;

public class Destinatario extends Entity<DestinatarioId> {
    public Destinatario(DestinatarioId entityId) {
        super(entityId);
    }
}
