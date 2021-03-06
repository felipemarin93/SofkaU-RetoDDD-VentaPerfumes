package org.example.venta.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.envio.values.Celular;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String telefono;
    public Telefono(String telefono) {

        this.telefono = Objects.requireNonNull(telefono);

        if (this.telefono.isBlank()){
            throw new IllegalArgumentException("El campo telefono no puede estar vacío");
        }
        if (this.telefono.length()>10){
            throw new IllegalArgumentException("Un telefono no tiene mas de 10 Digitos");
        }

    }
    @Override
    public String value() {
        return telefono;
    }

    public Telefono cambiarTelefono(String telefonoAModificar){
        return new Telefono(Objects.requireNonNull(telefonoAModificar));
    }
}
