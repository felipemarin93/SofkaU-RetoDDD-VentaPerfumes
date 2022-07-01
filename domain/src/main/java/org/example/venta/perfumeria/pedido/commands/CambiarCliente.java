package org.example.venta.perfumeria.pedido.commands;

import org.example.venta.perfumeria.pedido.entities.Cliente;
import org.example.venta.perfumeria.pedido.values.PedidoId;

public class CambiarCliente {

    private final PedidoId pedidoId;
    private final Cliente cliente;

    public CambiarCliente(PedidoId pedidoId, Cliente cliente){

        this.pedidoId = pedidoId;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
