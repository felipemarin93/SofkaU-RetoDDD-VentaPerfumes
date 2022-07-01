package org.example.venta.perfumeria.perfumeria.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.perfumeria.envio.events.values.Correo;
import org.example.venta.perfumeria.envio.events.values.Nombre;
import org.example.venta.perfumeria.envio.events.values.VendedorId;

public class Vendedor extends Entity<VendedorId> {
    private Nombre nombre;
    private Correo correo;

    public Vendedor(VendedorId entityId, Nombre nombre, Correo correo) {
        super(entityId);
        this.nombre = nombre;
        this.correo = correo;
    }

    public Nombre nombre() {
        return nombre;
    }
    public Correo correo() {
        return correo;
    }


}
