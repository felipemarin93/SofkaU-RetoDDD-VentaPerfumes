package org.example.venta.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.values.*;
import org.example.venta.pedido.values.PedidoId;

public class CrearEnvio extends Command {

    private final PedidoId pedidoId;
    private final EnvioId envioId;
    private final Fecha fecha;

    public CrearEnvio(PedidoId pedidoId, EnvioId envioId, Fecha fecha){

        this.pedidoId = pedidoId;
        this.envioId = envioId;
        this.fecha = fecha;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
