package org.example.venta.envio.usecase.perfumeriausecase;


import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.venta.perfumeria.events.TelefonoProveedorActualizado;
import org.example.venta.perfumeria.values.Telefono;
import org.example.venta.perfumeria.commands.ActualizarTelefonoProveedor;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.example.venta.perfumeria.values.ProveedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EventoActualizarTelefonoProveedorUseCaseTest {

    @Mock
    PhoneServiceProveedor phoneServiceProveedor;

    @InjectMocks
    EventoActualizarTelefonoProveedorUseCase usecase;

    @Test

    void actualizarTelefonoProveedor(){

        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
        Telefono telefono = new Telefono("5656565");
        ProveedorId proveedorId = ProveedorId.of("1");

        var event = new TelefonoProveedorActualizado(perfumeriaId, telefono,proveedorId);
        Mockito.doNothing().when(phoneServiceProveedor).actualizarTelefonoProveedor(perfumeriaId, "Has Actualizado el número Telefonico");
        usecase.addServiceBuilder(new ServiceBuilder().addService(phoneServiceProveedor));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(phoneServiceProveedor).actualizarTelefonoProveedor(perfumeriaId, "Has Actualizado el número Telefonico");
        Assertions.assertEquals(0, events.size());
    }
}