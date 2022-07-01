package org.example.venta.envio.usecase.pedidousecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.values.Fecha;
import org.example.venta.pedido.commands.CambiarCantidadProducto;
import org.example.venta.pedido.entities.Cliente;
import org.example.venta.pedido.events.CantidadProductoCambiada;
import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.values.Cantidad;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.pedido.values.ProductoId;
import org.example.venta.perfumeria.values.PerfumeriaId;
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
class CambiarCantidadProductoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarCantidadProductoUseCase useCase;

    @Test
    public void CambiarCantidadProducto(){

        PedidoId pedidoId = PedidoId.of("1");
        ProductoId productoId = ProductoId.of("1");
        Cantidad cantidad = new Cantidad(15);

        var command = new CambiarCantidadProducto( pedidoId, productoId, cantidad);

//        when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
//        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CantidadProductoCambiada)events.get(0);
        Assertions.assertEquals("15" , event.cantidad().value());
        Assertions.assertEquals("1" , event.productoId().value());
    }

//    private List<DomainEvent> history(){
//
//        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
//        Cliente cliente = new Cliente("1");
//
//
//        Nombre nombre = new Nombre("Daniel Felipe");
//        Direccion direccion = new Direccion("Calle29A");
//        Celular celular = new Celular("323232131");
//        DestinatarioId destinatarioId = DestinatarioId.of("1");
//
//        return List.of(
//                new ProductoCreado(pedidoId, fecha),
//                new PedidoCreado(perfumeriaId,cliente)
//
//        );
//
//
//    }


}