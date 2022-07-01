package org.example.venta.envio.usecase.envio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.venta.envio.commands.AgregarDestinatario;

public class AgregarDestinatarioUseCase extends UseCase<RequestCommand<AgregarDestinatario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDestinatario> agregarDestinatarioRequestCommand) {

    }
}
