package org.example.venta.perfumeria.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.values.Marca;
import org.example.venta.perfumeria.envio.values.Tipo;
import org.example.venta.perfumeria.envio.values.VehiculoId;

public class VehiculoAgregado extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final Tipo tipo;
    private final Marca marca;

    public VehiculoAgregado(VehiculoId vehiculoId, Tipo tipo, Marca marca) {
        super("org.example.venta.perfumeria.VehiculoAgregado");
        this.vehiculoId = vehiculoId;
        this.tipo = tipo;
        this.marca = marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }
}