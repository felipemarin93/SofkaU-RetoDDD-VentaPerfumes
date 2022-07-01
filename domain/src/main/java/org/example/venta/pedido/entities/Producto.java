package org.example.venta.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.pedido.values.Cantidad;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.ProductoId;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {
    protected Nombre nombre;
    protected Cantidad cantidad;

    public Producto(ProductoId entityId, Nombre nombre, Cantidad cantidad) {
        super(entityId);

        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void  cambiarCantidad(Cantidad cantidadAmodificar){
        this.cantidad = cantidad.cambiarCantidad(Objects.requireNonNull(cantidadAmodificar).value());
    }


}
