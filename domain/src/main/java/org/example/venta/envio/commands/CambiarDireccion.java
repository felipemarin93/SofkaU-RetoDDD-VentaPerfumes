package org.example.venta.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.values.DestinatarioId;
import org.example.venta.envio.values.Direccion;
import org.example.venta.envio.values.EnvioId;

public class CambiarDireccion extends Command {

    private final EnvioId envioId;
    private final DestinatarioId destinatarioId;
    private final Direccion direccionACambiar;

    public CambiarDireccion(EnvioId envioId, DestinatarioId destinatarioId, Direccion direccionACambiar){

        this.envioId = envioId;
        this.destinatarioId = destinatarioId;
        this.direccionACambiar = direccionACambiar;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public DestinatarioId getDestinatarioId() {
        return destinatarioId;
    }

    public Direccion getDireccionACambiar() {
        return direccionACambiar;
    }
}
