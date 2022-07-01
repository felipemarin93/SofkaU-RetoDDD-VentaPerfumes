package org.example.venta.envio.usecase.pedidousecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.pedido.commands.AgregarFactura;

public class AgregarFacturaUseCase extends UseCase<RequestCommand<AgregarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarFactura> agregarFacturaRequestCommand) {
        var command = agregarFacturaRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarFactura(command.getFacturaId(),command.getPrecio(),command.getDetalle());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
