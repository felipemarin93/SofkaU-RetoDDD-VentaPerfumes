package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.venta.perfumeria.events.NombreAdministradorCambiado;
import org.example.venta.perfumeria.events.TelefonoProveedorActualizado;

import java.util.List;

public class EventoActualizarNombreAdministradorUseCase extends UseCase<TriggeredEvent<NombreAdministradorCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<NombreAdministradorCambiado> nombreAdministradorCambiadoTriggeredEvent) {

        var event = nombreAdministradorCambiadoTriggeredEvent.getDomainEvent();

        var service = getService(NombreServiceAdministrador.class).orElseThrow();

        String body = String.format("Administrador, has actualizado tu nombre");
        service.actualizarNombreAdministrador(event.perfumeriaId(), body);

        emit().onResponse(new ResponseEvents(List.of()));

    }
}
