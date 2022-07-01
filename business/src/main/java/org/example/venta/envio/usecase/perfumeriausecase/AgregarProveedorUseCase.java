package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.perfumeria.Perfumeria;
import org.example.venta.perfumeria.commands.AgregarProveedor;

public class AgregarProveedorUseCase extends UseCase<RequestCommand<AgregarProveedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProveedor> agregarProveedorRequestCommand) {
        var command = agregarProveedorRequestCommand.getCommand();
        var perfumeria = Perfumeria.from(command.getPerfumeriaId(),repository().getEventsBy(command.getPerfumeriaId().value()));

        perfumeria.agregarProveedor(command.getProveedorId(),command.getNombre(),command.getNit(),command.getTelefono());
        emit().onResponse(new ResponseEvents(perfumeria.getUncommittedChanges()));
    }
}
