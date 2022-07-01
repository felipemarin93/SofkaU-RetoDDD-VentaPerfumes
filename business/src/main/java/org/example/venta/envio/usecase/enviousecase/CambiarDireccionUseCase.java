package org.example.venta.envio.usecase.enviousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.CambiarDireccion;

public class CambiarDireccionUseCase extends UseCase<RequestCommand<CambiarDireccion>, ResponseEvents> {
    @Override
        public void executeUseCase(RequestCommand<CambiarDireccion> cambiarDireccionRequestCommand) {
            var command = cambiarDireccionRequestCommand.getCommand();
            var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

            envio.cambiarDireccion(command.getEnvioId(),command.getDestinatarioId(),command.getDireccionACambiar());

            emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
