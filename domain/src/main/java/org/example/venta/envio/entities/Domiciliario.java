package org.example.venta.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.envio.values.DomiciliarioId;
import org.example.venta.envio.values.Nombre;

import java.util.Objects;

public class Domiciliario extends Entity<DomiciliarioId> {
    protected Nombre nombre;

    public Domiciliario(DomiciliarioId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public void cambiarNombre(String nombreAModificar) {
        this.nombre = nombre.cambiarNombre(Objects.requireNonNull(nombreAModificar));
    }
}
