package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.pedido.commands.AgregarFactura;
import org.example.venta.pedido.events.FacturaAgregada;
import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.values.*;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarFacturaUseCaseTest {

    @InjectMocks
    AgregarFacturaUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarFactura(){


        //arrange
        PedidoId pedidoId = PedidoId.of("1");
        FacturaId facturaId = FacturaId.of("1");
        Precio precio = new Precio(25000);
        Detalle detalle = new Detalle("Factura Generada para cobro");


        var command = new AgregarFactura(pedidoId,facturaId,precio,detalle );

        when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var facturaAgregada = (FacturaAgregada) events.get(0);
        //assert

        Assertions.assertEquals("Factura Generada para cobro",facturaAgregada.detalle().value());
        Assertions.assertEquals("1",facturaAgregada.facturaId().value());



    }

    private List<DomainEvent> history(){


        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
        ClienteId clienteId = ClienteId.of("5");
        Nombre nombre = new Nombre("Juancho");
        Telefono telefono = new Telefono("4561651");

        return List.of(
                new PedidoCreado(perfumeriaId,clienteId,nombre, telefono)

        );

    }

}