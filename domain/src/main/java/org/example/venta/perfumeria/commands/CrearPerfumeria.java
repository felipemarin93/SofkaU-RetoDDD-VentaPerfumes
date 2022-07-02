package org.example.venta.perfumeria.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.perfumeria.entities.Administrador;
import org.example.venta.perfumeria.values.Direccion;


public class CrearPerfumeria extends Command {

    private final Administrador administrador;
    private final Direccion direccion;

    public CrearPerfumeria(Administrador administrador, Direccion direccion){

        this.administrador = administrador;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Administrador getAdministrador() {
        return administrador;
    }
}
