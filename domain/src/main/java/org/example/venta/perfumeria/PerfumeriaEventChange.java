package org.example.venta.perfumeria;

import co.com.sofka.domain.generic.EventChange;

import org.example.venta.perfumeria.entities.Proveedor;
import org.example.venta.perfumeria.entities.Vendedor;
import org.example.venta.perfumeria.events.*;




public class PerfumeriaEventChange extends EventChange {
    public PerfumeriaEventChange(Perfumeria perfumeria) {
        apply((PerfumeriaCreada event) -> {
            perfumeria.administrador = event.administrador();
            perfumeria.direccion = event.direccion();
            perfumeria.proveedor = null;
            perfumeria.vendedor = null;
        });

        apply((VendedorAgregado event) ->{
            perfumeria.vendedor = new Vendedor(event.vendedorId(),event.nombre(), event.correo());
        });
        apply((ProveedorAgregado event) ->{
            perfumeria.proveedor = new Proveedor(event.proveedorId(),event.nombre(), event.nit(), event.telefono());
        });
        apply((NombreAdministradorCambiado event) -> {
            perfumeria.administrador.cambiarNombre(event.nombre().value());
        });
        apply((TelefonoProveedorActualizado event) -> {
            perfumeria.proveedor.actualizarTelefonoProveedor(event.telefono().value());
        });


    }
}
