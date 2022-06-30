package org.example.venta.perfumeria.envio.values;

import co.com.sofka.domain.generic.Identity;

public class DomiciliarioId extends Identity {

    public DomiciliarioId(){

    }

    private DomiciliarioId(String id){
        super(id);
    }

    public static DomiciliarioId of(String id){
        return new DomiciliarioId(id);
    }
}
