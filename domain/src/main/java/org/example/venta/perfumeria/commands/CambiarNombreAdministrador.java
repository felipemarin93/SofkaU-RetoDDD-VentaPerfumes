package org.example.venta.perfumeria.commands;

import org.example.venta.perfumeria.values.AdministradorId;
import org.example.venta.perfumeria.values.Nombre;
import org.example.venta.perfumeria.values.PerfumeriaId;

public class CambiarNombreAdministrador {


    private final PerfumeriaId perfumeriaId;
    private final Nombre nombre;
    private final AdministradorId administradorId;

    public CambiarNombreAdministrador(PerfumeriaId perfumeriaId, Nombre nombre, AdministradorId administradorId){

        this.perfumeriaId = perfumeriaId;
        this.nombre = nombre;
        this.administradorId = administradorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PerfumeriaId getPerfumeriaId() {
        return perfumeriaId;
    }

    public AdministradorId getAdministradorId() {
        return administradorId;
    }
}
