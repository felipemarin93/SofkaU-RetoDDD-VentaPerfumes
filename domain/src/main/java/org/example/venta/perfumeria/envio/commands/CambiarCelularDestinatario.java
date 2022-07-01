package org.example.venta.perfumeria.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.perfumeria.envio.values.Celular;
import org.example.venta.perfumeria.envio.values.DestinatarioId;
import org.example.venta.perfumeria.envio.values.EnvioId;

public class CambiarCelularDestinatario extends Command {


    private final EnvioId envioId;
    private final Celular celular;
    private final DestinatarioId destinatarioId;

    public CambiarCelularDestinatario(EnvioId envioId, Celular celular, DestinatarioId destinatarioId){

        this.envioId = envioId;
        this.celular = celular;
        this.destinatarioId = destinatarioId;
    }

    public DestinatarioId getDestinatarioId() {
        return destinatarioId;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Celular getCelular() {
        return celular;
    }
}
