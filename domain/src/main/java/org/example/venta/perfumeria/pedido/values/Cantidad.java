package org.example.venta.perfumeria.pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import org.example.venta.perfumeria.envio.values.Celular;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {
    private final Integer cantidad;
    public Cantidad(Integer cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);
    }
    @Override
    public Integer value() {
        return cantidad;
    }

    public Cantidad cambiarCantidad(Integer cantidadAmodificar){
        return new Cantidad(Objects.requireNonNull(cantidadAmodificar));
    }

}
