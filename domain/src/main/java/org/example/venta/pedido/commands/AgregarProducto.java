package org.example.venta.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.pedido.values.Cantidad;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.pedido.values.ProductoId;

public class AgregarProducto extends Command {

    private final PedidoId pedidoId;
    private final ProductoId productoId;
    private final Nombre nombre;
    private final Cantidad cantidad;

    public AgregarProducto(PedidoId pedidoId,ProductoId productoId, Nombre nombre, Cantidad cantidad){
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
