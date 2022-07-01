package org.example.venta.envio.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.CambiarCelularDestinatario;
import org.example.venta.envio.events.CelularDestinatarioCambiado;
import org.example.venta.envio.events.DestinatarioCreado;
import org.example.venta.envio.events.EnvioCreado;
import org.example.venta.envio.usecase.enviousecase.CambiarCelularDestinatarioUseCase;
import org.example.venta.envio.values.*;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.envio.values.Direccion;
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
class CambiarCelularDestinatarioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarCelularDestinatarioUseCase useCase;

    @Test
    public void CambiarCelularDestinatario(){
        EnvioId envioId = EnvioId.of("1");
        Celular celular = new Celular("32156161");
        DestinatarioId destinatarioId = DestinatarioId.of("1");


        var command = new CambiarCelularDestinatario(envioId,celular,destinatarioId);

        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CelularDestinatarioCambiado)events.get(0);
        Assertions.assertEquals("32156161" , event.celular().value());

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