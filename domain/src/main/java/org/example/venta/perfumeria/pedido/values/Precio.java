package org.example.venta.perfumeria.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.perfumeria.envio.values.Celular;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {
    private final Integer precio;
    public Precio(Integer precio) {

        this.precio = Objects.requireNonNull(precio);
    }
    @Override
    public Integer value() {
        return precio;
    }

}
