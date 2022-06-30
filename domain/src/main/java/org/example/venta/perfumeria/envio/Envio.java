package org.example.venta.perfumeria.envio;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.venta.perfumeria.envio.entities.Destinatario;
import org.example.venta.perfumeria.envio.entities.Domiciliario;
import org.example.venta.perfumeria.envio.entities.Vehiculo;
import org.example.venta.perfumeria.envio.events.*;
import org.example.venta.perfumeria.envio.values.*;
import org.example.venta.perfumeria.pedido.PedidoId;

public class Envio extends AggregateEvent<EnvioId> {
    protected Domiciliario domiciliario;
    protected Destinatario destinatario;
    protected Vehiculo vehiculo;
    protected Fecha fecha;

    protected PedidoId pedidoId;

    public Envio(EnvioId entityId, Fecha fecha, PedidoId pedidoId, Destinatario destinatario) {
        super(entityId);

        appendChange(new EnvioCreado(pedidoId,fecha,destinatario)).apply();
        subscribe(new EnvioEventChange(this));
    }

    public void cambiarDestinatario(Nombre nombre, Direccion direccion, Celular celular){
        appendChange(new DestinatarioCambiado(nombre,direccion,celular)).apply();

    }

    public void cambiarDireccion(Direccion direccion){
        appendChange(new DireccionCambiada(direccion)).apply();

    }

    public void cambiarFecha(Fecha fecha){
        appendChange(new FechaCambiada(fecha)).apply();

    }

    public void agregarDomiciliario(DomiciliarioId domiciliarioId, Nombre nombre){
        appendChange(new DomiciliarioAgregado(domiciliarioId, nombre)).apply();

    }
    public void agregarVehiculo(VehiculoId vehiculoId, Tipo tipo, Marca marca ){
        appendChange(new VehiculoAgregado(vehiculoId, tipo, marca)).apply();

    }








}
