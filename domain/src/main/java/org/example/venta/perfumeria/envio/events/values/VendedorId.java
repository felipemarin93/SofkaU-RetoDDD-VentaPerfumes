package org.example.venta.perfumeria.envio.events.values;

import co.com.sofka.domain.generic.Identity;

public class VendedorId extends Identity {

    public VendedorId(){

    }

    private VendedorId(String id){
        super(id);
    }

    public static VendedorId of(String id){
        return new VendedorId(id);
    }
}
