package org.example.venta.perfumeria.pedido.commands;

import org.example.venta.perfumeria.pedido.values.Cantidad;
import org.example.venta.perfumeria.pedido.values.PedidoId;
import org.example.venta.perfumeria.pedido.values.ProductoId;

public class CambiarCantidadProducto {

    private final PedidoId pedidoId;
    private final ProductoId productoId;
    private final Cantidad cantidad;

    public CambiarCantidadProducto(PedidoId pedidoId, ProductoId productoId, Cantidad cantidad){
        this.pedidoId = pedidoId;

        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
