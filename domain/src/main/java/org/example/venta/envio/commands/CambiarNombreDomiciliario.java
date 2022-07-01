package org.example.venta.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.values.DestinatarioId;
import org.example.venta.envio.values.EnvioId;
import org.example.venta.envio.values.Nombre;

public class CambiarNombreDomiciliario extends Command {

    private final EnvioId envioId;
    private final Nombre nombre;
    private final DestinatarioId destinatarioId;

    public CambiarNombreDomiciliario(EnvioId envioId, Nombre nombre, DestinatarioId destinatarioId){

        this.envioId = envioId;
        this.nombre = nombre;
        this.destinatarioId = destinatarioId;
    }


    public Nombre getNombre() {
        return nombre;
    }

    public DestinatarioId getDestinatarioId() {
        return destinatarioId;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }
}
