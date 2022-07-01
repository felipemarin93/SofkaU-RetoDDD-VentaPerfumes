package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.CrearPedido;
import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.values.ClienteId;
import org.example.venta.pedido.values.Nombre;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.pedido.values.Telefono;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearPedidoUseCaseTest {

    @Test
    void CrearNuevoPedido(){

        PedidoId pedidoId = PedidoId.of("1");
        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
        ClienteId clienteId = ClienteId.of("1");
        Nombre nombre = new Nombre("Daniel Felipe");
        Telefono telefono = new Telefono("355156454");


        var command = new CrearPedido(pedidoId,perfumeriaId,clienteId,nombre,telefono);

        var useCase = new CrearPedidoUseCase();

        List<DomainEvent>events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        PedidoCreado event = (PedidoCreado) events.get(0);
        Assertions.assertEquals("Daniel Felipe", event.nombre().value());
        Assertions.assertEquals("355156454", event.telefono().value());
    }

}