package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Fecha;
import org.example.venta.perfumeria.envio.entities.Destinatario;
import org.example.venta.perfumeria.pedido.values.PedidoId;

public class EnvioCreado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Fecha fecha;


    public EnvioCreado(PedidoId pedidoId, Fecha fecha) {
        super("org.example.venta.perfumeria.EnvioCreado");

        this.pedidoId = pedidoId;
        this.fecha = fecha;

    }

    public Fecha fecha() {
        return fecha;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }


}
