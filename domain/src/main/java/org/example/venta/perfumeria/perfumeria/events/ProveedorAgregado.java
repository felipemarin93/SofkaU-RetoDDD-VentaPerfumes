package org.example.venta.perfumeria.perfumeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.envio.events.values.Nit;
import org.example.venta.perfumeria.envio.events.values.Nombre;
import org.example.venta.perfumeria.envio.events.values.ProveedorId;
import org.example.venta.perfumeria.envio.events.values.Telefono;

public class ProveedorAgregado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final Nombre nombre;
    private final Nit nit;
    private final Telefono telefono;

    public ProveedorAgregado(ProveedorId proveedorId, Nombre nombre, Nit nit, Telefono telefono) {
        super("org.example.venta.perfumeria.ProveedorAgregado");
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Nombre nombre() {
        return nombre;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }
    public Nit nit() {
        return nit;
    }
}
