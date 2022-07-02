package org.example.venta.envio.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.AgregarDestinatario;
import org.example.venta.envio.events.DestinatarioAgregado;
import org.example.venta.envio.events.DestinatarioCreado;
import org.example.venta.envio.events.EnvioCreado;
import org.example.venta.envio.usecase.enviousecase.AgregarDestinatarioUseCase;
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
class AgregarDestinatarioUseCaseTest {

    @InjectMocks
    AgregarDestinatarioUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarNuevoDestinatario(){


        //arrange
        EnvioId envioId = EnvioId.of("1");
        DestinatarioId destinatarioId = DestinatarioId.of("10");
        Nombre nombre = new Nombre("LaPrueba");
        Direccion direccion = new Direccion("Calle25 con carrera");
        Celular celular = new Celular("31265156");
        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);


        var command = new AgregarDestinatario(envioId,destinatarioId, nombre, direccion,celular);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var destinatarioAgregado = (DestinatarioAgregado) events.get(0);
        //assert
        Assertions.assertTrue(Objects.nonNull(destinatarioAgregado));
        Assertions.assertEquals("LaPrueba",destinatarioAgregado.getNombre().value());
        Assertions.assertEquals("Calle25 con carrera",destinatarioAgregado.getDireccion().value());


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