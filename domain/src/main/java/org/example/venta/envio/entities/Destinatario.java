package org.example.venta.envio.entities;

import co.com.sofka.domain.generic.Entity;
import org.example.venta.envio.values.*;

public class Destinatario extends Entity<DestinatarioId> {
    protected Nombre nombre;
    protected Direccion direccion;
    protected Celular celular;

    public Destinatario(DestinatarioId entityId, Nombre nombre , Direccion direccion, Celular celular) {
        super(entityId);
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
    }

    public void cambiarCelular(Celular celularAModificar){
        this.celular = celular.cambiarCelular(celularAModificar.value());
    }

    public void cambiarDireccion(Direccion direccionAModificar){
        this.direccion = direccion.cambiarDireccion(direccionAModificar.value());
    }







}
