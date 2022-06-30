package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.ValueObject;

public class Factura extends Entity<FacturaId> {

    public Factura(FacturaId entityId) {
        super(entityId);
    }
}
