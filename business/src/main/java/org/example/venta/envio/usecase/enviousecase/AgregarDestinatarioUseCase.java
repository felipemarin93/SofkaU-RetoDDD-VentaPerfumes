package org.example.venta.envio.usecase.enviousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.AgregarDestinatario;

public class AgregarDestinatarioUseCase extends UseCase<RequestCommand<AgregarDestinatario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDestinatario> agregarDestinatarioRequestCommand) {
        var command = agregarDestinatarioRequestCommand.getCommand();
        var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

        envio.agregarDestinatario(command.getDestinatarioId(),command.getNombre(),command.getDireccion(),command.getCelular());

        emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
