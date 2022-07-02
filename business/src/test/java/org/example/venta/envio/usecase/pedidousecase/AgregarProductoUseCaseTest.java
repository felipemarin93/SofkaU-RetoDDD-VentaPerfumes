package org.example.venta.envio.usecase.pedidousecase;




import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.venta.pedido.commands.AgregarProducto;

import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.events.ProductoAgregado;
import org.example.venta.pedido.values.*;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.example.venta.pedido.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarProductoUseCaseTest {
    @InjectMocks
    AgregarProductoUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarNuevoProducto(){


        //arrange
        PedidoId pedidoId = PedidoId.of("1");
        ProductoId productoId = ProductoId.of("1");
        Nombre nombre = new Nombre("LacosteRed");
        Cantidad cantidad = new Cantidad(10);


        var command = new AgregarProducto(pedidoId,productoId,nombre,cantidad);

        when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var productoAgregado = (ProductoAgregado) events.get(0);
        //assert

        Assertions.assertEquals("LacosteRed",productoAgregado.nombre().value());



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