package org.example.venta.perfumeria.perfumeria;

import co.com.sofka.domain.generic.EventChange;

public class PerfumeriaEventChange extends EventChange {
    public PerfumeriaEventChange(Perfumeria perfumeria) {
        apply((PerfumeriaCreada event) -> {
            perfumeria.administrador = event.getAdministrador();
            perfumeria.direccion = event.getDireccion();
            perfumeria.proveedor = null;
            perfumeria.vendedor = null;

        });


    }
}
