package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.CambiarCliente;

public class CambiarClienteUseCase extends UseCase<RequestCommand<CambiarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarCliente> cambiarClienteRequestCommand) {

        var command = cambiarClienteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.cambiarCliente(command.getCliente());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));

    }
}
