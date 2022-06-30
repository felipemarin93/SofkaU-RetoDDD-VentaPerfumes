package org.example.venta.perfumeria.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.pedido.values.Detalle;
import org.example.venta.perfumeria.pedido.values.FacturaId;
import org.example.venta.perfumeria.pedido.values.Precio;

public class Factura extends Entity<FacturaId> {

    private final Precio precio;
    private final Detalle detalle;

    public Factura(FacturaId entityId, Precio precio, Detalle detalle) {
        super(entityId);
        this.precio = precio;
        this.detalle = detalle;
    }
}
