package org.example.venta.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.values.DomiciliarioId;
import org.example.venta.envio.values.EnvioId;
import org.example.venta.envio.values.Nombre;

public class AgregarDomiciliario extends Command {

    private final EnvioId envioId;
    private final DomiciliarioId domiciliarioId;
    private final Nombre nombre;

    public AgregarDomiciliario (EnvioId envioId, DomiciliarioId domiciliarioId, Nombre nombre){

        this.envioId = envioId;
        this.domiciliarioId = domiciliarioId;
        this.nombre = nombre;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public DomiciliarioId getDomiciliarioId() {
        return domiciliarioId;
    }
}
