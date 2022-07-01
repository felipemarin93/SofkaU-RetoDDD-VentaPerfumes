package org.example.venta.perfumeria.values;

import co.com.sofka.domain.generic.Identity;

public class PerfumeriaId extends Identity {

    public PerfumeriaId(){

    }

    private PerfumeriaId(String id){
        super(id);
    }

    public static PerfumeriaId of(String id){
        return new PerfumeriaId(id);
    }
}
