package org.example.venta.perfumeria.envio.events.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String telefono;
    public Telefono(String telefono) {

        this.telefono = Objects.requireNonNull(telefono);
    }
    @Override
    public String value() {
        return telefono;
    }
    public Telefono cambiarTelefonoProveedor(String telefonoAModificar){
        return new Telefono(Objects.requireNonNull(telefonoAModificar));
    }
}
