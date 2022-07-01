package org.example.venta.envio;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.envio.entities.Vehiculo;
import org.example.venta.envio.events.*;
import org.example.venta.envio.values.*;
import org.example.venta.pedido.values.PedidoId;
import org.example.venta.envio.entities.Destinatario;
import org.example.venta.envio.entities.Domiciliario;

import java.util.List;
import java.util.Objects;

public class Envio extends AggregateEvent<EnvioId> {
    protected Domiciliario domiciliario;
    protected Destinatario destinatario;
    protected Vehiculo vehiculo;
    protected Fecha fecha;
    protected PedidoId pedidoId;
    protected DestinatarioId destinatarioId;

    public Envio(EnvioId entityId, Fecha fecha, PedidoId pedidoId, Nombre nombre, Direccion direccion, Celular celular, DestinatarioId destinatarioId) {
        super(entityId);
        this.destinatarioId = destinatarioId;
        appendChange(new EnvioCreado(pedidoId,fecha)).apply();
        appendChange(new DestinatarioCreado(nombre,direccion,celular,destinatarioId)).apply();
        subscribe(new EnvioEventChange(this));
    }

    private Envio(EnvioId envioId){
        super(envioId);
        subscribe(new EnvioEventChange(this));
    }

    public static Envio from(EnvioId envioId, List<DomainEvent> events){
        var envio = new Envio(envioId);
        events.forEach(envio::applyEvent);
        return envio;
    }



    public void cambiarDireccion(EnvioId envioId, DestinatarioId destinatarioId, Direccion direccionACambiar){
        Objects.requireNonNull(envioId);
        Objects.requireNonNull(destinatarioId);
        Objects.requireNonNull(direccionACambiar);
        appendChange(new DireccionCambiada(envioId,destinatarioId,direccionACambiar)).apply();

    }

    public void agregarDomiciliario(DomiciliarioId domiciliarioId, Nombre nombre){
        Objects.requireNonNull(domiciliarioId);
        Objects.requireNonNull(nombre);
        appendChange(new DomiciliarioAgregado(domiciliarioId, nombre)).apply();

    }
    public void agregarVehiculo(VehiculoId vehiculoId, Tipo tipo, Marca marca ){
        Objects.requireNonNull(vehiculoId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(marca);
        appendChange(new VehiculoAgregado(vehiculoId, tipo, marca)).apply();

    }
    public void cambiarCelularDestinatario(EnvioId envioId, Celular celular, DestinatarioId destinatarioId){
        Objects.requireNonNull(envioId);
        Objects.requireNonNull(celular);
        Objects.requireNonNull(destinatarioId);
        appendChange(new CelularDestinatarioCambiado(envioId,celular,destinatarioId)).apply();
    }

    public void agregarDestinatario(EnvioId envioId, Destinatario destinatario){
        Objects.requireNonNull(envioId);
        Objects.requireNonNull(destinatario);
        appendChange(new DestinatarioAgregado(envioId,destinatario)).apply();
    }

    public void cambiarNombreDomiciliario(EnvioId envioId, Nombre nombre, DestinatarioId destinatarioId){
        Objects.requireNonNull(envioId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(destinatarioId);
        appendChange(new NombreDomiciliarioCambiado(envioId,nombre,destinatarioId)).apply();
    }











}
