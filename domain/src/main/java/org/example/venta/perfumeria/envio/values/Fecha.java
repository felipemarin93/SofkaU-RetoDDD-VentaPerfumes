package org.example.venta.perfumeria.envio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Fecha implements ValueObject<Date> {


    private final Date fecha;
    public Fecha(Date fecha) {
        this.fecha = Objects.requireNonNull(fecha);
    }
    @Override
    public Date value() {
        return fecha;
    }

}
