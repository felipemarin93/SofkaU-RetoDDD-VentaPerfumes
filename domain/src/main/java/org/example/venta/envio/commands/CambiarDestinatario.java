package org.example.venta.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.values.Celular;
import org.example.venta.envio.values.Direccion;
import org.example.venta.envio.values.EnvioId;
import org.example.venta.envio.values.Nombre;

public class CambiarDestinatario extends Command {

    private final EnvioId envioId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Celular celular;

    public CambiarDestinatario(EnvioId envioId, Nombre nombre, Direccion direccion, Celular celular) {
        this.envioId = envioId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
    }


    public Celular getCelular() {
        return celular;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }
}



