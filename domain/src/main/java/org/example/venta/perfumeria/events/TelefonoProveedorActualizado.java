package org.example.venta.perfumeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.example.venta.perfumeria.values.ProveedorId;
import org.example.venta.perfumeria.values.Telefono;

public class TelefonoProveedorActualizado extends DomainEvent {
    private final PerfumeriaId perfumeriaId;
    private final Telefono telefono;
    private final ProveedorId proveedorId;

    public TelefonoProveedorActualizado(PerfumeriaId perfumeriaId, Telefono telefono, ProveedorId proveedorId) {
        super("org.example.venta.perfumeria.");
        this.perfumeriaId = perfumeriaId;
        this.telefono = telefono;
        this.proveedorId = proveedorId;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }

    public Telefono telefono() {
        return telefono;
    }

    public PerfumeriaId perfumeriaId() {
        return perfumeriaId;
    }
}
