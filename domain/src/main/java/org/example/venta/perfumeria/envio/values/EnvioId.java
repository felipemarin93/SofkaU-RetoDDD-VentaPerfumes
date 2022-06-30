package org.example.venta.perfumeria.envio.values;

import co.com.sofka.domain.generic.Identity;

public class EnvioId extends Identity {
    public EnvioId(){

    }

    private EnvioId(String id){
        super(id);
    }

    public static EnvioId of(String id){
        return new EnvioId(id);
    }
}
