package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.EnvioId;
import org.example.venta.envio.values.Fecha;
import org.example.venta.pedido.values.PedidoId;

public class EnvioCreado extends DomainEvent {
    private final EnvioId envioId;
    private final PedidoId pedidoId;
    private final Fecha fecha;


    public EnvioCreado(EnvioId envioId, PedidoId pedidoId, Fecha fecha) {
        super("org.example.venta.perfumeria.EnvioCreado");
        this.envioId = envioId;

        this.pedidoId = pedidoId;
        this.fecha = fecha;

    }

    public Fecha fecha() {
        return fecha;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }

    public EnvioId envioId() {
        return envioId;
    }
}
