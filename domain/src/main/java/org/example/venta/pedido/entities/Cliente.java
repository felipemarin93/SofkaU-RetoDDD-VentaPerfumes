package org.example.venta.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.pedido.values.ClienteId;

public class Cliente extends Entity<ClienteId> {
    public Cliente(ClienteId entityId) {
        super(entityId);
    }
}
