package org.example.venta.perfumeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject <String> {
    private final String correo;
    public Correo(String correo) {

        this.correo = Objects.requireNonNull(correo);

        if (!this.correo.contains("@")){
            throw new IllegalArgumentException("No es un correo valido, por favor ingresalo nuevamente");
        }
        if (!this.correo.contains(".")){
            throw new IllegalArgumentException("No es un correo valido, por favor ingresalo nuevamente");
        }
        if (this.correo.length()<10){
            throw new IllegalArgumentException("No es un correo valido, por favor ingresalo nuevamente");
        }

    }
    @Override
    public String value() {
        return correo;
    }
    public Correo cambiarCorreoVendedor(String correoAModificar){
        return new Correo(Objects.requireNonNull(correoAModificar));
    }
}
