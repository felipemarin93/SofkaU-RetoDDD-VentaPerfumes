package org.example.venta.envio;

import co.com.sofka.domain.generic.EventChange;
import org.example.venta.envio.entities.Destinatario;
import org.example.venta.envio.entities.Domiciliario;
import org.example.venta.envio.entities.Vehiculo;
import org.example.venta.envio.events.*;


public class EnvioEventChange extends EventChange {
    public EnvioEventChange(Envio envio) {
        apply((EnvioCreado event) -> {
            envio.fecha = event.fecha();
            envio.destinatario = null;
            envio.domiciliario = null;
            envio.vehiculo = null;
            envio.pedidoId = event.pedidoId();

        });


        apply((DomiciliarioAgregado event) -> {
            envio.domiciliario = new Domiciliario(event.domiciliarioId(), event.nombre());
        });
        apply((VehiculoAgregado event) -> {
            envio.vehiculo = new Vehiculo(event.vehiculoId(), event.tipo(), event.marca());
        });
        apply((DestinatarioAgregado event) ->{
            envio.destinatario = new Destinatario(event.getDestinatarioId(),event.getNombre(),event.getDireccion(),event.getCelular());
        });
        apply((DestinatarioCreado event) -> {
            envio.destinatario = new Destinatario(event.destinatarioId(), event.nombre(), event.direccion(), event.celular());
        });

        apply((CelularDestinatarioCambiado event) -> {
            envio.destinatario.cambiarCelular( event.celular());
        });
        apply((DireccionCambiada event) -> {
            envio.destinatario.cambiarDireccion(event.direccion());
        });
        apply((NombreDomiciliarioCambiado event) -> {
            envio.domiciliario.cambiarNombre(event.nombre().value());
        });



    }
}
