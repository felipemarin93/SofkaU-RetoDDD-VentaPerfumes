package org.example.venta.perfumeria.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String direccion;
    public Direccion(String direccion) {

        this.direccion = Objects.requireNonNull(direccion);
    }
    @Override
    public String value() {
        return direccion;
    }
}
