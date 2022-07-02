package org.example.venta.envio.usecase.enviousecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.AgregarDomiciliario;
import org.example.venta.envio.events.DomiciliarioAgregado;
import org.example.venta.envio.events.EnvioCreado;
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
import java.util.Objects;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarDomiciliarioUseCaseTest {
    @InjectMocks
    AgregarDomiciliarioUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarNuevoDomiciliario(){


        //arrange
        EnvioId envioId = EnvioId.of("1");
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        Nombre nombre = new Nombre("DomiciliarioNuevo");


        var command = new AgregarDomiciliario(envioId,domiciliarioId,nombre);

        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var domiciliarioAgregado = (DomiciliarioAgregado) events.get(0);
        //assert
        Assertions.assertTrue(Objects.nonNull(domiciliarioAgregado));
        Assertions.assertEquals("DomiciliarioNuevo",domiciliarioAgregado.nombre().value());



    }

    private List<DomainEvent> history(){

        PedidoId pedidoId = PedidoId.of("1");
        Fecha fecha = new Fecha(LocalDate.now());
        EnvioId envioId = EnvioId.of("1");

        return List.of(
                new EnvioCreado(envioId,pedidoId, fecha)

        );


    }
}