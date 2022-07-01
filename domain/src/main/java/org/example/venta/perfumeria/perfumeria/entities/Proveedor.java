package org.example.venta.perfumeria.perfumeria.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.envio.events.values.Nit;
import org.example.venta.perfumeria.envio.events.values.Nombre;
import org.example.venta.perfumeria.envio.events.values.ProveedorId;
import org.example.venta.perfumeria.envio.events.values.Telefono;

import java.util.Objects;

public class Proveedor extends Entity<ProveedorId> {
    protected  Nombre nombre;
    protected  Nit nit;
    protected  Telefono telefono;

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
