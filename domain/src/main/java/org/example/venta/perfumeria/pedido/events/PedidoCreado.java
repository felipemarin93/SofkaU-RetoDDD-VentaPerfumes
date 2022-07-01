package org.example.venta.perfumeria.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.pedido.entities.Cliente;
import org.example.venta.perfumeria.perfumeria.values.PerfumeriaId;

public class PedidoCreado extends DomainEvent {
    private final PerfumeriaId perfumeriaId;
    private final Cliente cliente;

    public PedidoCreado(PerfumeriaId perfumeriaId, Cliente cliente) {
        super("org.example.venta.perfumeria.PedidoCreado");
        this.perfumeriaId = perfumeriaId;
        this.cliente = cliente;
    }

    public Cliente cliente() {
        return cliente;
    }

    public PerfumeriaId perfumeriaId() {
        return perfumeriaId;
    }
}
