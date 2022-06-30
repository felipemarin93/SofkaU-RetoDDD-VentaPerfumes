package org.example.venta.perfumeria.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.pedido.values.Detalle;
import org.example.venta.perfumeria.pedido.values.FacturaId;
import org.example.venta.perfumeria.pedido.values.Precio;

public class FacturaAgregada extends DomainEvent {
    private final FacturaId facturaId;
    private final Precio precio;
    private final Detalle detalle;

    public FacturaAgregada(FacturaId facturaId, Precio precio, Detalle detalle) {
        super("org.example.venta.perfumeria.FacturaAgregada");
        this.facturaId = facturaId;
        this.precio = precio;
        this.detalle = detalle;
    }

    public Detalle detalle() {
        return detalle;
    }

    public FacturaId facturaId() {
        return facturaId;
    }

    public Precio precio() {
        return precio;
    }
}
