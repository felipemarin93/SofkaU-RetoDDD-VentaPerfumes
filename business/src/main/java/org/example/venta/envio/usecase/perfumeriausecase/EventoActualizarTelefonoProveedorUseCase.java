package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.venta.perfumeria.events.TelefonoProveedorActualizado;

import java.util.List;

public class EventoActualizarTelefonoProveedorUseCase extends UseCase<TriggeredEvent<TelefonoProveedorActualizado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<TelefonoProveedorActualizado> telefonoProveedorActualizadoTriggeredEvent) {

        var event = telefonoProveedorActualizadoTriggeredEvent.getDomainEvent();

        var service = getService(PhoneServiceProveedor.class).orElseThrow();

        String body = String.format("Has Actualizado el número Telefonico");
        service.actualizarTelefonoProveedor(event.perfumeriaId(), body);

        emit().onResponse(new ResponseEvents(List.of()));

    }


}

