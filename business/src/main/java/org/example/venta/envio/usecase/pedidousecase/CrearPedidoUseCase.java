package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedido> crearPedidoRequestCommand) {
        var command =crearPedidoRequestCommand.getCommand();
        var pedido = new Pedido(command.getPedidoId(),command.getPerfumeriaId(),command.getClienteId(), command.getNombre(),command.getTelefono());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));

    }
}
