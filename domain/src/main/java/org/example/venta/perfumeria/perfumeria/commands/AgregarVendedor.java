package org.example.venta.perfumeria.perfumeria.commands;

import org.example.venta.perfumeria.perfumeria.values.Correo;
import org.example.venta.perfumeria.perfumeria.values.Nombre;
import org.example.venta.perfumeria.perfumeria.values.PerfumeriaId;
import org.example.venta.perfumeria.perfumeria.values.VendedorId;

public class AgregarVendedor {

    private final PerfumeriaId perfumeriaId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Correo correo;

    public AgregarVendedor (PerfumeriaId perfumeriaId, VendedorId vendedorId, Nombre nombre, Correo correo){

        this.perfumeriaId = perfumeriaId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.correo = correo;
    }


    public Nombre getNombre() {
        return nombre;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Correo getCorreo() {
        return correo;
    }

    public PerfumeriaId getPerfumeriaId() {
        return perfumeriaId;
    }
}
