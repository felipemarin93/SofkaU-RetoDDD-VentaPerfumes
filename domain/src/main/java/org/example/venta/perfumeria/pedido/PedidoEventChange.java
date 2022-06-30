package org.example.venta.perfumeria.pedido;

import co.com.sofka.domain.generic.EventChange;
import org.example.venta.perfumeria.pedido.entities.Factura;
import org.example.venta.perfumeria.pedido.entities.Producto;
import org.example.venta.perfumeria.pedido.events.ClienteCambiado;
import org.example.venta.perfumeria.pedido.events.FacturaAgregada;
import org.example.venta.perfumeria.pedido.events.PedidoCreado;
import org.example.venta.perfumeria.pedido.events.ProductoAgregado;


public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {

        apply((PedidoCreado event)->{
            pedido.cliente = event.cliente();
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
