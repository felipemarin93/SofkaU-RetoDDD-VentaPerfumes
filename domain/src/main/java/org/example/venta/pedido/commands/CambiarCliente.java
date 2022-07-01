package org.example.venta.pedido.commands;

import org.example.venta.pedido.entities.Cliente;
import org.example.venta.pedido.values.PedidoId;

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
