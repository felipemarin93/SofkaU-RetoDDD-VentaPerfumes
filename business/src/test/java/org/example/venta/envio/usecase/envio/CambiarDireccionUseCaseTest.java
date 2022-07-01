package org.example.venta.envio.usecase.envio;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.CambiarDireccion;
import org.example.venta.envio.events.DestinatarioCreado;
import org.example.venta.envio.events.DireccionCambiada;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CambiarDireccionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarDireccionUseCase useCase;

    @Test
    public void CambiarDireccion(){

        EnvioId envioId = EnvioId.of("1");
        Direccion direccionACambiar = new Direccion("Diagonal50C#46-98");
        DestinatarioId destinatarioId = DestinatarioId.of("1");

        var command = new CambiarDireccion(envioId,destinatarioId, direccionACambiar);

        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DireccionCambiada)events.get(0);
        Assertions.assertEquals("Diagonal50C#46-98" , event.direccion().value());
    }
    private List<DomainEvent> history(){

        PedidoId pedidoId = PedidoId.of("1");
        Fecha fecha = new Fecha(LocalDate.now());


        Nombre nombre = new Nombre("Daniel Felipe");
        Direccion direccion = new Direccion("Calle29A");
        Celular celular = new Celular("323232131");
        DestinatarioId destinatarioId = DestinatarioId.of("1");

        return List.of(
                new EnvioCreado(pedidoId, fecha),
                new DestinatarioCreado(nombre, direccion,celular,destinatarioId)

        );


    }



}