package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.pedido.values.Cantidad;
import org.example.venta.perfumeria.pedido.values.Nombre;
import org.example.venta.perfumeria.pedido.values.PedidoId;
import org.example.venta.perfumeria.pedido.values.ProductoId;

public class CantidadProductoCambiada extends DomainEvent {

    private final ProductoId productoId;
    private final Cantidad cantidad;

    public CantidadProductoCambiada(ProductoId productoId,Cantidad cantidad) {
        super("org.example.venta.perfumeria.CantidadProductoCambiada");

        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Cantidad cantidad() {
        return cantidad;
    }

    public ProductoId productoId() {
        return productoId;
    }


}
