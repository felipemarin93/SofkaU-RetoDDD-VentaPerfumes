package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.perfumeria.Perfumeria;
import org.example.venta.perfumeria.commands.AgregarVendedor;

public class AgregarVendedorUseCase extends UseCase<RequestCommand<AgregarVendedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVendedor> agregarVendedorRequestCommand) {
        var command = agregarVendedorRequestCommand.getCommand();
        var perfumeria = Perfumeria.from(command.getPerfumeriaId(),repository().getEventsBy(command.getPerfumeriaId().value()));

        perfumeria.agregarVendedor(command.getVendedorId(),command.getNombre(),command.getCorreo());
        emit().onResponse(new ResponseEvents(perfumeria.getUncommittedChanges()));
    }
}
