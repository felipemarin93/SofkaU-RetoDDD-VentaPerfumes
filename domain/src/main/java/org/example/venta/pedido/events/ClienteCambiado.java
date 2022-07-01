package org.example.venta.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.entities.Cliente;

public class ClienteCambiado extends DomainEvent {
    private final Cliente cliente;


    public ClienteCambiado(Cliente cliente) {
        super("org.example.venta.perfumeria.ClienteAgregado");
        this.cliente = cliente;

    }

    public Cliente cliente() {
        return cliente;
    }
}
