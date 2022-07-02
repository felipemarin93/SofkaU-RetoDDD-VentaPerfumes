package org.example.venta.envio.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.CambiarNombreDomiciliario;
import org.example.venta.envio.events.*;
import org.example.venta.envio.usecase.enviousecase.CambiarNombreDomiciliarioUseCase;
import org.example.venta.envio.values.*;
import org.example.venta.pedido.values.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CambiarNombreDomiciliarioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarNombreDomiciliarioUseCase useCase;

    @Test
    public void CambiarNombreDomiciliario(){
        EnvioId envioId = EnvioId.of("1");
        Nombre nombre = new Nombre("NuevoDomiciliario");
        DestinatarioId destinatarioId = DestinatarioId.of("1");

        var command = new CambiarNombreDomiciliario(envioId, nombre, destinatarioId);

        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreDomiciliarioCambiado)events.get(0);
        Assertions.assertEquals("NuevoDomiciliario" , event.nombre().value());

    }

    private List<DomainEvent> history(){

        PedidoId pedidoId = PedidoId.of("1");
        Fecha fecha = new Fecha(LocalDate.now());
        EnvioId envioId = EnvioId.of("1");
        Nombre nombre = new Nombre("Daniel Felipe");
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");

        return List.of(
                new EnvioCreado(envioId,pedidoId, fecha),
                new DomiciliarioAgregado(domiciliarioId, nombre)
        );

    }


}