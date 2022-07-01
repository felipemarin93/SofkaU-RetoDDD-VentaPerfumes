package org.example.venta.perfumeria.envio.commands;

import co.com.sofka.domain.generic.Command;
import org.example.venta.perfumeria.envio.values.EnvioId;
import org.example.venta.perfumeria.envio.values.Marca;
import org.example.venta.perfumeria.envio.values.Tipo;
import org.example.venta.perfumeria.envio.values.VehiculoId;

public class AgregarVehiculo extends Command {

    private final EnvioId envioId;
    private final VehiculoId vehiculoId;
    private final Tipo tipo;
    private final Marca marca;

    public AgregarVehiculo (EnvioId envioId, VehiculoId vehiculoId, Tipo tipo, Marca marca ){

        this.envioId = envioId;
        this.vehiculoId = vehiculoId;
        this.tipo = tipo;
        this.marca = marca;
    }

    public EnvioId getEnvioId() {
        return envioId;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public Marca getMarca() {
        return marca;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
