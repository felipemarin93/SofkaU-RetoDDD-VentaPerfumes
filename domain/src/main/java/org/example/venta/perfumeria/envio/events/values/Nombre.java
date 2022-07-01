package org.example.venta.perfumeria.envio.events.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject <String> {
    private final String nombre;
    public Nombre(String nombre) {

        this.nombre = Objects.requireNonNull(nombre);
    }
    @Override
    public String value() {
        return nombre;
    }

    public Nombre cambiarNombre(String nombreAModificar){
        return new Nombre(Objects.requireNonNull(nombreAModificar));
    }
}
