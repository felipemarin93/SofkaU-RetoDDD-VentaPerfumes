package org.example.venta.pedido;

import co.com.sofka.domain.generic.EventChange;
import org.example.venta.pedido.entities.Cliente;
import org.example.venta.pedido.entities.Factura;
import org.example.venta.pedido.entities.Producto;
import org.example.venta.pedido.events.CantidadProductoCambiada;
import org.example.venta.pedido.events.ClienteCambiado;
import org.example.venta.pedido.events.FacturaAgregada;
import org.example.venta.pedido.events.PedidoCreado;
import org.example.venta.pedido.events.ProductoAgregado;


public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {

        apply((PedidoCreado event)->{
            pedido.cliente = new Cliente(event.clienteId(),event.nombre(),event.telefono());
            pedido.factura = null;
            pedido.perfumeriaId = event.perfumeriaId();
            pedido.descripcion = null;
            pedido.producto = null;


        });

        apply((ClienteCambiado event)->{
            pedido.cliente = event.cliente();
        });

        apply((ProductoAgregado event)->{
            pedido.producto = new Producto(event.productoId(), event.nombre(), event.cantidad());
        });

        apply((FacturaAgregada event)->{
            pedido.factura = new Factura(event.facturaId(),event.precio(), event.detalle());
        });
        apply((CantidadProductoCambiada event)->{
            pedido.producto.cambiarCantidad(event.cantidad());
        });

    }
}
