package org.example.venta.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.pedido.values.Detalle;
import org.example.venta.pedido.values.FacturaId;
import org.example.venta.pedido.values.Precio;

public class Factura extends Entity<FacturaId> {

    private final Precio precio;
    private final Detalle detalle;

    public Factura(FacturaId entityId, Precio precio, Detalle detalle) {
        super(entityId);
        this.precio = precio;
        this.detalle = detalle;
    }

}
