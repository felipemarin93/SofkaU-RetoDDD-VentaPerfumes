package org.example.venta.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.entities.Cliente;
import org.example.venta.pedido.values.ClienteId;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.Telefono;
import org.example.venta.perfumeria.values.PerfumeriaId;

public class PedidoCreado extends DomainEvent {
    private final PerfumeriaId perfumeriaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Telefono telefono;


    public PedidoCreado(PerfumeriaId perfumeriaId, ClienteId clienteId, Nombre nombre, Telefono telefono) {
        super("org.example.venta.pedido.PedidoCreado");
        this.perfumeriaId = perfumeriaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.telefono = telefono;

    }


    public PerfumeriaId perfumeriaId() {
        return perfumeriaId;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Nombre nombre() {
        return nombre;
    }

    public ClienteId clienteId() {
        return clienteId;
    }
}
