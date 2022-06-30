package org.example.venta.perfumeria.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.pedido.values.Cantidad;
import org.example.venta.perfumeria.pedido.values.Nombre;
import org.example.venta.perfumeria.pedido.values.ProductoId;

public class Producto extends Entity<ProductoId> {
    protected Nombre nombre;
    protected Cantidad cantidad;

    public Producto(ProductoId entityId, Nombre nombre, Cantidad cantidad) {
        super(entityId);

        this.nombre = nombre;
        this.cantidad = cantidad;
    }


    public Cantidad getCantidad() {
        return cantidad;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
