package org.example.venta.envio.usecase.enviousecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.AgregarDomiciliario;
import org.example.venta.envio.commands.AgregarVehiculo;
import org.example.venta.envio.events.DomiciliarioAgregado;
import org.example.venta.envio.events.EnvioCreado;
import org.example.venta.envio.events.VehiculoAgregado;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarVehiculoUseCaseTest {

    @InjectMocks
    AgregarVehiculoUseCase useCase;

    @Mock
    DomainEventRepository repository;
    @Test
    public  void AgregarNuevoVehiculo(){


        //arrange
        EnvioId envioId = EnvioId.of("1");
        VehiculoId vehiculoId = VehiculoId.of("1");
        Tipo tipo = new Tipo("Carro");
        Marca marca = new Marca("Mazda");


        var command = new AgregarVehiculo(envioId,vehiculoId,tipo, marca);

        when(repository.getEventsBy(envioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var vehiculoAgregado = (VehiculoAgregado) events.get(0);
        //assert
        Assertions.assertTrue(Objects.nonNull(vehiculoAgregado));
        Assertions.assertEquals("Mazda",vehiculoAgregado.marca().value());
        Assertions.assertEquals("Carro",vehiculoAgregado.tipo().value());



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