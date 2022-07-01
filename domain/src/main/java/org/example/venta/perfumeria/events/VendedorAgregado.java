package org.example.venta.perfumeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.values.Nombre;
import org.example.venta.perfumeria.values.Correo;
import org.example.venta.perfumeria.values.VendedorId;

public class VendedorAgregado extends DomainEvent {
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Correo correo;

    public VendedorAgregado(VendedorId vendedorId, Nombre nombre, Correo correo) {
        super("org.example.venta.perfumeria.VendedorAgregado");
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Nombre nombre() {
        return nombre;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public Correo correo() {
        return correo;
    }
}
