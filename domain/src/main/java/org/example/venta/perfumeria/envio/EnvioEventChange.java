package org.example.venta.perfumeria.envio;

import co.com.sofka.domain.generic.EventChange;
import org.example.venta.perfumeria.envio.entities.Destinatario;
import org.example.venta.perfumeria.envio.entities.Domiciliario;
import org.example.venta.perfumeria.envio.entities.Vehiculo;
import org.example.venta.perfumeria.envio.events.*;

public class EnvioEventChange extends EventChange {
    public EnvioEventChange(Envio envio) {
        apply((EnvioCreado event) -> {
            envio.fecha = event.fecha();
            envio.destinatario = null;
            envio.domiciliario = null;
            envio.vehiculo = null;
            envio.pedidoId = event.pedidoId();

        });

        apply((DestinatarioCambiado event) -> {
            envio.cambiarDestinatario(event.nombre(), event.direccion(), event.celular());
        });
        apply((DomiciliarioAgregado event) -> {
            envio.domiciliario = new Domiciliario(event.domiciliarioId(), event.nombre());
        });
        apply((VehiculoAgregado event) -> {
            envio.vehiculo = new Vehiculo(event.vehiculoId(), event.tipo(), event.marca());
        });
        apply((DestinatarioAgregado event) ->{
            envio.destinatario = event.destinatario();
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
