package org.example.venta.perfumeria.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nit implements ValueObject <String> {
    private final String nit;
    public Nit(String nit) {

        this.nit = Objects.requireNonNull(nit);
    }
    @Override
    public String value() {
        return nit;
    }
}
