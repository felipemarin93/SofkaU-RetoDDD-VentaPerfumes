package org.example.venta.perfumeria.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.values.AdministradorId;
import org.example.venta.perfumeria.values.Nombre;
import org.example.venta.perfumeria.values.PerfumeriaId;

public class NombreAdministradorCambiado extends DomainEvent {
    private final PerfumeriaId perfumeriaId;
    private final Nombre nombre;
    private final AdministradorId administradorId;

    public NombreAdministradorCambiado(PerfumeriaId perfumeriaId, Nombre nombre, AdministradorId administradorId) {
        super("org.example.venta.perfumeria.NombreAdministradorCambiado");
        this.perfumeriaId = perfumeriaId;
        this.nombre = nombre;
        this.administradorId = administradorId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public AdministradorId administradorId() {
        return administradorId;
    }

    public PerfumeriaId perfumeriaId() {
        return perfumeriaId;
    }
}
