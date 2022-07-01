package org.example.venta.perfumeria.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject <String> {
    private final String correo;
    public Correo(String correo) {

        this.correo = Objects.requireNonNull(correo);
    }
    @Override
    public String value() {
        return correo;
    }
    public Correo cambiarCorreoVendedor(String correoAModificar){
        return new Correo(Objects.requireNonNull(correoAModificar));
    }
}
