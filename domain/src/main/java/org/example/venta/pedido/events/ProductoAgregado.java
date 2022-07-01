package org.example.venta.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.values.Cantidad;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.ProductoId;

public class ProductoAgregado extends DomainEvent {
    private final ProductoId productoId;
    private final Nombre nombre;
    private final Cantidad cantidad;

    public ProductoAgregado(ProductoId productoId, Nombre nombre, Cantidad cantidad) {
        super("org.example.venta.perfumeria.ProductoAgregado");
        this.productoId = productoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public ProductoId productoId() {
        return productoId;
    }

    public Cantidad cantidad() {
        return cantidad;
    }


}
