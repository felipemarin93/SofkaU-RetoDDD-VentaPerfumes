package org.example.venta.perfumeria.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.perfumeria.envio.values.Celular;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {
    private final Integer precio;
    public Precio(Integer precio) {

        this.precio = Objects.requireNonNull(precio);

        if (this.precio < 0){
            throw new IllegalArgumentException("Los precios son valores positivos");
        }


    }
    @Override
    public Integer value() {
        return precio;
    }

}
