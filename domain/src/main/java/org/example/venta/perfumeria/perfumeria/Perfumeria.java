package org.example.venta.perfumeria.perfumeria;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.venta.perfumeria.pedido.events.PedidoCreado;

public class Perfumeria extends AggregateEvent<PerfumeriaId> {



    protected Direccion direccion;
    protected Administrador administrador;

    protected Vendedor vendedor;

    protected Proveedor proveedor;

    public Perfumeria(PerfumeriaId entityId, Administrador administrador, Direccion direccion) {
        super(entityId);
        appendChange(new PerfumeriaCreada(administrador,direccion)).apply();
        subscribe(new PerfumeriaEventChange(this));
    }
}
