package org.example.venta.perfumeria.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.perfumeria.envio.values.Celular;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;
    public Descripcion(String descripcion) {

        this.descripcion = Objects.requireNonNull(descripcion);
    }
    @Override
    public String value() {
        return descripcion;
    }

}
