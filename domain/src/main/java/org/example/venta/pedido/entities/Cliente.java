package org.example.venta.pedido.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.pedido.values.ClienteId;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.Telefono;

public class Cliente extends Entity<ClienteId> {
    private Nombre nombre;
    private Telefono telefono;

    public Cliente(ClienteId entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Nombre nombre() {
        return nombre;
    }


    public Telefono cambiarTelefono(String telefonAModificar){
        return new Telefono(telefonAModificar);
    }
}
