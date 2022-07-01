package org.example.venta.perfumeria.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nit implements ValueObject <String> {
    private final String nit;
    public Nit(String nit) {

        this.nit = Objects.requireNonNull(nit);

        if (this.nit.length()<5){
            throw new IllegalArgumentException("No es un Nit valido, por favor ingrésalo nuevamente");
        }

    }
    @Override
    public String value() {
        return nit;
    }
}
