package org.example.venta.envio.usecase.enviousecase;



import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.commands.CrearEnvio;
import org.example.venta.envio.events.EnvioCreado;
import org.example.venta.envio.values.EnvioId;
import org.example.venta.envio.values.Fecha;
import org.example.venta.pedido.values.PedidoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class CrearEnvioUseCaseTest {

    @Test
    void CrearNuevoEnvio(){

        PedidoId pedidoId = PedidoId.of("1");
        EnvioId envioId = EnvioId.of("10");
        Fecha fecha = new Fecha(LocalDate.now());


        var command = new CrearEnvio(pedidoId,envioId,fecha);

        var useCase = new CrearEnvioUseCase();

        List<DomainEvent> events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        EnvioCreado event = (EnvioCreado) events.get(0);
        Assertions.assertEquals("10", event.envioId().value());


    }


}