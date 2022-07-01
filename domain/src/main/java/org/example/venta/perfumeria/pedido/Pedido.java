package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.venta.perfumeria.pedido.entities.Cliente;
import org.example.venta.perfumeria.pedido.entities.Factura;
import org.example.venta.perfumeria.pedido.entities.Producto;
import org.example.venta.perfumeria.pedido.events.*;
import org.example.venta.perfumeria.pedido.values.*;
import org.example.venta.perfumeria.perfumeria.values.PerfumeriaId;

import java.util.List;
import java.util.Objects;

public class Pedido extends AggregateEvent<PedidoId> {
    protected PerfumeriaId perfumeriaId;
    protected Cliente cliente;
    protected Producto producto;
    protected Factura factura;
    protected Descripcion descripcion;

    public Pedido(PedidoId entityId, PerfumeriaId perfumeriaId, Cliente cliente) {
        super(entityId);
        appendChange(new PedidoCreado(perfumeriaId,cliente)).apply();
        subscribe(new PedidoEventChange(this));
    }
    private Pedido(PedidoId pedidoId){
        super(pedidoId);
        subscribe(new PedidoEventChange(this));
    }

    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }


    public void cambiarCliente(Cliente cliente){
        Objects.requireNonNull(cliente);
        appendChange(new ClienteCambiado(cliente)).apply();
    }

    public void agregarProducto(ProductoId productoId, Nombre nombre, Cantidad cantidad){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(cantidad);
        appendChange(new ProductoAgregado(productoId,nombre,cantidad)).apply();
    }
    public void agregarFactura(FacturaId facturaId, Precio precio, Detalle detalle){
        Objects.requireNonNull(facturaId);
        Objects.requireNonNull(precio);
        Objects.requireNonNull(detalle);
        appendChange(new FacturaAgregada(facturaId,precio,detalle)).apply();
    }
    public void cambiarCantidadProducto(ProductoId productoId, Cantidad cantidad){
        Objects.requireNonNull(productoId);
        Objects.requireNonNull(cantidad);
        appendChange(new CantidadProductoCambiada(productoId,cantidad)).apply();
    }

}
