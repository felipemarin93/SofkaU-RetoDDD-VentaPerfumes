package org.example.venta.pedido.commands;

import org.example.venta.pedido.values.Detalle;
import org.example.venta.pedido.values.FacturaId;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.pedido.values.Precio;

public class AgregarFactura {

    private final PedidoId pedidoId;
    private final FacturaId facturaId;
    private final Precio precio;
    private final Detalle detalle;

    public AgregarFactura(PedidoId pedidoId, FacturaId facturaId, Precio precio, Detalle detalle){

        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
        this.precio = precio;
        this.detalle = detalle;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
