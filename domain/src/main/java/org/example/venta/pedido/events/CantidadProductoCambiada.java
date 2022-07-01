package org.example.venta.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.values.Cantidad;
import org.example.venta.pedido.values.ProductoId;

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
