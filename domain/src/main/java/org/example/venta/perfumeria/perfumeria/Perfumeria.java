package org.example.venta.perfumeria.perfumeria;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.perfumeria.entities.Administrador;
import org.example.venta.perfumeria.perfumeria.entities.Proveedor;
import org.example.venta.perfumeria.perfumeria.entities.Vendedor;
import org.example.venta.perfumeria.perfumeria.events.*;
import org.example.venta.perfumeria.perfumeria.values.*;


import java.util.List;
import java.util.Objects;

public class Perfumeria extends AggregateEvent<PerfumeriaId> {

    protected Direccion direccion;
    protected Administrador administrador;
    protected Vendedor vendedor;
    protected Proveedor proveedor;

    public Perfumeria(PerfumeriaId entityId, Administrador administrador, Direccion direccion) {
        super(entityId);
        appendChange(new PerfumeriaCreada(administrador,direccion)).apply();
        subscribe(new PerfumeriaEventChange(this));
    }

    private Perfumeria(PerfumeriaId perfumeriaId){
        super(perfumeriaId);
        subscribe(new PerfumeriaEventChange(this));
    }

    public static Perfumeria from(PerfumeriaId perfumeriaId, List<DomainEvent> events){
        var perfumeria = new Perfumeria(perfumeriaId);
        events.forEach(perfumeria::applyEvent);
        return perfumeria;
    }

    public void agregarVendedor(VendedorId vendedorId, Nombre nombre, Correo correo){
        Objects.requireNonNull(vendedorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(correo);
        appendChange(new VendedorAgregado(vendedorId, nombre,correo)).apply();

    }
    public void agregarProveedor(ProveedorId proveedorId, Nombre nombre, Nit nit, Telefono telefono){
        Objects.requireNonNull(proveedorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nit);
        Objects.requireNonNull(telefono);
        appendChange(new ProveedorAgregado(proveedorId, nombre,nit, telefono)).apply();

    }

    public void cambiarNombreAdministrador(PerfumeriaId perfumeriaId, Nombre nombre, AdministradorId administradorId){
        Objects.requireNonNull(perfumeriaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(administradorId);
        appendChange(new NombreAdministradorCambiado(perfumeriaId,nombre,administradorId)).apply();
    }

    public void actualizarTelefonoProveedor(PerfumeriaId perfumeriaId, Telefono telefono, ProveedorId proveedorId){
        Objects.requireNonNull(perfumeriaId);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(proveedorId);
        appendChange(new TelefonoProveedorActualizado(perfumeriaId,telefono,proveedorId)).apply();
    }



}
