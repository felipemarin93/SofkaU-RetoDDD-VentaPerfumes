package org.example.venta.envio.usecase.envio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.Envio;
import org.example.venta.envio.commands.AgregarVehiculo;

public class AgregarVehiculoUseCase extends UseCase<RequestCommand<AgregarVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVehiculo> agregarVehiculoRequestCommand) {
        var command = agregarVehiculoRequestCommand.getCommand();
        var envio = Envio.from(command.getEnvioId(),repository().getEventsBy(command.getEnvioId().value()));

        envio.agregarVehiculo(command.getVehiculoId(),command.getTipo(),command.getMarca());

        emit().onResponse(new ResponseEvents(envio.getUncommittedChanges()));
    }
}
