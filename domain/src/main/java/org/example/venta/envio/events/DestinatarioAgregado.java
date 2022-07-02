package org.example.venta.envio.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.entities.Destinatario;
import org.example.venta.envio.values.*;

public class DestinatarioAgregado extends DomainEvent {

    private final DestinatarioId destinatarioId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Celular celular;


    public DestinatarioAgregado(DestinatarioId destinatarioId, Nombre nombre, Direccion direccion, Celular celular) {
        super("org.example.venta.perfumeria.DestinatarioAgregado");
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.destinatarioId = destinatarioId;


    }


    public Direccion getDireccion() {
        return direccion;
    }

    public DestinatarioId getDestinatarioId() {
        return destinatarioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
