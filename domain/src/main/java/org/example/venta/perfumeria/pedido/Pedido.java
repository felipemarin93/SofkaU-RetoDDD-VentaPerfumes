package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.AggregateEvent;

public class Pedido extends AggregateEvent<PedidoId> {
    public Pedido(PedidoId entityId) {
        super(entityId);
    }
}
