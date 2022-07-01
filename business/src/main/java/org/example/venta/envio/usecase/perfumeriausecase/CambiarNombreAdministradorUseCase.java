package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.perfumeria.Perfumeria;
import org.example.venta.perfumeria.commands.CambiarNombreAdministrador;

public class CambiarNombreAdministradorUseCase extends UseCase<RequestCommand<CambiarNombreAdministrador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombreAdministrador> cambiarNombreAdministradorRequestCommand) {
        var command = cambiarNombreAdministradorRequestCommand.getCommand();
        var perfumeria = Perfumeria.from(command.getPerfumeriaId(),repository().getEventsBy(command.getPerfumeriaId().value()));

        perfumeria.cambiarNombreAdministrador(command.getPerfumeriaId(),command.getNombre(),command.getAdministradorId());
        emit().onResponse(new ResponseEvents(perfumeria.getUncommittedChanges()));

    }
}
