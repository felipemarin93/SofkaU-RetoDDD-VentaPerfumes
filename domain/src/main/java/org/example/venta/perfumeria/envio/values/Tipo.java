package org.example.venta.perfumeria.envio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {
    private final String tipoVehiculo;
    public Tipo(String tipoVehiculo) {
        this.tipoVehiculo = Objects.requireNonNull(tipoVehiculo);
    }
    @Override
    public String value() {
        return tipoVehiculo;
    }
    public Tipo tipoVehiculo(String tipoVehiculo){
        return new Tipo(Objects.requireNonNull(tipoVehiculo));
    }
}
