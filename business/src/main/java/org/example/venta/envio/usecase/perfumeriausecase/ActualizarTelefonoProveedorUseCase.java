package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.pedido.Pedido;
import org.example.venta.perfumeria.Perfumeria;
import org.example.venta.perfumeria.commands.ActualizarTelefonoProveedor;

public class ActualizarTelefonoProveedorUseCase extends UseCase<RequestCommand<ActualizarTelefonoProveedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoProveedor> actualizarTelefonoProveedorRequestCommand) {

        var command = actualizarTelefonoProveedorRequestCommand.getCommand();
        var perfumeria = Perfumeria.from(command.getPerfumeriaId(),repository().getEventsBy(command.getPerfumeriaId().value()));

        perfumeria.actualizarTelefonoProveedor(command.getPerfumeriaId(),command.getTelefono(),command.getProveedorId());
        emit().onResponse(new ResponseEvents(perfumeria.getUncommittedChanges()));

    }
}
