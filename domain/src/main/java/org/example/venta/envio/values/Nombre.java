package org.example.venta.envio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;
    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.length()<4){
            throw new IllegalArgumentException("Es un nombre demasiado Corto, pon tu apellido por favor");
        }

    }
    @Override
    public String value() {
        return nombre;
    }
    public Nombre cambiarNombre(String nombreAModificar){
        return new Nombre(Objects.requireNonNull(nombreAModificar));
    }
}
