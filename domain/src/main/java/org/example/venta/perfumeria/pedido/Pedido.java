package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.venta.perfumeria.pedido.entities.Cliente;
import org.example.venta.perfumeria.pedido.entities.Factura;
import org.example.venta.perfumeria.pedido.entities.Producto;
import org.example.venta.perfumeria.pedido.events.ClienteCambiado;
import org.example.venta.perfumeria.pedido.events.FacturaAgregada;
import org.example.venta.perfumeria.pedido.events.PedidoCreado;
import org.example.venta.perfumeria.pedido.events.ProductoAgregado;
import org.example.venta.perfumeria.pedido.values.*;
import org.example.venta.perfumeria.perfumeria.PerfumeriaId;

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



    public void cambiarCliente(Cliente cliente){
        appendChange(new ClienteCambiado(cliente)).apply();
    }

    public void agregarProducto(ProductoId productoId, Nombre nombre, Cantidad cantidad){
        appendChange(new ProductoAgregado(productoId,nombre,cantidad)).apply();
    }
    public void agregarFactura(FacturaId facturaId, Precio precio, Detalle detalle){
        appendChange(new FacturaAgregada(facturaId,precio,detalle)).apply();
    }
    public void cambiarCantidadProducto(ProductoId productoId, Cantidad cantidad){
        appendChange(new CantidadProductoCambiada(productoId,cantidad)).apply();
    }

}
