package org.example.venta.envio.usecase.enviousecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.CrearEnvio;



public class CrearEnvioUseCase extends UseCase<RequestCommand<CrearEnvio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEnvio> crearEnvioRequestCommand) {
        var command = crearEnvioRequestCommand.getCommand();
        var envio = new Envio(command.getEnvioId(),command.getPedidoId(),command.getFecha());
        emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
