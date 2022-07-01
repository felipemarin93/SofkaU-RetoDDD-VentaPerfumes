package org.example.venta.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;
    public Descripcion(String descripcion) {

        this.descripcion = Objects.requireNonNull(descripcion);

        if (this.descripcion.length()<10){
            throw new IllegalArgumentException("Se requiere una descriopcion mas detallada");
        }

    }
    @Override
    public String value() {
        return descripcion;
    }

}
