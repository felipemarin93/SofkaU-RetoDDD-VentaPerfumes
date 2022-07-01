package org.example.venta.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.envio.values.Marca;
import org.example.venta.envio.values.Tipo;
import org.example.venta.envio.values.VehiculoId;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {
    protected Tipo tipo;
    protected Marca marca;

    public Vehiculo(VehiculoId entityId, Tipo tipo, Marca marca) {
        super(entityId);
        this.tipo = tipo;
        this.marca = marca;
    }

    public Marca marca() {
        return marca;
    }

    public Tipo tipo() {
        return tipo;
    }

    public void cambiarTipoVehiculo(Tipo tipo) {
        this.tipo = Objects.requireNonNull(tipo);
    }
}
