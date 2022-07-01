package org.example.venta.perfumeria.commands;


import co.com.sofka.domain.generic.Command;
import org.example.venta.perfumeria.values.*;

public class AgregarProveedor extends Command {

    private final PerfumeriaId perfumeriaId;
    private final ProveedorId proveedorId;
    private final Nombre nombre;
    private final Nit nit;
    private final Telefono telefono;

    public AgregarProveedor(PerfumeriaId perfumeriaId, ProveedorId proveedorId, Nombre nombre, Nit nit, Telefono telefono){

        this.perfumeriaId = perfumeriaId;
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public PerfumeriaId getPerfumeriaId() {
        return perfumeriaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Nit getNit() {
        return nit;
    }
}
