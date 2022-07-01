package org.example.venta.perfumeria.perfumeria.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.perfumeria.values.AdministradorId;
import org.example.venta.perfumeria.perfumeria.values.Nombre;

import java.util.Objects;

public class Administrador extends Entity<AdministradorId> {
    protected  Nombre nombre;

    public Administrador(AdministradorId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void cambiarNombre(String nombreAModificar) {
        this.nombre = nombre.cambiarNombre(Objects.requireNonNull(nombreAModificar));
    }

}
