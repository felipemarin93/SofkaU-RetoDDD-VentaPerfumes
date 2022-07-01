package org.example.venta.perfumeria.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.perfumeria.envio.values.Celular;

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

}
