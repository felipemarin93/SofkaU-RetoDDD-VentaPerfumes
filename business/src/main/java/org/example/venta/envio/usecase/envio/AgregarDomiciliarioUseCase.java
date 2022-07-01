package org.example.venta.envio.usecase.envio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.AgregarDomiciliario;

public class AgregarDomiciliarioUseCase extends UseCase<RequestCommand<AgregarDomiciliario>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarDomiciliario> agregarDomiciliarioRequestCommand) {
        var command = agregarDomiciliarioRequestCommand.getCommand();
        var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

        envio.agregarDomiciliario(command.getDomiciliarioId(),command.getNombre());

        emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
