package org.example.venta.perfumeria.envio;

import co.com.sofka.domain.generic.EventChange;
import org.example.venta.perfumeria.envio.entities.Domiciliario;
import org.example.venta.perfumeria.envio.entities.Vehiculo;
import org.example.venta.perfumeria.envio.events.*;

public class EnvioEventChange extends EventChange {
    public EnvioEventChange(Envio envio) {
        apply((EnvioCreado event) -> {
            envio.fecha = event.getFecha();
            envio.destinatario = event.getDestinatario();
            envio.domiciliario = null;
            envio.vehiculo = null;
            envio.pedidoId = event.getPedidoId();

        });

        apply((DestinatarioCambiado event) -> {
            envio.cambiarDestinatario(event.getNombre(), event.getDireccion(), event.getCelular());
        });

        apply((DireccionCambiada event) -> {
            envio.cambiarDireccion(event.getDireccion());
        });

        apply((FechaCambiada event) -> {
            envio.cambiarFecha(event.getFecha());
        });

        apply((DomiciliarioAgregado event) -> {
            envio.domiciliario = new Domiciliario(event.getDomiciliarioId(), event.getNombre());
        });

        apply((VehiculoAgregado event) -> {
            envio.vehiculo = new Vehiculo(event.getVehiculoId(), event.getTipo(), event.getMarca());
        });
    }
}
