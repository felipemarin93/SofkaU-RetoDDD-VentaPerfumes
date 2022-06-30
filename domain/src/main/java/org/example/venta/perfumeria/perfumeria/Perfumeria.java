package org.example.venta.perfumeria.perfumeria;

import co.com.sofka.domain.generic.AggregateEvent;

public class Perfumeria extends AggregateEvent<PerfumeriaId> {


    protected Nombre nombre;

    public Perfumeria(PerfumeriaId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }
}
