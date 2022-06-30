package org.example.venta.perfumeria.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.pedido.values.Cantidad;
import org.example.venta.perfumeria.pedido.values.Nombre;
import org.example.venta.perfumeria.pedido.values.ProductoId;

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

    public Nombre getNombre() {
        return nombre;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }


}
