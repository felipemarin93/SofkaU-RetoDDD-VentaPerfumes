package org.example.venta.envio.usecase.pedidousecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.AgregarProducto;

public class AgregarProductoUseCase extends UseCase<RequestCommand<AgregarProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProducto> agregarProductoRequestCommand) {
        var command = agregarProductoRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarProducto(command.getProductoId(),command.getNombre(), command.getCantidad());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));

    }
}
