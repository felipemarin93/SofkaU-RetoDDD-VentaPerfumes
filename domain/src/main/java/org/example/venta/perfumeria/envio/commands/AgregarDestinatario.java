package org.example.venta.perfumeria.envio.commands;


import co.com.sofka.domain.generic.Command;
import org.example.venta.perfumeria.envio.entities.Destinatario;
import org.example.venta.perfumeria.envio.values.EnvioId;


public class AgregarDestinatario extends Command {

    private final EnvioId envioId;
    private final Destinatario destinatario;


    public AgregarDestinatario (EnvioId envioId, Destinatario destinatario) {
        this.envioId = envioId;
        this.destinatario = destinatario;

    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }
}
