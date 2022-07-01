package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.CambiarCantidadProducto;



public class CambiarCantidadProductoUseCase extends UseCase<RequestCommand<CambiarCantidadProducto>, ResponseEvents> {
    @Override

        public void executeUseCase(RequestCommand<CambiarCantidadProducto> cambiarCantidadProductoRequestCommand) {
        var command = cambiarCantidadProductoRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.cambiarCantidadProducto(command.getProductoId(),command.getCantidad());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
