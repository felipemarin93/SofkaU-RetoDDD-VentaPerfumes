package org.example.venta.perfumeria.envio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<String> {
    private final String celular;
    public Celular(String celular) {

        this.celular = Objects.requireNonNull(celular);
    }
    @Override
    public String value() {
        return celular;
    }
    public Celular cambiarCelular(String numeroAModificar){
        return new Celular(Objects.requireNonNull(numeroAModificar));
    }
}
