package org.example.venta.perfumeria.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String direccion;
    public Direccion(String direccion) {

        this.direccion = Objects.requireNonNull(direccion);

        if (this.direccion.isBlank()){
            throw new IllegalArgumentException("La direccion no puede ser vacía");
        }

    }
    @Override
    public String value() {
        return direccion;
    }
}
