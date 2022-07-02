package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.venta.perfumeria.events.NombreAdministradorCambiado;
import org.example.venta.perfumeria.events.TelefonoProveedorActualizado;
import org.example.venta.perfumeria.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class EventoActualizarNombreAdministradorUseCaseTest {
    @Mock
    NombreServiceAdministrador nombreServiceAdministrador;

    @InjectMocks
    EventoActualizarNombreAdministradorUseCase usecase;

    @Test
    void actualizarNombreAdministrador(){

        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
        Nombre nombre = new Nombre("Juan Perez");
        AdministradorId administradorId = AdministradorId.of("1");

        var event = new NombreAdministradorCambiado(perfumeriaId, nombre,administradorId);
        Mockito.doNothing().when(nombreServiceAdministrador).actualizarNombreAdministrador(perfumeriaId, "Administrador, has actualizado tu nombre");
        usecase.addServiceBuilder(new ServiceBuilder().addService(nombreServiceAdministrador));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(nombreServiceAdministrador).actualizarNombreAdministrador(perfumeriaId, "Administrador, has actualizado tu nombre");
        Assertions.assertEquals(0, events.size());
    }
}