package org.example.venta.perfumeria.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.envio.values.Marca;
import org.example.venta.perfumeria.envio.values.Tipo;
import org.example.venta.perfumeria.envio.values.VehiculoId;

public class Vehiculo extends Entity<VehiculoId> {
    protected Tipo tipo;
    protected Marca marca;

    public Vehiculo(VehiculoId entityId, Tipo tipo, Marca marca) {
        super(entityId);
        this.tipo = tipo;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
