package org.example.venta.pedido.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.pedido.values.ClienteId;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.pedido.values.Telefono;
import org.example.venta.perfumeria.values.PerfumeriaId;

public class CrearPedido extends Command {

    private final PedidoId pedidoId;
    private final PerfumeriaId perfumeriaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Telefono telefono;

    public CrearPedido(PedidoId pedidoId, PerfumeriaId perfumeriaId, ClienteId clienteId, Nombre nombre, Telefono telefono){

        this.pedidoId = pedidoId;
        this.perfumeriaId = perfumeriaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public PerfumeriaId getPerfumeriaId() {
        return perfumeriaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
