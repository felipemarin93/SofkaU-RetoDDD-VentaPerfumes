package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class Producto extends Entity<ProductoId> {
    public Producto(ProductoId entityId) {
        super(entityId);

    }
}
