package org.example.venta.perfumeria.perfumeria.commands;

import org.example.venta.perfumeria.perfumeria.values.PerfumeriaId;
import org.example.venta.perfumeria.perfumeria.values.ProveedorId;
import org.example.venta.perfumeria.perfumeria.values.Telefono;

public class ActualizarTelefonoProveedor {

    private final PerfumeriaId perfumeriaId;
    private final Telefono telefono;
    private final ProveedorId proveedorId;

    public ActualizarTelefonoProveedor(PerfumeriaId perfumeriaId, Telefono telefono, ProveedorId proveedorId){

        this.perfumeriaId = perfumeriaId;
        this.telefono = telefono;
        this.proveedorId = proveedorId;

    }

    public Telefono getTelefono() {
        return telefono;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public PerfumeriaId getPerfumeriaId() {
        return perfumeriaId;
    }
}
