package org.example.venta.perfumeria.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.values.Nit;
import org.example.venta.perfumeria.values.Nombre;
import org.example.venta.perfumeria.values.ProveedorId;
import org.example.venta.perfumeria.values.Telefono;

import java.util.Objects;

public class Proveedor extends Entity<ProveedorId> {
    protected Nombre nombre;
    protected Nit nit;
    protected Telefono telefono;

    public Proveedor(ProveedorId entityId, Nombre nombre , Nit nit , Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }
    public Nombre nombre() {
        return nombre;
    }
    public Telefono telefono() {
        return telefono;
    }
    public Nit nit() {
        return nit;
    }

    public void actualizarTelefonoProveedor(String telefonoAModificar) {
        this.telefono = telefono.cambiarTelefonoProveedor(Objects.requireNonNull(telefonoAModificar));
    }
}
