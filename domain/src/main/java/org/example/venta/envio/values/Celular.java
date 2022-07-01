package org.example.venta.envio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<String> {
    private final String celular;
    public Celular(String celular) {
        this.celular = Objects.requireNonNull(celular);

        if (this.celular.isBlank()){
            throw new IllegalArgumentException("El campo celular no puede estar vacío");
        }
        if (this.celular.length()>10){
            throw new IllegalArgumentException("Un celular no tiene mas de 10 Digitos");
        }
    }
    @Override
    public String value() {
        return celular;
    }
    public Celular cambiarCelular(String numeroAModificar){
        return new Celular(Objects.requireNonNull(numeroAModificar));
    }
}
