package org.example.venta.envio.usecase.envio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.CambiarCelularDestinatario;


public class CambiarCelularDestinatarioUseCase extends UseCase<RequestCommand<CambiarCelularDestinatario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarCelularDestinatario> cambiarCelularDestinatarioRequestCommand) {
            var command = cambiarCelularDestinatarioRequestCommand.getCommand();
            var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

            envio.cambiarCelularDestinatario(command.getEnvioId(),command.getCelular(),command.getDestinatarioId());

            emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
