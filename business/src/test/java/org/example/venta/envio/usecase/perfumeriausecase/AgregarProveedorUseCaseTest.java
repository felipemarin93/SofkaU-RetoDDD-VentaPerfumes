package org.example.venta.envio.usecase.perfumeriausecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.events.ProductoAgregado;
import org.example.venta.perfumeria.entities.Administrador;
import org.example.venta.perfumeria.events.PerfumeriaCreada;
import org.example.venta.perfumeria.values.*;
import org.example.venta.perfumeria.commands.AgregarProveedor;
import org.example.venta.perfumeria.values.Nit;
import org.example.venta.perfumeria.values.PerfumeriaId;
import org.example.venta.perfumeria.values.ProveedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarProveedorUseCaseTest {
    @InjectMocks
    AgregarProveedorUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarProveedor(){


        //arrange
        PerfumeriaId perfumeriaId = PerfumeriaId.of("1");
        ProveedorId proveedorId = ProveedorId.of("1");
        Nit nit = new Nit("635465656-4");
        Nombre nombre = new Nombre("Raul Alzate");
        Telefono telefono = new Telefono("65565665");


        var command = new AgregarProveedor(perfumeriaId,proveedorId,nombre,nit,telefono);

        when(repository.getEventsBy(perfumeriaId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var productoAgregado = (ProductoAgregado) events.get(0);
        //assert

        Assertions.assertEquals("Raul Alzate",productoAgregado.nombre().value());





    }

    private List<DomainEvent> history(){


        Administrador administrador = new Administrador();
        Direccion direccion = new Direccion("Diagonal50Cad");

        return List.of(
                new PerfumeriaCreada(administrador,direccion);

        );

    }
}