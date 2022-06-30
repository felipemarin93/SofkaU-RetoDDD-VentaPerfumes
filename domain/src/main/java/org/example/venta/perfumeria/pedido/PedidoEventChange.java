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
            pedido.cliente = event.getCliente();
            pedido.factura = null;
            pedido.perfumeriaId = event.getPerfumeriaId();
            pedido.descripcion = null;
            pedido.producto = null;
                //new HashSet<>();//TODO Pendiente preguntar como crear el Set cuando nace de la entidad a coach Raul

        });

        apply((ClienteCambiado event)->{
            pedido.cliente = event.getCliente();
        });

        apply((ProductoAgregado event)->{
            pedido.producto = new Producto(event.getProductoId(), event.getNombre(), event.getCantidad());
        });

        apply((FacturaAgregada event)->{
            pedido.factura = new Factura(event.getFacturaId(),event.getPrecio(), event.getDetalle());
        });


    }
}
