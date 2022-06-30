package org.example.venta.perfumeria.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.pedido.values.ClienteId;

public class Cliente extends Entity<ClienteId> {
    public Cliente(ClienteId entityId) {
        super(entityId);
    }
}
