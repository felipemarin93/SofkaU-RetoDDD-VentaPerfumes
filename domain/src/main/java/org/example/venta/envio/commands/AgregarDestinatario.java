package org.example.venta.envio.commands;


import co.com.sofka.domain.generic.Command;
import org.example.venta.envio.entities.Destinatario;
import org.example.venta.envio.values.*;


public class AgregarDestinatario extends Command {

    private final EnvioId envioId;
    private final DestinatarioId destinatarioId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Celular celular;



    public AgregarDestinatario (EnvioId envioId, DestinatarioId destinatarioId, Nombre nombre, Direccion direccion, Celular celular) {
        this.envioId = envioId;
        this.destinatarioId = destinatarioId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;


    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public DestinatarioId getDestinatarioId() {
        return destinatarioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Celular getCelular() {
        return celular;
    }
}
