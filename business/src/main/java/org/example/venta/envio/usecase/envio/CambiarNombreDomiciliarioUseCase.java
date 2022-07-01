package org.example.venta.envio.usecase.envio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.CambiarNombreDomiciliario;


public class CambiarNombreDomiciliarioUseCase extends UseCase<RequestCommand<CambiarNombreDomiciliario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombreDomiciliario> cambiarNombreDomiciliarioRequestCommand) {
        var command = cambiarNombreDomiciliarioRequestCommand.getCommand();
        var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

        envio.cambiarNombreDomiciliario(command.getEnvioId(),command.getNombre(),command.getDestinatarioId());
        emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
