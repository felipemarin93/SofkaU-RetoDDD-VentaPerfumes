package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Fecha;
import org.example.venta.perfumeria.envio.entities.Destinatario;
import org.example.venta.perfumeria.pedido.PedidoId;

public class EnvioCreado extends DomainEvent {
    private final PedidoId pedidoId;
    private final Fecha fecha;
    private final Destinatario destinatario;

    public EnvioCreado(PedidoId pedidoId, Fecha fecha, Destinatario destinatario) {
        super("org.example.venta.perfumeria.EnvioCreado");

        this.pedidoId = pedidoId;
        this.fecha = fecha;
        this.destinatario = destinatario;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }
}
