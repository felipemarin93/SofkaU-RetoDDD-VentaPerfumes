package org.example.venta.perfumeria.values;

import co.com.sofka.domain.generic.Identity;

public class ProveedorId extends Identity {

    public ProveedorId(){

    }

    private ProveedorId(String id){
        super(id);
    }

    public static ProveedorId of(String id){
        return new ProveedorId(id);
    }
}
